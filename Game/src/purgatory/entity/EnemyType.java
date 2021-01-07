package purgatory.entity;

import purgatory.weapon.WeaponType;

import java.util.Arrays;
import java.util.List;

public enum EnemyType implements VirtualEntityType {
    // angels
    GUARDIAN("Guardian",
            "A hearty foe, the lowest order of angels. They wield a sword and club.",
            CharacterType.ENEMY,
            Arrays.asList(WeaponType.WAND)),
    ARCHANGEL("Archangel",
            "",
            CharacterType.ENEMY,
            Arrays.asList(WeaponType.SWORD)),
    PRINCIPALITY("Principality",
            "",
            CharacterType.ENEMY,
            Arrays.asList(WeaponType.STAFF)),
    POWER("Power",
            "",
            CharacterType.ENEMY,
            Arrays.asList(WeaponType.BOW, WeaponType.AXE)),
    VIRTUE("Virtue",
            "",
            CharacterType.ENEMY,
            Arrays.asList(WeaponType.TOME)),
    DOMINATION("Domination",
            "",
            CharacterType.ENEMY,
            Arrays.asList(WeaponType.SWORD, WeaponType.CLUB)),
    THRONE("Throne",
            "",
            CharacterType.ENEMY,
            Arrays.asList(WeaponType.WAND)),
    SERAPHIM("Seraphim",
            "",
            CharacterType.ENEMY,
            Arrays.asList(WeaponType.STAFF, WeaponType.TOME)),

    // spheres
    MOON("Moon",
            "The first sphere of Paradiso, a powerful elemental magic user.",
            CharacterType.ENEMY,
            Arrays.asList(WeaponType.WAND, WeaponType.STAFF));

    //ATTRIBUTES
    private final EntityType entityType;

    // CONSTRUCTOR
    EnemyType(String typeName, String description, CharacterType type, List<WeaponType> weaponTypeTypes) {
        this.entityType = EntityType.of(typeName, description, type, weaponTypeTypes);
    }

    @Override
    public EntityType getEntityType() { return entityType; }

    @Override
    public String toString() { return getEntityType().getTypeName(); }
}
