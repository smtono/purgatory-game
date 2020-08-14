package purgatory.entity;

/*
    Author: Shannon Thornton

    Purpose: To keep all possible moves that the hero can use (depending on their type) in one file, along
    with keeping track of base damage, whether it is AOE or not, etc.

    Move types will be dependent on their hero counterparts, for now I will work on Warrior and Mage moves.
    Warrior:
    can use "SWORD" moves or "CLUB" etc..
    Somehow come up with a way to keep certain moves associated to different weapons and levels.

    Mage:
    can use "WAND" or "STAFF" spells, wand will be hit one target, staff will be hit all

    How accuracy can work:
    Take hero's current accuracy (in entity constructor)
    multiply that by 200,
    then take the weapon's accuracy and multiply by that
    take whatever percent over 100 it gets and use that for critical
    critical can be calculated by taking whatever percentage it is after the above calulations and adding that percent
    of damage on top of the base damage.

    Attributes of a move:
    name,
    base damage,
    mana usage
    accuracy,
    magic or strength
 */
public enum EntityMoves {
    //  STRENGTH
    // sword
    LUNGE("Lunge", 10, 0, 0.5, false, AttackType.STRENGTH, MoveType.SWORD),
    SLASH("Slash", 20, 0, 0.5, false, AttackType.STRENGTH, MoveType.SWORD),
    RIPOSTE("Riposte", 35, 10, 0.6, true, AttackType.STRENGTH, MoveType.SWORD),
    // club
    // wand
    FROSTBITE("Frostbite", 10, 2, 0.7, false, AttackType.MAGIC, MoveType.WAND),
    LUMINESCENCE("Luminescence", 15, 8, 0.7, true, AttackType.MAGIC, MoveType.WAND),
    FIRESTORM("Firestorm", 25, 10, 0.7, true, AttackType.MAGIC, MoveType.WAND);

    //  MAGIC

    // variables for construction of move types
    private enum AttackType {MAGIC, STRENGTH}
    // TODO: move this to a weapon class later
    private enum MoveType {SWORD, CLUB, WAND, STAFF}
    private String name;
    private int damage;
    private int mana;
    private double accuracy;
    boolean attackAll;
    private AttackType attackType;
    private MoveType moveType;
    //  CONSTRUCTOR
    EntityMoves(String name, int damage, int mana, double accuracy, boolean attackAll, AttackType attackType, MoveType moveType) {
        this.name = name;
        this.damage = damage;
        this.mana = mana;
        this.accuracy = accuracy;
        this.attackAll = attackAll;
        this.attackType = attackType;
        this.moveType = moveType;
    }
    //  ACCESSORS
    public String getName() { return name; }
    public int getDamage() { return damage; }
    public int getMana() { return mana; }
    public double getAccuracy() { return accuracy; }
    public AttackType getAttackType() { return attackType; }
    public MoveType getMoveType() { return moveType; }

    @Override
    public String toString() {
        return "HeroMoves{" +
                "name='" + name + '\'' +
                ", damage=" + damage +
                ", mana=" + mana +
                ", accuracy=" + accuracy +
                ", attackAll=" + attackAll +
                ", attackType=" + attackType +
                ", moveType=" + moveType +
                '}';
    }
}
