package purgatory.util;

import purgatory.Reference;
import purgatory.entity.CharacterType;
import purgatory.entity.Entity;
import purgatory.entity.EntityType;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * StatUtil is used to extrapolate / manipulate stats associated with Entity objects.
 * <p>
 * Manipulation of stats is present for both enemy generation and temporary change of hero stats
 * for special moves in battle.
 */
public class StatUtil {
    // TODO: write different methods that calculate different random stats.

    /**
     * Returns a random name for an enemy.
     *
     * @return Returns a random name from ENEMY_NAMES
     */
    public static String generateRandomName() {
        // TODO: fix so that multiple enemies cannot have the same name
        Random gen = new Random();
        int index = gen.nextInt(Reference.ENEMY_NAMES.length);
        return Reference.ENEMY_NAMES[index];
    }

    /**
     * Get a parametrized enemy based on hero stats
     * <p>
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
     * @param hero: The current Entity object used for the hero (player)
     * @return An enemy Entity object with stats tailored to hero's level.
     */
    private Entity generateEnemy(Entity hero) {
        Random ran = new Random();

        // calculating enemy stats
        String enemyName = StatUtil.generateRandomName();
        EntityType enemyType = EntityUtil.getEntityTypes(CharacterType.ENEMY).get(ran.nextInt(EntityUtil.getEntityTypes(CharacterType.ENEMY).size()));
        int enemyCurrentHealth = hero.getMaxHealth() * 2;
        final int ENEMY_MAX_HEALTH = hero.getMaxHealth() * 2;
        int enemySpeed = ran.nextInt(30);
        double enemyAccuracy = ThreadLocalRandom.current().nextDouble(0.6, 1);
        int strength = 0;
        int magic = 0;
        int defense = 0;
        int enemyLevel = ThreadLocalRandom.current().nextInt(hero.getLevel(), hero.getLevel() + 3);

        return new Entity(enemyName, enemyType, ENEMY_MAX_HEALTH, 0, enemySpeed, enemyAccuracy, strength, magic,
                MoveUtil.getEnemyMoveSet(enemyType, 1), enemyLevel);
    }
}
