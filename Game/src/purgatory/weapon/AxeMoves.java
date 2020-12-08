package purgatory.weapon;

public enum AxeMoves implements Move {
    ;
    // NORMAL AXE

    // GREAT AXE

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
    AxeMoves(String name, int result, int mana, double accuracy, boolean isAffectAll, int levelOfAccess) {
        this.name = name;
        this.result = result;
        this.mana = mana;
        this.accuracy = accuracy;
        this.isAffectAll = isAffectAll;
        this.levelOfAccess = levelOfAccess;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getResult() {
        return 0;
    }

    @Override
    public int getMana() {
        return 0;
    }

    @Override
    public double getAccuracy() {
        return 0;
    }

    @Override
    public AttackType getAttackType() {
        return null;
    }

    @Override
    public int getLevelOfAccess() {
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
