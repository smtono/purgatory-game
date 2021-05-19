package purgatory.dialogue.story;

/**
 * ChoiceType is an enum for different types of dialogue choices in the story
 */
public enum ChoiceType {
    // ENUM CHOICES
    GOOD("Good", "You feel this is the right choice."),
    EVIL("Evil", "You feel that wasn't right..."),
    NEUTRAL("Neutral", "You feel that had no effect.");

    // ATTRIBUTES
    private final String choice;
    private final String description;

    // CONSTRUCTOR
    ChoiceType(String choice, String description) {
        this.choice = choice;
        this.description = description;
    }

    // ACCESSORS
    public String getChoice() { return choice; }
    public String getDescription() { return description; }
}
