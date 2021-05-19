package purgatory.dialogue.story;

/**
 * Choice is used to make dialogue options for StoryDialog
 */
public class Choice {
    // ATTRIBUTES
    private final ChoiceType choiceType;
    private final String dialogue;

    // CONSTRUCTOR
    public Choice(ChoiceType choiceType, String dialogue) {
        this.choiceType = choiceType;
        this.dialogue = dialogue;
    }

    // ACCESSORS
    public ChoiceType getChoiceType() { return choiceType; }
    public String getDialogue() { return dialogue; }
}
