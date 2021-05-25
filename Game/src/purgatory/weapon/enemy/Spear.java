package purgatory.weapon.enemy;

import purgatory.move.Move;
import purgatory.move.type.Attack;
import purgatory.move.type.MoveType;
import purgatory.weapon.AttackType;
import purgatory.weapon.ManaType;

public enum Spear implements Attack {
    PIERCE("Pierce", 10, 0, 0.5, false, 1),
    JAB("Jab", 20, 0, 0.8, false, 1),
    SPIKE("Spike", 30, 0, 0.4, false, 1),

    BORE("Bore", 80, 0 , 0.5, true, 3),

    PERMEATE("Permeate", 100, 0, 0.5, true, 5),

    PERCOLATE("Percolate", 150, 0, 0.5, true, 7),
    PERVADE("Pervade", 200, 0, 0.6, true, 7),
    ;

    private final Move move;
    private final MoveType moveType = MoveType.ATTACK;
    private final AttackType attackType = AttackType.PIERCE;

    //  CONSTRUCTOR
    Spear(String name, int result, int mana, double accuracy, boolean isAffectAll, int levelOfAccess) {
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
                "\nResult: " + getResult() +
                "\nMana: " + getMana() +
                "\nAccuracy: " + getAccuracy() +
                "\nAffects all?: " + affectAll;
    }
}
