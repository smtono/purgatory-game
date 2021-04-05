package purgatory.battle;

import purgatory.entity.CharacterType;
import purgatory.move.Attack;
import purgatory.move.Move;
import purgatory.move.MoveUtil;
import purgatory.stats.BattleStats;
import purgatory.stats.StatUtil;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
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

    // CONSTRUCTOR
    public BattleController(BattleView view, BattleModel model) {
        this.view = view;
        this.model = model;
        model.setFighters(StatUtil.pushInitialFighterStats(model.getInitialFighters())); // pushing initial stats upon construction
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

    /**
     * Prepares the move set and name card for the current hero or
     * party member attacking.
     *
     * @param currUnit: The current entity attacking.
     */
    private void prepareViewForUnit(BattleStats currUnit) {
        setMoves(currUnit);
        setCurrHeroName(currUnit);
    }

    /**
     * Sets up a MouseAdapter object to listen to the user input for a JList and respond
     * based on the move chosen
     *
     * @param currHero: The entity object currently in control of the move set
     * @return A MouseAdapter to pass into a JList listener
     */
    private MouseAdapter createListener(BattleStats currHero) {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                @SuppressWarnings("unchecked")
                JList<String> source = (JList<String>) e.getSource(); // gets which move the user picked

                if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2) { // detects double-click

                    int index = source.locationToIndex(e.getPoint()); // gets index in JList

                    if (index >= 0) {
                        // battle logic from here out
                        String moveSelected = source.getModel().getElementAt(index); // gets string value at index

                        model.setFighters(doAction(currHero, moveSelected));
                    }
                }
            }
        };
    }

    /**
     * Adds the JList listener needed for the BattleView
     *
     * @param mouseAdapter: A mouse adapter object to add a listener to
     */
    private void prepareJListListener(MouseAdapter mouseAdapter) {
        view.getMoveSet().addMouseListener(mouseAdapter);
    }

    /**
     * Prepares the view for the first turn by telling the user they encountered
     * an enemy and displaying starting enemy stats
     */
    public void prepareBattle() {
        view.appendBattleText("A team of wild demons appeared!\n\n");

        appendEnemyStats();

        // prompts hero that they have encountered and enemy, and gives a brief tutorial on how to play.
        JOptionPane.showMessageDialog(null, "You have just entered a battle!\n"
                + "Read your enemy's stats, and choose the move that would best counter it!\n"
                + "Different enemies have different weaknesses!", "Enemy Appeared!", JOptionPane.INFORMATION_MESSAGE);

        appendOrder();
    }

    /**
     * Sets the move set JList in the BattleView GUI based on the move set of the current hero
     *
     * @param currHero: The current Entity object used for the hero (player)
     */
    private void setMoves(BattleStats currHero) {
        List<String> moves = MoveUtil.getHeroMoveSetByName(currHero.getMoveSet());
        view.setMoves(moves.toArray(String[]::new));
    }

    /**
     * Sets the current hero or party member's name to the JLabel in the BattleView
     */
    private void setCurrHeroName(BattleStats currHero) {
        view.setCurrentHeroName(currHero.getFighter());
    }

    /**
     * Determines the current order of fighters and appends it to the battleText JTextArea
     * in the BattleView GUI
     */
    private void appendOrder() {
        model.determineOrder();
        view.appendBattleText(model.getFighterOrder());
    }

    private void appendEnemyStats() {
        StringBuilder builder = new StringBuilder();

        StatUtil.getStatsOfTypeFromList(model.getFighters(), CharacterType.ENEMY).iterator().forEachRemaining(enemy -> {
            builder.append(enemy.getInfo());
            builder.append("\n\n");
        });

        view.appendStatsText(builder.toString());
    }

    private void appendAttack(String attacker,String target, int damage) {
        if(damage == 0) {
            view.appendBattleText("\nAttack missed for " + target);
        }
        else {
            view.appendBattleText("\n" + attacker + " just hit " + target + " dealing " + damage + " damage!");
        }
    }

    /**
     *
     * @param currHero
     * @param enemies
     * @param heroMove
     * @return
     */
    private List<BattleStats> heroAttack(BattleStats currHero, List<BattleStats> enemies, Attack heroMove) {
        if (heroMove.isAffectAll()) {
            List<DamageOutput> damageOutputs = model.damageAllEnemies(currHero, enemies, heroMove);

            for(int i = 0; i <= enemies.size(); i++) {
                if (damageOutputs.get(i).getCritical()) {
                    view.appendBattleText("\nCritical hit!");
                }
                appendAttack(currHero.getFighter(), enemies.get(i).getFighter(), damageOutputs.get(i).getDamage()); // say who was attacked and for how much
                enemies.get(i).setCurrHealth(enemies.get(i).getCurrHealth() - damageOutputs.get(i).getDamage()); // set new health
            }

        } else {
            BattleStats enemyChosen = enemies.get(chooseTarget(enemies));
            DamageOutput values = model.damageEnemy(currHero, enemyChosen, heroMove);

            if (values.getCritical()) {
                view.appendBattleText("\nCritical hit!");
            }
            appendAttack(currHero.getFighter(), enemyChosen.getFighter(), values.getDamage());
            enemyChosen.setCurrHealth(enemyChosen.getCurrHealth() - values.getDamage());
        }

        return enemies;
    }

    /**
     *
     */
    private List<BattleStats> enemyAttack() {

    }

    /**
     * Prompts user to choose from the list of potential targets for the move in battle
     *
     * @return The index of the enemy chosen
     */
    private int chooseTarget(List<BattleStats> targets) {
        return JOptionPane.showOptionDialog(
                null,
                "Choose a target!",
                "",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                targets.toArray(),
                null);
    }

    /**
     * Prints out a death script, takes current death count and adds it need to keep up with that variable.
     * returns amount of time hero has died
     *
     * @param playerDeaths: The current amount of times the user has died
     * @return The current amount of player deaths
     */
    public int die(int playerDeaths) {
        JOptionPane.showMessageDialog
                (null,
                        "\nHero! You have died.",
                        "You have died!",
                        JOptionPane.INFORMATION_MESSAGE);

        return playerDeaths + 1;
    }

    /**
     * Either damages a chosen enemy or heals or does a support skill on a party member or self.
     * Returns the stats of all fighters to update the GUI.
     *
     * @param currHero: The current hero fighting
     * @param moveSelected: The String value of the move selected by the user
     * @return
     */
    private List<BattleStats> doAction(BattleStats currHero, String moveSelected) {
        List<BattleStats> newStats = new ArrayList<>();
        Move heroMove = MoveUtil.getUnitMoveFromList(currHero, moveSelected);
        List<BattleStats> enemies = StatUtil.getStatsOfTypeFromList(model.getFighters(), CharacterType.ENEMY);
        List<BattleStats> party = StatUtil.getStatsOfTypeFromList(model.getFighters(), CharacterType.PARTY);

            switch (heroMove.getMoveType()) {
                case ATTACK:
                   return heroAttack(currHero, enemies, (Attack) heroMove);
                case HEAL:
                    BattleStats partyChosen = party.get(chooseTarget(party));
                    break;
                case SUPPORT:
                    break;
            }

        return newStats;
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
     * @param currTurn: The current turn iteration
     * @return An int which will be used to keep tack of iterations
     */
    public int updateView(int currTurn) {
        BattleStats hero = StatUtil.getHeroFromList(model.getFighters());

        prepareViewForUnit(hero);
        prepareBattleText(currTurn);

        if (currTurn == 0) {

            prepareBattle();
        } else {
            appendOrder();
        }

        for (BattleStats currUnit : model.getFighters()) {
            MouseAdapter mouseAdapter = null;
            view.enableMoveSet(false);

            switch (currUnit.getEntityType().getCharacterType()) { // find who is the current fighter
                case HERO: // if HERO or
                case PARTY: // if PARTY do this ->
                    view.enableMoveSet(true);
                    mouseAdapter = createListener(currUnit);
                    prepareJListListener(mouseAdapter);
                    break;
                // make new MouseAdapter object to pass into the JList listener
                case ENEMY:
                case BOSS:
                    view.enableMoveSet(false);

                    break;
            }
        }

        currTurn++;
        return currTurn;
    }
}