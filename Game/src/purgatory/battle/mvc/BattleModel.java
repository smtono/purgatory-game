package purgatory.battle.mvc;

import purgatory.battle.stats.BattleStats;
import purgatory.battle.stats.DamageOutput;
import purgatory.entity.Entity;
import purgatory.inventory.Inventory;
import purgatory.move.type.Attack;
import purgatory.move.Move;
import purgatory.move.type.MoveType;
import purgatory.move.MoveUtil;
import purgatory.stats.StatMath;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * BattleModel serves as the logic of the battle system.
 * <p>
 * It will take in a list of fighters that will be manipulated by order.
 */
public class BattleModel {
    private final List<Entity> initialFighters;
    private final Inventory inventory;
    private List<BattleStats> fighters;

    // CONSTRUCTOR
    public BattleModel(List<Entity> fighters, Inventory inventory) {
        this.initialFighters = fighters;
        this.inventory = inventory;
    }

    // ACCESSORS / MUTATORS
    public List<Entity> getInitialFighters() {
        return initialFighters;
    }
    public Inventory getInventory() { return inventory; }
    public List<BattleStats> getFighters() { return fighters; }
    public void setFighters(List<BattleStats> fighters) { this.fighters = fighters; }

    /** Sorts the list of fighters based on speed stat of entity objects */
    public void determineOrder() {
        fighters.sort(Comparator.comparingInt(BattleStats::getCurrSpeed));
        Collections.reverse(fighters);
    }

    /**
     * Gets the ordered list of fighters and returns them as a string
     *
     * @return A string of the order of fighters
     */
    public String getFighterOrder() {
        StringBuilder builder = new StringBuilder();
        builder.append("The order for this turn is: \n");
        fighters.forEach(fighter -> {
            builder.append(fighter.getFighter());
            builder.append(" \n");
        });
        return builder.toString();
    }

    // DIRECT ATTACKS

    /**
     * Figures critical chance for the unit passed.
     *
     * @param unit The entity object associated with the current unit attacking
     * @return A boolean of whether the move will critical or not
     */
    private boolean isCritical(BattleStats unit) {
        double criticalChance = unit.getLevel() * 0.09;
        double criticalHit = ThreadLocalRandom.current().nextDouble(0, 1);

        return criticalHit < criticalChance;
    }

    /**
     * Randomly determines if the move given is a critical hit
     * Which will double the damage output
     *
     * @param unit The unit attacking
     * @param targetDefense The defense of the target
     * @param move The move chosen
     * @return A pair of the damage given as well as if it is a critical hit or not
     */
    private DamageOutput determineCriticalDamage(BattleStats unit, double targetDefense, Attack move){
        boolean critical = false;
        int damage = damage(unit, targetDefense, move);

        if (isCritical(unit)) {
            damage *= 2;
            critical = true;
        }

        return new DamageOutput(critical, damage);
    }

    /**
     * Figures the damage output of the attacker when taking into account
     * the target's defense.
     *
     * @param unit The unit attacking
     * @param targetDefense The defense of the target being attacked
     * @param move The move being used to attack
     * @return An int of the damage output
     */
    private int damage(BattleStats unit, double targetDefense, Attack move) {
        if (StatMath.doesHit(unit, move)) {
            int damage = move.attack(unit);
            int damageReduction = (int) (damage * targetDefense);

            return damage - damageReduction;
        }
        else {
            return 0;
        }
    }

    /**
     * Returns a boolean that represents whether the move chosen hit critical or not.
     * Changes the health of the target based on damage inflicted.
     * <p>
     * First determine if the move hits using doesHit() from MoveUtil
     * Takes the stats of the hero and formulates the attack power of the move
     * based on base damage along with the hero's strength/magic
     * <p>
     * Each weapon/attack type is weak and strong against other weapon/attack types.
     * If a weapon is weak it will have a 25% reduction in base damage.
     * If it is strong it will have a 25% increase in base damage.
     *
     * @param hero The entity object associated with the hero attacking
     * @param enemy The enemy entity object being attacked
     * @param move The move chosen by the player, specifically an attack move
     * @return A boolean of whether the move crit or not
     */
    public DamageOutput damageEnemy(BattleStats hero, BattleStats enemy, Attack move) {
        double enemyDefense = enemy.getCurrDefense(); // used to calculate percent "absorbed" by enemy
        return determineCriticalDamage(hero, enemyDefense, move);
    }

    /**
     * Damages each enemy in a list using determineCriticalDamage()
     *
     * @param hero The entity object associated with the hero attacking
     * @param enemies A list of the enemy entity objects being attacked
     * @param move The move chosen by the player, specifically an attack move
     * @return A list of damage outputs for each enemy in the list given
     */
    public List<DamageOutput> damageAllEnemies(BattleStats hero, List<BattleStats> enemies, Attack move) {
        List<DamageOutput> values = new ArrayList<>();

        enemies.forEach(enemy -> {
            values.add(determineCriticalDamage(hero, enemy.getCurrDefense(), move));
        });

        return values;
    }

    /**
     * Returns an int based on the move chosen (randomly) by enemy entity
     *
     * @param enemy: The entity object associated with the enemy attacking
     * @param hero:  The entity object associated with the current hero
     * @return A boolean of whether the move crit or not
     */
    public DamageOutput damageHero(BattleStats enemy, BattleStats hero) {
        List<Move> enemyAttacks = MoveUtil.getMovesByMoveType(MoveType.ATTACK, enemy.getMoveSet());
        Attack move = (Attack) MoveUtil.getRandomMove(enemyAttacks);
        double heroDefense = hero.getCurrDefense();
        boolean critical = false;
        int damage = damage(enemy, heroDefense, move);

        if (isCritical(enemy)) {
            damage *= 2;
            critical = true;
        }

        return new DamageOutput(critical, damage);
    }

    /**
     * Damages each enemy in a list using determineCriticalDamage()
     *
     * @param enemy The entity object associated with the enemy attacking
     * @param heroes A list of the hero entity objects being attacked
     * @param move The move chosen by the enemy, specifically an attack move
     * @return A list of damage outputs for each enemy in the list given
     */
    public List<DamageOutput> damageAllHeroes(BattleStats enemy, List<BattleStats> heroes, Attack move) {
        List<DamageOutput> values = new ArrayList<>();

        heroes.forEach(hero -> {
            values.add(determineCriticalDamage(enemy, hero.getCurrDefense(), move));
        });

        return values;
    }
}