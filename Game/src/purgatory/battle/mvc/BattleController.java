package purgatory.battle.mvc;

import purgatory.battle.stats.BattleStats;
import purgatory.battle.stats.DamageOutput;
import purgatory.dialogue.dialog.BattleDialog;
import purgatory.entity.type.CharacterType;
import purgatory.move.type.Attack;
import purgatory.move.Move;
import purgatory.move.type.MoveType;
import purgatory.move.MoveUtil;
import purgatory.stats.StatUtil;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * BattleController serves as the interface between BattleModel and BattleView.
 * <p>
 * It will take input from the user and display to the view based on moves chosen, buttons pressed
 * This will be done through an update() function which will print to the view relevant information.
 */
public class BattleController {
    private final BattleView view;
    private final BattleModel model;

    // CONSTRUCTOR
    public BattleController(BattleView view, BattleModel model) {
        this.view = view;
        this.model = model;
        model.setFighters(StatUtil.pushInitialFighterStats(model.getInitialFighters())); // pushing initial stats upon construction
    }

    // UPDATE METHOD

    /**
     * Refreshes text appearing on the view of the UI
     * <p>
     * Call this method recursively until one of the following exit conditions are reached:
     * The hero HP reaches 0 (die sequence)
     * the enemy HP reaches 0 (level up/ gain loot, etc.)
     * the hero runs away (return to main screen, implement this one last.)
     * returns an int which will be used to keep tack of iterations, since this method will be called recursively.
     *
     * @param currTurn: The current turn iteration
     */
    public void battle(int currTurn) {
        // PREPARING GUI
        BattleStats hero = StatUtil.getHeroFromList(model.getFighters()); // get the hero from the fighter list for easier access

        boolean done = false;

        while (!done) {
            prepareViewForUnit(hero);
            prepareBattleText(currTurn);
            //appendHeroStats();

            if (currTurn == 1) {
                prepareBattle();
            } else {
                appendEnemyStats();
                appendOrder();
            }

            // DOING ACTION
            // TODO: figure out how to approach the changing of size of the list
            List<BattleStats> fighters = model.getFighters();

            for (BattleStats currUnit : fighters) {

                if (currUnit.getCurrHealth() <= 0) {
                    break;
                }

                switch (currUnit.getEntityType().getCharacterType()) { // find who is the current fighter
                    case HERO:
                    case PARTY:
                        // Prompting user
                        JOptionPane.showMessageDialog(null, "It's " + currUnit.getFighter() + "'s turn!");
                        prepareViewForUnit(currUnit);
                        doAction(currUnit);

                        // wait
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    case ENEMY:
                    case BOSS:
                        if (model.getFighters().contains(currUnit)) {
                            // wait
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            doEnemyAction(currUnit);

                            // check if hero died
                            if (StatUtil.getHeroFromList(model.getFighters()).getCurrHealth() <= 0) { // dead hero
                                BattleDialog.die(hero.getFighter());
                                done = true;
                                // return to title / retry battle?
                            }
                        }
                        break;
                }
            }

            // check if one enemy is dead, prompt then skip over them
            StatUtil.getStatsOfTypeFromList(model.getFighters(), CharacterType.ENEMY).forEach(enemy -> {
                if (enemy.isDead()) {
                    JOptionPane.showMessageDialog(null, enemy.getFighter() + " is defeated!", "", JOptionPane.INFORMATION_MESSAGE);
                    model.getFighters().remove(enemy);
                    model.getFighters().removeAll(Collections.singleton(null));
                }
            });

            if (StatUtil.allEnemiesDead(StatUtil.getHealthForAll(StatUtil.getStatsOfTypeFromList(model.getFighters(), CharacterType.ENEMY)))) { // check if enemies are dead
                JOptionPane.showMessageDialog(null, "All enemies are defeated!", "", JOptionPane.INFORMATION_MESSAGE);
                done = true;
            }

            currTurn++;

            // wait
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // clear battle text field for the new turn
            view.clearBattleText();
        }

    }

