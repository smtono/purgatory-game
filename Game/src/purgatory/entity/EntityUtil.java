package purgatory.entity;

import purgatory.entity.Entity;
import purgatory.entity.EntityType;
import purgatory.battle.Move;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EntityUtil {
    // CONSTRUCTOR
    public EntityUtil() { }

    // TODO rewrite because awkward
    // HERO - ENEMY - PARTY
    public static List<Entity> getHeroesFromSet(List<Entity> entities, EntityType entityType) {
        List<Entity> result = new ArrayList<>();
        entities.iterator().forEachRemaining(entity -> {
            if (entity.getEntityType().getCharacterType().equals(EntityType.CharacterType.HERO))
                result.add(entity);
        });
        return result;
    }
    public static List<Entity> getEnemiesFromSet(List<Entity> entities) {
        List<Entity> result = new ArrayList<>();
        entities.iterator().forEachRemaining(entity -> {
            if (entity.getEntityType().getCharacterType() == EntityType.CharacterType.ENEMY)
                result.add(entity);
        });
        return result;
    }

    /**
     getHeroes/Enemies
     creates a list of every hero.
     if the entity type returns true (or not) to isHero(), then it will be added to the list.
     @return a list of all heroes/enemies
     */
    public static List<EntityType> getHeroes() {
        List<EntityType> heroes = new ArrayList<>();
        for (EntityType entity : EntityType.values()) {
            if(entity.getCharacterType().equals(EntityType.CharacterType.HERO))
                heroes.add(entity);
        }
        return heroes;
    }
    public static List<EntityType> getEnemies() {
        List<EntityType> enemies = new ArrayList<>();
        for (EntityType entity : EntityType.values()) {
            if(entity.getCharacterType().equals(EntityType.CharacterType.ENEMY))
                enemies.add(entity);
        }
        return enemies;
    }
    /*
        Returns a list of moves depending on the enemy type
     */
    public static List<Move> getEnemyMoveSet(EntityType enemy) {
        List moves = new ArrayList();
        switch(enemy) {
            // normal enemies
            case GUARDIAN:
                moves = Arrays.asList();
                break;
            case MOON:
                moves = Arrays.asList();
                break;
            // boss enemies
            case GLUTTONY:
                moves = Arrays.asList();
                break;
            case SLOTH:
                moves = Arrays.asList();
            break;
            case AVARICE:
                moves = Arrays.asList();
                break;
            case PRIDE:
                moves = Arrays.asList();
                break;
            case ENVY:
                moves = Arrays.asList();
                break;
            case LUST:
                moves = Arrays.asList();
                break;
            case WRATH:
                moves = Arrays.asList();
                break;
        }
        return moves;
    }
}