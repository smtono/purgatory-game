package purgatory;

import purgatory.entity.Entity;
import purgatory.entity.EntityType;

import java.util.List;
import java.util.Random;

/*
    Author: Shannon Thornton

    Purpose: To keep all the global/most used variables in one place, as well as
    helper methods used in other classes.
 */
public class Reference {
    // Hero (Player)
    // This is the hero object that all files will be interacting with in order to use or modify the hero
    // whether this be stats, or just using to get stats from.
    public static Entity hero;

    // Names of enemies
    public final static String[] ENEMY_NAMES = {"boo", "simp", "incel"};

}
