package purgatory.entity;

import java.util.ArrayList;
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
            CharacterType.HERO,
            Arrays.asList(EntityWeapons.AttackType.SLASH, EntityWeapons.AttackType.BLUNT),
            Arrays.asList(EntityWeapons.SWORD, EntityWeapons.CLUB),
            true),
    ARCHER("Archer",
            CharacterType.HERO,
            null,
            Arrays.asList(EntityWeapons.BOW),
            true),
    MAGE("Mage",
            CharacterType.HERO,
            Arrays.asList(EntityWeapons.AttackType.ELEMENTAL, EntityWeapons.AttackType.DARK, EntityWeapons.AttackType.HOLY),
            Arrays.asList(EntityWeapons.WAND, EntityWeapons.STAFF),
            true),
    CLERIC("Cleric",
            CharacterType.HERO,
            Arrays.asList(EntityWeapons.AttackType.HOLY),
            Arrays.asList(EntityWeapons.STAFF),
            true),
    SCHOLAR("Scholar",
            CharacterType.HERO,
            Arrays.asList(EntityWeapons.AttackType.DARK, EntityWeapons.AttackType.HOLY),
            Arrays.asList(EntityWeapons.TOME),
            true),

    // enemies
    SOLDIER("Soldier",
            CharacterType.ENEMY,
            Arrays.asList(EntityWeapons.AttackType.SLASH, EntityWeapons.AttackType.BLUNT),
            Arrays.asList(EntityWeapons.SWORD, EntityWeapons.CLUB),
            false),
    MAGICIAN("Magician",
            CharacterType.ENEMY,
            Arrays.asList(EntityWeapons.AttackType.ELEMENTAL),
            Arrays.asList(EntityWeapons.WAND, EntityWeapons.STAFF),
            false); // don't forget about this semicolon '-'

    // variables for construction of the entity types
    public enum CharacterType {HERO, ENEMY, PARTY} // public so this enum can be accessed.
    private final String typeName;
    private final CharacterType characterType;
    private final List<EntityWeapons.AttackType> attackTypes;
    private final List<EntityWeapons> weaponTypes;
    private final boolean isHero;
    // CONSTRUCTOR
    EntityType(String typeName,
               CharacterType type,
               List<EntityWeapons.AttackType> attackTypes,
               List<EntityWeapons> weaponTypes,
               boolean isHero)
    {
        this.typeName = typeName;
        this.characterType = type;
        this.attackTypes = attackTypes;
        this.weaponTypes = weaponTypes;
        this.isHero = isHero;
    }
    // ACCESSORS
    public String getHeroType() { return typeName; }
    public CharacterType getCharacterType() {return characterType; }
    public List<EntityWeapons.AttackType> getAttackTypes() { return attackTypes; }
    public List<EntityWeapons> getWeaponTypes() { return weaponTypes; }
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