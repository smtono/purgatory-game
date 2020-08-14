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
    WARRIOR("Warrior", CharacterType.HERO, true),
    MAGE("Mage", CharacterType.HERO, true),
    // enemies
    SLIME("Slime", CharacterType.ENEMY, false),
    FIRE("Fire", CharacterType.ENEMY, false); // don't forget about this semicolon '-'
    // variables for construction of the entity types
    private enum CharacterType {HERO, ENEMY, PARTY}
    private String typeName;
    private CharacterType type;
    private boolean isHero;
    // CONSTRUCTOR
    EntityType(String typeName, CharacterType type, boolean isHero) {
        this.typeName = typeName;
        this.type = type;
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