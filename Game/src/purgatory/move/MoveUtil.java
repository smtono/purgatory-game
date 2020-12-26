package purgatory.move;

import purgatory.entity.Entity;
import purgatory.entity.EntityType;

import javax.swing.*;
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
        allMoves.addAll(Arrays.asList(SupportMoves.values().clone()));
        return allMoves;
    }

    /**
     * Returns a list of possible moves based on the weapon type passed.
     *
     * @param weaponType: The type of weapon used by the unit
     * @return A list of all the moves for the specific weapon
     */
    private static List<Move> getMovesByWeapon(WeaponType weaponType) {
        switch (weaponType) {
            case SWORD:
                return Arrays.asList(Sword.values().clone());
            case CLUB:
                return Arrays.asList(Club.values().clone());
            case AXE:
                return Arrays.asList(Axe.values().clone());
            case BOW:
                return Arrays.asList(Bow.values().clone());
            case WAND:
                return Arrays.asList(Wand.values().clone());
            case STAFF:
                return Arrays.asList(Staff.values().clone());
            case TOME:
                return Arrays.asList(Tome.values().clone());
            default:
                return null;
        }
    }

    /**
     * Returns a list of possible moves available to the hero based on their level
     *
     * @param hero: The entity object associated with the hero character
     * @return a list of possible moves available to the hero based on level
     */
    public static List<Move> getAccessibleMoves(Entity hero) {
        int heroLevel = hero.getLevel();
        List<WeaponType> heroWeaponTypes = hero.getEntityType().getWeaponTypes();
        List<Move> moves = new ArrayList<>();

        // loops through each weapon type hero can use
        heroWeaponTypes.forEach(weaponType -> {
            List<Move> availableMoves = Objects.requireNonNull(getMovesByWeapon(weaponType));

            // loops through each move available for that weapon type and checks against the hero's level
            // must be a move that is less than or equal to the player's level.
            availableMoves.forEach(move -> {
                if (move.getLevelOfAccess() <= heroLevel) {
                    moves.add(move);
                }
            });
        });

        return moves;
    }

    /**
     * Returns a list of moves dependent on the hero type of the hero Entity Object passed.
     * These moves are based off of a level 1 hero.
     *
     * @param hero: The EntityType of the hero Entity object.
     * @return Returns a list of moves based on the hero type
     */
    public static List<Move> getBaseHeroMoveSet(EntityType hero) {
        switch (hero) {
            case WARRIOR:
                return Arrays.asList(Sword.SLASH, Sword.LUNGE, Club.BLUDGEON);
            case MAGE:
                return Arrays.asList(Wand.FROSTBITE, Wand.GUST, Wand.FIRESTORM);
            case ARCHER:
                return Arrays.asList(Bow.AIM, Bow.FIRE, Bow.ARROWSTORM);
            case CLERIC:
                return Arrays.asList(Staff.LUX, Staff.LUMINESCENCE, Staff.MEND);
            case SCHOLAR:
                return Arrays.asList(Tome.ANGEL, Tome.LEVIATHAN, Tome.ABADDON);
            default:
                return null;
        }
    }

    /**
     * Returns the current move set of the hero Entity object passed as a list of strings.
     *
     * @param hero: An entity object associated with the hero (player)
     * @return A list of the string values of the Move enum constants.
     */
    public static List<String> getHeroMoveSetByName(Entity hero) {
        List<String> moves = new ArrayList<>();

        hero.getMoveSet().forEach(move -> {
            String moveName = move.getName();
            moves.add(moveName);
        });

        return moves;
    }


    /**
     * Depending on the enemy entity type, a different move set will be set.
     * The moves will be based on the level of the enemy.
     *
     * @param enemy:      The EntityType of the enemy Entity object.
     * @param enemyLevel: The current level of the enemy
     * @return Returns a list of moves based on the enemy type.
     */
    public static List<Move> getNewEnemyMoveSet(EntityType enemy, int enemyLevel) {
        List<Move> moveSet = new ArrayList<>();
        switch (enemy) {
            // normal enemies
            case GUARDIAN:
                moveSet = Arrays.asList();
                break;
            case MOON:
                moveSet = Arrays.asList();
                break;
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

    // PERTAINING TO SPECIFIC MOVES
    /**
     * Uses the accuracy stat passed that both the hero or party member has as well as the move used
     * to determine if the move hits or not, and returns true if it does hit, and false if it does not.
     *
     * @param unitAccuracy: The accuracy stat of the current unit passed.
     * @return A boolean true if the move hits and false if it does not.
     */
    public boolean doesHit(double unitAccuracy, Move move) {
        Random gen = new Random();

        // find the combined accuracy of the weapon and the hero's
        double combinedAccuracy = unitAccuracy * move.getAccuracy();

        if (combinedAccuracy > 0) {
            // find a range to pick a random number out of
            int upperBound = (int) (combinedAccuracy * 100);
            // find out if this random number is larger than 1/2
            return gen.nextInt(upperBound) > 0.5;
        }
        else {
            return false;
        }
    }
}