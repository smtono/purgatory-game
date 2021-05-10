package purgatory.dialogue;

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
}
