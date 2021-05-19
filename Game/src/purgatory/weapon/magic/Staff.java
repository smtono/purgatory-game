package purgatory.weapon.magic;

import purgatory.move.type.Attack;
import purgatory.move.type.Heal;
import purgatory.move.Move;
import purgatory.move.type.MoveType;
import purgatory.weapon.AttackType;
import purgatory.weapon.ManaType;

public enum Staff implements Attack, Heal {
    // NORMAL STAFF
    // ATTACKS
    LUX("Lux", 10, 5, 0.7, true, 1, MoveType.ATTACK, AttackType.HOLY),
    LUMINESCENCE("Luminescence", 15, 8, 0.7, true, 1, MoveType.ATTACK, AttackType.HOLY),

    // HEALS
    MEND("Mend", 10, 2, 0.7, false, 1, MoveType.HEAL, AttackType.HOLY),
    REMEDIAL("Remedial", 25, 5, 0.75, false, 2, MoveType.HEAL, AttackType.HOLY),
    RECOVERY("Recovery", 45, 10, 0.8, true, 5, MoveType.HEAL, AttackType.HOLY),
    
    // SUPPORT
    ENERGIZE("Energize", 10, 5, 0.5, false, 5, MoveType.SUPPORT, AttackType.HOLY);

    // SCEPTER

    // ATTRIBUTES
    private final Move move;
    private final AttackType attackType = AttackType.HOLY;

    //  CONSTRUCTOR
    Staff(String name, int result, int mana, double accuracy, boolean isAffectAll, int levelOfAccess, MoveType moveType, AttackType attackType) {
        this.move = Move.of(name, result, mana, accuracy, isAffectAll, levelOfAccess, moveType, attackType);
    }

    // IMPLEMENTED METHODS
    @Override
    public Move getMove() { return move; }

    @Override
    public int heal() {
        return 0;
    }

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
