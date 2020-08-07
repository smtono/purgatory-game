package Game.GUI;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
public class BattleGUI {
	/***************************************************************************************************************************************************************************************/

	//							CLASS VARIABLES

	/***************************************************************************************************************************************************************************************/
	// class variables
	// String heroType; // declares the hero type which will be used to determine the move set
	// for GUI
	static String moves[] = {"Fire", "Ice", "Earth"};
	static String menu[] = {"Run", "Profile", "Items"};
	enum EnemyType {FIRE, ICE, EARTH};
	static int enemyStats[] = {0, 200, 60}; // hp and accuracy, hard coded
	static int heroStats[] = {0, 100, 60}; // hp and accuracy
	static EnemyType type = EnemyType.FIRE; // the enemy's type which was enumerated to make method arguments easier to implement
	// for methods
	static String heroMoveSelected = "";
	static int heroHP, enemyHP;
	static int turnIteration = 0;
	enum Type {HERO, ENEMY;};
	/***************************************************************************************************************************************************************************************/

	//							PANEL COMPONENTS

	/***************************************************************************************************************************************************************************************/
	// declare panel components
	// static so that they are edited by methods throughout the class
	final static JFrame frame = new JFrame("Battle!"); // the container where everything will be put
	// Text areas
	final static JTextArea battleText = new JTextArea(); // text area to display what is happening in the battle
	final static JTextArea statsText = new JTextArea(); // text area to display hero stat's as they deplete (or replenish)
	// JLists
	final static JList<String> menuSet = new JList<>(menu); // displays menu choices
	final static JList<String> moveSet = new JList<>(moves); // displays moves in a choosable list
	// JLabels
	final static JLabel enemyName = new JLabel("Enemy"); // displays the enemy's name.
	final static JLabel heroName = new JLabel("Hero"); // displays hero's name
	// JSplitPanes, used to store components together in one spot on the GUI
	final static JSplitPane eastSide = new JSplitPane(SwingConstants.HORIZONTAL, statsText, menuSet); // to split up the components on the east side of the GUI
	final static JSplitPane southSide = new JSplitPane(SwingConstants.HORIZONTAL, heroName, moveSet); // to split up the components on the south side of the GUI
	/***************************************************************************************************************************************************************************************/

	//							COMPONENT PLACEMENT

	/***************************************************************************************************************************************************************************************/
	// prepares the GUI with components in the correct place
	public BattleGUI() {
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
		/***************************************************************************************************************************************************************************************/	

		//							ACTION LISTENERS

		/***************************************************************************************************************************************************************************************/
		/**
		 * Move set action listener
		 * to test:
		 * Fire outputs to the battle text area : "You chose fire!"
		 * Ice, Wind, etc.... does likewise.
		 */
		moveSet.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent event) {
				if (!event.getValueIsAdjusting()) {
					@SuppressWarnings("unchecked")
					JList<String> source = (JList<String>)event.getSource(); // gets which move the user picked
					heroMoveSelected = source.getSelectedValue().toString(); // stores the value into a string variable
				}
			}
		});
		/**
		 * Menu set action listener
		 * to test:
		 * Use different jdialog boxes to display different messages depending on what is selected.
		 */
		menuSet.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				// ListSelectionModel userChoice = (ListSelectionModel)event.getSource();
				JOptionPane.showMessageDialog(null, "test");
			} // end valueChanged()
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
}