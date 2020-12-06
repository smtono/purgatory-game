package purgatory.battle;

import purgatory.Reference;
import purgatory.entity.Entity;
import purgatory.util.EntityUtil;

import javax.swing.*;
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
    private final List<Entity> fighters;

    public BattleController(BattleView view, BattleModel model, List<Entity> fighters) {
        this.view = view;
        this.model = model;
        this.fighters = fighters;
    }

    /**
     * Sets the move set JList in the BattleView GUI based on the move set of the current hero
     */
    public void setMoves() {
        List<String> moves = new ArrayList<>();

        Reference.hero.getMoveSet().forEach(move -> {
            String moveName = move.getName();
            moves.add(moveName);
        });

        view.setMoves(moves.toArray(String[]::new));
    }

    /**
     * Prepares the view for the first turn by telling the user they encountered an enemy and then
     * will bring up the turn based combat system.
     */
    public void startBattle() {
        StringBuilder builder = new StringBuilder();
        EntityUtil.getEnemiesFromSet(fighters).iterator().forEachRemaining(entity -> {
            builder.append(entity.getInfo());
            builder.append("\n\n");
        });
        view.appendBattleText("A team of wild monsters appeared!\n\n");
        view.appendStatsText(builder.toString());
        // prompts hero that they have encountered and enemy, and gives a brief tutorial on how to play.
        JOptionPane.showMessageDialog(null, "You have just entered a battle!\n"
                + "Read your enemy's stats, and choose the move that would best counter it!\n"
                + "Different enemies have different weaknesses!", "Enemy Appeared!", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * turnSequence int
     * This method will contain both the hero and enemy's turn
     * Call this method recursively until one of the following exit conditions are reached:
     * The hero HP reaches 0 (die sequence)
     * the enemy HP reaches 0 (level up/ gain loot, etc.)
     * the hero runs away (return to main screen, implement this one last.)
     * returns an int which will be used to keep tack of iterations, since this method will be called recursively.
     *
     * @return An int which will be used to keep tack of iterations
     */


    /**
     * dieSequence int
     * prints out a death script, takes current death count and adds it need to keep up with that variable.
     * returns amount of time hero has died
     */
    public void dieSequence() {
        JOptionPane.showMessageDialog
                (null,
                        "\nHero! You have died.",
                        "You have died!",
                        JOptionPane.INFORMATION_MESSAGE);
    }
}
