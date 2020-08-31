package purgatory.util;

import purgatory.entity.Entity;
import purgatory.entity.EntityMoves;
import purgatory.entity.EntityType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EntityUtil {
    // CONSTRUCTOR
    public EntityUtil() { }

    // TODO rewrite because awkward
    // HERO - ENEMY - PARTY
    public static List<Entity> getHeroesFromSet(List<Entity> entities, EntityType entityType) {
        List<Entity> result = new ArrayList<>();
        entities.iterator().forEachRemaining(entity -> {
            if (entity.getEntityType().isHero())
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
}