package purgatory.logic;
import purgatory.entity.Entity;
import purgatory.entity.EntityType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/*
 * Author: Shannon Thornton
 * 
 * Purpose: This file implements all the game logic.
 * 
 * TODO:
 * Make this file the drive for the main method.
 * Call methods from here to the main method
 */
@SuppressWarnings("DanglingJavadoc")
public class GameLogic {
	//	CLASS VARIABLES
	public static Entity hero = new Entity(EntityType.MAGE);
	// CONSTRUCTOR
	public GameLogic() {

	}
	//	CLASS METHODS
	// General
	/**
	 *  chooseHero 
	 *  using JOptionPane we will store what type of hero the user wants to be.
	 *  prompt the user of which hero type they would like to be
	 *  possibly provide a description for each
	 *  set the entity type of the generic hero to the type the user picks.
	 */
	public void chooseHero() {
		EntityType userChoice = null;
		/*TODO:
			make a gui for choosing a hero (Make it a quiz?)
			implement logic for gui
			call that logic here
		 */

		hero.setEntityType(userChoice);
	}
	// Battle
	/**
	 * generateEnemy
	 * hero's level will change, so must be done outside of the battle GUI.
	 * the enemy will be 3 levels above or below what the hero currently is.
	 *
	 * formula to determine what each stat will be based on the hero's:
	 * type: random
	 * hit points: x2
	 * speed: random from 1 to 30
	 * accuracy: random from .60 to 1.00
	 * level: 3 above or below hero
	 */
	//TODO: Fix with new Moves enum
	public Entity generateEnemy() {
		// adding enemies to a list
		List<EntityType> enemies = EntityType.getEnemies();
		// method variables
		int heroCurrentLevel = hero.getLevel();
		EntityType enemyType = enemies.get(ThreadLocalRandom.current().nextInt(enemies.size()));
		int enemyHealth = hero.getMaxHealth() * 2;
		int enemySpeed = ThreadLocalRandom.current().nextInt(1, 30 + 1);
		double enemyAccuracy = ThreadLocalRandom.current().nextDouble(0.6, 1);
		int enemyLevel = ThreadLocalRandom.current().nextInt(heroCurrentLevel, heroCurrentLevel + 3);
		// private Entity enemy = new Entity(null, 200, 0, 10, 0.6, 0, 1); // generic enemy
		//public Entity(EntityType entityType, int maxHealth, int mana, int speed, double accuracy, int xp, int strength, int magic, int level)
		//Entity enemy = new Entity(enemyType, enemyHealth, 0, enemySpeed, enemyAccuracy, 0, enemyLevel);
		// return enemy;

		// place holder enemy
		Entity enemy = new Entity(EntityType.SLIME);
		return enemy;
	}
	/******************************************************/
	/**
	 * generateBattle
	 * originally this was going to be done in BattleLogic, however it would make more sense to put the logic for it here.
	 * This method will call the BattleGUI and implement logic needed for turn sequences
	 */
	public void generateBattle() {

	}
}
