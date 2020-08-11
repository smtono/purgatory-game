package purgatory.entity;
/*
    Author: Shannon Thornton

    Purpose: To simplify the "abstraction" I used earlier. Since heroes and enemies are so similar, it would be simpler
    to store their data and similar methods into one file. Basically, more files =/= more complex.
 */
public class Entity {
    /***************************************************************************************************************************************************************************************/

    //							CLASS VARIABLES

    /***************************************************************************************************************************************************************************************/
    private EntityType entityType;
    // for battle
    private int health;
    final private int maxHealth;
    private int mana;
    private int speed;
    private int damage;
    private int strength, magic;
    private int xp, level;
    /***************************************************************************************************************************************************************************************/

    //							CONSTRUCTORS

    /***************************************************************************************************************************************************************************************/
    // TODO: differentiate enemy from hero constructor (their starting stats are different)
    public Entity(EntityType entityType) {
            this(entityType, 100, 100, 0, 1, 10);
    }
    // parametrized
    public Entity(EntityType entityType, int health, int maxHealth, int xp, int level, int speed) {
        this.entityType = entityType;
        this.health = health;
        this.maxHealth = maxHealth;
        this.xp = xp;
        this.level = level;
        this.speed = speed;
    }
    /***************************************************************************************************************************************************************************************/

    //							ACCESSORS / MUTATORS

    /***************************************************************************************************************************************************************************************/
    public EntityType getEntityType() { return entityType; }
    public void setEntityType(EntityType entityType) { this.entityType = entityType; }

    public int getHealth() { return health; }
    public void setHealth(int health) { this.health = health; }
    public int getMaxHealth() { return maxHealth; }

    public int getMana() { return mana; }
    public void setMana(int mana) { this.mana = mana; }

    public int getSpeed() { return speed; }
    public void setSpeed(int speed) { this.speed = speed; }

    public int getDamage() { return damage; }
    public void setDamage(int damage) { this.damage = damage; }

    public int getXp() { return xp; }
    public void setXp(int xp) { this.xp = xp; }

    public int getStrength() { return strength; }
    public void setStrength(int strength) { this.strength = strength; }

    public int getMagic() { return magic; }
    public void setMagic(int magic) { this.magic = magic; }

    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }
}
