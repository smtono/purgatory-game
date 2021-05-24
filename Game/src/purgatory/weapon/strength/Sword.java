package purgatory.weapon.strength;

import purgatory.move.type.Attack;
import purgatory.move.Move;
import purgatory.move.type.MoveType;
import purgatory.weapon.AttackType;
import purgatory.weapon.ManaType;

/**
 *
 */
public enum Sword implements Attack {
    // NORMAL SWORD
    LUNGE("Lunge", 30, 0, 0.5, false, 1),
    SLASH("Slash", 45, 0, 0.5, false, 1),
    SLICE("Slice", 60, 0, 0.55, false, 2),
    RIPOSTE("Riposte", 80, 0, 0.6, true, 5),
    REMISE("Remise", 100, 0, 0.6, true, 7),
    FEINT("Feint", 200, 0, 0.7, false, 7),
    ;

    // GREAT SWORD

    // ATTRIBUTES
    private final Move move;
    private final MoveType moveType = MoveType.ATTACK;
    private final AttackType attackType = AttackType.SLASH;

    //  CONSTRUCTOR
    Sword(String name, int result, int mana, double accuracy, boolean isAffectAll, int levelOfAccess) {
        this.move = Move.of(name, result, mana, accuracy, isAffectAll, levelOfAccess, moveType, attackType);
    }

    // IMPLEMENTED METHODS
    @Override
    public Move getMove() { return move; }

    @Override
    public boolean isStrength() {
        return true;
    }

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
                "\nType: " + getMoveType() +
                "\nDamage: " + getResult() +
                "\nMana: " + getMana() +
                "\nAccuracy: " + getAccuracy() +
                "\nAffects all?: " + affectAll;
    }
}
