package purgatory.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    Author: Shannon Thornton

    Purpose: To keep all possible moves that the hero can use (depending on their type) in one file, along
    with keeping track of base damage, whether it is AOE or not, etc.

    How accuracy can work:
    Take hero's current accuracy (in entity constructor)
    multiply that by 200,
    then take the weapon's accuracy and multiply by that
    take whatever percent over 100 it gets and use that for critical
    critical can be calculated by taking whatever percentage it is after the above calculations and adding that percent
    of damage on top of the base damage.

    Attributes of a move:
    name,
    base damage,
    mana usage
    accuracy,
    magic or strength
    TODO: implement support moves (it may have to be separate)
 */
public enum EntityMoves {
    // These look so terrible. Is there any way to simplify all of this?
    //  Some stuff to look into:
    //      a builder class?
    //      a helper class of some sort?
    // sword
    LUNGE("Lunge", 10, 0, 0.5, false, MoveType.ATTACK, EntityWeapons.AttackType.SLASH, EntityWeapons.SWORD, 1),
    SLASH("Slash", 20, 0, 0.5, false, MoveType.ATTACK, EntityWeapons.AttackType.SLASH, EntityWeapons.SWORD, 1),
    SLICE("Slice", 27, 0, 0.55, false, MoveType.ATTACK, EntityWeapons.AttackType.SLASH, EntityWeapons.SWORD, 2),
    RIPOSTE("Riposte", 35, 10, 0.6, true, MoveType.ATTACK, EntityWeapons.AttackType.SLASH, EntityWeapons.SWORD, 5),
    // UPGRADE great sword
    // club
    BLUDGEON("Bludgeon", 30, 0, 0.4, false, MoveType.ATTACK, EntityWeapons.AttackType.BLUNT, EntityWeapons.CLUB, 1),
    CLOBBER("Clobber", 35, 0, 0.4, false, MoveType.ATTACK, EntityWeapons.AttackType.BLUNT, EntityWeapons.CLUB, 1),
    BATTER("Batter", 45, 0, 0.3, false, MoveType.ATTACK, EntityWeapons.AttackType.BLUNT, EntityWeapons.CLUB, 5),
    // UPGRADE morning star
    // axe
    // UPGRADE great axe
    // bow and arrow
    // UPGRADE longbow
    // wand
    FROSTBITE("Frostbite", 10, 2, 0.7, false, MoveType.ATTACK, EntityWeapons.AttackType.ELEMENTAL, EntityWeapons.WAND, 1),
    LUMINESCENCE("Luminescence", 15, 8, 0.7, true, MoveType.ATTACK, EntityWeapons.AttackType.HOLY, EntityWeapons.WAND, 1),
    FIRESTORM("Firestorm", 25, 10, 0.7, true, MoveType.ATTACK, EntityWeapons.AttackType.ELEMENTAL, EntityWeapons.WAND, 1),
    LIGHTNING("Lightning", 40, 10, 0.7, false, MoveType.ATTACK, EntityWeapons.AttackType.ELEMENTAL, EntityWeapons.WAND, 2 ),
    // tome
    LEVIATHAN("Leviathan", 40, 15, 0.7, true, MoveType.ATTACK, EntityWeapons.AttackType.DARK, EntityWeapons.TOME, 1),
    ABADDON("Abaddon", 50, 17, 0.7, true, MoveType.ATTACK, EntityWeapons.AttackType.DARK, EntityWeapons.TOME, 1),
    CHERUBIM("Cherubim", 60, 20, 0.75, true, MoveType.ATTACK, EntityWeapons.AttackType.DARK, EntityWeapons.TOME, 2),
    NEPHILUM("Nephilum", 70, 22, 0.75, true, MoveType.ATTACK, EntityWeapons.AttackType.DARK, EntityWeapons.TOME, 5),
    BEHEMOTH("Behemoth", 100, 25, 0.8, true, MoveType.ATTACK, EntityWeapons.AttackType.DARK, EntityWeapons.TOME, 7),
    SERAPHIM("Seraphim", 150, 30, 0.9, true, MoveType.ATTACK, EntityWeapons.AttackType.DARK, EntityWeapons.TOME, 10),
    // staff
    // TODO: change healing spells to be proportional to hero's current level?
    MEND("Mend", 10, 2, 0.7, false, MoveType.HEAL, EntityWeapons.AttackType.HOLY, EntityWeapons.STAFF, 1),
    REMEDIAL("Remedial", 25, 5, 0.75, false, MoveType.HEAL, EntityWeapons.AttackType.HOLY, EntityWeapons.STAFF, 2),
    RECOVERY("Recovery", 45, 10, 0.8, true, MoveType.HEAL, EntityWeapons.AttackType.HOLY, EntityWeapons.STAFF, 5);
    // UPGRADE scepter

