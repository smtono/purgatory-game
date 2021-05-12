package purgatory.terraces;

import purgatory.entity.type.BossType;

/**
 * Terrace is a collection of levels in the game, each with different names, level of access, number of rooms,
 * and enemy types seen.
 * <p>
 * This will lay out the foundation of the "map" of the game. Purgatory is divided into seven terraces.
 * This is to represent the seven deadly sins.
 * Each terrace will have it's own enemy types and final boss.
 */
public enum Terrace {
    GLUTTONY("Gluttony", "", 1, 2, BossType.GLUTTONY),
    SLOTH("Sloth", "", 2, 4, BossType.SLOTH),
    AVARICE("Avarice", "", 3, 6, BossType.AVARICE),
    PRIDE("Pride", "", 4, 8, BossType.PRIDE),
    ENVY("Envy", "", 5, 10, BossType.ENVY),
    LUST("Lust", "", 6, 15, BossType.LUST),
    WRATH("Wrath", "", 7, 20, BossType.WRATH);

    // variables for construction
    private final String name;
    private final String description;
    private final int level;
    private final int numRooms;
    private final BossType boss;

    // CONSTRUCTOR
    Terrace(String name,
            String description,
            int level,
            int numRooms,
            BossType boss) {
        this.name = name;
        this.description = description;
        this.level = level;
        this.numRooms = numRooms;
        this.boss = boss;
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
    public BossType getBoss() { return boss; }

    @Override
    public String toString() {
        return name;
    }
}
