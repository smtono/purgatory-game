package purgatory.entity;

import purgatory.dialogue.Dialog;

import javax.swing.*;

/**
 * CharacterCreation allows the user to create the protagonist of the story with name and class.
 * <p>
 * These methods can be called to construct attributes associated with an Entity object.
 *
 * @see Entity
 */
public class CharacterCreation {

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
                Dialog.leave();
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
                    "Choose hero type!",
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
     * Constructs a new Entity object tailored to user input
     *
     * @return A new Entity object that represents the hero (user)
     */
    public static Entity getHero() {
        return new Entity(askName(), chooseType());
    }
}
