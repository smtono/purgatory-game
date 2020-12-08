package purgatory.util;

import purgatory.weapon.Move;
import purgatory.entity.Entity;
import purgatory.entity.EntityType;
import purgatory.weapon.SwordMoves;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * MoveUtil is used to extrapolate data from Move enum constants
 */
public class MoveUtil {

    /**
     * Returns a list of every possible move that exists.
     *
     * @return list of every move that exists
     */
    public static List<Move> getAllMoves() {
        return Arrays.asList(Move.values().clone());
    }

    /**
     * Returns a list of possible moves available to the hero based on their level
     *
     * @param hero: An entity object associated with the hero (player)
     * @return a list of possible moves available to the hero based on level
     */
    public static List<Move> getAccessibleMoves(Entity hero) {
        List<Move> moves = new ArrayList<>();
        for (Move move : Move.values()) {
            if (move.getLevelOfAccess() <= hero.getLevel()) {
                moves.add(move);
            }

            // TODO: check to see if this actually works lol
            if (hero.getEntityType()
                    .getWeaponTypes()
                    .stream()
                    .noneMatch(heroWeapon ->
                            heroWeapon.getAttackTypes()
                                    .equals(move
                                            .getAttackType()
                                    )
                    )
            ) {
                moves.remove(move);
            }
        }
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
        List<Move> moveSet = new ArrayList<>();
        switch (hero) {
            case WARRIOR:
                moveSet = Arrays.asList(SwordMoves.SLASH, SwordMoves.LUNGE, Move.BLUDGEON);
                break;
            case MAGE:
                moveSet = Arrays.asList(Move.FROSTBITE, Move.GUST, Move.FIRESTORM);
                break;
            case ARCHER:
                moveSet = Arrays.asList(Move.AIM, Move.FIRE, Move.ARROWSTORM);
                break;
            case CLERIC:
                moveSet = Arrays.asList(Move.LUX, Move.LUMINESCENCE, Move.MEND);
                break;
            case SCHOLAR:
                moveSet = Arrays.asList(Move.ANGEL, Move.LEVIATHAN, Move.ABADDON);
                break;
        }
        return moveSet;
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
    public static List<Move> getEnemyMoveSet(EntityType enemy, int enemyLevel) {
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
}
