package purgatory.weapon;

import purgatory.entity.Entity;
import purgatory.move.Attack;
import purgatory.move.Move;
import purgatory.move.MoveType;

public enum Bow implements Attack {
    // NORMAL BOW
    AIM("Aim", 10, 0, 0.4, false, 1),
    FIRE("Fire", 15, 0, 0.3, false, 1),
    ARROWSTORM("Arrowstorm", 25, 0, 0.4, false, 1);

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
    public int attack(Entity unit) {
        return 0;
    }

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