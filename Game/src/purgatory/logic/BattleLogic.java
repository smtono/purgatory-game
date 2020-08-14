package purgatory.logic;
import javax.swing.JOptionPane;

import purgatory.entity.Entity;
import purgatory.gui.BattleGUI;
import purgatory.logic.GameLogic;
import purgatory.util.EntityUtil;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/*
 * Author: Shannon Thornton
 * 
 * Purpose: This file implements all the battle mechanics and logic, using Entity and EntityType.
 * BattleLogic constructor will be called to initiate a battle.
 */
@SuppressWarnings({"unused", "DanglingJavadoc"})
public class BattleLogic {
	//	CLASS VARIABLES
	private List<Entity> fighters;
	private BattleGUI gui = new BattleGUI();
	// CONSTRUCTOR
	public BattleLogic(List<Entity> fighters) {
		this.fighters = fighters;
		List<String> heroMoves = GameLogic.hero.getMoves(GameLogic.hero.getEntityType());
		String[] moves = new String[heroMoves.size()];
		moves = heroMoves.toArray(moves);
		gui.setMoves(moves);
		determineOrder();
		startBattle();
	}
	//	CALCULATIONS
	/**                   
	 * determineOrder
	 * compare each fighter's (Entity) speed
	 * sort the list
	 *
	 * @return the order of fighters 1st to last, in the form of a poppable list
	 */
	public void determineOrder() {
		/*
			Explaining how this works:
			Collections has a sort function, which can take two parameters. What is being sorted, and how to sort them.
			So the first parameter is everyone fighting in the battle (fighters)
			The second parameter is using Comparator, which will compare each fighter using the getSpeed method in the Entity class
			Hence why the syntax is Entity::getSpeed (:: means reference)
			It pushes the order of fighters from least speed to most, so we have to reverse the order after everything is pushed.
		 */
		Collections.sort(fighters, Comparator.comparingInt(Entity::getSpeed));
		Collections.reverse(fighters);
	}


	/***************************************************************************************************************************************************************************************/
	/**
	 * damageEnemy int
	 * This method will represent the hero's turn.
	 * This method will take in a string (the JList is made up of strings, so just pass the index of what the user chose in the list)
	 * And based on the move, will return an int that will represent the damage inflicted on the enemy.
	 * 
	 * @return int that will represent the damage inflicted on the enemy.
	 */
	public int damageEnemy(String heroMove) {
		gui.appendBattleText("\nYou chose: " + heroMove + "!\n"); // prints to the battle screen
		// heroDamage = hero.heroAttack(heroMove); this will call the attack function in the Hero class and return the damage output of that particular move.
		// return heroDamage;
		return 10;
	}
	/***************************************************************************************************************************************************************************************/
	/**
	 * damageHero
	 * This method will represent the enemy's turn
	 * This method will also take in a string like in damageEnemy, this will be taken from the Enemy class.
	 * Based on the move, will return an int that will represent the amount of damage inflicted on the hero.
	 * 
	 * @return int that will represent the amount of damage inflicted on the hero.
	 */
	public int damageHero() {

		return 10;
	}
	/***************************************************************************************************************************************************************************************/

	//							SEQUENCES	

	/***************************************************************************************************************************************************************************************/
	/**
	 * battleSequence 
	 * Call startBattle() if turn iteration is 0,
	 * determine enemy level,
	 * determine order,
	 * recursively call turnSequence.
	 * TODO: redo
	 */
	/*
		public void battleSequence() {
		// method variables
		int enemyLevel;
		Type order;
		if (turnIteration == 0) {
			startBattle();
			enemyLevel = enemy.determineEnemyLevel();
			order = determineOrder();
			battleText.append("\n" + order + "Will be going first!\n");
		}
	}
	*/
	/***************************************************************************************************************************************************************************************/
	/**
	 * startBattle 
	 * This will prepare the GUI for the hero, giving them important information about the enemy they just encountered.
	 * will tell the user they encountered an enemy and then will bring up the turn based combat system.
	 * using timeout like function, (it'll be difference when using swing,) make the user wait once the enemy has attacked.
	 */
	public void startBattle() {
		StringBuilder builder = new StringBuilder();
		EntityUtil.getEnemiesFromSet(fighters).iterator().forEachRemaining(entity -> {
			builder.append(entity.getEnemyInfo());
			builder.append("\n\n");
		});
		gui.appendBattleText("A team of wild monsters appeared!\n");
		gui.appendStatsText(builder.toString());
		// prompts hero that they have encountered and enemy, and gives a brief tutorial on how to play.
		JOptionPane.showMessageDialog(null, "You have just enter a battle!\n"
				+ "Read your enemy's stats, and choose the move that would best counter it!\n"
				+ "Different enemies have different weaknesses!", "Enemy Appeared!", JOptionPane.INFORMATION_MESSAGE);
	}
	/***************************************************************************************************************************************************************************************/		
	/**
	 * turnSequence int
	 * This method will contain both the hero and enemy's turn
	 * Call this method recursively until one of the following exit conditions are reached:
	 * The hero HP reaches 0 (die sequence)
	 * the enemy HP reaches 0 (level up/ gain loot, etc.)
	 * the hero runs away (return to main screen, implement this one last.)
	 * returns an int which will be used to keep tack of iterations, since this method will be called recursively.
	 *
	 * @return An int which will be used to keep tack of iterations
	 */
	/*
		public static int turnSequence(int iteration, int enemyLevel, Type whoFirst) {
		// method variables
		final int enemyFullHP = enemy.getHP();
		final int heroFullHP = hero.getHP();

		switch (whoFirst) {
		case HERO: {
			int heroDamage = damageEnemy(heroMoveSelected);
			// enemy.setHP(enemy.getHP - heroDamage);
			if (iteration == 0)
				enemyHP = enemyFullHP - heroDamage;
			else
				enemyHP = enemyHP - heroDamage;
			break;
		}
		case ENEMY: {
			damageHero();
		}
		default :
			JOptionPane.showMessageDialog(null, "Error! Could not determine whoFirst", "Error", JOptionPane.ERROR_MESSAGE);
		}
		turnIteration++;  // use this value to determine how many turns it took the player to beat the enemy
		return turnIteration;
		}
	 */
	/***************************************************************************************************************************************************************************************/	
	/**
	 * dieSequence int
	 * prints out a death script, takes current death count and adds it need to keep up with that variable.
	 * returns amount of time hero has died
	 * 
	 * @return amount of times hero has died
	 */
	public int dieSequence(int currentDeath) {
		currentDeath++;
		JOptionPane.showMessageDialog
		(null, 
				"\nHero! You have died.\nYou have died: " + currentDeath + " times.\n",
				"You have died!", 
				JOptionPane.INFORMATION_MESSAGE);
		return currentDeath;
	}
}