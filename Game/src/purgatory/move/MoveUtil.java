package purgatory.move;

import purgatory.entity.*;
import purgatory.battle.stats.BattleStats;
import purgatory.entity.type.BossType;
import purgatory.entity.type.EnemyType;
import purgatory.entity.type.HeroType;
import purgatory.move.type.MoveType;
import purgatory.move.type.SupportMove;
import purgatory.weapon.*;
import purgatory.weapon.enemy.Dagger;
import purgatory.weapon.enemy.Hammer;
import purgatory.weapon.enemy.Rapier;
import purgatory.weapon.enemy.Scythe;
import purgatory.weapon.magic.Staff;
import purgatory.weapon.magic.Tome;
import purgatory.weapon.magic.Wand;
import purgatory.weapon.strength.*;

import java.util.*;

/**
 * MoveUtil is used to extrapolate data from Move enum constants
 */
public class MoveUtil {
    // ACCESSING MOVES/SPECIFIC MOVE SETS

    /**
     * Returns a list of every possible move that exists.
     *
     * @return list of every move that exists
     */
    public static List<Move> getAllMoves() {
        // TODO: fix the repeat code here
        List<Move> allMoves = new ArrayList<>(Arrays.asList(Sword.values().clone()));
        allMoves.addAll(Arrays.asList(Club.values().clone()));
        allMoves.addAll(Arrays.asList(Axe.values().clone()));
        allMoves.addAll(Arrays.asList(Bow.values().clone()));
        allMoves.addAll(Arrays.asList(Wand.values().clone()));
        allMoves.addAll(Arrays.asList(Staff.values().clone()));
        allMoves.addAll(Arrays.asList(Tome.values().clone()));
        allMoves.addAll(Arrays.asList(SupportMove.values().clone()));
        return allMoves;
    }

    /**
     * Returns a list of possible moves based on the weapon type passed.
     *
     * @param weaponType: The type of weapon used by the unit
     * @return A list of all the moves for the specific weapon
     */
    private static List<Move> getAllMovesByWeapon(WeaponType weaponType) {
        switch (weaponType) {
            // STRENGTH
            case SWORD:
                return Arrays.asList(Sword.values().clone());
            case AXE:
                return Arrays.asList(Axe.values().clone());
            case LANCE:
                return Arrays.asList(Lance.values().clone());
            case BOW:
                return Arrays.asList(Bow.values().clone());
            case CLUB:
                return Arrays.asList(Club.values().clone());
            case RAPIER:
                return Arrays.asList(Rapier.values().clone());
            case DAGGER:
                return Arrays.asList(Dagger.values().clone());
            case SCYTHE:
                return Arrays.asList(Scythe.values().clone());
            case HAMMER:
                return Arrays.asList(Hammer.values().clone());
            case SPEAR:
                return Arrays.asList(Spear.values().clone());

            // MAGIC
            case WAND:
                return Arrays.asList(Wand.values().clone());
            case TOME:
                return Arrays.asList(Tome.values().clone());
            case STAFF:
                return Arrays.asList(Staff.values().clone());


            default:
                return null;
        }
    }

    /**
     * Returns a list of moves of the given move type
     *
     * @param moveType The MoveType of the moves wanted
     * @param moveSet The list to extract the move types from
     * @return A list of moves of the given move type
     */
    public static List<Move> getMovesByMoveType(MoveType moveType, List<Move> moveSet) {
        List<Move> moves = new ArrayList<>();
        moveSet.forEach(move -> {
            if (move.getMoveType() == moveType) {
                moves.add(move);
            }
        });
        return moves;
    }


