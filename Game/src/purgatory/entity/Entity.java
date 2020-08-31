package purgatory.entity;

import purgatory.Reference;

import java.util.List;
import java.util.Random;

/*
    Author: Shannon Thornton

    Purpose: To simplify the "abstraction" I used earlier. Since heroes and enemies are so similar, it would be simpler
    to store their data and similar methods into one file. Basically, more files =/= more complex.

    health = the amount of hit points the character can take
    mana = the amount of energy the character has to make moves
    xp = the amount of experience a character receives to level up
    accuracy = determines if the move chosen will hit or not
    evasion = determines if a character will dodge an attack, and also determines the order of battle

    A baseline hero will start out with 100 hit points, 20 mana points, 0 experience, and 60 accuracy.
    A baseline enemy will start out with 200 hit points and 60 accuracy.
 */
public class Entity {
    //	for specification
    private EntityType entityType;
    private List<EntityWeapons.AttackType> attackTypes;
    private List<EntityWeapons> weaponTypes;
    private List<EntityMoves> moveSet;
    // for battle
    private final String name;
    private final int maxHealth;
    private int mana;
    private int speed;
    private double accuracy;
    private int strength, magic;
    private int xp, level;

    //	CONSTRUCTORS
    // The default constructor is tailored for a level 1 hero.
    public Entity(EntityType entityType) {
            this(entityType, 100, 20, 10, 0.6, 0, 0, 0, null, null, null, 1);
            this.attackTypes = entityType.getAttackTypes();
    }
    // parametrized
    // TODO: use a switch case to specify each entity type's starting stats
    public Entity(EntityType entityType,
                  int maxHealth,
                  int mana,
                  int speed,
                  double accuracy,
                  int xp,
                  int strength,
                  int magic,
                  List<EntityWeapons.AttackType> attackTypes,
                  List<EntityWeapons> weaponTypes,
                  List<EntityMoves> moveSet,
                  int level)
    {
        this.entityType = entityType;
        this.maxHealth = maxHealth;
        this.mana = mana;
        this.speed = speed;
        this.accuracy = accuracy;
        this.xp = xp;
        this.strength = strength;
        this.magic = magic;
        this.attackTypes = attackTypes;
        this.level = level;
        // TODO fix for hero
        this.name = Reference.NAMES[new Random().nextInt(Reference.NAMES.length)];
    }
    //  ACCESSORS / MUTATORS
    public EntityType getEntityType() { return entityType; }
    public void setEntityType(EntityType entityType) { this.entityType = entityType; }

    public int getMaxHealth() { return maxHealth; }

    public int getMana() { return mana; }
    public void setMana(int mana) { this.mana = mana; }

    public int getSpeed() { return speed; }
    public void setSpeed(int speed) { this.speed = speed; }

    public double getAccuracy() { return accuracy; }
    public void setAccuracy(int accuracy) { this.accuracy = accuracy; }

    public int getXp() { return xp; }
    public void setXp(int xp) { this.xp = xp; }

    public int getStrength() { return strength; }
    public void setStrength(int strength) { this.strength = strength; }

    public int getMagic() { return magic; }
    public void setMagic(int magic) { this.magic = magic; }

    public List<EntityWeapons.AttackType> getAttackTypes() { return attackTypes; }
    public void setAttackTypes(List<EntityWeapons.AttackType> attackTypes) { this.attackTypes = attackTypes; }

    public List<EntityWeapons> getWeaponTypes() { return weaponTypes; }
    public void setWeaponTypes(List<EntityWeapons> weaponTypes) { this.weaponTypes = weaponTypes; }

    public List<EntityMoves> getMoveSet() { return moveSet; }
    public void setMoveSet(List<EntityMoves> moveSet) { this.moveSet = moveSet; }

    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }

    public String getEnemyInfo() {
       return name + "\n" +
               entityType.toString() +
               "\nHealth: " + maxHealth +
                "\nLevel " + level;
    }
    @Override
    public String toString() {
        return "Entity{" +
                "entityType=" + entityType +
                ", maxHealth=" + maxHealth +
                ", mana=" + mana +
                ", speed=" + speed +
                ", strength=" + strength +
                ", magic=" + magic +
                ", xp=" + xp +
                ", level=" + level +
                '}';
    }
}