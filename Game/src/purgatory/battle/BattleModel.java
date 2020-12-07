package purgatory.battle;

import javax.swing.JOptionPane;

import purgatory.Reference;
import purgatory.entity.CharacterType;
import purgatory.entity.Entity;
import purgatory.entity.EntityType;
import purgatory.util.EntityUtil;
import purgatory.util.MoveUtil;
import purgatory.util.StatUtil;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * BattleModel serves as the logic of the battle system.
 * <p>
 * It will take in a list of fighters that will be manipulated by order.
 */
public class BattleModel {
    private final List<Entity> fighters;

    public BattleModel(List<Entity> fighters) {
        this.fighters = fighters;
    }

    public List<Entity> getFighters() {
        return fighters;
    }

    /**
     * Returns a list of enemies based on hero stats.
     *
     * Uses a set of methods for stat manipulation
     * @see StatUtil
     *
     * @param numEnemies: The amount of enemies that will be returned
     * @return A list with a number of requested enemies based on hero stats.
     */
    public static List<Entity> generateEnemies(int numEnemies) {
        List<Entity> enemies = new ArrayList<>();

        // TODO: write the loop for generating enemies and their stats

        return enemies;
    }

    /**
     * Sorts the list of fighters based on speed stat
     */
    public void determineOrder(List<Entity> fighters) {
        fighters.sort(Comparator.comparingInt(Entity::getSpeed));
        Collections.reverse(fighters);
    }

    /**
     * damageEnemy int
     * This method will represent the hero's turn.
     * This method will take in a string (the JList is made up of strings, so just pass the index of what the user chose in the list)
     * And based on the move, will return an int that will represent the damage inflicted on the enemy.
     *
	 * @param heroMove: The string value of the move that the user (player) picked.
     * @return int that will represent the damage inflicted on the enemy.
     */
    public int damageEnemy(String heroMove) {
        // heroDamage = hero.heroAttack(heroMove); this will call the attack function in the Hero class and return the damage output of that particular move.
        // return heroDamage;
        return 10;
    }

	/**
	 *
	 */
	public void defendHero() {
    	// code
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

	/**
	 *
	 */
	public void defendEnemy() {
    	// code
	}
}