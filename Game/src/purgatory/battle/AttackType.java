package purgatory.battle;
/*
    Author: Shannon Thornton

    This is to separate attack types from moves, this is because each attack type will have a weakness.
    These weaknesses will be expressed and implemented here.
 */
public enum AttackType {
    SLASH, PIERCE, SHOOT, BLUNT, ELEMENTAL, HOLY, DARK;

    /**
     * determineAdvantage
     * Compare the attack types of each entity in the battle, rank the types over who has advantage over another.
     * Give an advantage (WEAK!)
     */
    public void determineAdvantage() {
        // method variables

    }
}
