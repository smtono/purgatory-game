package purgatory.stats;

import purgatory.entity.Entity;
import purgatory.move.MoveUtil;

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
    static Random gen = new Random();
    public final static String[] ENEMY_NAMES = {"Alastor", "Asura", "Azazel", "Astaroth", "Barbatos",
                                                "Beleth", "Belial", "Eblis", "Dev", "Focalor", "Forneus",
                                                "Legion", "Lilith", "Murmur", "Moloch", "Orcus", "Alichino"
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
     *
     * TODO: add this attribute
     * critical: 0.0 double
     *
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
        // calculating enemy stats
        String enemyName = generateRandomName();
        int strength = 0;
        int magic = 0;
        int defense = 0;
    }
}
