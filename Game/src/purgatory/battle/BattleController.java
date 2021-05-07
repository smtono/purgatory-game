package purgatory.battle;

import purgatory.entity.CharacterType;
import purgatory.move.Attack;
import purgatory.move.Move;
import purgatory.move.MoveType;
import purgatory.move.MoveUtil;
import purgatory.stats.BattleStats;
import purgatory.stats.StatUtil;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
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
     * @return An int which will be used to keep tack of iterations
     */
    public int updateView(int currTurn) {
        // PREPARING GUI
        BattleStats hero = StatUtil.getHeroFromList(model.getFighters()); // get the hero from the fighter list for easier access
        prepareViewForUnit(hero);
        prepareBattleText(currTurn);
        if (currTurn == 0) {
            prepareBattle();
        } else {
            appendOrder();
        }

        // DOING ACTION
        for (BattleStats currUnit : model.getFighters()) {
            MouseAdapter mouseAdapter = null;
            view.enableMoveSet(false);

            switch (currUnit.getEntityType().getCharacterType()) { // find who is the current fighter
                case HERO:
                case PARTY:
                    view.enableMoveSet(true);
                    mouseAdapter = createListener(currUnit);
                    view.getMoveSet().addMouseListener(mouseAdapter);
                    break;
                case ENEMY:
                case BOSS:
                    view.enableMoveSet(false);
                    break;
            }

            // clear battle text field for the new turn
            view.clearBattleText();
        }

        currTurn++;
        return currTurn;
    }

    /**
     * Either damages a chosen enemy or heals or does a support skill on a party member or self.
     * Returns the stats of all fighters to update the GUI.
     *
     * @param currUnit: The current unit fighting
     * @param moveSelected: The String value of the move selected by the user
     * @return A new list with the update stats of everyone in battle
     */
    private List<BattleStats> doHeroAction(BattleStats currUnit, String moveSelected) {
        List<BattleStats> newStats = new ArrayList<>();
        Move heroMove = MoveUtil.getUnitMoveFromList(currUnit, moveSelected);
        List<BattleStats> enemies = StatUtil.getStatsOfTypeFromList(model.getFighters(), CharacterType.ENEMY);
        List<BattleStats> party = StatUtil.getStatsOfTypeFromList(model.getFighters(), CharacterType.PARTY);

        switch (heroMove.getMoveType()) {
            case ATTACK:
                return heroAttack(currUnit, enemies, (Attack) heroMove);
            case HEAL:
                BattleStats partyChosen = party.get(chooseTarget(party));
                break;
            case SUPPORT:
                break;
        }
        return newStats;
    }

    // TODO: finish this method
    private List<BattleStats> doEnemyAction(BattleStats currUnit) {
        List<BattleStats> newStats = new ArrayList<>();
        Random gen = new Random();

        // Determine if it will be an attack or support move

        return newStats;
    }

    /**
     * Prompts user to choose from the list of potential targets for the move in battle
     *
     * @return The index of the enemy chosen
     */
    private int chooseTarget(List<BattleStats> targets) {
        return JOptionPane.showOptionDialog(
                null,
                "Choose a target!",
                "",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                targets.toArray(),
                null);
    }

    /**
     * Prepares the view for the first turn by telling the user they encountered
     * an enemy and displaying starting enemy stats
     */
    public void prepareBattle() {
        view.appendBattleText("A team of wild demons appeared!\n\n");
        appendEnemyStats();
        // prompts hero that they have encountered and enemy, and gives a brief tutorial on how to play.
        JOptionPane.showMessageDialog(null, "You have just entered a battle!\n"
                + "Read your enemy's stats, and choose the move that would best counter it!\n"
                + "Different enemies have different weaknesses!", "Enemy Appeared!", JOptionPane.INFORMATION_MESSAGE);

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
        view.enableMoveSet(false);
    }

    /**
     * Prepares the move set and name card for the current hero or
     * party member attacking.
     *
     * @param currUnit The current entity attacking.
     */
    private void prepareViewForUnit(BattleStats currUnit) {
        List<String> moves = MoveUtil.getHeroMoveSetByName(currUnit.getMoveSet());
        view.setMoves(moves.toArray(String[]::new));
        view.setCurrentHeroName(currUnit.getFighter());
    }

    /**
     * Sets up a MouseAdapter object to listen to the user input for a JList and respond
     * based on the move chosen
     *
     * @param currHero: The entity object currently in control of the move set
     * @return A MouseAdapter to pass into a JList listener
     */
    private MouseAdapter createListener(BattleStats currHero) {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                @SuppressWarnings("unchecked")
                JList<String> source = (JList<String>) e.getSource(); // gets which move the user picked

                if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2) { // detects double-click
                    int index = source.locationToIndex(e.getPoint()); // gets index in JList
                    if (index >= 0) {
                        // battle logic from here out
                        String moveSelected = source.getModel().getElementAt(index); // gets string value at index
                        model.setFighters(doHeroAction(currHero, moveSelected)); // damages enemy
                        // update enemy stats for changes
                        view.clearStatsText();
                        appendEnemyStats();
                    }
                }
            }
        };
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
            builder.append(enemy.getInfo());
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

    /** Outputs the damage outputs for an AOE attack */
    private void appendDamageOutputs(BattleStats currUnit, List<BattleStats> targets, List<DamageOutput> damageOutputs) {
        for(int i = 0; i <= targets.size(); i++) { // check for critical hits/output damage amounts
            if (damageOutputs.get(i).getCritical()) {
                view.appendBattleText("\nCritical hit!");
            }
            appendAttack(currUnit.getFighter(), targets.get(i).getFighter(), damageOutputs.get(i).getDamage()); // say who was attacked and for how much
            targets.get(i).setCurrHealth(targets.get(i).getCurrHealth() - damageOutputs.get(i).getDamage()); // set new health
        }
    }

    /**
     * Asks hero which enemy to attack, then does proper calculations
     * to attack the enemies chosen with the given move
     * Returns the stats of everyone
     *
     * @param currHero The current hero or party member attacking
     * @param enemies The list of all enemy fighters
     * @param heroMove The Attack move that the currHero chose
     * @return The stats of all enemies in battle after being damaged
     */
    private List<BattleStats> heroAttack(BattleStats currHero, List<BattleStats> enemies, Attack heroMove) {
        if (heroMove.isAffectAll()) { // check if the move is an AOE attack
            List<DamageOutput> damageOutputs = model.damageAllEnemies(currHero, enemies, heroMove);
            appendDamageOutputs(currHero, enemies, damageOutputs);
        }
        else { // the attack is not AOE
            BattleStats enemyChosen = enemies.get(chooseTarget(enemies)); // get the enemy chosen
            DamageOutput values = model.damageEnemy(currHero, enemyChosen, heroMove);
            if (values.getCritical()) { // check for critical hit
                view.appendBattleText("\nCritical hit!");
            }
            // output damage
            appendAttack(currHero.getFighter(), enemyChosen.getFighter(), values.getDamage());
            enemyChosen.setCurrHealth(enemyChosen.getCurrHealth() - values.getDamage());
        }
        return enemies; // enemy stats
    }

    /**
     * Determines a random move from the enemy's move set to use
     * Determines which hero to attack if there are multiple
     * Then calculates damage based on stats of current enemy and hero
     * Returns the stats of the hero attacked
     *
     * @param currEnemy The current enemy attacking
     * @return The stats of the hero after the damage is done
     */
    private List<BattleStats> enemyAttack(BattleStats currEnemy, List<Move> enemyMoves) {
        Random gen = new Random();

        // Get all possible targets
        List<BattleStats> possibleTargets = new ArrayList<>();
        possibleTargets.addAll(StatUtil.getStatsOfTypeFromList(model.getFighters(), CharacterType.HERO));
        possibleTargets.addAll(StatUtil.getStatsOfTypeFromList(model.getFighters(), CharacterType.PARTY));

        // Determine move to use
        List<Move> enemyAttacks = MoveUtil.getMovesByMoveType(MoveType.ATTACK, enemyMoves); // get just attacks
        Attack enemyMove = (Attack) MoveUtil.getRandomMove(enemyAttacks);

        if (enemyMove.isAffectAll()) { // if it is AOE we go to a different method
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
        return possibleTargets;
    }

    /**
     * Prints out a death script, takes current death count and adds it need to keep up with that variable.
     * returns amount of time hero has died
     *
     * @param playerDeaths: The current amount of times the user has died
     * @return The current amount of player deaths
     */
    public int die(int playerDeaths) {
        JOptionPane.showMessageDialog
                (null,
                        "\nHero! You have died.",
                        "You have died!",
                        JOptionPane.INFORMATION_MESSAGE);
        return playerDeaths + 1;
    }
}