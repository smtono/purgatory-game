package purgatory.battle;

import purgatory.entity.Entity;
import purgatory.move.Attack;
import purgatory.move.Move;
import purgatory.stats.StatUtil;

import java.util.*;

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
     * @return A list with a number of requested enemies based on hero stats
     */
    public static List<Entity> generateEnemies(int numEnemies) {
        List<Entity> enemies = new ArrayList<>();

        // TODO: write the loop for generating enemies and their stats

        return enemies;
    }

    /**
     * Sorts the list of fighters based on speed stat of entity objects
     */
    public void determineOrder() {
        fighters.sort(Comparator.comparingInt(Entity::getSpeed));
        Collections.reverse(fighters);
    }

    // DIRECT ATTACKS
    /**
     *
     */
    public void defendEnemy() {
        // code
    }

    /**
     * Returns an int that will represent the damage inflicted on the enemy
     * based on the damage value of the move, along with the stats of the hero
     *
	 * @param heroMove: The string value of the move that the user (player) picked.
     * @return Returns an int that will represent the damage inflicted on the enemy.
     */
    public int damageEnemy(String heroMove, Entity enemy) {
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
     * Returns an int based on the move chosen (randomly) by enemy entity
     *
     * @param enemy: The entity object associated with the enemy attacking
     * @param move: The move randomly chosen by an enemy, specifically an attack move
     * @return int that will represent the amount of damage inflicted on the hero
     */
    public int damageHero(Entity enemy, Attack move) {

        return 0;
    }
}