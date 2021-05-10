package purgatory.entity;

import purgatory.terraces.Terrace;
import purgatory.weapon.WeaponType;

import java.util.Arrays;
import java.util.List;

public enum EnemyType implements VirtualEntityType {
    // angels
    GUARDIAN("Guardian",
            "A hearty foe, the lowest order of angels.",
            CharacterType.ENEMY,
            Arrays.asList(WeaponType.SWORD, WeaponType.CLUB), Terrace.GLUTTONY),
    ARCHANGEL("Archangel",
            "The trumpet call of God.",
            CharacterType.ENEMY,
            Arrays.asList(WeaponType.SWORD, WeaponType.SPEAR),
            Terrace.SLOTH),
    PRINCIPALITY("Principality",
            "Preside over the bands of angels and charge them with fulfilling the divine ministry.",
            CharacterType.ENEMY,
            Arrays.asList(WeaponType.STAFF),
            Terrace.AVARICE),
    POWER("Power",
            "An angel that has power over evil forces.",
            CharacterType.ENEMY,
            Arrays.asList(WeaponType.BOW, WeaponType.SCYTHE),
            Terrace.PRIDE),
    VIRTUE("Virtue",
            "Ministries through which signs and miracles are made.",
            CharacterType.ENEMY,
            Arrays.asList(WeaponType.STAFF, WeaponType.WAND),
            Terrace.PRIDE),
    DOMINATION("Domination",
            "A celestial Lordship. They regulate the duties of lower angels.",
            CharacterType.ENEMY,
            Arrays.asList(WeaponType.MACE, WeaponType.HAMMER),
            Terrace.LUST),
    THRONE("Throne",
            "Angels whom the Creator sits over and discharges His judgments through them.",
            CharacterType.ENEMY,
            Arrays.asList(WeaponType.HAMMER, WeaponType.AXE),
            Terrace.LUST),
    SERAPHIM("Seraphim",
            "The highest order of angels, they sing their praises to God.",
            CharacterType.ENEMY,
            Arrays.asList(WeaponType.STAFF, WeaponType.TOME),
            Terrace.WRATH),
    FALLEN("Fallen",
            "Angels who were expelled from Heaven",
            CharacterType.ENEMY,
            Arrays.asList(WeaponType.TOME),
            Terrace.WRATH),

    // spheres
    MOON("Moon",
            "The Inconstant",
            CharacterType.ENEMY,
            Arrays.asList(WeaponType.WAND, WeaponType.STAFF),
            Terrace.GLUTTONY),
    MERCURY("Mercury",
            "The Ambitious",
            CharacterType.ENEMY,
            Arrays.asList(WeaponType.WAND),
            Terrace.SLOTH),
    VENUS("Venus",
            "The Lovers",
            CharacterType.ENEMY,
            Arrays.asList(WeaponType.RAPIER, WeaponType.DAGGER),
            Terrace.AVARICE),
    SUN("Sun",
            "The Wise",
            CharacterType.ENEMY,
            Arrays.asList(WeaponType.TOME),
            Terrace.PRIDE),
    MARS("Mars",
            "The Warrior of Faith",
            CharacterType.ENEMY,
            Arrays.asList(WeaponType.MACE, WeaponType.LANCE),
            Terrace.ENVY),
    JUPITER("Jupiter",
            "The Just Ruler",
            CharacterType.ENEMY,
            Arrays.asList(WeaponType.STAFF, WeaponType.RAPIER),
            Terrace.LUST),
    SATURN("Saturn",
            "The Contemplative",
            CharacterType.ENEMY,
            Arrays.asList(WeaponType.TOME, WeaponType.WAND),
            Terrace.LUST),
    STAR("Fixed Stars",
            "A collection of celestial bodies affixed to the area above.",
            CharacterType.ENEMY,
            Arrays.asList(WeaponType.WAND),
            Terrace.WRATH),
    PRIMUM("Primum Mobile",
            "The outermost moving sphere of the universe.",
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
