package purgatory.gui;
import javax.swing.JOptionPane;

import purgatory.enemy.*;
import purgatory.hero.*;
/*
 * Author: Shannon Thornton
 * 
 * Purpose: This file implements all the battle mechanics and logic.
 * This is when implementing the GUI and action listeners, so that they can all be in one place.
 * Calculations for separate enemy and hero damage will be done in respective classes.
 * Class methods will be called from different class files in order to do this.
 * 
 * 	TODO:
 * 	Create character objects
 * 	Streamline methods to the battleSequence method so that one is the only one that needs to be called.
 */
@SuppressWarnings({"unused", "DanglingJavadoc"})
public class BattleLogic extends BattleGUI {
	/***************************************************************************************************************************************************************************************/

	//							CLASS VARIABLES	

	/***************************************************************************************************************************************************************************************/
	static Enemy enemy = new Enemy();
	static Hero hero = new Hero();
	/***************************************************************************************************************************************************************************************/

	//							CALCULATIONS	

	/***************************************************************************************************************************************************************************************/
	// "Calculations" -> Anything that involves determining a number.
	/**                   
	 * determineOrder, returns first "Character type"
	 * This method will determine which type goes first in the battle.
	 * 
	 * @return Who will go first in battle
	 */
	public static Type determineOrder() {

		final Type[] whoFirst = {Type.HERO, Type.ENEMY};
		Type order = null;
		if (hero.getEVA() > enemy.getEVA()) {
			order = whoFirst[0];
		}
		else if (hero.getEVA() < enemy.getEVA()) {
			order = whoFirst[1];
		}
		else if (hero.getEVA() == enemy.getEVA()) {
			int determiner = (int)(Math.random() * (2 - 1 + 1) + 1); // casted to int because Math.random() deals with double
			order = whoFirst[determiner];
		}
		return order;
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
	public static int damageEnemy(String heroMove) {
		battleText.append("\nYou chose: " + heroMove + "!\n"); // prints to the battle screen
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
	public static int damageHero() {

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
	 */
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
	/***************************************************************************************************************************************************************************************/
	/**
	 * startBattle 
	 * This will prepare the GUI for the hero, giving them important information about the enemy they just encountered.
	 * will tell the user they encountered an enemy and then will bring up the turn based combat system.
	 * using timeout like function, (it'll be difference when using swing,) make the user wait once the enemy has attacked.
	 */
	public void startBattle() {
		String enemyStats = enemy.getInfo();
		battleText.append("A wild monster appeared!\n");
		statsText.append(enemyStats);
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