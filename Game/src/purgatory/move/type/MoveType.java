package purgatory.move.type;

/**
 * MoveType is an enum used to differentiate different types of moves that can be done.
 *
 * ATTACK damages enemies
 * HEAL increases hp for hero or party members
 * SUPPORT is anything that has to deal with other stats not involving health, whether they be hero or party buffs
 * or enemy debuffs
 */
public enum MoveType {
    ATTACK, HEAL, SUPPORT, NONE
}
