package purgatory.weapon.enemy;

import purgatory.move.Move;
import purgatory.move.type.Attack;
import purgatory.move.type.MoveType;
import purgatory.weapon.AttackType;
import purgatory.weapon.ManaType;

public enum Rapier implements Attack {
    LUNGE("Lunge", 8, 0, 0.3, false, 1),
    SLASH("Slash", 15, 0, 0.2, false, 1),
    SLICE("Slice", 22, 0, 0.2, false, 2),
    RIPOSTE("Riposte", 35, 10, 0.4, true, 5)
    ;

    private final Move move;
    private final MoveType moveType = MoveType.ATTACK;
    private final AttackType attackType = AttackType.PIERCE;

    //  CONSTRUCTOR
    Rapier(String name, int result, int mana, double accuracy, boolean isAffectAll, int levelOfAccess) {
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
