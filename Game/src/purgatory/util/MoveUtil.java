package purgatory.util;

import purgatory.battle.Move;
import purgatory.entity.Entity;
import purgatory.entity.EntityType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MoveUtil {
    // METHODS
    /**
     getAllMoves List
     Returns every possible move that exists.

     @return list of every move that exists
     */
    public static List<Move> getAllMoves() {
        List<Move> allMoves = new ArrayList();
        Collections.addAll(allMoves, Move.values());
        return allMoves;
    }
    /**
     getAccessibleMoves List
     gives a list of possible moves available to the hero based on their level

     @return a list of possible moves available to the hero based on level
     */
    public static List<Move> getAccessibleMoves(Entity entity) {
        List<Move> moves = new ArrayList<>();
        for (Move move : Move.values()) {
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
            // TODO: check to see if this actually works lol
            if (entity.getEntityType().getWeaponTypes().stream().noneMatch(heroWeapon -> heroWeapon.getAttackTypes().equals(move.getAttackType()))) {
                moves.remove(move);
            }
        }
        return moves;
    }
    /**
     * Depending on the hero type, a different move set will be returned.
     * These moves are based off of a level 1 hero.
     * @return Returns a list of moves base on the hero type
     */
    public static List<Move> getHeroMoveSet(EntityType hero) {
        List<Move> moveSet = new ArrayList<>();
        switch (hero) {
            case WARRIOR:
                moveSet = Arrays.asList(Move.SLASH, Move.LUNGE, Move.BLUDGEON);
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
     * Depending on the enemy entity type, a different move set will be set.
     * The moves will be based on the level of the enemy.
        @return Returns a list of moves depending on the enemy type
        
        TODO: edit for levels
     */
    public static List<Move> getEnemyMoveSet(EntityType enemy, int enemyLevel) {
        List<Move> moveSet = new ArrayList<>();
        switch(enemy) {
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
