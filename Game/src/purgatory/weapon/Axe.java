package purgatory.weapon;

import purgatory.entity.Entity;
import purgatory.move.Attack;
import purgatory.move.Move;
import purgatory.move.MoveType;

public enum Axe implements Attack {
    ;
    // NORMAL AXE

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
    public int attack(Entity hero) {

        return 0;
    }

    @Override
    public boolean isStrength() { return true; }

    @Override
    public boolean isMagic() {
        return false;
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