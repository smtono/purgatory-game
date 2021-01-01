package purgatory.battle;

import purgatory.entity.CharacterType;
import purgatory.entity.Entity;
import purgatory.entity.EntityUtil;
import purgatory.move.Attack;
import purgatory.stats.StatUtil;
import purgatory.terraces.Terrace;

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
     * Sorts the list of fighters based on speed stat of entity objects
     */
    public void determineOrder() {
        fighters.sort(Comparator.comparingInt(Entity::getSpeed));
        Collections.reverse(fighters);
    }

    // DIRECT ATTACKS
    /**
     * Returns an int that will represent the damage inflicted on the enemy
     * based on the damage value of the move, along with the stats of the hero
     *
     * @param hero: The entity object associated with the hero attacking
     * @param enemy: The enemy entity object being attacked
     * @param move: The move chosen by the player, specifically an attack move
     * @return Returns an int that will represent the damage inflicted on the enemy.
     */
    public int damageEnemy(Entity hero, Entity enemy, Attack move) {
        // heroDamage = hero.heroAttack(heroMove); this will call the attack function in the Hero class and return the damage output of that particular move.
        // return heroDamage;
        return 10;
    }

    /**
     * Returns an int based on the move chosen (randomly) by enemy entity
     *
     * @param enemy: The entity object associated with the enemy attacking
     * @param hero: The entity object associated with the current hero
     * @param move: The move randomly chosen by an enemy, specifically an attack move
     * @return int that will represent the amount of damage inflicted on the hero
     */
    public int damageHero(Entity enemy, Entity hero, Attack move) {

        return 0;
    }

    /**
     * Gathers current stats of all fighters
     *
     * @return
     */
    public Map<String, Object> getCurrentState() {

    }
}