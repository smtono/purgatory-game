package purgatory.weapon;

public enum TomeMoves implements Move {
    ANGEL("Angel", 30, 10, 0.6, true, 1),
    LEVIATHAN("Leviathan", 40, 15, 0.7, true, 1),
    ABADDON("Abaddon", 50, 17, 0.7, true, 1),
    CHERUBIM("Cherubim", 60, 20, 0.75, true, 2),
    NEPHILUM("Nephilum", 70, 22, 0.75, true, 5),
    BEHEMOTH("Behemoth", 100, 25, 0.8, true, 7),
    SERAPHIM("Seraphim", 150, 30, 0.9, true, 9),
    LUCIFER("Lucifer", 250, 35, 0.9, true, 10);

    // ATTRIBUTES
    private final String name;
    private final int result; // either damage or healing
    private final int mana;
    private final double accuracy;
    private final boolean isAffectAll;
    private final int levelOfAccess;
    private final MoveType moveType = MoveType.ATTACK;
    private final AttackType attackType = AttackType.DARK;

    //  CONSTRUCTOR
    TomeMoves(String name, int result, int mana, double accuracy, boolean isAffectAll, int levelOfAccess) {
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
