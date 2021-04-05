package purgatory.entity;

import purgatory.terraces.Terrace;
import purgatory.weapon.WeaponType;

import java.util.Arrays;
import java.util.List;

public enum EnemyType implements VirtualEntityType {
    // angels
    GUARDIAN("Guardian", "A hearty foe, the lowest order of angels.", CharacterType.ENEMY, Arrays.asList(WeaponType.SWORD, WeaponType.CLUB), Terrace.GLUTTONY),
    ARCHANGEL("Archangel",
            "",
            CharacterType.ENEMY,
            Arrays.asList(WeaponType.SWORD, WeaponType.SPEAR),
            Terrace.SLOTH),
    PRINCIPALITY("Principality",
            "",
            CharacterType.ENEMY,
            Arrays.asList(WeaponType.STAFF),
            Terrace.AVARICE),
    POWER("Power",
            "",
            CharacterType.ENEMY,
            Arrays.asList(WeaponType.BOW, WeaponType.SCYTHE),
            Terrace.PRIDE),
    VIRTUE("Virtue",
            "",
            CharacterType.ENEMY,
            Arrays.asList(WeaponType.TOME),
            Terrace.LUST),
    DOMINATION("Domination",
            "",
            CharacterType.ENEMY,
            Arrays.asList(WeaponType.MACE, WeaponType.HAMMER),
            Terrace.LUST),
    THRONE("Throne",
            "",
            CharacterType.ENEMY,
            Arrays.asList(WeaponType.WAND),
            Terrace.WRATH),
    SERAPHIM("Seraphim",
            "",
            CharacterType.ENEMY,
            Arrays.asList(WeaponType.STAFF, WeaponType.TOME),
            Terrace.WRATH),

    // spheres
    MOON("Moon",
            "The Inconstant, a powerful elemental magic user.",
            CharacterType.ENEMY,
            Arrays.asList(WeaponType.WAND, WeaponType.STAFF),
            Terrace.GLUTTONY),
    MERCURY("Mercury",
            "The Ambitious, a powerful elemental magic user.",
            CharacterType.ENEMY,
            Arrays.asList(WeaponType.WAND),
            Terrace.SLOTH),
    VENUS("Venus",
            "The Lovers, ",
            CharacterType.ENEMY,
            Arrays.asList(WeaponType.RAPIER, WeaponType.DAGGER),
            Terrace.AVARICE),
    SUN("Sun",
            "The Wise, ",
            CharacterType.ENEMY,
            Arrays.asList(WeaponType.TOME),
            Terrace.PRIDE),
    MARS("Mars",
            "The Warrior of Faith, ",
            CharacterType.ENEMY,
            Arrays.asList(WeaponType.MACE, WeaponType.LANCE),
            Terrace.ENVY),
    JUPITER("Jupiter",
            "The Just Ruler, ",
            CharacterType.ENEMY,
            Arrays.asList(WeaponType.STAFF, WeaponType.RAPIER),
            Terrace.LUST),
    SATURN("Saturn",
            "The Contemplative, ",
            CharacterType.ENEMY,
            Arrays.asList(WeaponType.TOME, WeaponType.WAND),
            Terrace.LUST),
    STAR("Fixed Stars",
            "",
            CharacterType.ENEMY,
            Arrays.asList(WeaponType.WAND),
            Terrace.WRATH),
    PRIMUM("Primum Mobile",
            "",
            CharacterType.ENEMY,
            Arrays.asList(WeaponType.TOME, WeaponType.WAND, WeaponType.STAFF),
            Terrace.WRATH),

    ;

    //ATTRIBUTES
    private final EntityType entityType;
    private final Terrace lowestTerrace; // the earliest level this enemy will be found at

    // CONSTRUCTOR
    EnemyType(String typeName, String description, CharacterType type, List<WeaponType> weaponTypeTypes, Terrace lowestTerrace) {
        this.entityType = EntityType.of(typeName, description, type, weaponTypeTypes);
        this.lowestTerrace = lowestTerrace;
    }

    public Terrace getLowestTerrace() { return lowestTerrace; }

    @Override
    public EntityType getEntityType() { return entityType; }

    @Override
    public String toString() { return getEntityType().getTypeName(); }
}
