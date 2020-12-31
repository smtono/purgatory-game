package purgatory.battle;

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
    DefaultListModel<String> moves = new DefaultListModel<>();
    private String currHeroName = "Hero";
    private String moveSelected;
    private String menuSelected;

    // Text areas
    private final JTextArea battleText = new JTextArea(); // text area to display what is happening in the battle
    private final JTextArea statsText = new JTextArea(); // text area to display hero stat's as they deplete (or replenish)

    // CONSTRUCTOR
    public BattleView() {
        final String[] menu = {"Run", "Profile", "Items", "Help"};

        //	PANEL COMPONENTS
        // Frame
        final JFrame frame = new JFrame("Battle!"); // the container where everything will be put

        // JLists
        final JList<String> menuSet = new JList<>(menu); // displays menu choices
        final JList<String> moveSet = new JList<>(moves); // displays moves in a list

        // JLabels
        final JLabel enemyName = new JLabel("You have entered a battle!"); // header
        final JLabel heroName = new JLabel(currHeroName); // displays hero's name

        // JSplitPanes, used to store components together in one spot on the GUI
        final JSplitPane eastSide = new JSplitPane(JSplitPane.VERTICAL_SPLIT, statsText, menuSet); // to split up the components on the east side of the GUI
        final JSplitPane southSide = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, heroName, moveSet); // to split up the components on the south side of the GUI

        //  COMPONENT PLACEMENT
        final BorderLayout layout = new BorderLayout();
        final JPanel panel = new JPanel();
        // tweaking components
        battleText.setEditable(false);
        statsText.setEditable(false);
        eastSide.setDividerLocation(300);
        // tweaking panels
        panel.setLayout(layout);
        // adding components to the right place
        panel.add(enemyName, BorderLayout.NORTH);
        panel.add(battleText, BorderLayout.CENTER);
        panel.add(eastSide, BorderLayout.EAST);
        panel.add(southSide, BorderLayout.SOUTH);

        //	ACTION LISTENERS
        // Move selected
        moveSet.addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()) {
                @SuppressWarnings("unchecked")
                JList<String> source = (JList<String>) event.getSource(); // gets which move the user picked
                moveSelected = source.getSelectedValue(); // stores the value into a string variable
            }
        });

        // Menu item selected
        menuSet.addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()) {
                @SuppressWarnings("unchecked")
                JList<String> source = (JList<String>) event.getSource(); // gets which menu option the user picked
                menuSelected = source.getSelectedValue(); // stores the value into a string variable
            }
        });

        //  FRAME CONSTRUCTION
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(500, 500);
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
     * Appends to the statsText JTextArea in the BattleView GUI
     *
     * @param text: A string to display on the BattleView GUI
     */
    public void appendStatsText(String text) {
        statsText.append(text);
    }

    /**
     * Returns the string of the move that the user chose
     *
     * @return the string value of the move from the move set that the user chose
     */
    public String getMoveSelected() {
        return moveSelected;
    }

    /**
     * Sets up the move set for the JList in the BattleView GUI
     *
     * @param heroMoves: An array of strings of the moves the hero can use
     */
    public void setMoves(String[] heroMoves) {
        for (int i = 0; i < heroMoves.length; i++) {
            moves.add(i, heroMoves[i]);
        }
    }

    /**
     * Sets the current name of the current unit
     *
     * @param unit: The current Entity object used for the unit
     */
    public void setCurrentHeroName(Entity unit) {
        currHeroName = unit.getName();
    }
}