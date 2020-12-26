package purgatory.move;

/**
 * Move is an interface with move constants that are associated with different hero types, weapon types,
 * and move types (attack or support)
 * <p>
 * Can be used to keep track of base damage, AOE attack or not.
 * <p>
 * Classes or enums that implement Move will have to implement
 * <p>
 * How accuracy for moves work:
 * Take hero's current accuracy (in entity constructor)
 * multiply that by 200,
 * then take the weapon's accuracy and multiply by that
 * take whatever percent over 100 it gets and use that for critical
 * critical can be calculated by taking whatever percentage it is after the above calculations and adding that percent
 * of damage on top of the base damage.
 * <p>
 * A move enum constant contains a
 * NAME: The name of the move
 * RESULT: damage/heal/utility
 * MANA: the amount of mana (energy) consumed using the move
 * ACCURACY: how often the move will hit
 * MAGIC or STRENGTH: ...
 * IS AFFECT ALL: whether or not the move will hit all enemies or not
 * MOVE TYPE: Whether it is an attack, heal, or utility move
 * ATTACK TYPE: What kind/how the weapon of the move is handled
 * LEVEL OF ACCESS: When (at what level) the move can be unlocked for a unit.
 */
public interface Move {
    /**
     * Determines how much mana is going to be subtracted from the current hero
     * or party member's total mana, and returns that value to be subtracted.
     *
     * @param currMana: The current amount of mana the unit passed has
     * @return The amount of mana points to be subtracted from the current mana.
     */
    public int useMana(int currMana);

}