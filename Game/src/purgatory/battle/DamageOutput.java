package purgatory.battle;

/**
 * DamageOutput acts as a return value for the damage methods in BattleModel.java
 *
 * A defined Pair of type boolean (critical) and int (damage)
 */
public class DamageOutput {
    private final boolean critical;
    private final int damage;

    public DamageOutput(boolean critical, int damage) {
        this.critical = critical;
        this.damage = damage;
    }

    public boolean getCritical() { return critical; }
    public int getDamage() { return damage; }
}
