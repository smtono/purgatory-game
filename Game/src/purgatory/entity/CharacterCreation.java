package purgatory.entity;

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
     * Prompts the user for the name they will give their hero. The name is "Robin" by default.
     *
     * @return A string of the chosen hero name.
     */
    private static String askName() {
        // TODO: setup for when the user selects "cancel"

        String name = "";
        int restart = 1;
        while (restart == 1) {
            name = JOptionPane.showInputDialog("What is your name?", "Robin");
            restart = JOptionPane.showConfirmDialog(null, "Ah, so your name is ".concat(name).concat("?"));
            if (restart == 1) {
                JOptionPane.showMessageDialog(null, "Oh, sorry, can you tell me again?");
            }
        }
        return name;
    }

    /**
     * Prompts user for the hero type they want to be
     */
    private static HeroType chooseType() {
        HeroType[] heroTypes = HeroType.values().clone();
        HeroType heroType = null;
        int restart = 1;

        while (restart == 1) {
            int type = JOptionPane.showOptionDialog(null,
                    "Choose hero type!",
                    "",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    heroTypes,
                    heroTypes[0]);
            heroType = heroTypes[type];
            restart = JOptionPane.showConfirmDialog(null, "Oh, so you're a ".concat(heroType.getTypeName().toLowerCase()).concat("?"));
            if (restart == 1) {
                JOptionPane.showMessageDialog(null, "Oh, sorry, can you tell me again?");
            }
        }
        return heroType;
    }

    /**
     * Returns the information of the given entity type.
     *
     * @param type: The EntityType associated with the unit.
     * @return the information of the given entity type.
     */
    public static String typeInfo(EntityType type) {
        return type.getTypeName() +
                "\n\n" +
                type.getDescription();
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
