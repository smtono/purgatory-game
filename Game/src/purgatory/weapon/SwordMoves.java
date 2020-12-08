package purgatory.weapon;

/**
 *
 */
public enum SwordMoves implements Move {
    // NORMAL SWORD
    LUNGE("Lunge", 10, 0, 0.5, false, 1),
    SLASH("Slash", 20, 0, 0.5, false, 1),
    SLICE("Slice", 27, 0, 0.55, false, 2),
    RIPOSTE("Riposte", 35, 10, 0.6, true, 5);

    // GREAT SWORD

    // ATTRIBUTES
    private final String name;
    private final int result; // either damage or healing
    private final int mana;
    private final double accuracy;
    private final boolean isAffectAll;
    private final int levelOfAccess;
    private final MoveType moveType = MoveType.ATTACK;
    private final AttackType attackType = AttackType.SLASH;

    //  CONSTRUCTOR
    SwordMoves(String name, int result, int mana, double accuracy, boolean isAffectAll, int levelOfAccess) {
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
