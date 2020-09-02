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
            Arrays.asList(AttackType.SLASH, AttackType.BLUNT),
            Arrays.asList(Weapon.SWORD, Weapon.CLUB),
            true),
    ARCHER("Archer",
            CharacterType.HERO,
            Arrays.asList(AttackType.SHOOT),
            Arrays.asList(Weapon.BOW),
            true),
    MAGE("Mage",
            CharacterType.HERO,
            Arrays.asList(AttackType.ELEMENTAL, AttackType.DARK, AttackType.HOLY),
            Arrays.asList(Weapon.WAND, Weapon.STAFF),
            true),
    CLERIC("Cleric",
            CharacterType.HERO,
            Arrays.asList(AttackType.HOLY),
            Arrays.asList(Weapon.STAFF),
            true),
    SCHOLAR("Scholar",
            CharacterType.HERO,
            Arrays.asList(AttackType.DARK, AttackType.HOLY),
            Arrays.asList(Weapon.TOME),
            true),

    // enemies
    SOLDIER("Soldier",
            CharacterType.ENEMY,
            Arrays.asList(AttackType.SLASH, AttackType.BLUNT),
            Arrays.asList(Weapon.SWORD, Weapon.CLUB),
            false),
    MAGICIAN("Magician",
            CharacterType.ENEMY,
            Arrays.asList(AttackType.ELEMENTAL),
            Arrays.asList(Weapon.WAND, Weapon.STAFF),
            false); // don't forget about this semicolon '-'

    // variables for construction of the entity types
    public enum CharacterType {HERO, ENEMY, PARTY} // public so this enum can be accessed.
    private final String typeName;
    private final CharacterType characterType;
    private final List<AttackType> attackTypes;
    private final List<Weapon> weaponTypes;
    private final boolean isHero;
    // CONSTRUCTOR
    EntityType(String typeName,
               CharacterType type,
               List<AttackType> attackTypes,
               List<Weapon> weaponTypes,
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
    public List<AttackType> getAttackTypes() { return attackTypes; }
    public List<Weapon> getWeaponTypes() { return weaponTypes; }
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