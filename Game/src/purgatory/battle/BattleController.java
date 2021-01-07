package purgatory.battle;

import purgatory.entity.CharacterType;
import purgatory.entity.Entity;
import purgatory.entity.EntityUtil;
import purgatory.move.MoveUtil;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 * BattleController serves as the interface between BattleModel and BattleView.
 * <p>
 * It will take input from the user and display to the view based on moves chosen, buttons pressed
 * This will be done through an update() function which will print to the view relevant information.
 */
public class BattleController {
    private final BattleView view;
    private final BattleModel model;

    private MouseAdapter mouseAdapter;


    // CONSTRUCTOR
    public BattleController(BattleView view, BattleModel model) {
        this.view = view;
        this.model = model;
    }

    /** Prepares the view for the first turn by telling the user they encountered an enemy and displaying stats.*/
    public void startBattle() {
        StringBuilder builder = new StringBuilder();
        EntityUtil.getEntitiesOfTypeFromList(model.getFighters(), CharacterType.ENEMY).iterator().forEachRemaining(entity -> {
            builder.append(entity.getInfo());
            builder.append("\n\n");
        });
        view.appendBattleText("A team of wild demons appeared!\n\n");
        view.appendStatsText(builder.toString());
        // prompts hero that they have encountered and enemy, and gives a brief tutorial on how to play.
        JOptionPane.showMessageDialog(null, "You have just entered a battle!\n"
                + "Read your enemy's stats, and choose the move that would best counter it!\n"
                + "Different enemies have different weaknesses!", "Enemy Appeared!", JOptionPane.INFORMATION_MESSAGE);

        appendOrder();
    }

    /**
     * Gets the ordered list of fighters and returns them as a string
     *
     * @param fighters: A list of all the fighters in battle
     * @return A string of the order of fighters
     */
    private String getFighterOrder(List<Entity> fighters) {
        StringBuilder builder = new StringBuilder();
        builder.append("The order for this turn is: \n");
        fighters.forEach(fighter -> {
            builder.append(fighter.getName());
            builder.append(" \n");
        });
        return builder.toString();
    }

    /**
     * Prints out a death script, takes current death count and adds it need to keep up with that variable.
     * returns amount of time hero has died
     *
     * @param playerDeaths: The current amount of times the user has died
     * @return The current amount of player deaths
     */
    public int dieSequence(int playerDeaths) {
        JOptionPane.showMessageDialog
                (null,
                        "\nHero! You have died.",
                        "You have died!",
                        JOptionPane.INFORMATION_MESSAGE);
        playerDeaths += 1;
        return playerDeaths;
    }

    // HELPER METHODS

    /**
     * Sets the move set JList in the BattleView GUI based on the move set of the current hero
     *
     * @param currHero: The current Entity object used for the hero (player)
     */
    private void setMoves(Entity currHero) {
        List<String> moves = MoveUtil.getHeroMoveSetByName(currHero);
        view.setMoves(moves.toArray(String[]::new));
    }

    private void setCurrHeroName(Entity currHero) {
        view.setCurrentHeroName(currHero);
    }

    /**
     * Determines the current order of fighters and appends it to the battleText JTextArea
     * in the BattleView GUI
     */
    private void appendOrder() {
        model.determineOrder();
        view.appendBattleText(getFighterOrder(model.getFighters()));
    }

    private void appendEnemyStats() {

    }

    /**
     * Prepares each text area in the BattleView GUI for each turn of battle
     *
     * @param i: The current turn of battle
     */
    private void prepareBattleText(int i) {
        view.clearBattleText();
        view.clearStatsText();
        view.appendBattleText("Turn: " + i + "\n\n");
        view.enableMoveSet(false);
    }

    private void prepareViewForUnit(Entity currUnit) {
        setMoves(currUnit);
        setCurrHeroName(currUnit);
    }

    /**
     *
     */
    private void prepareJListListener(MouseAdapter mouseAdapter) {
        view.getMoveSet().addMouseListener(mouseAdapter);
    }

    // UPDATE METHOD
    /**
     * Refreshes text appearing on the view of the UI
     * <p>
     * Call this method recursively until one of the following exit conditions are reached:
     * The hero HP reaches 0 (die sequence)
     * the enemy HP reaches 0 (level up/ gain loot, etc.)
     * the hero runs away (return to main screen, implement this one last.)
     * returns an int which will be used to keep tack of iterations, since this method will be called recursively.
     *
     * @param i: The current turn iteration
     * @return An int which will be used to keep tack of iterations
     */
    public int updateView(int i) {
        List<Entity> fighters = model.getFighters();
        Entity hero = EntityUtil.getHeroFromList(fighters);

        prepareViewForUnit(hero);
        prepareBattleText(i);

        if (i == 0) {
            startBattle();
        } else {
            appendOrder();
        }

        for (Entity currUnit : fighters) {
            switch (currUnit.getEntityType().getCharacterType()) { // find who is the current fighter
                case HERO:
                    view.enableMoveSet(true);

                    // make new MouseAdapter object to pass into the JList listener
                    mouseAdapter = new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            @SuppressWarnings("unchecked")
                            JList<String> source = (JList<String>) e.getSource(); // gets which move the user picked

                            if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2) { // detects double-click

                                int index = source.locationToIndex(e.getPoint()); // gets index in JList
                                if (index >= 0) {
                                    String moveSelected = source.getModel().getElementAt(index); // gets string value at index

                                    
                                }
                            }
                        }
                    };

                    prepareJListListener(mouseAdapter);

                case ENEMY:
                case BOSS:
                case PARTY:
            }
        }


        return 0;
    }
}
