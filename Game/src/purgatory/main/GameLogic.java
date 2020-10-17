package purgatory.main;
import purgatory.Reference;
import purgatory.entity.Entity;
import purgatory.entity.EntityType;
import purgatory.util.EntityUtil;
import purgatory.util.MoveUtil;
import purgatory.util.StatUtil;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/*
 * Author: Shannon Thornton
 * 
 * Purpose: To implement all the game logic / calculations needed to call everything in the main method from here.
 */
public class GameLogic {

	public GameLogic() {

	}

	// Battle
	/**
	 * Get a parametrized enemy based on hero stats
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
		// hero
		Entity hero = Reference.hero;

		// calculating enemy stats
		String enemyName = StatUtil.generateRandomName();
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

	/** Get a battle sequence that interacts with the BattleGUI and user input */
	public void generateBattle() {

	}
}