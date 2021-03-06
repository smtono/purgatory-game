package purgatory.entity;

import java.util.ArrayList;
import java.util.List;

import purgatory.dialogue.dialog.CharacterCreationDialog;
import purgatory.entity.type.EntityType;
import purgatory.entity.type.HeroType;
import purgatory.move.Move;
import purgatory.move.MoveUtil;
import purgatory.weapon.ManaType;

import javax.swing.*;

/**
 * Entity is used to create objects for characters such as the hero, part members, and enemies.
 * <p>
 * Each Entity object will have a set of attributes called "stats" in game that correspond to different values:
 * name = the given name to the character, party member, or enemy. enemies will have names coming from Reference.java
 *<l>
 * health = the amount of hit points the character can take
 * mana = the amount of energy the character has to make moves
 * speed = the value used to determine the entity's order in battle.
 * accuracy = determines if the move chosen will hit or not
 * strength = the value associated with non-magical weapons that allows for a boost in attack power
 * magic = the value associated with magical weapons that allows for a boost in attack power
 * defense = how much an entity will "shield" an attack viz. how much damage will be absorbed
 * level = the level of play of the entity, this value will move up progressively as the game goes on.
 * </l>
 * <p>
 * A baseline hero will start out with 100 hit points, 20 mana points, and 60 accuracy.
 * A baseline enemy will start out with 200 hit points and 60 accuracy.
 */
public class Entity {
    private EntityType entityType;
    private List<Move> moveSet;
    private final String name;
    private int MAX_HEALTH;
    private int mana;
    private int speed;
    private double accuracy;
    private double strength, magic;
    private double defense;
    private int level;

    //	CONSTRUCTORS
    // The default constructor is tailored for a level 1 hero.
    public Entity(String name, EntityType entityType, List<Move> moveSet) {
        this(name, entityType, 300, 50, 10, 0.6, 0, 0, 0, moveSet, 1);
    }

    // Overloaded constructor, mainly used for the creation of enemies
    public Entity(String name,
                  EntityType entityType,
                  int MAX_HEALTH,
                  int mana,
                  int speed,
                  double accuracy,
                  double strength,
                  double magic,
                  double defense,
                  List<Move> moveSet,
                  int level) {
        this.name = name;
        this.entityType = entityType;
        this.MAX_HEALTH = MAX_HEALTH;
        this.mana = mana;
        this.speed = speed;
        this.accuracy = accuracy;
        this.strength = strength;
        this.magic = magic;
        this.defense = defense;
        this.moveSet = moveSet;
        this.level = level;
    }

    //  ACCESSORS
    public String getName() {
        return name;
    }
    public EntityType getEntityType() { return entityType; }
    public int getMaxHealth() {
        return MAX_HEALTH;
    }
    public int getMana() {
        return mana;
    }
    public int getSpeed() {
        return speed;
    }
    public double getAccuracy() {
        return accuracy;
    }
    public double getStrength() {
        return strength;
    }
    public double getMagic() {
        return magic;
    }
    public double getDefense() { return defense; }
    public List<Move> getMoveSet() { return moveSet; }
    public int getLevel() {
        return level;
    }

    // MUTATORS
    public void setEntityType(EntityType entityType) {
        this.entityType = entityType;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }
    public void setMagic(int magic) {
        this.magic = magic;
    }
    public void setDefense(double defense) { this.defense = defense; }
    public void setMoveSet(List<Move> moveSet) {
        this.moveSet = moveSet;
    }
    public void setLevel(int level) {
        this.level = level;
    }

    // HELPER
    public void levelUp() {
        if (!name.equalsIgnoreCase("rosalind")) {
            JOptionPane.showMessageDialog(null, name + " leveled up!", "Rosalind", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null, "I leveled up!", "Rosalind", JOptionPane.INFORMATION_MESSAGE);
        }

        level += 1;

        if (level < 3) {
            MAX_HEALTH += 200;
            mana += 50;
            speed += 2;
            accuracy += 0.05;
            magic += 0.05;
            strength += 0.05;
            defense += 0.1;
        }
        else {
            MAX_HEALTH += 500;
            mana += 100;
            speed += 5;
            accuracy += 0.05;
            magic += 0.1;
            strength += 0.1;
            defense += 0.1;
        }

        // choose new move set
        List<Move> chosenMoves = new ArrayList<>();
        JOptionPane.showConfirmDialog(null, "Time to choose some new moves!", "Rosalind", JOptionPane.DEFAULT_OPTION);
        for (int i = 0; i < 3; i++) {
            chosenMoves.add(CharacterCreationDialog.chooseMove(MoveUtil.getAccessibleMoves(1, entityType.getWeaponTypes()), chosenMoves));
        }
    }

    @Override
    public String toString() {
        return name;
    }
}