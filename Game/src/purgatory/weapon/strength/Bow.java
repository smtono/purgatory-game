package purgatory.weapon.strength;

import purgatory.move.type.Attack;
import purgatory.move.Move;
import purgatory.move.type.MoveType;
import purgatory.weapon.AttackType;
import purgatory.weapon.ManaType;

public enum Bow implements Attack {
    // NORMAL BOW
    AIM("Aim", 10, 0, 0.4, false, 1),
    FIRE("Fire", 15, 0, 0.3, false, 1),
    ARROWSTORM("Arrow storm", 25, 0, 0.4, false, 1);

    // LONGBOW

    // ATTRIBUTES
    private final Move move;
    private final MoveType moveType = MoveType.ATTACK;
    private final AttackType attackType = AttackType.SHOOT;

    //  CONSTRUCTOR
    Bow(String name, int result, int mana, double accuracy, boolean isAffectAll, int levelOfAccess) {
        this.move = Move.of(name, result, mana, accuracy, isAffectAll, levelOfAccess, moveType, attackType);
    }

    // IMPLEMENTED METHODS
    @Override
    public Move getMove() { return move; }

    @Override
    public boolean isStrength() { return true; }

    @Override
    public boolean isMagic() { return false; }

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