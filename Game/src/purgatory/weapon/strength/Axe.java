package purgatory.weapon.strength;

import purgatory.move.type.Attack;
import purgatory.move.Move;
import purgatory.move.type.MoveType;
import purgatory.weapon.AttackType;
import purgatory.weapon.ManaType;

public enum Axe implements Attack {
    // NORMAL AXE
    CHOP("Chop", 15, 0, 0.4, false, 1),
    CLEAVE("Cleave", 30, 0, 0.3, false, 1),
    AMPUTATE("Amputate", 45, 0, 0.3, true, 1),
    HEW("Hew", 75, 0,0.4, false, 5),
    SLASH("Slash", 100, 0, 0.4, true, 5),
    ABOLISH("Abolish", 200, 0, 0.2, true, 7),
    ;

    // GREAT AXE

    // ATTRIBUTES
    private final Move move;
    private final MoveType moveType = MoveType.ATTACK;
    private final AttackType attackType = AttackType.BLUNT;

    //  CONSTRUCTOR
    Axe(String name, int result, int mana, double accuracy, boolean isAffectAll, int levelOfAccess) {
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