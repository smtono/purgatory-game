package purgatory.dialogue.dialog;

import javax.swing.*;

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
