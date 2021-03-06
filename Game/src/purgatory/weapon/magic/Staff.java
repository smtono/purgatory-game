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
    LUX("Lux", 20, 10, 0.7, true, 1, MoveType.ATTACK, AttackType.HOLY),
    LUMINESCENCE("Luminescence", 30, 8, 0.7, true, 1, MoveType.ATTACK, AttackType.HOLY),
    SHOWER("Light Shower", 50, 10, 0.9, true, 5, MoveType.ATTACK, AttackType.HOLY),

    // HEALS
    MEND("Mend", 50, 10, 0.7, false, 1, MoveType.HEAL, AttackType.HOLY),
    REMEDIAL("Remedial", 100, 20, 0.75, false, 5, MoveType.HEAL, AttackType.HOLY),
    RECOVERY("Recovery", 500, 50, 0.8, true, 7, MoveType.HEAL, AttackType.HOLY),
    
    // SUPPORT
    ENERGIZE("Energize", 10, 5, 0.5, false, 5, MoveType.SUPPORT, AttackType.HOLY),
    DESHIELD("De-Shield", 0, 30, 0.9, false, 7, MoveType.SUPPORT, AttackType.HOLY),
    ;
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
                "\nResult: " + getResult() +
                "\nMana: " + getMana() +
                "\nAccuracy: " + getAccuracy() +
                "\nAffects all?: " + affectAll;
    }
}
