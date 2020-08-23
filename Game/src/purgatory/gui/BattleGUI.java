package purgatory.gui;

import purgatory.entity.Entity;
import purgatory.logic.GameLogic;

import java.awt.BorderLayout;
import javax.swing.*;

/*
 * Author: Shannon Thornton
 *
 * Purpose: To construct the GUI for the battle sequence of the game.
 * This particular file will include all the components needed, and set them up correctly.
 * A separate file will deal with the implementation of methods.
 *
 * TODO:
 * Figure out how to recursively use heroMoveSelected.
 * Possibly by using a while loop and keeping track of the iteration
 * Reset all hard coded class variables to use objects instead
 * Clean up class variables so that appropriate variables go to their respective classes
 */
@SuppressWarnings("DanglingJavadoc")
public class BattleGUI {

    //	VARIABLES
    // class variables
    // for GUI
    DefaultListModel moves = new DefaultListModel();
    private String[] menu = {"Run", "Profile", "Items", "Help"};
    private String moveSelected;
    private String menuSelected;

    //	PANEL COMPONENTS
    // declare panel components
    // static so that they are edited by methods throughout the class
    private final JFrame frame = new JFrame("Battle!"); // the container where everything will be put
    // Text areas
    private final JTextArea battleText = new JTextArea(); // text area to display what is happening in the battle
    private final JTextArea statsText = new JTextArea(); // text area to display hero stat's as they deplete (or replenish)
    // JLists
    private final JList<String> menuSet = new JList<>(menu); // displays menu choices
    private final JList<String> moveSet = new JList<>(moves); // displays moves in a list
    // JLabels
    private final JLabel enemyName = new JLabel("Enemy"); // displays the enemy's name.
    private final JLabel heroName = new JLabel("Hero"); // displays hero's name
    // JSplitPanes, used to store components together in one spot on the GUI
    private final JSplitPane eastSide = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, statsText, menuSet); // to split up the components on the east side of the GUI
    private final JSplitPane southSide = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, heroName, moveSet); // to split up the components on the south side of the GUI
    // CONSTRUCTOR
    public BattleGUI() {
            //  COMPONENT PLACEMENT
            // prepares the GUI with components in the correct place
            // panel, setting up the layout
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
            moveSet.addListSelectionListener(event -> {
                if (!event.getValueIsAdjusting()) {
                    @SuppressWarnings("unchecked")
                    JList<String> source = (JList<String>) event.getSource(); // gets which move the user picked
                    moveSelected = source.getSelectedValue(); // stores the value into a string variable
                }
            });
            menuSet.addListSelectionListener(event -> {
                if (!event.getValueIsAdjusting()) {
                    @SuppressWarnings("unchecked")
                    JList<String> source = (JList<String>) event.getSource(); // gets which menu option the user picked
                    menuSelected = source.getSelectedValue(); // stores the value into a string variable
                }
            });
            /***************************************************************************************************************************************************************************************/

            //							FRAME CONSTRUCTION

            /***************************************************************************************************************************************************************************************/
            // setting up the frame
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(panel);
            frame.setSize(500, 500);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
    } // end GUI()

    // UTILITY METHODS
    // append text
    public void appendBattleText(String text) {
        battleText.append(text);
    }
    public void appendStatsText(String text) { statsText.append(text); }
    // ACCESSORS / MUTATORS
    public String getMoveSelected() { return moveSelected; }
    public void setMoves(String[] heroMoves) {
        for (int i = 0; i < heroMoves.length; i++ ) {
            moves.add(i, heroMoves[i]);
        }
    }
}