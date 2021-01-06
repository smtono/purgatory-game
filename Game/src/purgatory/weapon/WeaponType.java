package purgatory.weapon;

import java.util.Arrays;
import java.util.List;

/**
 * Weapon is an enum to declare weapon constants used by heroes and enemies in the game. Also to separate weapons from
 * move types, so that both enums can exist separately. Each weapon will have an advantage and disadvantage
 * over other weapons. Similar to the weapon triangle in fire emblem.
 *
 * A weapon has the following
 * NAME: What the weapon is called
 * DESCRIPTION: A short passage about the weapon
 * ATTACK TYPES: The "attack type" that the weapon is viz. how the weapon is used, and what moves the weapon can do.
 */
public enum WeaponType {
    // WEAPONS
    SWORD("Sword", "A long metal blade", Arrays.asList(AttackType.SLASH), ManaType.STRENGTH),
    AXE("Axe", "A steel blade attached at a right angle to a wooden handle.", Arrays.asList(), ManaType.STRENGTH),
    BOW("Bow", "A weapon for shooting arrows", Arrays.asList(AttackType.SHOOT), ManaType.STRENGTH),
    CLUB("Club", "A heavy stick with a thick end", Arrays.asList(AttackType.BLUNT), ManaType.STRENGTH),
    WAND("Wand", "A stick or rod thought to have magic properties", Arrays.asList(AttackType.ELEMENTAL, AttackType.HOLY, AttackType.DARK), ManaType.MAGIC),
    TOME("Tome", "A book filled with mystery", Arrays.asList(AttackType.HOLY, AttackType.DARK), ManaType.MAGIC),
    STAFF("Staff", "A strong wooden stick", Arrays.asList(AttackType.HOLY), ManaType.MAGIC),

    // BOSS WEAPONS
    /*
    GLUTTONY,
        SLOTH,
        AVARICE,
        PRIDE,
        ENVY,
        LUST,
        WRATH;
     */
    TRIDENT("Trident", "Looks like a big fork!", Arrays.asList(AttackType.HOLY, AttackType.PIERCE), ManaType.STRENGTH);
    // TODO: add the rest of the boss weapons

    private final String name;
    private final String description;
    private final List<AttackType> attackTypes;
    private final ManaType manaType;

    // CONSTRUCTOR
    WeaponType(String name, String description, List<AttackType> attackTypes, ManaType manaType) {
        this.name = name;
        this.description = description;
        this.attackTypes = attackTypes;
        this.manaType = manaType;
    }

    // ACCESSORS
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<AttackType> getAttackTypes() {
        return attackTypes;
    }

    public ManaType getManaType() { return manaType; }
}
