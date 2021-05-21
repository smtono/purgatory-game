package purgatory.dialogue.dialog;

import purgatory.dialogue.dialog.Dialog;
import purgatory.entity.Entity;
import purgatory.entity.type.HeroType;
import purgatory.move.Move;
import purgatory.move.MoveUtil;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * CharacterCreation allows the user to create the protagonist of the story with name and class.
 * <p>
 * These methods can be called to construct attributes associated with an Entity object.
 *
 * @see Entity
 */
public class CharacterCreationDialog {

    /**
     * Prompts the user for the name they will give their hero.
     * The name is "Robin" by default.
     *
     * @return A string of the chosen hero name.
     */
    private static String askName() {
        String name = "";
        int button = JOptionPane.NO_OPTION;

        while (button == JOptionPane.NO_OPTION) {
            name = JOptionPane.showInputDialog("What is your name?", "Augustus");
            if (name != null && !name.equals("")) { // checking if string is null
                // Confirm the name
                button = JOptionPane.showConfirmDialog(null, "Ah, so your name is ".concat(name).concat("?"));
                Dialog.checkButtons(button);
            }
            else { // User must have cancelled
                JOptionPane.showMessageDialog(null, "Please enter your name!");
            }
        }
        return name;
    }

    /** Prompts user for the hero type they want to be */
    private static HeroType chooseType() {
        HeroType[] heroTypes = HeroType.values().clone(); // Clone hero types for option list
        HeroType heroType = null; // Initialize heroType to none
        int button = JOptionPane.NO_OPTION;

        while (button == JOptionPane.NO_OPTION) {
            int type = JOptionPane.showOptionDialog(null,
                    "So, what do you do? What even are you?",
                    "",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    heroTypes,
                    heroTypes[0]);

            // Confirm user choice
            heroType = heroTypes[type];
            button = JOptionPane.showConfirmDialog(null, "Oh, so you're a ".concat(heroType.getTypeName().toLowerCase()).concat("?"));
            Dialog.checkButtons(button);
        }

        return heroType;
    }

    /**
     * Asks the user to choose a move for their starting move set
     *
     * @param accessibleMoves A list of the moves first accessible to the user
     * @param movesChosen A list of moves the user has already chosen
     * @return A move that the user chose
     */
    public static Move chooseMove(List<Move> accessibleMoves, List<Move> movesChosen) {
        Move move = null;
        List<String> availableMoves = new ArrayList<>();
        boolean isPresent = false;
        int button = JOptionPane.NO_OPTION;

        // getting just names for the JOptionPane buttons
        accessibleMoves.forEach(accessibleMove -> {
            availableMoves.add(accessibleMove.getName());
        });

        while (button == JOptionPane.NO_OPTION || button == JOptionPane.CANCEL_OPTION) {
            int choice = JOptionPane.showOptionDialog(null,
                    "What do you want to learn how to do?",
                    "",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    availableMoves.toArray(new String[0]),
                    null);

            // Confirm user choice
            move = accessibleMoves.get(choice);

            for (Move moveChosen : movesChosen) {
                if (moveChosen.getName().equals(move.getName())) {
                    isPresent = true;
                    JOptionPane.showMessageDialog(null, "You already chose that move! Try again.");
                    break;
                }
            }

            if (!isPresent) {
                button = JOptionPane.showConfirmDialog(null, move + "\n\nIs this okay?");
                Dialog.checkButtons(button);
            }
            // reset
            isPresent = false;
        }
        return move;
    }

    /**
     * Constructs a new Entity object tailored to user input
     *
     * @return A new Entity object that represents the hero (user)
     */
    public static Entity getHero() {
        List<Move> chosenMoves = new ArrayList<>();

        String name = askName();
        HeroType type = chooseType();

        for (int i = 0; i < 3; i++) {
            chosenMoves.add(chooseMove(MoveUtil.getAccessibleMoves(1, type.getWeaponTypes()), chosenMoves));
        }
        return new Entity(name, type, chosenMoves);
    }
}
