package purgatory.dialogue.story;

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

}
