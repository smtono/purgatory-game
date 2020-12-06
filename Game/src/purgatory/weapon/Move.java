package purgatory.battle;

import purgatory.weapon.AttackType;

/**
 * Purpose: To keep all possible moves that the hero can use (depending on their type) in one file, along
 * with keeping track of base damage, whether it is AOE or not, etc.
 *
 * How accuracy can work:
 * Take hero's current accuracy (in entity constructor)
 * multiply that by 200,
 * then take the weapon's accuracy and multiply by that
 * take whatever percent over 100 it gets and use that for critical
 * critical can be calculated by taking whatever percentage it is after the above calculations and adding that percent
 * of damage on top of the base damage.
 *
 * Attributes of a move:
 * name,
 * base damage,
 * mana usage
 * accuracy,
 * magic or strength
 * TODO: implement support moves (it may have to be separate)
 */
public enum Move {
    // These look so terrible. Is there any way to simplify all of this?
    // sword
    LUNGE("Lunge", 10, 0, 0.5, false, MoveType.ATTACK, AttackType.SLASH, 1),
    SLASH("Slash", 20, 0, 0.5, false, MoveType.ATTACK, AttackType.SLASH, 1),
    SLICE("Slice", 27, 0, 0.55, false, MoveType.ATTACK, AttackType.SLASH, 2),
    RIPOSTE("Riposte", 35, 10, 0.6, true, MoveType.ATTACK, AttackType.SLASH, 5),
    // UPGRADE great sword
    // bow
    AIM("Aim", 10, 0, 0.4, false, MoveType.ATTACK, AttackType.SHOOT, 1),
    FIRE("Fire", 15, 0, 0.3, false, MoveType.ATTACK, AttackType.SHOOT, 1),
    ARROWSTORM("Arrowstorm", 25, 0, 0.4, false, MoveType.ATTACK, AttackType.SHOOT, 1),
    // club
    BLUDGEON("Bludgeon", 30, 0, 0.4, false, MoveType.ATTACK, AttackType.BLUNT, 1),
    CLOBBER("Clobber", 35, 0, 0.4, false, MoveType.ATTACK, AttackType.BLUNT, 1),
    BATTER("Batter", 45, 0, 0.3, false, MoveType.ATTACK, AttackType.BLUNT, 5),
    // UPGRADE morning star
    // axe
    // UPGRADE great axe
    // bow and arrow
    // UPGRADE longbow
    // wand
    FROSTBITE("Frostbite", 10, 2, 0.7, false, MoveType.ATTACK, AttackType.ELEMENTAL, 1),
    FIRESTORM("Firestorm", 25, 10, 0.7, true, MoveType.ATTACK, AttackType.ELEMENTAL, 1),
    GUST("Gust", 12, 3, 0.7, true, MoveType.ATTACK, AttackType.ELEMENTAL, 1),
    LIGHTNING("Lightning", 40, 10, 0.7, false, MoveType.ATTACK, AttackType.ELEMENTAL, 2 ),
    // tome
    ANGEL("Angel", 30, 10, 0.6, true, MoveType.ATTACK, AttackType.DARK, 1),
    LEVIATHAN("Leviathan", 40, 15, 0.7, true, MoveType.ATTACK, AttackType.DARK, 1),
    ABADDON("Abaddon", 50, 17, 0.7, true, MoveType.ATTACK, AttackType.DARK, 1),
    CHERUBIM("Cherubim", 60, 20, 0.75, true, MoveType.ATTACK, AttackType.DARK, 2),
    NEPHILUM("Nephilum", 70, 22, 0.75, true, MoveType.ATTACK, AttackType.DARK, 5),
    BEHEMOTH("Behemoth", 100, 25, 0.8, true, MoveType.ATTACK, AttackType.DARK, 7),
    SERAPHIM("Seraphim", 150, 30, 0.9, true, MoveType.ATTACK, AttackType.DARK, 9),
    LUCIFER("Lucifer", 250, 35, 0.9, true, MoveType.ATTACK, AttackType.DARK, 10),
    // staff
    // TODO: change healing spells to be proportional to hero's current level?
    LUX("Lux", 10, 5, 0.7, true, MoveType.ATTACK, AttackType.HOLY, 1),
    LUMINESCENCE("Luminescence", 15, 8, 0.7, true, MoveType.ATTACK, AttackType.HOLY, 1),
    MEND("Mend", 10, 2, 0.7, false, MoveType.HEAL, AttackType.HOLY, 1),
    REMEDIAL("Remedial", 25, 5, 0.75, false, MoveType.HEAL, AttackType.HOLY, 2),
    RECOVERY("Recovery", 45, 10, 0.8, true, MoveType.HEAL, AttackType.HOLY, 5);
    // UPGRADE scepter

    public enum MoveType {ATTACK, HEAL, SUPPORT}
    private final String name;
    private final int result; // either damage or healing
    private final int mana;
    private final double accuracy;
    private final boolean isAffectAll;
    private final MoveType moveType;
    private final AttackType attackType;
    private final int levelOfAccess;
    //  CONSTRUCTOR
    Move(String name,
         int result,
         int mana,
         double accuracy,
         boolean isAffectAll,
         MoveType moveType,
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
    //  ACCESSORS
    public String getName() { return name; }
    public int getResult() { return result; }
    public int getMana() { return mana; }
    public double getAccuracy() { return accuracy; }
    public AttackType getAttackType() { return attackType; }
    public int getLevelOfAccess() { return levelOfAccess; }
    
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