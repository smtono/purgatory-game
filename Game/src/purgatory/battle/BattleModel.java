package purgatory.battle;

import purgatory.entity.Entity;
import purgatory.move.Attack;
import purgatory.move.Move;
import purgatory.move.MoveType;
import purgatory.move.MoveUtil;

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
     * Sorts the list of fighters based on speed stat of entity objects
     */
    public void determineOrder() {
        fighters.sort(Comparator.comparingInt(Entity::getSpeed));
        Collections.reverse(fighters);
    }

    // DIRECT ATTACKS

    /**
     * Figures critical chance for the unit passed.
     *
     * @param unit: The entity object associated with the current unit attacking
     * @return A boolean of whether the move will critical or not
     */
    public boolean isCritical(Entity unit) {
        double criticalChance = unit.getLevel() * 0.09;
        double criticalHit = ThreadLocalRandom.current().nextDouble(0, 1);

        return criticalHit < criticalChance;
    }

    private int damage(Entity unit, double defense, Attack move) {
        if (MoveUtil.doesHit(unit, move)) {
            int damage = move.attack(unit);
            int damageReduction = (int) (move.attack(unit) * defense);

            return damage - damageReduction;
        } else {
            return 0;
        }
    }

    /**
     * Returns an int that will represent the damage inflicted on the enemy
     * based on the damage value of the move, along with the stats of the hero
     *
     * First determine if the move hits using doesHit() from MoveUtil
     * Takes the stats of the hero and formulates the attack power of the move
     * based on base damage along with the hero's strength/magic
     * <p>
     * Critical is calculated by choosing randomly. A move has a chance to critical 0.09 * Level of unit
     *
     * Each weapon/attack type is weak and strong against other weapon/attack types.
     * If a weapon is weak it will have a 25% reduction in base damage.
     * If it is strong it will have a 25% increase in base damage.
     *
     * @param hero: The entity object associated with the hero attacking
     * @param enemy: The enemy entity object being attacked
     * @param move: The move chosen by the player, specifically an attack move
     * @return Returns an int that will represent the damage inflicted on the enemy.
     */
    public int damageEnemy(Entity hero, Entity enemy, Attack move) {
        double enemyDefense = enemy.getDefense(); // used to calculate percent "absorbed" by enemy

       return damage(hero, enemyDefense, move);
    }

    /**
     * Returns an int based on the move chosen (randomly) by enemy entity
     *
     * @param enemy: The entity object associated with the enemy attacking
     * @param hero: The entity object associated with the current hero
     * @return int that will represent the amount of damage inflicted on the hero
     */
    public int damageHero(Entity enemy, Entity hero) {
        List<Move> enemyAttacks = MoveUtil.getMovesByMoveType(MoveType.ATTACK, enemy.getMoveSet());
        Attack move = (Attack) MoveUtil.getRandomMove(enemyAttacks);

        double heroDefense = hero.getDefense();

       return damage(enemy, heroDefense, move);
    }

    /**
     * Gathers current stats of all fighters
     *
     * @return
     */
    /*public Map<String, Object> getCurrentStats() {

    }*/
}