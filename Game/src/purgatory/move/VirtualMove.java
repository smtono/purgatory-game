package purgatory.move;

import purgatory.weapon.AttackType;

/**
 * VirtualMove is an attempt to implement a "Virtual Field Pattern" in the Weapon enums hierarchy.
 * <p>
 * Each weapon enum implements these similar methods, so the idea is to implement this interface
 * and return an anonymous class that has these methods already implemented.
 *
 * This is my attempt in getting around the inability for enums to extend abstract classes.
 */
public interface VirtualMove extends Move {
    Move getMove();

    @Override
    default int useMana(int currMana) { return getMove().useMana(currMana); }

    @Override
    default String getName() { return getMove().getName(); }

    @Override
    default int getResult() { return getMove().getResult(); }

    @Override
   default int getMana() { return getMove().getMana(); }

    @Override
    default double getAccuracy() { return getMove().getAccuracy(); }

    @Override
    default boolean isAffectAll() { return getMove().isAffectAll(); }

    @Override
    default int getLevelOfAccess() { return getMove().getLevelOfAccess(); }

    @Override
    default MoveType getMoveType() { return getMove().getMoveType(); }

    @Override
    default AttackType getAttackType() { return getMove().getAttackType(); }
}
