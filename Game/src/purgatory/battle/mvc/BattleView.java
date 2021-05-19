package purgatory.battle.mvc;

import purgatory.entity.Entity;

import java.awt.BorderLayout;
import javax.swing.*;

/**
 * BattleView launches a UI in which the player will engage in a battle with a number of enemies based on
 * parameters such as terrace level, room number, enemy type, etc.
 * <p>
 * It will include all the components of the GUI needed, and set them up correctly.
 * A separate file will deal with the implementation of methods.
 */
public class BattleView {
    final JFrame frame = new JFrame("Battle!"); // the container where everything will be put

    // Text areas
    private final JTextArea battleText = new JTextArea(); // text area to display what is happening in the battle
    private final JTextArea statsText = new JTextArea(); // text area to display hero stat's as they deplete (or replenish)

    // JLabels
    final JLabel heroName = new JLabel("Hero"); // displays current hero's name

    // CONSTRUCTOR
    public BattleView() {
        // JLabels
        final JLabel greeting = new JLabel("You have entered a battle!"); // header

        //  COMPONENT PLACEMENT
        final BorderLayout layout = new BorderLayout();
        final JPanel panel = new JPanel();

        // tweaking components
        battleText.setEditable(false);
        statsText.setEditable(false);

        // tweaking panels
        panel.setLayout(layout);

        // adding components to the right place
        panel.add(greeting, BorderLayout.NORTH);
        panel.add(battleText, BorderLayout.CENTER);
        panel.add(statsText, BorderLayout.EAST);
        panel.add(heroName, BorderLayout.SOUTH);
        
        //  FRAME CONSTRUCTION
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(700, 700);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // UTILITY METHODS

    /**
     * Appends to the battleText JTextArea in the BattleView GUI
     *
     * @param text: A string to display on the BattleView GUI
     */
    public void appendBattleText(String text) {
        battleText.append(text);
    }

    /**
     * Clears the battleText JTextArea in the BattleView GUI
     */
    public void clearBattleText() {
        battleText.setText("");
    }

    /** Appends to the statsText JTextArea in the BattleView GUI */
    public void appendStatsText(String text) {
        statsText.append(text);
    }

    /** Clears the statsText JTextArea in the BattleView GUI */
    public void clearStatsText() {
        statsText.setText("");
    }

    /** Sets the JLabel of the current hero fighting to the current hero */
    public void setCurrentHeroName(String name) { heroName.setText(name); }
}