package purgatory.main;
import purgatory.battle.BattleController;
import purgatory.battle.BattleModel;
import purgatory.battle.BattleView;
import purgatory.entity.Entity;
import purgatory.entity.CharacterCreation;
import purgatory.move.Move;
import purgatory.stats.StatUtil;
import purgatory.terraces.Terrace;
import purgatory.weapon.Axe;
import purgatory.weapon.Tome;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
 * Goal (Updated):
 * Continue to work until January, if still not done, that's okay.
 * Just keep adding on, and hopefully be able to showcase this AT LATEST next year's fall career fair.
 *
 * @author Shannon Thornton
 * @version 1.0
 * @since May 19, 2020
 */
public class Game {
	public static void main(String[] args) {
		List<Entity> fighters = new ArrayList<>();
		Entity hero = CharacterCreation.getHero();
		Random gen = new Random();
		fighters.add(hero);
		fighters.add(StatUtil.generateEnemy(hero, Terrace.GLUTTONY));
		//fighters.add(StatUtil.generateSuperEnemy(hero, Terrace.GLUTTONY));
		BattleModel model = new BattleModel(fighters);
		BattleView view = new BattleView();
		BattleController control = new BattleController(view, model);
		control.updateView(0);

	}
}