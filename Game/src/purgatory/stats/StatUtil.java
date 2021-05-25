package purgatory.stats;

import purgatory.battle.stats.BattleStats;
import purgatory.entity.type.CharacterType;
import purgatory.entity.Entity;
import purgatory.entity.type.EnemyType;
import purgatory.entity.type.EntityType;
import purgatory.move.Move;
import purgatory.move.MoveUtil;
import purgatory.terraces.Terrace;

import javax.swing.*;
import java.util.*;

/**
 * StatUtil is used to extrapolate / manipulate stats associated with Entity objects.
 * <p>
 * Manipulation of stats is present for both enemy generation and temporary change of hero stats
 * for special moves in battle.
 */
public class StatUtil {
    static Random gen = new Random();
    public final static String[] ENEMY_NAMES = {"Alastor", "Asura", "Azazel", "Astaroth", "Barbatos",
                                                "Beleth", "Belial", "Eblis", "Dev", "Focalor", "Forneus",
                                                "Legion", "Lilith", "Murmur", "Moloch", "Orcus", "Alichino",
                                                "Barbariccia", "Cagnazzo", "Calcabrina", "Ciriatto", "Draghignazzo",
                                                 "Farfarello", "Graffiacane", "Libicocco", "Rubicante", "Scarmiglione"};

