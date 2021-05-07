package purgatory.battle;

import purgatory.entity.Entity;

import java.awt.BorderLayout;
import java.awt.event.*;
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
    private final String[] menu = {"Run", "Profile", "Items", "Help"};
    private final JList<String> menuSet = new JList<>(menu); // displays menu choices
    private final JList<String> moveSet = new JList<>(moves); // displays moves in a list

    // Text areas
    private final JTextArea battleText = new JTextArea(); // text area to display what is happening in the battle
    private final JTextArea statsText = new JTextArea(); // text area to display hero stat's as they deplete (or replenish)

    // JLabels
    final JLabel heroName = new JLabel("Hero"); // displays current hero's name

    // CONSTRUCTOR
    public BattleView() {
        //	PANEL COMPONENTS
        // Frame
        final JFrame frame = new JFrame("Battle!"); // the container where everything will be put

        // JLabels
        final JLabel greeting = new JLabel("You have entered a battle!"); // header

        // JSplitPanes, used to store components together in one spot on the GUI
        final JSplitPane eastSide = new JSplitPane(JSplitPane.VERTICAL_SPLIT, statsText, menuSet); // to split up the components on the east side of the GUI
        final JSplitPane southSide = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, heroName, moveSet); // to split up the components on the south side of the GUI

        //  COMPONENT PLACEMENT
        final BorderLayout layout = new BorderLayout();
        final JPanel panel = new JPanel();

        // tweaking components
        battleText.setEditable(false);
        statsText.setEditable(false);

        eastSide.setDividerLocation(500);
        southSide.setDividerLocation(100);

        eastSide.setOneTouchExpandable(true);
        southSide.setOneTouchExpandable(true);

        // tweaking panels
        panel.setLayout(layout);

        // adding components to the right place
        panel.add(greeting, BorderLayout.NORTH);
        panel.add(battleText, BorderLayout.CENTER);
        panel.add(eastSide, BorderLayout.EAST);
        panel.add(southSide, BorderLayout.SOUTH);

        //	ACTION LISTENERS
      /*  moveSet.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                @SuppressWarnings("unchecked")
                JList<String> source = (JList<String>) e.getSource(); // gets which move the user picked

                if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2) {

                    int index = source.locationToIndex(e.getPoint());
                    if (index >= 0) {
                        Object o = source.getModel().getElementAt(index);
                        // System.out.println("Double-clicked on: " + o.toString());
                        //moveSelected = o.toString();
                    }
                }
            }
        }); */

        // Menu item selected
        menuSet.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2) {
                    @SuppressWarnings("unchecked")
                    JList<String> source = (JList<String>) e.getSource(); // gets which move the user picked
                   // menuSelected = source.getSelectedValue(); // stores the value into a string variable

                    //System.out.println(menuSelected);
                }
            }
        });

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

    /**
     * Appends to the statsText JTextArea in the BattleView GUI
     *
     * @param text: A string to display on the BattleView GUI
     */
    public void appendStatsText(String text) {
        statsText.append(text);
    }

    /**
     * Clears the statsText JTextArea in the BattleView GUI
     */
    public void clearStatsText() {
        statsText.setText("");
    }
    

    public void enableMoveSet(boolean enable) {
        moveSet.setEnabled(enable);
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

    // ACCESSOR
    public JList<String> getMoveSet() {
        return moveSet;
    }
    public JList<String> getMenuSet() {
        return menuSet;
    }
    
    // MUTATOR
    public void setCurrentHeroName(String name) {
        heroName.setText(name);
    }
}