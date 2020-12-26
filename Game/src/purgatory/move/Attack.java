package purgatory.move;

import purgatory.entity.Entity;

public interface Attack extends Move {
    /**
     * First determine if the move hits using doesHit() from Move
     * Takes the stats of the hero and formulates the attack power of the move
     * based on base damage along with the hero's strength/magic
     *
     * Take whatever percent over 100 for the accuracy of the move from doesHit() and use that for critical
     * <p>
     * Critical can be calculated by taking whatever percentage it is
     * after the above calculations and adding that percent
     * of damage on top of the base damage.
     *
     * @param hero: The entity object associated with the hero character
     * @return An int of the damage dealt by the hero unit
     */
    public int attack(Entity hero);

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