    /**
     * Returns a list of possible moves available to the unit based on their level
     *
     * @param level The level of the unit
     * @param weaponTypes A list of weapon types for the hero or enemy type
     * @return a list of possible moves available to the unit based on level
     */
    public static List<Move> getAccessibleMoves(int level, List<WeaponType> weaponTypes) {
        List<Move> moves = new ArrayList<>();

        // loops through each weapon type unit can use
        weaponTypes.forEach(weaponType -> {
            List<Move> availableMoves = Objects.requireNonNull(getAllMovesByWeapon(weaponType));

            // loops through each move available for that weapon type and checks against the unit's level
            // must be a move that is less than or equal to the player's level.
            availableMoves.forEach(move -> {
                if (move.getLevelOfAccess() <= level) {
                    moves.add(move);
                }
            });
        });

        return moves;
    }

    /**
     * Depending on the enemy entity type, a different move set will be set.
     * The moves will be based on the level of the enemy.
     * 
     * the enemy should primarily attack
     * the enemy should use a support move only if it has it
     * the enemy should try to heal if it has a heal move, and if another enemy is hurt
     *
     * @param enemy The EntityType of the enemy Entity object.
     * @param enemyLevel The current level of the enemy
     * @return Returns a list of moves based on the enemy type.
     */
    public static List<Move> getNewEnemyMoveSet(EnemyType enemy, int enemyLevel) {
        List<Move> moveSet = new ArrayList<>();
        List<Move> accessibleMoves = getAccessibleMoves(enemyLevel, enemy.getWeaponTypes());

        // determine move based on weapon type?

        if (enemyLevel <= 2) { // only add attacks
           moveSet = MoveUtil.getMovesByMoveType(MoveType.ATTACK, accessibleMoves);
           // pick random 3
        }
        else if (enemyLevel <= 5) { // only attacks and heals
            moveSet.addAll(MoveUtil.getMovesByMoveType(MoveType.ATTACK, accessibleMoves));
            moveSet.addAll(MoveUtil.getMovesByMoveType(MoveType.HEAL, accessibleMoves));
        }
        else { // anything
            moveSet.addAll(accessibleMoves);
        }

        return moveSet;
    }

    public static List<Move> getNewBossMoveSet(BossType boss) {
        List<Move> moveSet = new ArrayList<>();
        switch(boss) {
            // boss enemies
            case GLUTTONY:
                moveSet = Arrays.asList();
                break;
            case SLOTH:
                moveSet = Arrays.asList();
                break;
            case AVARICE:
                moveSet = Arrays.asList();
                break;
            case PRIDE:
                moveSet = Arrays.asList();
                break;
            case ENVY:
                moveSet = Arrays.asList();
                break;
            case LUST:
                moveSet = Arrays.asList();
                break;
            case WRATH:
                moveSet = Arrays.asList();
                break;
        }
        return moveSet;
    }

    /**
     * Gets a random move from the move set passed
     *
     * @param moveSet: A list of moves
     * @return A random move from the enemy's move set
     */
    public static Move getRandomMove(List<Move> moveSet) {
        Random rng = new Random();
        return moveSet.get(rng.nextInt(moveSet.size()));
    }

    /**
     * Returns the current move set of the hero Entity object passed as a list of strings.
     *
     * @param moveSet: A list of moves for the current hero
     * @return A list of the string values of the Move enum constants.
     */
    public static List<String> getHeroMoveSetByName(List<Move> moveSet) {
        List<String> moves = new ArrayList<>();

        moveSet.forEach(move -> {
            String moveName = move.getName();
            moves.add(moveName);
        });

        return moves;
    }

    /**
     *
     * @param unit
     * @param moveToFind
     * @return
     */
    public static Move getUnitMoveFromList(BattleStats unit, String moveToFind) {
        List<Move> moveSet = unit.getMoveSet();
        List<String> moveSetStrings = new ArrayList<>();
        Move moveFound = null;

        moveSet.forEach(move -> { // push move names to list of strings
            moveSetStrings.add(move.getName());
        });

        for(int i = 0; i < moveSetStrings.size(); i++) { // compare strings against strings in move set
            if (moveSetStrings.get(i).equalsIgnoreCase(moveToFind)) {
                moveFound = moveSet.get(i);
            }
        }
        return moveFound;
    }
}
