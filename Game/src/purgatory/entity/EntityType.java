package purgatory.entity;
/*
    Author:

    Purpose:
 */
public enum EntityType {
    HERO,
    ENEMY;


    public static EntityType getRandom(){
        return (Math.round(Math.random()) == 1) ? HERO : ENEMY;
    }
}