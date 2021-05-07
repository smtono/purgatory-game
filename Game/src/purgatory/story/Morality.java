package purgatory.story;

/**
 *
 */
public class Morality {
    public static int setMorality(int morality, Choice choice) {
        switch (choice) {
            case GOOD:
                return morality += 1;
            case EVIL:
                return  morality -= 1;
            default: // "neutral" option
                return morality;
        }
    }

}
