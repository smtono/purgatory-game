package purgatory.weapon;

public enum WandMoves implements Move {
    FROSTBITE("Frostbite", 10, 2, 0.7, false, 1),
    FIRESTORM("Firestorm", 25, 10, 0.7, true, 1),
    GUST("Gust", 12, 3, 0.7, true, 1),
    LIGHTNING("Lightning", 40, 10, 0.7, false, 2 );

    // ATTRIBUTES
    private final String name;
    private final int result; // either damage or healing
    private final int mana;
    private final double accuracy;
    private final boolean isAffectAll;
    private final int levelOfAccess;
    private final MoveType moveType = MoveType.ATTACK;
    private final AttackType attackType = AttackType.ELEMENTAL;

    //  CONSTRUCTOR
    WandMoves(String name, int result, int mana, double accuracy, boolean isAffectAll, int levelOfAccess) {
        this.name = name;
        this.result = result;
        this.mana = mana;
        this.accuracy = accuracy;
        this.isAffectAll = isAffectAll;
        this.levelOfAccess = levelOfAccess;
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
