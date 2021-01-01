package purgatory.entity;

import purgatory.weapon.WeaponType;

import java.util.Arrays;
import java.util.List;

/**
 * EntityType is an enum that lists out different hero/enemy/boss types a unit can be.
 * <p>
 * Each unit type has a different name, description, character type, and weapons that they can use.
 */
public enum EntityType {
    //	ENTITY TYPES
    // heroes
    WARRIOR("Warrior",
            "A seasoned fighter skilled with a sword and a club, fights for the thrill of battle, and the rush of tomorrow.",
            CharacterType.HERO,
            Arrays.asList(WeaponType.SWORD, WeaponType.CLUB)),
    ARCHER("Archer",
            "One who shoots arrows with a bow with precision and accuracy done so, quite beautifully.",
            CharacterType.HERO,
            Arrays.asList(WeaponType.BOW)),
    MAGE("Mage",
            "A powerful magic user, one who can control the elements, holy, and darkness with the use of a magical medium.",
            CharacterType.HERO,
            Arrays.asList(WeaponType.WAND, WeaponType.STAFF)),
    CLERIC("Cleric",
            "A tender or healer by nature, user of holy magic to sustain their loved ones through grief-stricken torment.",
            CharacterType.HERO,
            Arrays.asList(WeaponType.STAFF)),
    SCHOLAR("Scholar",
            "Deeply impassioned with knowledge, and a love of learning, they wield the powers of the beasts they read of.",
            CharacterType.HERO,
            Arrays.asList(WeaponType.TOME)),

    // enemies
    GUARDIAN("Guardian",
            "A hearty foe, the lowest order of angels. They wield a sword and club.",
            CharacterType.ENEMY,
            Arrays.asList(WeaponType.SWORD, WeaponType.CLUB)),
    MOON("Moon",
            "The first sphere of Paradiso, a powerful elemental magic user.",
            CharacterType.ENEMY,
            Arrays.asList(WeaponType.WAND, WeaponType.STAFF)),

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

    private final String typeName;
    private final String description;
    private final CharacterType characterType;
    private final List<WeaponType> weaponTypeTypes;

    // CONSTRUCTOR
    EntityType(String typeName,
               String description,
               CharacterType type,
               List<WeaponType> weaponTypeTypes) {
        this.typeName = typeName;
        this.description = description;
        this.characterType = type;
        this.weaponTypeTypes = weaponTypeTypes;
    }

    // ACCESSORS
    public String getTypeName() {
        return typeName;
    }

    public String getDescription() {
        return description;
    }

    public CharacterType getCharacterType() {
        return characterType;
    }

    public List<WeaponType> getWeaponTypes() {
        return weaponTypeTypes;
    }

    @Override
    public String toString() {
        return typeName;
    }
}