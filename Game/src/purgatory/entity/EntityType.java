package purgatory.entity;

import purgatory.battle.Weapon;

import java.util.Arrays;
import java.util.List;

/*
    Author: Shannon Thornton

    Purpose: To declare different "entity (heroes/enemies/and eventually party members) in one place, since they
    all use similar methods. This is to reduce the amount of redundant / similar code in my files.
    More files =/= more complexity. Also, finally a chance to properly learn enums and how to use them!
 */
public enum EntityType {
    //	ENTITY TYPES
    // heroes
    WARRIOR("Warrior",
            "A seasoned fighter skilled with a sword and a club, fights for the thrill of battle, and the rush of tomorrow.",
            CharacterType.HERO,
            Arrays.asList(Weapon.SWORD, Weapon.CLUB)
    ),
    ARCHER("Archer",
            "One who shoots arrows with a bow with precision and accuracy done so, quite beautifully.",
            CharacterType.HERO,
            Arrays.asList(Weapon.BOW)
    ),
    MAGE("Mage",
            "A powerful magic user, one who can control the elements, holy, and darkness with the use of a magical medium.",
            CharacterType.HERO,
            Arrays.asList(Weapon.WAND, Weapon.STAFF)
    ),
    CLERIC("Cleric",
            "A tender or healer by nature, user of holy magic to sustain their loved ones through grief-stricken torment.",
            CharacterType.HERO,
            Arrays.asList(Weapon.STAFF)
    ),
    SCHOLAR("Scholar",
            "Deeply impassioned with knowledge, and a love of learning, they wield the powers of the beasts they read of.",
            CharacterType.HERO,
            Arrays.asList(Weapon.TOME)
    ),

    // enemies
    GUARDIAN("Guardian",
            "A hearty foe, the lowest order of angels. They wield a sword and club.",
            CharacterType.ENEMY,
            Arrays.asList(Weapon.SWORD, Weapon.CLUB)
    ),
    MOON("Moon",
            "The first sphere of Paradiso, a powerful elemental magic user.",
            CharacterType.ENEMY,
            Arrays.asList(Weapon.WAND, Weapon.STAFF)
    ),

    // bosses
    // TODO: add weapon types
    GLUTTONY("Gluttony",
            "Overindulgence to the point of waste.",
            CharacterType.BOSS,
            Arrays.asList(Weapon.TRIDENT)
    ),
    SLOTH("Sloth",
            "Failure to act in pursuit of love",
            CharacterType.BOSS,
            Arrays.asList()
    ),
    AVARICE("Avarice",
            "Love of good things in excess",
            CharacterType.BOSS,
            Arrays.asList()
    ),
    PRIDE("Pride",
            "Directed perverted love",
            CharacterType.BOSS,
            Arrays.asList()
    ),
    ENVY("Envy",
            "Excessive desire to have material things",
            CharacterType.BOSS,
            Arrays.asList()
    ),
    LUST("Lust",
            "Misdirected sexual desire",
            CharacterType.BOSS,
            Arrays.asList()
    ),
    WRATH("Wrath",
            "Untreated prolific hatred",
            CharacterType.BOSS,
            Arrays.asList()
    );

    // variables for construction of the entity types
    public enum CharacterType {HERO, ENEMY, BOSS} // public so this enum can be accessed.
    private final String typeName;
    private final String description;
    private final CharacterType characterType;
    private final List<Weapon> weaponTypes;

    // CONSTRUCTOR
    EntityType(String typeName,
               String description,
               CharacterType type,
               List<Weapon> weaponTypes) {
        this.typeName = typeName;
        this.description = description;
        this.characterType = type;
        this.weaponTypes = weaponTypes;
    }

    // ACCESSORS
    public String getTypeName() { return typeName; }
    public String getDescription() { return description; }
    public CharacterType getCharacterType() {return characterType; }
    public List<Weapon> getWeaponTypes() { return weaponTypes; }

    // toString
    @Override
    public String toString() {
        return typeName;
    }
}