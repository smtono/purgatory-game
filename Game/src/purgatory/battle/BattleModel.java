package purgatory.battle;
import javax.swing.JOptionPane;

import purgatory.Reference;
import purgatory.entity.Entity;
import purgatory.entity.EntityType;
import purgatory.util.EntityUtil;
import purgatory.util.MoveUtil;
import purgatory.util.StatUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
/*
 * Author: Shannon Thornton
 *
 * Purpose: To implement all the battle mechanics and logic, using Entity and EntityType.
 * BattleLogic constructor will be called to initiate a battle.
 */

public class BattleModel {
	/**
	 * Get a parametrized enemy based on hero stats
	 *
	 * formula to determine what each stat will be based on the hero's:
	 * type: random
	 * health: x2
	 * mana: 0
	 * speed: random from 1 to 30
	 * accuracy: random from .60 to 1.00
	 * strength:
	 * magic:
	 * defense:
	 * level: 3 above or below hero
	 *
	 * @return An enemy entity with stats tailored to hero's level.
	 */
	public Entity generateEnemy() {
		// hero
		Entity hero = Reference.hero;

		// calculating enemy stats
		String enemyName = StatUtil.generateRandomName();
		EntityType enemyType = EntityUtil.getEnemies().get(ThreadLocalRandom.current().nextInt(EntityUtil.getEnemies().size()));
		int enemyCurrentHealth = hero.getMaxHealth() * 2;
		final int ENEMY_MAX_HEALTH = hero.getMaxHealth() * 2;
		int enemySpeed = ThreadLocalRandom.current().nextInt(1, 30 + 1);
		double enemyAccuracy = ThreadLocalRandom.current().nextDouble(0.6, 1);
		int strength = 0;
		int magic = 0;
		int defense = 0;
		int enemyLevel = ThreadLocalRandom.current().nextInt(hero.getLevel(), hero.getLevel() + 3);

		return new Entity(enemyName, enemyType, ENEMY_MAX_HEALTH, 0, enemySpeed, enemyAccuracy, strength, magic,
				MoveUtil.getEnemyMoveSet(enemyType, 1), enemyLevel);
	}

	/**
	 * Sorts the list of fighters based on speed stat, and returns the order as a string
	 *
	 * @return The order of the fighters based on speed as a string.
	 */
	public String determineOrder(List<Entity> fighters) {
		fighters.sort(Comparator.comparingInt(Entity::getSpeed));
		Collections.reverse(fighters);

		StringBuilder builder = new StringBuilder();
		builder.append("The order of battle is: \n");
		fighters.forEach(fighter -> {
			builder.append(fighter.getName());
			builder.append(" \n");
		});

		return builder.toString();
	}

	/**
	 * damageEnemy int
	 * This method will represent the hero's turn.
	 * This method will take in a string (the JList is made up of strings, so just pass the index of what the user chose in the list)
	 * And based on the move, will return an int that will represent the damage inflicted on the enemy.
	 *
	 * @return int that will represent the damage inflicted on the enemy.
	 */
	public int damageEnemy(String heroMove) {
		// heroDamage = hero.heroAttack(heroMove); this will call the attack function in the Hero class and return the damage output of that particular move.
		// return heroDamage;
		return 10;
	}

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
}