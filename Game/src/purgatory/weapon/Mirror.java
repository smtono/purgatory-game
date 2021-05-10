package purgatory.weapon;

import purgatory.move.Attack;
import purgatory.move.Move;
import purgatory.move.MoveType;

public enum Mirror implements Attack {
    ;

    // ATTRIBUTES
    private final Move move;
    private final MoveType moveType = MoveType.ATTACK;
    private final AttackType attackType = AttackType.PIERCE;

    // CONSTRUCTOR
    Mirror(String name, int result, int mana, double accuracy, boolean isAffectAll, int levelOfAccess) {
        this.move = Move.of(name, result, mana, accuracy, isAffectAll, levelOfAccess, moveType, attackType);
    }

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
