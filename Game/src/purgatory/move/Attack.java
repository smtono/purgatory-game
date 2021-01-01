package purgatory.move;

import purgatory.entity.Entity;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public interface Attack extends VirtualMove {
    /**
     * First determine if the move hits using doesHit() from Move
     * Takes the stats of the hero and formulates the attack power of the move
     * based on base damage along with the hero's strength/magic
     * <p>
     * Critical is calculated by choosing randomly. A move has a chance to critical 0.09 * Level of unit
     *
     * Each weapon/attack type is weak and strong against other weapon/attack types.
     * If a weapon is weak it will have a 25% reduction in base damage.
     * If it is strong it will have a 25% increase in base damage.
     *
     * @param hero: The entity object associated with the hero character
     * @return An int of the damage dealt by the hero unit
     */
    default int attack(Entity hero) {
        int baseDamage = getMove().getResult();
        int finalDamage;
        double criticalChance = hero.getLevel() * 0.09;
        double criticalHit = ThreadLocalRandom.current().nextDouble(0, 1);

        if(criticalHit < criticalChance) {
            finalDamage = baseDamage * 2;
        } else {
            finalDamage = baseDamage;
        }

        if(isStrength()) {
            finalDamage += finalDamage * hero.getStrength();
        } else if (isMagic()) {
            finalDamage += finalDamage * hero.getMagic();
        }

        return finalDamage;
    }

    /**
     * Returns a boolean of whether this is a strength based move or not.
     *
     * @return A boolean of whether this is a strength based move or not.
     */
    public boolean isStrength();

    /**
     * Returns a boolean of whether this is a magic based move or not.
     *
     * @return A boolean of whether this is a magic based move or not.
     */
    public boolean isMagic();
}
