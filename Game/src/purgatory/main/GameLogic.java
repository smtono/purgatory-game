package purgatory.main;
import purgatory.Reference;
import purgatory.battle.Move;
import purgatory.entity.Entity;
import purgatory.entity.EntityType;
import purgatory.util.EntityUtil;
import purgatory.util.MoveUtil;

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
	public static Entity hero;

	// CONSTRUCTOR
	public GameLogic() {

	}

	// ACCESSORS / MUTATORS
	public static Entity getHero() { return hero; }
	public static void setHero(String heroName, EntityType heroType) {
		hero = new Entity(heroName, heroType);
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
		// setting random generator
		Random gen = new Random();

		// calculating enemy stats
		String enemyName = Reference.NAMES_GENERIC[gen.nextInt(Reference.NAMES_GENERIC.length)]; // **********FIX*************
		EntityType enemyType = EntityUtil.getEnemies().get(ThreadLocalRandom.current().nextInt(EntityUtil.getEnemies().size()));
		int enemyCurrentHealth = hero.getMaxHealth() * 2;
		final int ENEMY_MAX_HEALTH = hero.getMaxHealth() * 2;
		int enemySpeed = ThreadLocalRandom.current().nextInt(1, 30 + 1);
		double enemyAccuracy = ThreadLocalRandom.current().nextDouble(0.6, 1);
		int enemyLevel = ThreadLocalRandom.current().nextInt(hero.getLevel(), hero.getLevel() + 3);

		return new Entity(enemyName,
						enemyType,
						ENEMY_MAX_HEALTH,
						0,
						enemySpeed,
						enemyAccuracy,
						0,
						0, // strength
						0, //int magic,
						MoveUtil.getEnemyMoveSet(enemyType, 1), // move set
						enemyLevel);
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