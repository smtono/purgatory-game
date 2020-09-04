package purgatory.main;
import purgatory.battle.BattleLogic;
import purgatory.entity.Entity;
import purgatory.entity.EntityType;
import purgatory.gui.BattleGUI;

import java.util.ArrayList;
import java.util.List;
/*
 * Author: Shannon Thornton
 * 
 * Date Start: May 19, 2020
 * Date End Battle Sequence: 
 *
 * Premise:
 * I want to make a text RPG that showcases skills I�ve learned in my first year of CS. 
 * I want to use Java, for the sole purpose of being able to use a GUI and to freshen up on my skills using it.
 * The premise of the game is simple. 
 * In its most basic form, I want to be able to have a combat system that resembles that of a JRPG. 
 * Turn based, with different weapon choices that counteract others that the enemy has.
 * Almost like a Fire Emblem or Persona-esque game.
 * 
 * Goal:
 * Complete before first day of class (August 17)
 * Add onto it throughout my fall semester as a side project
 * Showcase in the spring career fair.
 */


/**
 * Purpose: To create a simple text-based RPG game with turn based combat like a traditional JRPG. 
 * This is to showcase skills I've learned in my first year of programming.
 * 
 * @author Shannon Thornton
 * @version 1.0
 * @since May 19, 2020
 */
public class Game {
	/*
	 * TODO:
	 * set up args so that can be used as a save system
	 * read up on serializable
	 * find a way to be able to save this game
	 */
	public static Entity hero = new Entity(EntityType.SCHOLAR);
	public static void main(String[] args) {

		List<Entity> enemies = new ArrayList<Entity>();
		enemies.add(new Entity(EntityType.MOON));
		enemies.add(new Entity(EntityType.MOON));
		enemies.add(new Entity(EntityType.MOON));
		enemies.add(new Entity(EntityType.WARRIOR));
		new BattleLogic(enemies);
	}
}