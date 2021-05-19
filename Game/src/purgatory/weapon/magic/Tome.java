package purgatory.weapon.magic;

import purgatory.move.type.Attack;
import purgatory.move.Move;
import purgatory.move.type.MoveType;
import purgatory.weapon.AttackType;
import purgatory.weapon.ManaType;

public enum Tome implements Attack {
    ANGEL("Angel", 30, 10, 0.6, true, 1),
    LEVIATHAN("Leviathan", 40, 15, 0.7, true, 1),
    ABADDON("Abaddon", 50, 17, 0.7, true, 1),
    CHERUBIM("Cherubim", 60, 20, 0.75, true, 2),
    NEPHILUM("Nephilum", 70, 22, 0.75, true, 5),
    BEHEMOTH("Behemoth", 100, 25, 0.8, true, 7),
    SERAPHIM("Seraphim", 150, 30, 0.9, true, 9),
    LUCIFER("Lucifer", 250, 35, 0.9, true, 10);

    // ATTRIBUTES
    private final Move move;
    private final MoveType moveType = MoveType.ATTACK;
    private final AttackType attackType = AttackType.DARK;

    //  CONSTRUCTOR
    Tome(String name, int result, int mana, double accuracy, boolean isAffectAll, int levelOfAccess) {
        this.move = Move.of(name, result, mana, accuracy, isAffectAll, levelOfAccess, moveType, attackType);
    }

    // IMPLEMENTED METHODS
    @Override
    public Move getMove() { return move; }

    @Override
    public boolean isStrength() {
        return false;
    }

    @Override
    public boolean isMagic() {
        return true;
    }

    @Override
    public ManaType getManaType() { return ManaType.MAGIC; }

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
