package purgatory.weapon.magic;

import purgatory.move.type.Attack;
import purgatory.move.Move;
import purgatory.move.type.MoveType;
import purgatory.weapon.AttackType;
import purgatory.weapon.ManaType;

public enum Wand implements Attack {
    FROSTBITE("Frostbite", 40, 2, 0.7, false, 1),
    FIRESTORM("Firestorm", 60, 10, 0.7, true, 1),
    GUST("Gust", 70, 3, 0.7, true, 1),
    LIGHTNING("Lightning", 100, 10, 0.7, false, 2),
    CRYSTALIZE("Crystalize", 150, 15, 0.8, true, 4),
    GALESTORM("Galestorm", 200, 20, 0.8, false, 5),
    BLAZE("Blaze", 250, 25, 0.8, false, 5),
    THUNDERSTORM("Thunderstorm", 300, 40, 0.9, true, 7),
    ;


    // ATTRIBUTES
    private final Move move;
    private final MoveType moveType = MoveType.ATTACK;
    private final AttackType attackType = AttackType.ELEMENTAL;

    //  CONSTRUCTOR
    Wand(String name, int result, int mana, double accuracy, boolean isAffectAll, int levelOfAccess) {
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
