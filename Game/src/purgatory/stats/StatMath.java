package purgatory.stats;

import purgatory.entity.Entity;
import purgatory.entity.EntityType;
import purgatory.weapon.WeaponType;
import purgatory.terraces.Terrace;

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
    public static EntityType generateEnemyEntityType(Terrace terrace) {
        List<EntityType> types = terrace.getEnemyTypes();
        return types.get(rng.nextInt(types.size()));
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
        int lowerBound = terrace.getLevel() * 50;
        int upperBound = lowerBound + 200;

        return rng.nextInt(upperBound - lowerBound) + lowerBound;
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
}
