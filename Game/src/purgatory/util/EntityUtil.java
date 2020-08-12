package purgatory.util;

import purgatory.entity.Entity;

import java.util.ArrayList;
import java.util.List;

public class EntityUtil {
    public EntityUtil() { }
    public static List<Entity> getHeroesFromSet(List<Entity> entities) {
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
            if (!entity.getEntityType().isHero())
                result.add(entity);
        });
        return result;
    }
}
