package purgatory.stats;

import purgatory.battle.stats.BattleStats;
import purgatory.entity.type.EnemyType;
import purgatory.entity.Entity;
import purgatory.move.Move;
import purgatory.weapon.WeaponType;
import purgatory.terraces.Terrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * StatMath is used for the manipulation of random numbers for stats for entity objects.
 * <p>
 * This is specifically used for enemy and party creation as well as new stats for a
 * levelled up hero. Each stat is randomized based off of the level of the hero entity object,
 * as well as the hero's own stats.
 */
public class StatMath {
    static Random rng = new Random();

    /**
     * Returns a random entity type native to the current terrace (level) the hero is on
     *
     * @param terrace: The current level the hero is on
     * @return A random enemy EntityType
     */
    public static EnemyType generateEnemyEntityType(Terrace terrace) {
        List<EnemyType> possibleTypes = new ArrayList<>();

        Arrays.asList(EnemyType.values().clone()).forEach(type -> {
            if(type.getLowestTerrace().getLevel() <= terrace.getLevel()) {
                possibleTypes.add(type);
            }
        });

        return possibleTypes.get(rng.nextInt(possibleTypes.size()));
    }

    /**
     * A max health will be in range of the level of the terrace * 10
     * and the upper bound being + 50 of that number
     * A random number in this range will be picked
     *
     * @param terrace: The current level the hero is on
     * @return An int that is the max health based on the current level the hero is on
     */
    public static int generateEnemyMaxHealth(Terrace terrace) {
        if (terrace.getLevel() < 3) {
         int lowerBound = terrace.getLevel() * 50;
         int upperBound = lowerBound + 200;
         return rng.nextInt(upperBound - lowerBound) + lowerBound;
        } else if (terrace.getLevel() == 7) {
            int lowerBound = terrace.getLevel() * 300;
            int upperBound = lowerBound + 10000;
            return rng.nextInt(upperBound - lowerBound) + lowerBound;
        } else {
            int lowerBound = terrace.getLevel() * 100;
            int upperBound = lowerBound + 1000;
            return rng.nextInt(upperBound - lowerBound) + lowerBound;
        }
    }

    /**
     * Returns an int that ranges from 0-30 for the enemy entity's speed
     *
     * @return An int that ranges from 0-30 for the enemy entity's speed
     */
    public static int generateEnemySpeed() {
        return rng.nextInt(30);
    }

    /**
     * Returns double that represents a randomized accuracy stat
     *
     * @return A double that represents a randomized accuracy stat
     */
    public static double generateEnemyAccuracy() {
        return ThreadLocalRandom.current().nextDouble(0.6, 1);
    }

    /**
     * Returns a double that will be used as a percent for the magic or strength
     * stat of an Entity object.
     * <p>
     * This will range from 0-1 (0-100% damage increase)
     * <p>
     * The first element in the array return represents the magic stat
     * The second element in the array return represents the strength stat
     *
     * @param level: The current level of the enemy being made
     * @param weaponTypes: A list of the types of weapon that will determine if magic or strength is calculated
     * @return An int that represents the strength/magic stat
     */
    public static double[] generateEnemyStrengthOrMagic(int level, List<WeaponType> weaponTypes) {
        double[] manaStats = new double[2];

        if (level <= 5) { // if an enemy is less than level 5 it shouldn't get increased damage
            manaStats[0] = 0;
            manaStats[1] = 0;
        } else {
            if (weaponTypes.size() == 1) { // calculate only one stat if there's only one weapon
                WeaponType weaponType = weaponTypes.get(0);

                switch (weaponType.getManaType()) {
                    case MAGIC:
                        manaStats[0] = Math.round(ThreadLocalRandom.current().nextDouble(0, 1.0) * 100D) / 100D;
                        manaStats[1] = 0;
                        break;
                    case STRENGTH:
                        manaStats[1] = Math.round(ThreadLocalRandom.current().nextDouble(0, 1.0) * 100D) / 100D;
                        manaStats[0] = 0;
                        break;
                }
            } else { // calculate both stats otherwise
                manaStats[1] = Math.round(ThreadLocalRandom.current().nextDouble(0, 1.0) * 100D) / 100D;
                manaStats[0] = Math.round(ThreadLocalRandom.current().nextDouble(0, 1.0) * 100D) / 100D;
            }
        }
        return manaStats;
    }

    /**
     * Returns a double that will be used as a percent for the defense stat
     * of an Entity object.
     * <p>
     * This will range from 0-0.5 (0-50% off damage taken)
     *
     * @return A double that represents a defense stat.
     */
    public static double generateEnemyDefense() {
        return Math.round(ThreadLocalRandom.current().nextDouble(0, 0.5) * 100D) / 100D;
    }

    /**
     * Returns an int that is between 3 below and 3 above the hero entity's current level
     *
     * @param hero: The hero entity object
     * @return An int that is between 3 below and 3 above the hero entity's current level
     */
    public static int generateEnemyLevel(Entity hero) {
        int lowerBound = 1;
        if (hero.getLevel() > 3) {
            lowerBound = hero.getLevel() - 3;
        }
        int upperBound = hero.getLevel() + 3;
        return rng.nextInt(upperBound - lowerBound) + lowerBound;
    }

    /**
     * Uses the accuracy stat passed that both the hero or party member has as well as the move used
     * to determine if the move hits or not, and returns true if it does hit, and false if it does not.
     *
     * @param unit: The entity object of the unit attacking
     * @return A boolean true if the move hits and false if it does not.
     */
    public static boolean doesHit(BattleStats unit, Move move) {
        Random gen = new Random();

        // find the combined accuracy of the weapon and the hero's
        double combinedAccuracy = unit.getCurrAccuracy() * move.getAccuracy();

        if (combinedAccuracy > 0) {
            // find a range to pick a random number out of
            int upperBound = (int) (combinedAccuracy * 100);
            // find out if this random number is larger than 1/2
            return gen.nextInt(upperBound) > 0.5;
        } else {
            return false;
        }
    }
}
