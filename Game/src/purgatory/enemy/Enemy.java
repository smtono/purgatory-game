package purgatory.enemy;
import purgatory.logic.Character;
import purgatory.hero.Hero;
/* Author: Shannon Thornton
 * 
 * Purpose: This file is the super class for Enemies, all enemies inherit traits listed here.
 * 
 * hit points, mana points, experience points, accuracy
 * Note about accuracy: It will be based on percentage e.g. 60 = 60%
 * 
 * health = the amount of hit points the character can take
 * mana = the amount of energy the character has to make moves
 * xp = the amount of experience a character recieves to level up
 * accuracy = determines if the move chosen will hit or not
 * evasion = determines if a character will dodge an attack, and also determines the order of battle
 * 
 * A baseline enemy will start out with 200 hit points and 60 accuracy.
 * Level 1
 * 
 * Method ideas:
 * Make the enemy harder to defeat.
 * Up defense
 * Up damage
 * etc. 
 * These wil reset enemy stats to make more stats higher, or otherwise.
 * 
 * 	TODO:
 *	Clean up documentation
 *	Add more calculation methods
 *	Integrate Character class 
 *	Change constructor to instead use super constructor of Character class
 */
@SuppressWarnings("DanglingJavadoc")
public class Enemy extends Character {
	/***************************************************************************************************************************************************************************************/

	//							CLASS VARIABLES

	/***************************************************************************************************************************************************************************************/
	private Hero hero;
	private Character character;
	/***************************************************************************************************************************************************************************************/

	//							CONSTRUCTORS

	/***************************************************************************************************************************************************************************************/
	// default
	// hp, mp, xp, acc, eva, level, damage, strength, magic
	public Enemy() {
		/*
		 *  A baseline enemy will start out with 200 hit points and 60 accuracy, 10 evasion points.
		 * Level 1
		 */
		setName("");
		setLevel(1);
		setHP(200);
		setACC(60);
		setEVA(10);
	}
	// parametized
	public Enemy(int level, int HP, int ACC, int EVA) {
		setLevel(level);
		setHP(HP);
		setACC(ACC);
		setEVA(EVA);
	}
	/***************************************************************************************************************************************************************************************/

	//							CLASS METHODS

	/***************************************************************************************************************************************************************************************/

	/***************************************************************************************************************************************************************************************/
	/**
	 * Set enemy level to a range of either 3 above or 3 below the hero's level.
	 * Using Math class random numbers, cast as an int
	 * returns the enemy level suitable for the hero's level.
	 * 
	 * @return the enemy level suitable for the hero's level
	 */
	public int determineEnemyLevel() {
		int max = hero.getLevel() + 3;
		int min = hero.getLevel() - 3;
		int enemyLevel = (int)(Math.random() * (max - min + 1) + min); // cast to int because Math.random() deals with doubles
		return enemyLevel;
	}
	/***************************************************************************************************************************************************************************************/

	//							INHERITED METHODS

	/***************************************************************************************************************************************************************************************/
	public int attack() {

		return 0;
	}
}