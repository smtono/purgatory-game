package purgatory.entity;

import purgatory.weapon.WeaponType;

import java.util.Arrays;
import java.util.List;

public enum BossType implements VirtualEntityType {
    // bosses
    // TODO: add weapon types
    GLUTTONY("Gluttony",
            "Overindulgence to the point of waste.",
            CharacterType.BOSS,
            Arrays.asList(WeaponType.TRIDENT)),
    SLOTH("Sloth",
            "Failure to act in pursuit of love",
            CharacterType.BOSS,
            Arrays.asList()),
    AVARICE("Avarice",
            "Love of good things in excess",
            CharacterType.BOSS,
            Arrays.asList()),
    PRIDE("Pride",
            "Directed perverted love",
            CharacterType.BOSS,
            Arrays.asList()),
    ENVY("Envy",
            "Excessive desire to have material things",
            CharacterType.BOSS,
            Arrays.asList()),
    LUST("Lust",
            "Misdirected sexual desire",
            CharacterType.BOSS,
            Arrays.asList()),
    WRATH("Wrath",
            "Untreated prolific hatred",
            CharacterType.BOSS,
            Arrays.asList());

    //ATTRIBUTES
    private final EntityType entityType;

    // CONSTRUCTOR
    BossType(String typeName, String description, CharacterType type, List<WeaponType> weaponTypeTypes) {
        this.entityType = EntityType.of(typeName, description, type, weaponTypeTypes);
    }

    @Override
    public EntityType getEntityType() { return entityType; }

    @Override
    public String toString() { return getEntityType().getTypeName(); }
}