    /**
     *
     * @param currUnit
     */
    private void doAction(BattleStats currUnit) {
        boolean fighting = false;

        while (!fighting) {
            String item = BattleDialog.askAction();
            switch (item) {
                case "fight!":
                    doHeroAction(currUnit, BattleDialog.askMove(currUnit));
                    fighting = true;
                    break;
                case "items":
                    break;
                case "analyze":
                    item = BattleDialog.analyze();
                    switch (item) {
                        case "myself":
                            BattleDialog.profile(currUnit);
                            break;
                        case "enemies":
                            BattleStats enemy = BattleDialog.askEnemy(StatUtil.getStatsOfTypeFromList(model.getFighters(), CharacterType.ENEMY));
                            BattleDialog.profile(enemy);
                            break;
                    }
                    break;
                case "run":
                    break;
            }
        }
    }

    /**
     * Either damages a chosen enemy or heals or does a support skill on a party member or self.
     * Returns the stats of all fighters to update the GUI.
     *
     * @param currUnit : The current unit fighting
     * @param moveSelected : The String value of the move selected by the user
     */
    private void doHeroAction(BattleStats currUnit, String moveSelected) {
        Move heroMove = MoveUtil.getUnitMoveFromList(currUnit, moveSelected);
        List<BattleStats> enemies = StatUtil.getStatsOfTypeFromList(model.getFighters(), CharacterType.ENEMY);
        List<BattleStats> allies = StatUtil.getStatsOfTypeFromList(model.getFighters(), CharacterType.HERO);

        switch (heroMove.getMoveType()) {
            case ATTACK:
                heroAttack(currUnit, enemies, (Attack) heroMove);
                return;
            case HEAL:
                BattleStats allyChosen = allies.get(BattleDialog.chooseTarget(allies));
                allyChosen.setCurrHealth(allyChosen.getCurrHealth() + heroMove.getResult());
                appendHeal(currUnit.getFighter(), allyChosen.getFighter(), heroMove.getResult());
                break;
            case SUPPORT:
                // check what kind of support move, HEAL, BUFF, or DEBUFF (another switch)
                
                break;
        }
    }

    private void doEnemyAction(BattleStats currUnit) {
        // TODO: add heal and support cases
        // check if enemies need healing, if enemy has healing move to use
        // randomly do support move

        enemyAttack(currUnit, currUnit.getMoveSet());
    }

    /**
     * Asks hero which enemy to attack, then does proper calculations
     * to attack the enemies chosen with the given move
     * Returns the stats of everyone
     *
     * @param currHero The current hero or party member attacking
     * @param enemies The list of all enemy fighters
     * @param heroMove The Attack move that the currHero chose
     */
    private void heroAttack(BattleStats currHero, List<BattleStats> enemies, Attack heroMove) {
        if (heroMove.isAffectAll()) { // check if the move is an AOE attack
            List<DamageOutput> damageOutputs = model.damageAllEnemies(currHero, enemies, heroMove);
            appendDamageOutputs(currHero, enemies, damageOutputs);
        }
        else { // the attack is not AOE
            BattleStats enemyChosen = enemies.get(BattleDialog.chooseTarget(enemies)); // get the enemy chosen
            DamageOutput values = model.damageEnemy(currHero, enemyChosen, heroMove);
            if (values.getCritical()) { // check for critical hit
                view.appendBattleText("\nCritical hit!");
            }
            // output damage
            appendAttack(currHero.getFighter(), enemyChosen.getFighter(), values.getDamage());
            enemyChosen.setCurrHealth(enemyChosen.getCurrHealth() - values.getDamage());
        }
    }

