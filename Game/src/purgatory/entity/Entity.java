package purgatory.entity;

import purgatory.Reference;

import java.util.ArrayList;
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
    //	CLASS VARIABLES
    private EntityType entityType;
    // for battle
    private String name;
    final private int maxHealth;
    private int mana;
    private int speed;
    private int accuracy;
    private int strength, magic;
    private int xp, level;

    //	CONSTRUCTORS
    // The default constructor is tailored for a level 1 hero.
    public Entity(EntityType entityType) {
            this(entityType, 100, 20, 10, 0.6, 0, 0, 0, 1);
    }
    // parametrized
    public Entity(EntityType entityType, int maxHealth, int mana, int speed, double accuracy, int xp, int strength, int magic, int level) {
        this.entityType = entityType;
        this.maxHealth = maxHealth;
        this.xp = xp;
        this.level = level;
        this.speed = speed;
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

    public int getAccuracy() { return accuracy; }
    public void setAccuracy(int accuracy) { this.accuracy = accuracy; }

    public int getXp() { return xp; }
    public void setXp(int xp) { this.xp = xp; }

    public int getStrength() { return strength; }
    public void setStrength(int strength) { this.strength = strength; }

    public int getMagic() { return magic; }
    public void setMagic(int magic) { this.magic = magic; }

    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }

    public String getEnemyInfo() {
       return name + "\n" +
               entityType.toString() +
               "\nhealth = " + maxHealth +
                "\nmana = " + mana +
                "\nlevel = " + level;
    }

    // TODO: change into an enum ?
    public List<String> getMoves(EntityType type) {
        List<String> moves = new ArrayList<>();
        switch (type) {
            case WARRIOR: {
                moves.add("Lunge");
                moves.add("Slash");
                moves.add("Riposte");
                break;
            }
            case MAGE: {
                moves.add("Firestorm");
                moves.add("Frostbite");
                moves.add("Luminescence");
                break;
            }
        }
        return moves;
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
