package purgatory.weapon;

public enum Sword {
    LUNGE("Lunge", 10, 0, 0.5, false, Move.MoveType.ATTACK, AttackType.SLASH, 1),
    SLASH("Slash", 20, 0, 0.5, false, Move.MoveType.ATTACK, AttackType.SLASH, 1),
    SLICE("Slice", 27, 0, 0.55, false, Move.MoveType.ATTACK, AttackType.SLASH, 2),
    RIPOSTE("Riposte", 35, 10, 0.6, true, Move.MoveType.ATTACK, AttackType.SLASH, 5)

    public enum MoveType {ATTACK, HEAL, SUPPORT}
    private final String name;
    private final int result; // either damage or healing
    private final int mana;
    private final double accuracy;
    private final boolean isAffectAll;
    private final Move.MoveType moveType;
    private final AttackType attackType;
    private final int levelOfAccess;

    //  CONSTRUCTOR
    Sword(String name,
         int result,
         int mana,
         double accuracy,
         boolean isAffectAll,
         Move.MoveType moveType,
         AttackType attackType,
         int levelOfAccess)
    {
        this.name = name;
        this.result = result;
        this.mana = mana;
        this.accuracy = accuracy;
        this.isAffectAll = isAffectAll;
        this.moveType = moveType;
        this.attackType = attackType;
        this.levelOfAccess = levelOfAccess;
    }
}
