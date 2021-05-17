package purgatory.battle.stats;

import purgatory.entity.type.EntityType;
import purgatory.move.Move;

import java.util.ArrayList;
import java.util.List;


/**
 * BattleStats is used to keep track of and manipulate the current stats during a battle without
 * directly changing the values of the Entity objects associated with them.
 */
public class BattleStats {
    private String fighter;
    private EntityType entityType;
    private List<Move> moveSet;
    private int currHealth;
    private int currMana;
    private int currSpeed;
    private double currAccuracy;
    private double currStrength, currMagic;
    private double currDefense;
    private int level;

    public BattleStats() {}

    public BattleStats(
            String fighter,
            EntityType entityType,
            List<Move> moveSet,
            int currHealth,
            int currMana,
            int currSpeed,
            double currAccuracy,
            double currStrength,
            double currMagic,
            double currDefense,
            int level) {
        this.fighter = fighter;
        this.entityType = entityType;
        this.moveSet = moveSet;
        this.currHealth = currHealth;
        this.currMana = currMana;
        this.currSpeed = currSpeed;
        this.currAccuracy = currAccuracy;
        this.currStrength = currStrength;
        this.currMagic = currMagic;
        this.currDefense = currDefense;
        this.level = level;
    }

    // ACCESSORS
    public String getFighter() {
        return fighter;
    }
    public EntityType getEntityType() { return entityType; }
    public List<Move> getMoveSet() { return moveSet; }
    public int getCurrHealth() {
        return currHealth;
    }
    public int getCurrMana() {
        return currMana;
    }
    public int getCurrSpeed() {
        return currSpeed;
    }
    public double getCurrAccuracy() { return currAccuracy; }
    public double getCurrStrength() { return currStrength; }
    public double getCurrMagic() { return currMagic; }
    public double getCurrDefense() { return currDefense; }

    // MUTATORS
    public void setCurrHealth(int currHealth) {
        this.currHealth = currHealth;
    }
    public void setCurrMana(int currMana) { this.currMana = currMana; }
    public void setCurrSpeed(int currSpeed) { this.currSpeed = currSpeed; }
    public void setCurrAccuracy(double currAccuracy) { this.currAccuracy = currAccuracy; }
    public void setCurrStrength(double currStrength) { this.currStrength = currStrength; }
    public void setCurrMagic(double currMagic) { this.currMagic = currMagic; }
    public void setCurrDefense(double currDefense) { this.currDefense = currDefense; }

    public int getLevel() { return level; }

    // HELPER
    /**
     * Gets the stat values for the entity and returns the values back.
     *
     * @return A list of stat values for the given entity
     */
    public String getInfo() {
        return fighter + "\n" +
                entityType.toString() +
                "\nHealth: " + currHealth +
                "\nMana: " + currMana +
                "\nDefense: " + currDefense +
                "\nSpeed: " + currSpeed +
                "\nAccuracy: " + currAccuracy +
                "\nStrength: " + currStrength +
                "\nMagic: " + currMagic +
                "\nLevel: " + level;
    }

    /**
     * Gets a simplified version of stats for enemies
     *  
     * @return String of simplified stat values
     */
    public String getEnemyInfo() {
        return fighter + "\n" +
                entityType.toString() +
                "\nHealth: " + currHealth +
                "\nLevel: " + level;
    }
    
    public List<String> getMoveNames() {
        List<String> moves = new ArrayList<>();

        moveSet.forEach(move -> {
            moves.add(move.getName());
        });

        return moves;
    }

    @Override
    public String toString() { return fighter; }
}
