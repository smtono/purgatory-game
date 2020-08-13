package purgatory.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
    Author: Shannon Thornton

    Purpose: To declare different "entity (heroes/enemies/and eventually party members) in one place, since they
    all use similar methods. This is to reduce the amount of redundant / similar code in my files.
    More files =/= more complexity. Also, finally a chance to properly learn enums and how to use them!

    TODO:
    use map to separate enemies and party members.
 */
public enum EntityType {
    //	ENTITY TYPES
    // heroes
    WARRIOR("Warrior", true),
    MAGE("Mage",true),
    // enemies
    SLIME("Slime",false),
    FIRE("Fire", false); // don't forget about this semicolon '-'
    // variables for construction of the entity types
    private boolean isHero;
    private String typeName;
    // CONSTRUCTOR
    EntityType(String typeName, boolean isHero) {
        this.typeName = typeName;
        this.isHero = isHero;
    }
    // accessors
    public String getHeroTypeName() { return typeName; }
    public boolean isHero() { return isHero; }
    // METHODS
    /**
        getHeroes/Enemies
        creates a list of every hero.
        if the entity type returns true (or not) to isHero(), then it will be added to the list.
        @return a list of all heroes/enemies
     */
    public static List<EntityType> getHeroes() {
        List<EntityType> heroes = new ArrayList<>();
        for (EntityType entity : EntityType.values()) {
            if(entity.isHero)
                heroes.add(entity);
        }
        return heroes;
    }
    public static List<EntityType> getEnemies() {
        List<EntityType> enemies = new ArrayList<>();
        for (EntityType entity : EntityType.values()) {
            if(!entity.isHero)
                enemies.add(entity);
        }
        return enemies;
    }

    // toString
    @Override
    public String toString() {
        return typeName;
    }
}