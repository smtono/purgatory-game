package purgatory.battle;

import purgatory.entity.CharacterType;
import purgatory.entity.Entity;
import purgatory.entity.EntityUtil;
import purgatory.move.MoveUtil;

import javax.swing.*;
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
    }

    /**
     * Prepares the view for the first turn by telling the user they encountered an enemy and displaying stats.
     *
     * @param hero: The Entity object representing the hero (player)
     */
    public void startBattle(Entity hero) {
        StringBuilder builder = new StringBuilder();
        view.setCurrentHeroName(hero);
        EntityUtil.getEntitiesOfType(model.getFighters(), CharacterType.ENEMY).iterator().forEachRemaining(entity -> {
            builder.append(entity.getInfo());
            builder.append("\n\n");
        });
        view.appendBattleText("A team of wild demons appeared!\n\n");
        view.appendStatsText(builder.toString());
        // prompts hero that they have encountered and enemy, and gives a brief tutorial on how to play.
        JOptionPane.showMessageDialog(null, "You have just entered a battle!\n"
                + "Read your enemy's stats, and choose the move that would best counter it!\n"
                + "Different enemies have different weaknesses!", "Enemy Appeared!", JOptionPane.INFORMATION_MESSAGE);

        model.determineOrder();
        view.appendBattleText(getFighterOrder(model.getFighters()));
    }

    /**
     * Sets the move set JList in the BattleView GUI based on the move set of the current hero
     *
     * @param hero: The current Entity object used for the hero (player)
     */
    public void setMoves(Entity hero) {
        List<String> moves = MoveUtil.getHeroMoveSetByName(hero);
        view.setMoves(moves.toArray(String[]::new));
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

    /**
     * Refreshes text appearing on the view of the UI
     *
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
        return 0;
    }
}