    /**
     * Returns a random name for an enemy.
     *
     * @return Returns a random name from ENEMY_NAMES
     */
    public static String generateRandomName() {
        // TODO: fix so that multiple enemies cannot have the same name
        int index = gen.nextInt(ENEMY_NAMES.length);
        return ENEMY_NAMES[index];
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
     * @param terrace: The current level the player is on
     * @return An enemy Entity object with stats tailored to hero's level.
     */
    public static Entity generateEnemy(Entity hero, Terrace terrace) {
        // calculating enemy stats
        String enemyName = generateRandomName();
        int enemyLevel = StatMath.generateEnemyLevel(hero);
        int enemyHealth = StatMath.generateEnemyMaxHealth(terrace);
        double enemyAccuracy = StatMath.generateEnemyAccuracy();
        int enemySpeed = StatMath.generateEnemySpeed();
        EnemyType enemyType = StatMath.generateEnemyEntityType(terrace);
        double[] enemyManaStats = StatMath.generateEnemyStrengthOrMagic(enemyLevel, enemyType.getWeaponTypes());
        double enemyDefense = StatMath.generateEnemyDefense();
        List<Move> moveSet = MoveUtil.getNewEnemyMoveSet(enemyType, enemyLevel);

        return new Entity(enemyName,
                enemyType,
                enemyHealth,
                0,
                enemySpeed,
                enemyAccuracy,
                enemyManaStats[1],
                enemyManaStats[0],
                enemyDefense,
                moveSet,
                enemyLevel);
    }

    /**
     *
     * @param hero: The current Entity object used for the hero (player)
     * @param terrace: The current level the player is on
     * @return An enhanced version of an enemy Entity object with stats tailored to hero's level.
     */
    public static Entity generateSuperEnemy(Entity hero, Terrace terrace) {
        // calculating enemy stats
        // TODO: abstract these method calls into 1 method
        String enemyName = "Super " + generateRandomName();
        int enemyLevel = StatMath.generateEnemyLevel(hero) + 10;
        int enemyHealth = hero.getMaxHealth() * 3;
        double enemyAccuracy = StatMath.generateEnemyAccuracy();
        int enemySpeed = StatMath.generateEnemySpeed();
        EnemyType enemyType = StatMath.generateEnemyEntityType(terrace);
        double[] enemyManaStats = StatMath.generateEnemyStrengthOrMagic(enemyLevel, enemyType.getWeaponTypes());
        double enemyDefense = StatMath.generateEnemyDefense();
        List<Move> moveSet = MoveUtil.getNewEnemyMoveSet(enemyType, enemyLevel);

        // Enhancements
        if(enemyManaStats[0] < 0.75) {
            enemyManaStats[0] += 0.2;
        }
        if(enemyManaStats[1] < 0.75) {
            enemyManaStats[1] += 0.2;
        }
        if (enemyDefense < 0.8) { // defense
            enemyDefense += + 0.15;
        }

        return new Entity(enemyName,
                enemyType,
                enemyHealth,
                0,
                enemySpeed,
                enemyAccuracy,
                enemyManaStats[1],
                enemyManaStats[0],
                enemyDefense,
                moveSet,
                enemyLevel);
    }

    /**
     * Returns a list of enemies based on hero stats.
     *
     * Uses a set of methods for stat manipulation
     *
     * @param numEnemies: The amount of enemies that will be returned
     * @return A list with a number of requested enemies based on hero stats
     */
    public static List<Entity> generateEnemies(int numEnemies, Entity hero, Terrace terrace) {
        List<Entity> enemies = new ArrayList<>();

        for (int i = 0; i < numEnemies; i++) {
            enemies.add(generateEnemy(hero, terrace));
        }

        if (terrace.getLevel() > 3) {
            enemies.add(generateSuperEnemy(hero, terrace));
        }
        if (terrace.getLevel() > 5) {
            enemies.add(generateSuperEnemy(hero, terrace));
        }
        if (terrace.getLevel() >= 6) {
            enemies.add(generateSuperEnemy(hero, terrace));
        }

        return enemies;
    }

    /**
     * Returns a list of entities gathered from the list passed that match the character type passed.
     *
     * @param fighters:      A list with various character types (hero, party, enemy, boss)
     * @param type: The certain character type (hero, party, enemy, boss) being looked for from the list.
     * @return A list with only the entities with the specified character type.
     */
    public static List<BattleStats> getStatsOfTypeFromList(List<BattleStats> fighters, CharacterType type) {
        List<BattleStats> result = new ArrayList<>();
        fighters.iterator().forEachRemaining(fighter -> {
            if (fighter.getEntityType().getCharacterType().equals(type))
                result.add(fighter);
        });
        return result;
    }

    /**
     * Returns the hero entity from the list passed
     *
     * @param fighters: A list of entities with different types
     * @return The hero entity from the list
     */
    public static BattleStats getHeroFromList(List<BattleStats> fighters) {
        return getStatsOfTypeFromList(fighters, CharacterType.HERO).get(0);
    }

    /**
     * Returns the BattleStats object of the name of the fighter from the list provided
     *
     * @param fighter: The specific fighter wanted
     * @param fighterStats: A list of all fighters in battle
     * @return A BattleStats object for the given fighter
     */
    public static BattleStats getFighterStatsFor(String fighter, List<BattleStats> fighterStats) {
        BattleStats statsNeeded = new BattleStats();

        for (BattleStats stat : fighterStats) {
            if(stat.getFighter().equals(fighter)) {
                statsNeeded = stat;
            }
        }

        return statsNeeded;
    }

    /**
     *
     * @param fighters
     * @return
     */
    public static List<Integer> getHealthForAll(List<BattleStats> fighters) {
        List<Integer> values = new ArrayList<>();

        fighters.forEach(fighter -> {
            values.add(fighter.getCurrHealth());
        });

        return values;
    }

    /**
     *
     * @param fighters
     * @return
     */
    public static List<Integer> getSpeedForAll(List<BattleStats> fighters) {
        List<Integer> values = new ArrayList<>();

        fighters.forEach(fighter -> {
            values.add(fighter.getCurrSpeed());
        });

        return values;
    }

    /**
     *
     * @param fighters
     * @return
     */
    public static List<Double> getAccuracyForAll(List<BattleStats> fighters) {
        List<Double> values = new ArrayList<>();

        fighters.forEach(fighter -> {
            values.add(fighter.getCurrAccuracy());
        });

        return values;
    }

    /**
     *
     * @param fighters
     * @return
     */
    public static List<Double> getDefenseForAll(List<BattleStats> fighters) {
        List<Double> values = new ArrayList<>();

        fighters.forEach(fighter -> {
            values.add(fighter.getCurrDefense());
        });

        return values;
    }

    /**
     *
     * @param enemiesHealth
     * @return
     */
    public static boolean allEnemiesDead(List<Integer> enemiesHealth) {
        boolean allDead = true;

        for (Integer integer : enemiesHealth) {
            if (integer > 0) {
                allDead = false;
                break;
            }
        }

        return allDead;
    }

    /**
     * Pushes the initial base stats for all the Entity objects in the given list into a BattleStats list
     * to be manipulated in battle.
     *
     * @param fighters: A list of fighters for the battle
     * @return A list of BattleStats the correspond to each fighter
     */
    public static List<BattleStats> pushInitialFighterStats(List<Entity> fighters) {
        List<BattleStats> fighterStats = new ArrayList<>();

        fighters.forEach(fighter -> {
            fighterStats.add(new BattleStats(
                    fighter.getName(),
                    fighter.getEntityType(),
                    fighter.getMoveSet(),
                    fighter.getMaxHealth(),
                    fighter.getMana(),
                    fighter.getSpeed(),
                    fighter.getAccuracy(),
                    fighter.getStrength(),
                    fighter.getMagic(),
                    fighter.getDefense(),
                    fighter.getLevel()));
        });

        return fighterStats;
    }
}
