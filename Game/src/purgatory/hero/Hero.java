package purgatory.hero;
import purgatory.logic.Character;
/*
 * Author: Shannon Thornton
 * 
 * Purpose: This file is the super class for the Hero build. All hero types inherit traits listed here.
 * 
 * Attributes of a hero:
 * Health
 * Energy
 * Experience
 * Accuracy
 * 
 * hit points, mana points, experience points, accuracy
 * 
 * Note about accuracy: It will be based on percentage e.g. 60 = 60%
 * 
 * health = the amount of hit points the character can take
 * mana = the amount of energy the character has to make moves
 * xp = the amount of experience a character receives to level up
 * accuracy = determines if the move chosen will hit or not
 * evasion = determines if a character will dodge an attack, and also determines the order of battle
 * 
 * A baseline hero will start out with 100 hit points, 20 mana points, 0 experience, and 60 accuracy.
 * Level 0
 */


@SuppressWarnings("DanglingJavadoc")
public class Hero extends Character {
	/***************************************************************************************************************************************************************************************/

	//							CLASS VARIABLES

	/***************************************************************************************************************************************************************************************/
	// move sets
	protected String warriorMoves[] = {
			"null",
			"Punch",
			"Forward slash",
			"Uppercut",
	};
	protected String mageMoves[] = {
			"null",
			"Fire",
			"Ice",
			"Earth",
			"Wind",
	};
	/***************************************************************************************************************************************************************************************/

	//							CONSTRUCTORS

	/***************************************************************************************************************************************************************************************/
	// default
	//hp, mp, xp, acc, eva, level, damage, strength, magic;
	public Hero() {
		setLevel(1);
		setHP(100);
		setMP(20);
		setXP(0);
		setACC(60);
	}
	// parametrized
	public Hero(int level, int HP, int MP, int XP, int ACC) {
		/*
		 * TODO:
		 * Add all attributes
		 */
		setLevel(level);
		setHP(HP);
		setMP(MP);
		setXP(XP);
		setACC(ACC);
	}
	/***************************************************************************************************************************************************************************************/

	//							CLASS METHODS

	/***************************************************************************************************************************************************************************************/
	public String[] getMoves(HeroType hero) {
		switch (hero) {
		case WARRIOR :
			return warriorMoves;
		case MAGE :
			return mageMoves;
		default :
			return null;
		} 
	}
	/***************************************************************************************************************************************************************************************/

	//							INHERITED METHODS

	/***************************************************************************************************************************************************************************************/
	/**
	 * TODO:
	 * make it so you can't access the move set unless you are a certain level. highest level? make it like 50 or something.
	 * so that means make a switch case for the level, and access different moves according to that.
	 * there will have to be a function for move set that allows for the hero to swap out moves they want.
	 * 
	 * @return damage amount hero attacks
	 */
	public int attack() { // attack, each class needs an attack method e.g mage would have spells
		return 0;
	}
} 