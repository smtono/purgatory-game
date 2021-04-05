package purgatory.move;

import purgatory.entity.Entity;
import purgatory.stats.BattleStats;
import purgatory.weapon.ManaType;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public interface Attack extends VirtualMove {
    /**
     * Returns the base damage of the move with additional damage from
     * the unit's strength or magic stat
     * 
     * @param unit: The entity object associated with the unit attacking
     * @return An int of the damage dealt by the hero unit
     */
    default int attack(BattleStats unit) {
        int damage = getMove().getResult();
      
        if(isStrength()) {
            damage += damage * unit.getCurrStrength();
        } else if (isMagic()) {
            damage += damage * unit.getCurrMagic();
        }

        return damage;
    }

    /**
     * Returns a boolean of whether this is a strength based move or not.
     *
     * @return A boolean of whether this is a strength based move or not.
     */
    boolean isStrength();

    /**
     * Returns a boolean of whether this is a magic based move or not.
     *
     * @return A boolean of whether this is a magic based move or not.
     */
    boolean isMagic();

    /**
     * Returns the ManaType of this specific move
     * 
     * @return The ManaType of this specific move
     */
    ManaType getManaType();
}
