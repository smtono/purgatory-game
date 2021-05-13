package purgatory.weapon.strength;

import purgatory.move.Move;
import purgatory.move.type.Attack;
import purgatory.move.type.MoveType;
import purgatory.move.type.Support;
import purgatory.weapon.AttackType;
import purgatory.weapon.ManaType;

public enum Lance implements Attack, Support {
    IMPALE("Impale", 30, 0, 0.4, true, 1),
    STRIKE("Strike", 45, 0, 0.2, true, 1),
    BLOCK("Block", 10, 0, 0.5, false, 1), // blocks 10 damage
    ;

    private final Move move;
    private final MoveType moveType = MoveType.ATTACK;
    private final AttackType attackType = AttackType.PIERCE;

    //  CONSTRUCTOR
    Lance(String name, int result, int mana, double accuracy, boolean isAffectAll, int levelOfAccess) {
        this.move = Move.of(name, result, mana, accuracy, isAffectAll, levelOfAccess, moveType, attackType);
    }

    // IMPLEMENTED METHODS
    @Override
    public Move getMove() { return move; }

    @Override
    public boolean isStrength() { return true; }

    @Override
    public boolean isMagic() {
        return false;
    }

    @Override
    public ManaType getManaType() { return ManaType.STRENGTH; }

    @Override
    public String toString() {
        String affectAll;

        if (isAffectAll()) {
            affectAll = "Yes";
        }
        else {
            affectAll = "No";
        }

        return "Name: " + getName() +
                "\nDamage: " + getResult() +
                "\nMana: " + getMana() +
                "\nAccuracy: " + getAccuracy() +
                "\nAffects all?: " + affectAll;
    }
}