    /**
     * Determines a random move from the enemy's move set to use
     * Determines which hero to attack if there are multiple
     * Then calculates damage based on stats of current enemy and hero
     * Returns the stats of the hero attacked
     *
     * @param currEnemy The current enemy attacking
     */
    private void enemyAttack(BattleStats currEnemy, List<Move> enemyMoves) {
        Random gen = new Random();

        // Get all possible targets
        List<BattleStats> possibleTargets = new ArrayList<>();
        possibleTargets.addAll(StatUtil.getStatsOfTypeFromList(model.getFighters(), CharacterType.HERO));
        possibleTargets.addAll(StatUtil.getStatsOfTypeFromList(model.getFighters(), CharacterType.PARTY));

        // Determine move to use
        List<Move> enemyAttacks = MoveUtil.getMovesByMoveType(MoveType.ATTACK, enemyMoves); // get just attacks
        Attack enemyMove = (Attack) MoveUtil.getRandomMove(enemyAttacks);

        if (enemyMove.isAffectAll()) { // if it is AOE we must attack all heroes
            List<DamageOutput> damageOutputs = model.damageAllHeroes(currEnemy, possibleTargets, enemyMove);
            appendDamageOutputs(currEnemy, possibleTargets, damageOutputs);
        }
        else { // it is a single attack
            BattleStats target = possibleTargets.get(gen.nextInt(possibleTargets.size())); // Get a target from list of possible targets
            DamageOutput values = model.damageHero(currEnemy, target);
            if (values.getCritical()) { // check for critical hit
                view.appendBattleText("\nCritical hit!");
            }
            // output damage
            appendAttack(currEnemy.getFighter(), target.getFighter(), values.getDamage());
            target.setCurrHealth(target.getCurrHealth() - values.getDamage());
        }
    }

    /**
     * Prepares the view for the first turn by telling the user they encountered
     * an enemy and displaying starting enemy stats
     */
    public void prepareBattle() {
        view.appendBattleText("A team of wild demons appeared!\n\n");
        appendEnemyStats();
        BattleDialog.help();
        appendOrder();
    }

    /**
     * Prepares each text area in the BattleView GUI for each turn of battle
     * Clears the main text field that lists battle commands
     * Clears the stats field where enemies are listed
     * Appends the current turn to the main text field
     * Disables the user from choosing a move
     *
     * @param i: The current turn of battle
     */
    private void prepareBattleText(int i) {
        view.clearBattleText();
        view.clearStatsText();
        view.appendBattleText("Turn: " + i + "\n\n");
    }

    /**
     * Prepares the move set and name card for the current hero or
     * party member attacking.
     *
     * @param currUnit The current entity attacking.
     */
    private void prepareViewForUnit(BattleStats currUnit) {
        view.setCurrentHeroName(currUnit.getFighter());
    }

    /**
     * Determines the current order of fighters and appends it to the battleText JTextArea
     * in the BattleView GUI
     */
    private void appendOrder() {
        model.determineOrder();
        view.appendBattleText(model.getFighterOrder());
    }

    /** Gets the stats of all enemies in the fighter list and outputs it to the stats text field */
    private void appendEnemyStats() {
        StringBuilder builder = new StringBuilder();
        StatUtil.getStatsOfTypeFromList(model.getFighters(), CharacterType.ENEMY).iterator().forEachRemaining(enemy -> {
            builder.append(enemy.getShortInfo());
            builder.append("\n\n");
        });
        StatUtil.getStatsOfTypeFromList(model.getFighters(), CharacterType.HERO).iterator().forEachRemaining(hero -> {
            builder.append(hero.getShortInfo());
            builder.append("\n\n");
        });
        view.appendStatsText(builder.toString());
    }

    /**
     * Outputs which target was hit and for how much damage
     *
     * @param attacker The unit that is dealing damage
     * @param target The unit that is being hit
     * @param damage The amount of damage the attacker dealt
     */
    private void appendAttack(String attacker, String target, int damage) {
        if(damage == 0) {
            view.appendBattleText("\nAttack missed for " + target);
        }
        else {
            view.appendBattleText("\n" + attacker + " just hit " + target + " dealing " + damage + " damage!");
        }
    }

    private void appendHeal(String healer, String target, int health) {
        view.appendBattleText("\n" + healer + " just healed " + target + " for " + health + "!");
    }

    /** Outputs the damage outputs for an AOE attack */
    private void appendDamageOutputs(BattleStats currUnit, List<BattleStats> targets, List<DamageOutput> damageOutputs) {
        for(int i = 0; i <= targets.size() - 1; i++) { // check for critical hits/output damage amounts
            if (damageOutputs.get(i).getCritical()) {
                view.appendBattleText("\nCritical hit!");
            }
            appendAttack(currUnit.getFighter(), targets.get(i).getFighter(), damageOutputs.get(i).getDamage()); // say who was attacked and for how much
            targets.get(i).setCurrHealth(targets.get(i).getCurrHealth() - damageOutputs.get(i).getDamage()); // set new health
        }
    }
}