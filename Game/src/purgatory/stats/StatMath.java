package purgatory.stats;

import purgatory.entity.Entity;
import purgatory.entity.EntityType;
import purgatory.move.AttackType;
import purgatory.move.WeaponType;
import purgatory.terraces.Terrace;

import java.util.ArrayList;
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
    // TODO: add an ability for a "super" enemy to be generated
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
        int lowerBound = terrace.getLevel() * 10;
        int upperBound = lowerBound + 50;

        return rng.nextInt(lowerBound) + upperBound;
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
     *
     * @param weaponType: The type of weapon that will determine if magic or strength is calculated
     * @return An int that represents the strength/magic stat
     */
    public static int[] generateEnemyStrengthOrMagic(WeaponType weaponType) {
        switch (weaponType.getManaType()) {
            case MAGIC:

            case STRENGTH:
        }
    }

    /**
     *
     * @return
     */
    public static  int generateEnemyDefense() {
        // TODO: make defense stat a double so it can act as a percent
        // so that a percent of the damage can be taken off
    }

    /**
     * Returns an int that is between 3 below and 3 above the hero entity's current level
     *
     * @param hero: The hero entity object
     * @return An int that is between 3 below and 3 above the hero entity's current level
     */
    public static int generateEnemyLevel(Entity hero) {
        int lowerBound = hero.getLevel() - 3;
        int upperBound = hero.getLevel() + 3;
        return rng.nextInt(lowerBound) + upperBound;
    }
}
