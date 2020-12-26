package purgatory.move;

import purgatory.entity.Entity;

public enum Club implements Attack {
    // NORMAL CLUB
    BLUDGEON("Bludgeon", 30, 0, 0.4, false, 1),
    CLOBBER("Clobber", 35, 0, 0.4, false, 1),
    BATTER("Batter", 45, 0, 0.3, false, 5);

    // MORNING STAR

    // ATTRIBUTES
    private final String name;
    private final int result; // either damage or healing
    private final int mana;
    private final double accuracy;
    private final boolean isAffectAll;
    private final int levelOfAccess;
    private final MoveType moveType = MoveType.ATTACK;
    private final AttackType attackType = AttackType.BLUNT;

    //  CONSTRUCTOR
    Club(String name, int result, int mana, double accuracy, boolean isAffectAll, int levelOfAccess) {
        this.name = name;
        this.result = result;
        this.mana = mana;
        this.accuracy = accuracy;
        this.isAffectAll = isAffectAll;
        this.levelOfAccess = levelOfAccess;
    }

    // ACCESSORS
    public String getName() {
        return name;
    }

    public int getResult() {
        return result;
    }

    public int getMana() {
        return mana;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public boolean isAffectAll() {
        return isAffectAll;
    }

    public int getLevelOfAccess() {
        return levelOfAccess;
    }

    public MoveType getMoveType() {
        return moveType;
    }

    public AttackType getAttackType() {
        return attackType;
    }

    // IMPLEMENTED METHODS
    @Override
    public int attack(Entity hero) {
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
    public int useMana(int currMana) {
        return 0;
    }

    @Override
    public String toString() {
        return "HeroMoves{" +
                "name='" + name + '\'' +
                ", damage=" + result +
                ", mana=" + mana +
                ", accuracy=" + accuracy +
                ", attackAll=" + isAffectAll +
                ", attackType=" + attackType +
                '}' +
                "\n";
    }
}
