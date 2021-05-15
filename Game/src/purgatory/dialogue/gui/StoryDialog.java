package purgatory.dialogue.gui;

import purgatory.battle.stats.BattleStats;
import purgatory.story.ChoiceSet;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * StoryDialog is a series of JOptionPane Dialogs
 * to be utilized throughout the program pertaining to the story
 */
public class StoryDialog {
    private int morality = 0;

    public int getMorality() { return morality; }

    // TODO: decide , Jlist or JDialogs?
    // FRAME CONSTRUCTION
    public StoryDialog(List<ChoiceSet> choiceSets) {
        final JFrame frame = new JFrame();
        final JPanel panel = new JPanel();
        final JTextArea dialog = new JTextArea();
        final BorderLayout layout = new BorderLayout();

        dialog.setEditable(false);
        panel.setLayout(layout);

        panel.add(dialog, BorderLayout.CENTER);

        //  FRAME CONSTRUCTION
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(panel);
        frame.setSize(200, 220);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
