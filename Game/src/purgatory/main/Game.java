package purgatory.main;
import purgatory.battle.mvc.BattleController;
import purgatory.battle.mvc.BattleModel;
import purgatory.battle.mvc.BattleView;
import purgatory.entity.Entity;
import purgatory.dialogue.dialog.CharacterCreationDialog;
import purgatory.entity.type.BossType;
import purgatory.entity.type.HeroType;
import purgatory.inventory.Inventory;
import purgatory.stats.StatUtil;
import purgatory.dialogue.story.Morality;
import purgatory.terraces.Terrace;
import purgatory.weapon.magic.Staff;
import purgatory.weapon.magic.Wand;
import purgatory.weapon.strength.Bow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Premise:
 * I want to make a text RPG that showcases skills I�ve learned up until this point in my career as a CS student.
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
		Inventory inventory = new Inventory(new HashMap<>());

		// STORY

		// CHARACTER CREATION
		Entity hero = CharacterCreationDialog.getHero();

		// PARTY MEMBERS
		Entity rosalind = new Entity(
				"Rosalind",
				HeroType.CLERIC,
				400,
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
				700,
				125,
				15,
				0.6,
				0.2,
				0,
				0.1,
				Arrays.asList(Bow.AIM, Bow.FIRE, Bow.PIERCE),
				5);
		Entity dawn = new Entity(
				"Dawn",
				HeroType.MAGE,
				1000,
				250,
				25,
				0.4,
				0,
				0.45,
				0.2,
				Arrays.asList(Wand.CRYSTALIZE, Wand.GALESTORM, Wand.BLAZE),
				8);

		// STORY
		inventory.addItem("bandage", 10);
		inventory.addItem("energy drink", 10);

		// BATTLE
		int currTerrace = 0;
		List<Terrace> terraces = Arrays.asList(Terrace.values());
		List<Entity> fighters = new ArrayList<>();

		boolean done = false;

		while (!done) {
			int currRoom = 1;
			while (currRoom < terraces.get(currTerrace).getNumRooms()) { // Go for as many levels

				if (currRoom == terraces.get(currTerrace).getNumRooms()) {
					switch (terraces.get(currTerrace)) {
						case GLUTTONY:
							fighters.add(StatUtil.generateBoss(hero, BossType.GLUTTONY));
							break;
						case SLOTH:
							fighters.add(StatUtil.generateBoss(hero, BossType.SLOTH));
							break;
						case AVARICE:
							fighters.add(StatUtil.generateBoss(hero, BossType.AVARICE));
							break;
						case PRIDE:
							fighters.add(StatUtil.generateBoss(hero, BossType.PRIDE));
							break;
						case ENVY:
							fighters.add(StatUtil.generateBoss(hero, BossType.ENVY));
							break;
						case LUST:
							fighters.add(StatUtil.generateBoss(hero, BossType.LUST));
							break;
						case WRATH:
							fighters.add(StatUtil.generateBoss(hero, BossType.WRATH));
							break;
					}
				}


				switch (terraces.get(currTerrace)) {
					case GLUTTONY:
					case SLOTH:
						fighters = StatUtil.generateEnemies(3, hero, terraces.get(currTerrace)); // generate enemies for the floor
						fighters.add(hero); // add the hero to the fighter list
						fighters.add(rosalind);
						break;
					case AVARICE:
					case PRIDE:
					case ENVY:
						fighters = StatUtil.generateEnemies(3, hero, terraces.get(currTerrace)); // generate enemies for the floor
						fighters.add(hero); // add the hero to the fighter list
						fighters.add(rosalind);
						fighters.add(chase);
						break;
					case LUST:
					case WRATH:
						fighters = StatUtil.generateEnemies(3, hero, terraces.get(currTerrace)); // generate enemies for the floor
						fighters.add(hero); // add the hero to the fighter list
						fighters.add(rosalind);
						fighters.add(chase);
						fighters.add(dawn);
						break;
				}

				// instantiate mvc
				BattleModel model = new BattleModel(fighters, inventory);
				BattleView view = new BattleView();
				BattleController control = new BattleController(view, model);

				control.battle(1, currRoom, terraces.get(currTerrace));

				if (currRoom == terraces.get(currTerrace).getNumRooms()) {
					currTerrace++;
				}

				view.dispose();
				currRoom++;
			}
		}

		// level up
		switch (terraces.get(currTerrace)) {
			case GLUTTONY:
			case SLOTH:
				hero.levelUp();
				rosalind.levelUp();
				break;
			case AVARICE:
			case PRIDE:
			case ENVY:
				hero.levelUp();
				rosalind.levelUp();
				chase.levelUp();
				break;
			case LUST:
			case WRATH:
				hero.levelUp();
				rosalind.levelUp();
				chase.levelUp();
				dawn.levelUp();
				break;
		}

		// give items
		// final terrace: kill everyone except rosalind and chase
	}
}