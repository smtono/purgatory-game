package purgatory.entity.type;

import purgatory.weapon.WeaponType;

import java.util.Arrays;
import java.util.List;

public enum HeroType implements VirtualEntityType {
    WARRIOR("Warrior",
            "A seasoned fighter skilled with a sword and a club, fights for the thrill of battle, and the rush of tomorrow.",
            CharacterType.HERO,
            Arrays.asList(WeaponType.SWORD, WeaponType.CLUB)),
    ARCHER("Archer",
            "One who shoots arrows with a bow with precision and accuracy done so, quite beautifully.",
            CharacterType.HERO,
            Arrays.asList(WeaponType.BOW)),
    KNIGHT("Knight",
            "",
            CharacterType.HERO,
            Arrays.asList(WeaponType.LANCE, WeaponType.SPEAR)),
    DANCER("Dancer",
            "",
            CharacterType.HERO,
            Arrays.asList(WeaponType.FAN)),
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
            Arrays.asList(WeaponType.TOME));

    //ATTRIBUTES
    private final EntityType entityType;

    // CONSTRUCTOR
    HeroType(String typeName, String description, CharacterType type, List<WeaponType> weaponTypeTypes) {
        this.entityType = EntityType.of(typeName, description, type, weaponTypeTypes);
    }

    @Override
    public EntityType getEntityType() { return entityType; }

    @Override
    public String toString() { return getEntityType().getTypeName(); }
}
