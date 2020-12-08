package purgatory.weapon;

public enum StaffMoves implements Move {
    // NORMAL STAFF

    // ATTACKS
    LUX("Lux", 10, 5, 0.7, true, 1, MoveType.ATTACK, AttackType.HOLY),
    LUMINESCENCE("Luminescence", 15, 8, 0.7, true, 1, MoveType.ATTACK, AttackType.HOLY),

    // HEALS
    MEND("Mend", 10, 2, 0.7, false, 1, MoveType.HEAL, AttackType.HOLY),
    REMEDIAL("Remedial", 25, 5, 0.75, false, 2, MoveType.HEAL, AttackType.HOLY),
    RECOVERY("Recovery", 45, 10, 0.8, true, 5, MoveType.HEAL, AttackType.HOLY);

    // SCEPTER

    // ATTRIBUTES
    private final String name;
    private final int result; // either damage or healing
    private final int mana;
    private final double accuracy;
    private final boolean isAffectAll;
    private final int levelOfAccess;
    private final MoveType moveType;
    private final AttackType attackType;

    //  CONSTRUCTOR
    StaffMoves(String name, int result, int mana, double accuracy, boolean isAffectAll, int levelOfAccess, MoveType moveType, AttackType attackType) {
        this.name = name;
        this.result = result;
        this.mana = mana;
        this.accuracy = accuracy;
        this.isAffectAll = isAffectAll;
        this.levelOfAccess = levelOfAccess;
        this.moveType = moveType;
        this.attackType = attackType;
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
