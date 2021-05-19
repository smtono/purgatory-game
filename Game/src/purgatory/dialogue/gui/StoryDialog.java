package purgatory.dialogue.gui;

import purgatory.dialogue.story.ChoiceSet;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * StoryDialog is a series of JOptionPane Dialogs
 * to be utilized throughout the program pertaining to the story
 */
public class StoryDialog {
    private int morality = 0;

    // FRAME CONSTRUCTION
    public StoryDialog(List<ChoiceSet> choiceSets) {
        final JFrame frame = new JFrame();
        final JPanel panel = new JPanel();

        final JTextArea dialog = new JTextArea();

        DefaultListModel<String> choices = new DefaultListModel<>();
        final JList<String> choiceSet = new JList<>(choices);

        final BorderLayout layout = new BorderLayout();

        // EDITING COMPONENTS
        dialog.setEditable(false);
        panel.setLayout(layout);

        panel.add(dialog, BorderLayout.CENTER);

        //  FRAME CONSTRUCTION
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(panel);
        frame.setSize(400, 420);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public int getMorality() { return morality; }

   /* public static void main(String[] args) {
       List<ChoiceSet> choices = new ArrayList<>();

        new StoryDialog(choices);
    }*/
}