    public enum MoveType {ATTACK, HEAL, SUPPORT}
    private final String name;
    private final int result; // either damage or healing
    private final int mana;
    private final double accuracy;
    private final boolean isAffectAll;
    private final MoveType moveType;
    private final EntityWeapons.AttackType attackType;
    private final EntityWeapons weaponType;
    private final int levelOfAccess;
    //  CONSTRUCTOR
    EntityMoves(String name,
                int result,
                int mana,
                double accuracy,
                boolean isAffectAll,
                MoveType moveType,
                EntityWeapons.AttackType attackType,
                EntityWeapons weaponType,
                int levelOfAccess)
    {
        this.name = name;
        this.result = result;
        this.mana = mana;
        this.accuracy = accuracy;
        this.isAffectAll = isAffectAll;
        this.moveType = moveType;
        this.attackType = attackType;
        this.weaponType = weaponType;
        this.levelOfAccess = levelOfAccess;
    }
    //  ACCESSORS
    public String getName() { return name; }
    public int getResult() { return result; }
    public int getMana() { return mana; }
    public double getAccuracy() { return accuracy; }
    public EntityWeapons.AttackType getAttackType() { return attackType; }
    public EntityWeapons getWeaponType() { return weaponType; }
    public int getLevelOfAccess() { return levelOfAccess; }

    // METHODS
    /*
       getAllMoves List
       Returns every possible move that exists.

       @return list of every move that exists
    */
    public static List<EntityMoves> getAllMoves() {
        List<EntityMoves> allMoves = new ArrayList();
        Collections.addAll(allMoves, EntityMoves.values());
        return allMoves;
    }
    /*
       getWeaponMoves List
       receives weapon type,
       returns moves of that weapon type

       @param weaponType
       @return a list of moves using the weapon given in argument
    */
    public static List<EntityMoves> getWeaponMoves(EntityWeapons weaponType) {
        List<EntityMoves> moves = new ArrayList<>();
        for (EntityMoves move : EntityMoves.values()) {
            if (move.getWeaponType() == weaponType) {
                moves.add(move);
            }
        }
        return moves;
    }
    /*
       getAccessibleMoves List
       gives a list of possible moves available to the hero based on their level

       @return a list of possible moves available to the hero based on level
   */
    public static List<EntityMoves> getAccessibleMoves(Entity entity) {
        List<EntityMoves> moves = new ArrayList<>();
        for (EntityMoves move : EntityMoves.values()) {
            if (move.getLevelOfAccess() <= entity.getLevel()) {
                moves.add(move);
            }
            /*
                Explaining the following code down below
                we get the list of attack types the entity type can use and store it in a stream, which will allow us
                to use the anyMatch method, which basically uses a lambda to see if the elements in the list match with
                the element we are referring to after the '->'
                In this case, it is the current move we are on.
             */
            if (!(entity.getAttackTypes().stream().anyMatch(heroMoves -> heroMoves.equals(move.getAttackType())))) {
                moves.remove(move);
            }
        }
        return moves;
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
                ", moveType=" + weaponType +
                '}' +
                "\n";
    }
}