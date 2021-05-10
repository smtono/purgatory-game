package purgatory.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * EntityUtil is used to extrapolate data from Entity objects.
 */
public class EntityUtil {
    /**
     * Returns a list of entities gathered from the list passed that match the character type passed.
     *
     * @param entities:      A list of entities with various character types (hero, party, enemy, boss)
     * @param characterType: The certain character type (hero, party, enemy, boss) being looked for from the entity list.
     * @return A list with only the entities with the specified character type.
     */
    public static List<Entity> getEntitiesOfTypeFromList(List<Entity> entities, CharacterType characterType) {
        List<Entity> result = new ArrayList<>();
        entities.iterator().forEachRemaining(entity -> {
            if (entity.getEntityType().getCharacterType().equals(characterType))
                result.add(entity);
        });
        return result;
    }

    /**
     * Returns the hero entity from the list passed
     *
     * @param entities: A list of entities with different types
     * @return The hero entity from the list
     */
    public static Entity getHeroFromList(List<Entity> entities) {
        return getEntitiesOfTypeFromList(entities, CharacterType.HERO).get(0);
    }

    /**
     * Returns a list of entity types from the EntityType enum that match the character type passed.
     *
     * @param characterType: A type from the CharacterType enum either hero, enemy, or party
     * @return A list of all types associated with the type passed.
     */
    public static List<EntityType> getEntitiesOfType(CharacterType characterType) {
      switch (characterType) {
          case HERO:
          case PARTY:
              return Arrays.asList(HeroType.values().clone());
          case ENEMY:
              return Arrays.asList(EnemyType.values().clone());
          case BOSS:
              return Arrays.asList(BossType.values().clone());
          default:
              return null;
      }
    }
}