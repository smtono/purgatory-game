package purgatory.entity;
/*
    Author:

    Purpose:
 */
public class Entity {
    /***************************************************************************************************************************************************************************************/

    //							CLASS VARIABLES

    /***************************************************************************************************************************************************************************************/
    private EntityType entityType;
    private int health, maxHealth;
    private int xp, level;
    private int speed;
    /***************************************************************************************************************************************************************************************/

    //							CONSTRUCTORS

    /***************************************************************************************************************************************************************************************/
    public Entity(EntityType entityType) {
        this(entityType,100,100,0,1,10);
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

    //							ACCESSORS

    /***************************************************************************************************************************************************************************************/
    public EntityType getEntityType() {
        return entityType;
    }

    public void setEntityType(EntityType entityType) {
        this.entityType = entityType;
    }

    public int getHealth() {
        return health;
    }
/***************************************************************************************************************************************************************************************/

    //							MUTATORS

    /***************************************************************************************************************************************************************************************/
    public void setHealth(int health) {
        this.health = health;
    }
    public int getMaxHealth() {
        return maxHealth;
    }
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }
    public int getXp() {
        return xp;
    }
    public void setXp(int xp) {
        this.xp = xp;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public int getSpeed() {
        return speed;
    }
}
