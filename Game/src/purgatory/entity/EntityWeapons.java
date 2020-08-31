package purgatory.entity;

/*
    Author: Shannon Thornton

    Purpose: To declare weapon constants used by heroes and enemies in the game. Also to separate weapons from
    move types, so that both enums can exist separately. Each weapon will have an advantage and disadvantage
    over other weapons. Much like the weapon triangle in fire emblem.
 */

import java.util.ArrayList;
import java.util.List;

public enum EntityWeapons {
    // WEAPONS
    SWORD("Sword", "Placeholder"),
    CLUB("Club", "Placeholder"),
    WAND("Wand", "Placeholder"),
    TOME("Tome", "Placeholder"),
    STAFF("Staff", "Placeholder"); // semi-colon '-'

    // variables for construction
    private String name;
    private String description;
    EntityWeapons(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public enum AttackType {SLASH, BLUNT, ELEMENTAL, HOLY, DARK}
}
