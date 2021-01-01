package purgatory.move;

import purgatory.weapon.AttackType;

/**
 * Move is an interface with move constants that are associated with different hero types, weapon types,
 * and move types (attack or support)
 * <p>
 * Can be used to keep track of base damage, AOE attack or not.
 * <p>
 * Classes or enums that implement Move will have to implement
 * <p>
 * <p>
 * How accuracy for moves work:
 * <p>
 * Take hero's current accuracy (in entity constructor)
 * multiply that by 200,
 * then take the weapon's accuracy and multiply by that
 * take whatever percent over 100 it gets and use that for critical
 * critical can be calculated by taking whatever percentage it is after the above calculations and adding that percent
 * of damage on top of the base damage.
 * <p>
 * <p>
 * A move enum constant contains a:
 * <li>NAME: The name of the move
 * <li>RESULT: damage/heal/utility
 * <li>MANA: the amount of mana (energy) consumed using the move
 * <li>ACCURACY: how often the move will hit
 * <li>MAGIC or STRENGTH: the mana type of the given move
 * <li>IS AFFECT ALL: whether or not the move will hit all enemies or not
 * <li>MOVE TYPE: Whether it is an attack, heal, or utility move
 * <li>ATTACK TYPE: What kind/how the weapon of the move is handled
 * <li>LEVEL OF ACCESS: When (at what level) the move can be unlocked for a unit.
 */
public interface Move {
    /**
     * Determines how much mana is going to be subtracted from the current hero
     * or party member's total mana, and returns that value to be subtracted.
     *
     * @param currMana: The current amount of mana the unit passed has
     * @return The amount of mana points to be subtracted from the current mana.
     */
    int useMana(int currMana);

    // ACCESSORS
    String getName();

    int getResult();

    int getMana();

    double getAccuracy();

    boolean isAffectAll();

    int getLevelOfAccess();

    MoveType getMoveType();

    AttackType getAttackType();

    static Move of(final String name,
                   final int result,
                   final int mana,
                   final double accuracy,
                   final boolean isAffectAll,
                   final int levelOfAccess,
                   final MoveType moveType,
                   final AttackType attackType) {

        return new Move() {
            @Override
            public int useMana(int currMana) { return currMana - mana; }

            @Override
            public String getName() { return name; }

            @Override
            public int getResult() { return result; }

            @Override
            public int getMana() { return mana; }

            @Override
            public double getAccuracy() { return accuracy; }

            @Override
            public boolean isAffectAll() { return isAffectAll; }

            @Override
            public int getLevelOfAccess() { return levelOfAccess; }

            @Override
            public MoveType getMoveType() { return moveType; }

            @Override
            public AttackType getAttackType() { return attackType; }
        };
    }
}