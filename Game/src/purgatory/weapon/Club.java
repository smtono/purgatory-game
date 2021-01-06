package purgatory.weapon;

import purgatory.entity.Entity;
import purgatory.move.Attack;
import purgatory.move.Move;
import purgatory.move.MoveType;

public enum Club implements Attack {
    // NORMAL CLUB
    BLUDGEON("Bludgeon", 30, 0, 0.4, false, 1),
    CLOBBER("Clobber", 35, 0, 0.4, false, 1),
    BATTER("Batter", 45, 0, 0.3, false, 5);

    // MORNING STAR

    // ATTRIBUTES
    private final Move move;
    private final MoveType moveType = MoveType.ATTACK;
    private final AttackType attackType = AttackType.BLUNT;

    //  CONSTRUCTOR
    Club(String name, int result, int mana, double accuracy, boolean isAffectAll, int levelOfAccess) {
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
    public boolean isStrength() {
        return true;
    }

    @Override
    public boolean isMagic() {
        return false;
    }

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
