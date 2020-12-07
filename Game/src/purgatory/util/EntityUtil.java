package purgatory.util;

import purgatory.entity.CharacterType;
import purgatory.entity.Entity;
import purgatory.entity.EntityType;

import java.util.ArrayList;
import java.util.List;

/**
 * EntityUtil is used to extrapolate data from Entity objects.
 */
public class EntityUtil {

    /**
     * Returns a list of entities that match the character type passed.
     *
     * @param entities:      A list of entities with various character types (hero, party, enemy, boss)
     * @param characterType: The certain character type (hero, party, enemy, boss) being looked for from the entity list.
     * @return A list with only the entities with the specified character type.
     */
    public static List<Entity> getEntitiesOfType(List<Entity> entities, CharacterType characterType) {
        List<Entity> result = new ArrayList<>();
        entities.iterator().forEachRemaining(entity -> {
            if (entity.getEntityType().getCharacterType().equals(characterType))
                result.add(entity);
        });
        return result;
    }

    /**
     * Returns a list of entity types that match the character type passed.
     *
     * @param characterType: A type from the CharacterType enum either hero, enemy, or party
     * @return A list of all types associated with the type passed.
     */
    public static List<EntityType> getEntityTypes(CharacterType characterType) {
        List<EntityType> types = new ArrayList<>();
        for (EntityType type : EntityType.values()) {
            if (type.getCharacterType().equals(characterType))
                types.add(type);
        }
        return types;
    }
}