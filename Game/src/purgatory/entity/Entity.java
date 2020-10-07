package purgatory.entity;

import purgatory.Reference;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import purgatory.battle.*;
import purgatory.util.EntityUtil;
import purgatory.util.MoveUtil;

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
    private List<Move> moveSet;
    // for battle
    private final String name;
    private final int MAX_HEALTH;
    private int mana;
    private int speed;
    private double accuracy;
    private int strength, magic;
    private int xp, level;

    //	CONSTRUCTORS
    // The default constructor is tailored for a level 1 hero.
    public Entity(EntityType entityType) {
            this("", entityType, 100, 20, 10, 0.6, 0, 0, 0, null, 1);
       // define base move set
        moveSet = MoveUtil.getHeroMoveSet(entityType);
    }
    public Entity(String name, EntityType entityType) {
        this(name, entityType, 100, 20, 10, 0.6, 0, 0, 0, null, 1);
        // TODO: fix so it is not repeat code
        // define base move set
        moveSet = MoveUtil.getHeroMoveSet(entityType);

    }
    // fully parametrized
    // TODO: use a switch case to specify each entity type's starting stats
    public Entity(String name,
                  EntityType entityType,
                  int MAX_HEALTH,
                  int mana,
                  int speed,
                  double accuracy,
                  int xp,
                  int strength,
                  int magic,
                  List<Move> moveSet,
                  int level)
    {
        this.name = name;
        this.entityType = entityType;
        this.MAX_HEALTH = MAX_HEALTH;
        this.mana = mana;
        this.speed = speed;
        this.accuracy = accuracy;
        this.xp = xp;
        this.strength = strength;
        this.magic = magic;
        this.moveSet = moveSet;
        this.level = level;
    }

    //  ACCESSORS / MUTATORS
    public String getName() { return name; }

    public EntityType getEntityType() { return entityType; }
    public void setEntityType(EntityType entityType) { this.entityType = entityType; }

    public int getMaxHealth() { return MAX_HEALTH; }

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

    public List<Move> getMoveSet() { return moveSet; }
    public void setMoveSet(List<Move> moveSet) { this.moveSet = moveSet; }

    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }

    public String getInfo() {
        return name + "\n" +
                entityType.toString() +
                "\nHealth: " + MAX_HEALTH +
                "\nLevel " + level;
    }
    @Override
    public String toString() {
        return "Entity{" +
                "entityType=" + entityType +
                ", maxHealth=" + MAX_HEALTH +
                ", mana=" + mana +
                ", speed=" + speed +
                ", strength=" + strength +
                ", magic=" + magic +
                ", xp=" + xp +
                ", level=" + level +
                '}';
    }
}