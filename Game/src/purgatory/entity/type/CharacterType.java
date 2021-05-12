package purgatory.entity.type;

/**
 * CharacterType is an enum used to evaluate the type of unit being used.
 * <p>
 * Different types include
 * HERO: The user or player
 * PARTY: Units that travel with the hero also controlled by the user or player
 * ENEMY: Units that the hero fights
 * BOSS: Special enemy units that the hero fights
 */
public enum CharacterType {
    HERO, PARTY, ENEMY, BOSS
}
