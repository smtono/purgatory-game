package purgatory.util;

import purgatory.Reference;
import purgatory.entity.Entity;
import purgatory.entity.EntityType;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class StatUtil {
    /**
     * This method
     *
     * @return Returns a random name from ENEMY_NAMES
     * TODO: fix so that multiple enemies cannot have the same name
     */
    public static String generateRandomName() {
        Random gen = new Random();
        int index = gen.nextInt(Reference.ENEMY_NAMES.length);
        return Reference.ENEMY_NAMES[index];
    }

    /**
     * Will return a number based on stats,
     * Get a parametrized enemy based on hero stats
     *
     * formula to determine what each stat will be based on the hero's:
     * type: random
     * hit points: x2
     * speed: random from 1 to 30
     * accuracy: random from .60 to 1.00
     * level: 3 above or below hero
     * @return Returns a map of numbered stats based on the hero's level
     */
    public static Map<String, Integer> generateEnemyStats() {
        Entity hero = Reference.hero;
        Map<String, Integer> stats = new HashMap<String, Integer>();

        int MAX_HEALTH = hero.getMaxHealth() * 2;
        int mana = hero.getMana();
        int speed = ThreadLocalRandom.current().nextInt(1, 31); // 1 to 30
        double accuracy = ThreadLocalRandom.current().nextDouble(0.6, 1); // 60% to 100%
        int xp = 0;
        // TODO: must know the enemy's type in order to tailor these
        int strength = ThreadLocalRandom.current().nextInt(1, 11);; // 1 to 10
        int magic = ThreadLocalRandom.current().nextInt(1, 11);;
        // ************************************************
        int level = ThreadLocalRandom.current().nextInt(hero.getLevel() - 3, hero.getLevel() + 3);

        stats.put("health", MAX_HEALTH);
        stats.put("mana", mana);
        stats.put("speed", speed);
        //stats.put("accuracy", accuracy);
        stats.put("xp", xp);
        stats.put("strength", strength);
        stats.put("magic", magic);
        stats.put("level", level);

        return stats;
    }

    /**
     *
     * @return Returns the type of the enemy
     */
    public static EntityType generateEnemyType() {
        return EntityType.SCHOLAR;
    }
}
