package purgatory.entity;

/*
    Author: Shannon Thornton

    Purpose: To declare weapon constants used by heroes and enemies in the game. Also to separate weapons from
    move types, so that both enums can exist separately. Each weapon will have an advantage and disadvantage
    over other weapons. Much like the weapon triangle in fire emblem.
    Attributes of a weapon:
    Name
    Description
    The attack types it can use

    TODO: ***encapsulate weapons, so that you aren't using both attack type and weapon type in the same argument***
          create the weapon "triangle" with each weapon having a weakness
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum EntityWeapons {
    // WEAPONS
    SWORD("Sword", "a weapon with a long metal blade and a hilt with a hand guard", Arrays.asList(AttackType.SLASH)),
    BOW("Bow", "a weapon for shooting arrows", Arrays.asList(AttackType.SHOOT)),
    CLUB("Club", "a heavy stick with a thick end", Arrays.asList(AttackType.BLUNT)),
    WAND("Wand", "a stick or rod thought to have magic properties", Arrays.asList(AttackType.ELEMENTAL, AttackType.HOLY, AttackType.DARK)),
    TOME("Tome", "a book", Arrays.asList(AttackType.DARK, AttackType.HOLY)),
    STAFF("Staff", "a strong wooden stick", Arrays.asList(AttackType.ELEMENTAL, AttackType.HOLY, AttackType.DARK));

    public enum AttackType {SLASH, SHOOT, BLUNT, ELEMENTAL, HOLY, DARK}

    // variables for construction
    private String name;
    private String description;
    private List<AttackType> attackTypes;

    // CONSTRUCTOR
    EntityWeapons(String name, String description, List<AttackType> attackTypes) {
        this.name = name;
        this.description = description;
        this.attackTypes = attackTypes;
    }

    // ACCESSORS
    public String getName() { return name; }
    public String getDescription() { return description; }
    public List<AttackType> getAttackTypes() { return attackTypes; }
}
