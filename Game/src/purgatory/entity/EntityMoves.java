package purgatory.entity;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    critical can be calculated by taking whatever percentage it is after the above calculations and adding that percent
    of damage on top of the base damage.

    Attributes of a move:
    name,
    base damage,
    mana usage
    accuracy,
    magic or strength
 */
public enum EntityMoves {
    // TODO: implement support moves (it may have to be separate)
    // sword
    LUNGE("Lunge", 10, 0, 0.5, false, AttackType.STRENGTH, WeaponType.SWORD, 1),
    SLASH("Slash", 20, 0, 0.5, false, AttackType.STRENGTH, WeaponType.SWORD, 1),
    SLICE("Slice", 27, 0, 0.55, false, AttackType.STRENGTH, WeaponType.SWORD, 2),
    RIPOSTE("Riposte", 35, 10, 0.6, true, AttackType.STRENGTH, WeaponType.SWORD, 5),
    // club
    BLUDGEON("Bludgeon", 30, 0, 0.4, false, AttackType.STRENGTH, WeaponType.CLUB, 1),
    CLOBBER("Clobber", 35, 0, 0.4, false, AttackType.STRENGTH, WeaponType.CLUB, 1),
    BATTER("Batter", 45, 0, 0.3, false, AttackType.STRENGTH, WeaponType.CLUB, 5),
    // axe
    // bow and arrow
    // wand
    FROSTBITE("Frostbite", 10, 2, 0.7, false, AttackType.MAGIC, WeaponType.WAND, 1),
    LUMINESCENCE("Luminescence", 15, 8, 0.7, true, AttackType.MAGIC, WeaponType.WAND, 1),
    FIRESTORM("Firestorm", 25, 10, 0.7, true, AttackType.MAGIC, WeaponType.WAND, 1),
    // staff
    // TODO: change healing spells to be proportional to hero's current level?
    MEND("Mend", 10, 2, 0.7, false, AttackType.HOLY, WeaponType.STAFF, 1),
    REMEDIAL("Remedial", 25, 5, 0.75, false, AttackType.HOLY, WeaponType.STAFF, 2),
    RECOVERY("Recovery", 45, 10, 0.8, true, AttackType.HOLY, WeaponType.STAFF, 5);

    // variables for construction of move types
    public enum AttackType {MAGIC, STRENGTH, HOLY}
    // TODO: move this to a weapon class later? <- this is to implement a system for the weapons (like rock paper scissors as seen in fire emblem)
    public enum WeaponType {SWORD, CLUB, WAND, STAFF}
    private final String name;
    private final int result; // either damage or healing
    private final int mana;
    private final double accuracy;
    private final boolean isAffectAll;
    private final AttackType attackType;
    private final WeaponType weaponType;
    private final int levelOfAccess;
    //  CONSTRUCTOR
    EntityMoves(String name, int result, int mana, double accuracy, boolean isAffectAll, AttackType attackType, WeaponType weaponType, int levelOfAccess) {
        this.name = name;
        this.result = result;
        this.mana = mana;
        this.accuracy = accuracy;
        this.isAffectAll = isAffectAll;
        this.attackType = attackType;
        this.weaponType = weaponType;
        this.levelOfAccess = levelOfAccess;
    }
    //  ACCESSORS
    public String getName() { return name; }
    public int getResult() { return result; }
    public int getMana() { return mana; }
    public double getAccuracy() { return accuracy; }
    public AttackType getAttackType() { return attackType; }
    public WeaponType getWeaponType() { return weaponType; }
    public int getLevelOfAccess() { return levelOfAccess; }

    // METHODS
    /*
        upgradeMove
        this will take in a move to be upgraded
        it will be upgraded based on the hero's level
        this can either be done when the hero levels up, or it can be done through the shop?

        Some ideas:
        Obviously, an increase in damage/healing
        other stats also (but maybe not as much)
        changing the name?

        @param move to upgrade
     */
    public void upgradeMove(EntityMoves move) {

    }

    //  UTIL
    /*
        getAllMoves List
        Returns every possible move that exists.

        @return list of every move that exists
     */
    public List<EntityMoves> getAllMoves() {
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
    public @NotNull
    List<EntityMoves> getWeaponMoves(WeaponType weaponType) {
        List<EntityMoves> moves = new ArrayList<>();
        for (EntityMoves move : EntityMoves.values()) {
            if (move.getWeaponType() == weaponType) {
                moves.add(move);
            }
        }
        return moves;
    }
    // TODO rename to something better
    /*
        getAccessibleMoves List
        gives a list of possible moves available to the hero based on their level

        @return a list of possible moves available to the hero based on level
     */
    public List<EntityMoves> getAccessibleMoves(Entity entity) {
        List<EntityMoves> moves = new ArrayList<>();
        for (EntityMoves move : EntityMoves.values()) {
            if (move.getLevelOfAccess() <= entity.getLevel()) {
                moves.add(move);
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
                '}';
    }
}
