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
    SWORD("Sword", "A long metal blade", Arrays.asList(AttackType.SLASH), ManaType.STRENGTH),
    AXE("Axe", "A steel blade attached at a right angle to a wooden handle.", Arrays.asList(), ManaType.STRENGTH),
    LANCE("Lance", "A long weapon for thrusting, having a wooden shaft and a pointed steel head", Arrays.asList(AttackType.PIERCE), ManaType.STRENGTH),
    BOW("Bow", "A weapon for shooting arrows", Arrays.asList(AttackType.SHOOT), ManaType.STRENGTH),
    CLUB("Club", "A heavy stick with a thick end", Arrays.asList(AttackType.BLUNT), ManaType.STRENGTH),
    WAND("Wand", "A stick or rod thought to have magic properties", Arrays.asList(AttackType.ELEMENTAL, AttackType.HOLY, AttackType.DARK), ManaType.MAGIC),
    TOME("Tome", "A book filled with mystery", Arrays.asList(AttackType.HOLY, AttackType.DARK), ManaType.MAGIC),
    STAFF("Staff", "A strong wooden stick", Arrays.asList(AttackType.HOLY), ManaType.MAGIC),
    RAPIER("Rapier", "A thin, light sharp-pointed sword used for thrusting", Arrays.asList(AttackType.SLASH), ManaType.STRENGTH),
    DAGGER("Dagger", "A short knife with a pointed and edged blade", Arrays.asList(AttackType.PIERCE), ManaType.STRENGTH),
    SCYTHE("Scythe", "A long curved blade at the end of a long pole", Arrays.asList(), ManaType.STRENGTH),
    MACE("Mace", "A heavy club", Arrays.asList(AttackType.BLUNT), ManaType.STRENGTH),
    HAMMER("Hammer", "A heavy metal head mounted at right angles at the end of a handle", Arrays.asList(AttackType.BLUNT), ManaType.STRENGTH),
    SPEAR("Spear", "A weapon with a long shaft and a pointed tip", Arrays.asList(AttackType.PIERCE), ManaType.STRENGTH),



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
    TRIDENT("Trident", "Looks like a big fork!", Arrays.asList(AttackType.HOLY, AttackType.PIERCE), ManaType.STRENGTH),
    FLUTE("Flute", "Careful around that! Looks like you'll fall asleep!", Arrays.asList(AttackType.DARK), ManaType.MAGIC),

    MIRROR("Mirror", "It emits a powerful light magic from the reflection of those who look into it", Arrays.asList(AttackType.HOLY), ManaType.MAGIC),

    WHIP("Whip", "Who's idea was this for Lust?!", Arrays.asList(AttackType.SLASH), ManaType.STRENGTH),
    HAND("God's Hand", "The wrath of God Himself!", Arrays.asList(AttackType.HOLY), ManaType.STRENGTH);

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
