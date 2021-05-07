package purgatory.main;

import javax.swing.*;

/**
 * A series of JOptionPane Dialogs to be utilized throughout the program
 */
public class Dialog {

    /** Leaves the game */
    public static void leave() {
        JOptionPane.showMessageDialog(null, "Leaving already?");
        System.exit(0);
    }

    /** Prompts the user again */
    public static void promptAgain() {
        JOptionPane.showMessageDialog(null, "Oh, sorry, can you tell me again?");
    }

    public static void checkButtons(int button) {
        if (button == JOptionPane.NO_OPTION) {
            Dialog.promptAgain();
        }
        else if (button == JOptionPane.CANCEL_OPTION) { // User must have cancelled
            Dialog.leave();
        }
    }
}
