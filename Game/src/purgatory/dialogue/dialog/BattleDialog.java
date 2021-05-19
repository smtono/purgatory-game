package purgatory.dialogue.dialog;

import purgatory.battle.stats.BattleStats;
import purgatory.move.Move;

import javax.swing.*;
import java.util.List;

/**
 * 
 */
public class BattleDialog {
    // TODO: add dialogs from controller here
    /** Prompts the hero that they have encountered and enemy, and gives a brief tutorial on how to play. */
    public static void help() {
        JOptionPane.showMessageDialog(null, "You have just entered a battle!\n"
                + "Read your enemy's stats, and choose the move that would best counter it!\n"
                + "Different enemies have different weaknesses!", "Enemy Appeared!", JOptionPane.INFORMATION_MESSAGE);
    }

    public static String askAction() {
        String[] menu = {"Fight!", "Items", "Analyze", "Run"};

        int choice = JOptionPane.showOptionDialog(
                null,
                "Hurry! What do you want to do?",
                "",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                menu,
                null);
        return menu[choice].toLowerCase();
    }

    /**
     * Prompts user to choose from the list of potential targets for the move in battle
     *
     * @return The index of the enemy chosen
     */
    public static int chooseTarget(List<BattleStats> targets) {
        return JOptionPane.showOptionDialog(
                null,
                "Choose a target!",
                "",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                targets.toArray(new BattleStats[0]),
                null);
    }

    public static String askMove(BattleStats currUnit) {
        String[] moveSet = currUnit.getMoveNames().toArray(new String[0]);
        int move = JOptionPane.showOptionDialog(
                null,
                "What move?",
                "",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                moveSet,
                null);
        return moveSet[move];
    }

    public static String analyze() {
        String[] analyze = {"Myself", "Enemies"};
        int choice = JOptionPane.showOptionDialog(
                null,
                "Who do you want to analyze?",
                "",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                analyze,
                null);
        return analyze[choice].toLowerCase();
    }

    public static BattleStats askEnemy(List<BattleStats> enemies) {
        int choice = JOptionPane.showOptionDialog(
                null,
                "Okay, which enemy do you want to look at?",
                "",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                enemies.toArray(new BattleStats[0]),
                null);
        return enemies.get(choice);
    }

    /**
     * Prints out a death script, takes current death count and adds it need to keep up with that variable.
     * returns amount of time hero has died
     *
     * @param playerDeaths: The current amount of times the user has died
     * @return The current amount of player deaths
     */
    public static int die(int playerDeaths) {
        JOptionPane.showMessageDialog
                (null,
                        "\nHero! You have died.",
                        "You have died!",
                        JOptionPane.INFORMATION_MESSAGE);
        return playerDeaths + 1;
    }
}
