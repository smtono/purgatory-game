package purgatory.main;
import purgatory.battle.mvc.BattleController;
import purgatory.battle.mvc.BattleModel;
import purgatory.battle.mvc.BattleView;
import purgatory.entity.Entity;
import purgatory.dialogue.dialog.CharacterCreationDialog;
import purgatory.entity.type.HeroType;
import purgatory.stats.StatUtil;
import purgatory.dialogue.story.Morality;
import purgatory.terraces.Terrace;
import purgatory.weapon.magic.Staff;
import purgatory.weapon.magic.Wand;
import purgatory.weapon.strength.Bow;

import java.util.Arrays;
import java.util.List;

/**
 * Premise:
 * I want to make a text RPG that showcases skills I’ve learned up until this point in my career as a CS student.
 *
 * In its most basic form, I want to be able to have a combat system that resembles that of a JRPG. 
 * Turn based, with different weapon choices that counteract others that the enemy has.
 * Almost like a Fire Emblem or Persona-esque game.
 * I will slowly be adding more features after this main feature has been added.
 * I want the story to be based off my comic series, and is what has inspired this whole project.
 *
 * @author Shannon Thornton
 * @version 1.0
 * @since May 19, 2020
 */
public class Game {
	public static void main(String[] args) {
		Morality morality = new Morality(0);

		// STORY

		// CHARACTER CREATION
		Entity hero = CharacterCreationDialog.getHero();

		// PARTY MEMBERS
		Entity rosalind = new Entity(
				"Rosalind",
				HeroType.CLERIC,
				300,
				50,
				10,
				0.6,
				0,
				0.1,
				0.05,
				Arrays.asList(Staff.LUX, Staff.LUMINESCENCE, Staff.MEND),
				3);
		Entity chase = new Entity(
				"Chase",
				HeroType.ARCHER,
				500,
				125,
				15,
				0.6,
				0.2,
				0,
				0.1,
				Arrays.asList(Bow.AIM, Bow.FIRE, Bow.ARROWSTORM),
				5);
		Entity dawn = new Entity(
				"Dawn",
				HeroType.MAGE,
				800,
				250,
				25,
				0.4,
				0,
				0.45,
				0.2,
				Arrays.asList(Wand.FROSTBITE, Wand.GUST, Wand.FIRESTORM),
				8);

		// STORY

		// TODO: make this game loop generic (to loop through every terrace)
		for(int i = 0; i < Terrace.GLUTTONY.getNumRooms(); i++) { // Go for as many levels
			List<Entity> fighters = StatUtil.generateEnemies(3, hero, Terrace.GLUTTONY); // generate enemies for the floor
			fighters.add(hero); // add the hero to the fighter list
			fighters.add(rosalind);

			// instantiate mvc
			BattleModel model = new BattleModel(fighters);
			BattleView view = new BattleView();
			BattleController control = new BattleController(view, model);

			boolean done = false;
			int currTurn = 1;

			control.battle(currTurn);

			// level up
		}

		// final terrace: kill everyone except rosalind and chase

	}
}