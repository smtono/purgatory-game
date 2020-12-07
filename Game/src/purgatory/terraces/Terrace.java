package purgatory.terraces;

import purgatory.entity.EntityType;

import java.util.Arrays;
import java.util.List;

/**
 * Terrace is a collection of levels in the game, each with different names, level of access, number of rooms,
 * and enemy types seen.
 * <p>
 * This will lay out the foundation of the "map" of the game. Purgatory is divided into seven terraces.
 * This is to represent the seven deadly sins.
 * Each terrace will have it's own enemy types and final boss.
 */
public enum Terrace {
    // TODO: Fix variables for each
    GLUTTONY("Gluttony", "", 1, 0, Arrays.asList()),
    SLOTH("Sloth", "", 2, 0, Arrays.asList()),
    AVARICE("Avarice", "", 3, 0, Arrays.asList()),
    PRIDE("Pride", "", 4, 0, Arrays.asList()),
    ENVY("Envy", "", 5, 0, Arrays.asList()),
    LUST("Lust", "", 6, 0, Arrays.asList()),
    WRATH("Wrath", "", 7, 0, Arrays.asList());

    // variables for construction
    private String name;
    private String description;
    private int level;
    private int numRooms;
    private List<EntityType> enemyTypes;

    // CONSTRUCTOR
    Terrace(String name,
            String description,
            int level,
            int numRooms,
            List<EntityType> enemyTypes) {
        this.name = name;
        this.description = description;
        this.level = level;
        this.numRooms = numRooms;
        this.enemyTypes = enemyTypes;
    }

    // ACCESSORS
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getLevel() {
        return level;
    }

    public int getNumRooms() {
        return numRooms;
    }

    public List<EntityType> getEnemyTypes() {
        return enemyTypes;
    }

    @Override
    public String toString() {
        return "Terrace{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", level=" + level +
                ", numRooms=" + numRooms +
                ", enemyTypes=" + enemyTypes +
                '}';
    }
}
