package purgatory.story;

import java.util.ArrayList;
import java.util.List;

/**
 * ChoiceSet is a set of 3 Choices (dialogue options) for a story question
 */
public class ChoiceSet {
    // ATTRIBUTES
    private final Choice good;
    private final Choice evil;
    private final Choice neutral;

    // CONSTRUCTOR
    public ChoiceSet(Choice good, Choice evil, Choice neutral) {
        this.good = good;
        this.evil = evil;
        this.neutral = neutral;
    }

    // ACCESSORS
    public Choice getGood() { return good; }
    public Choice getEvil() { return evil; }
    public Choice getNeutral() { return neutral; }

    public List<Choice> getAllChoices() {
        List<Choice> choices = new ArrayList<>();
        choices.add(good);
        choices.add(evil);
        choices.add(neutral);
        return choices;
    }

    public List<String> getAllDialogues() {
        List<String> dialogues = new ArrayList<>();
        dialogues.add(good.getDialogue());
        dialogues.add(evil.getDialogue());
        dialogues.add(neutral.getDialogue());
        return dialogues;
    }
}
