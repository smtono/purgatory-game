package purgatory.dialogue.story;

import javax.swing.*;

/**
 *
 */
public class Morality {
    // ATTRIBUTES
    private static int morality;

    // CONSTRUCTOR
    public Morality(int morality) {
        Morality.morality = morality;
    }

    // ACCESSOR/MUTATOR
    public int getMorality() { return morality; }

    /** Takes in a choice and adds morality to it depending on the choice type */
    public static void setMorality(ChoiceType choiceType) {
        switch (choiceType) {
            case GOOD:
                morality += 1;
                break;
            case EVIL:
                morality -= 1;
                break;
            case NEUTRAL:
            default: // nothing happens
                break;
        }
    }

    // UTILITY METHODS

    public static Choice makeDialogue(String dialogue, ChoiceSet choices) {
        // The choices will always be in the order: good, neutral, evil
       int choice = JOptionPane.showOptionDialog(
                null,
                dialogue,
                "",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                choices.getAllChoices().toArray(new Choice[0]),
                null
        );

       return choices.getAllChoices().get(choice);
    }

    public static void readFileFor(String storyPart, String storyPartNumber) {
        // regex
        // -Story part:
        // Story Part number:
    }

}
