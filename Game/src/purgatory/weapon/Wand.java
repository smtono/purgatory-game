package purgatory.weapon;

import purgatory.entity.Entity;
import purgatory.move.Attack;
import purgatory.move.Move;
import purgatory.move.MoveType;

public enum Wand implements Attack {
    FROSTBITE("Frostbite", 10, 2, 0.7, false, 1),
    FIRESTORM("Firestorm", 25, 10, 0.7, true, 1),
    GUST("Gust", 12, 3, 0.7, true, 1),
    LIGHTNING("Lightning", 40, 10, 0.7, false, 2 );

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
    public int attack(Entity hero) {
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
    public String toString() {
        return "HeroMoves{" +
                "name='" + getName() + '\'' +
                ", damage=" + getResult() +
                ", mana=" + getMana() +
                ", accuracy=" + getAccuracy() +
                ", attackAll=" + isAffectAll() +
                ", attackType=" + moveType +
                ", attackType=" + attackType +
                '}' +
                "\n";
    }
}
