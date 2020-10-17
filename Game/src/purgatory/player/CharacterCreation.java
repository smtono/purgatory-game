package purgatory.player;

import purgatory.Reference;
import purgatory.entity.Entity;
import purgatory.entity.EntityType;
import purgatory.util.EntityUtil;
import purgatory.main.GameLogic;

import javax.swing.*;

/*
    prompt for name
    possibly make a quiz
    otherwise, just let them pick what type of hero they want to be
 */
public class CharacterCreation {
    // hero name
    String name = "";
    EntityType heroType = null;

    public CharacterCreation() {
        askName();
        chooseType();
        Reference.hero = new Entity(name, heroType);
    }

    /**
     * Prompts the user for the name they will give their hero. The name is "Robin" by default.
     * TODO: setup for when the user selects "cancel"
     */
    public void askName() {
        int restart = 1;
        while (restart == 1) {
            name = JOptionPane.showInputDialog("What is your name?", "Robin");
           restart = JOptionPane.showConfirmDialog(null, "Ah, so your name is ".concat(name).concat("?"));
            if (restart == 1) {
                JOptionPane.showMessageDialog(null, "Oh, sorry, can you tell me again?");
            }
        }
    }

    /**
     * Prompts user for the hero type they want to be
     */
    public void chooseType() {
        EntityType[] heroTypes = EntityUtil.getHeroes().toArray(new EntityType[0]);
        int restart = 1;
        while (restart == 1) {
            int type = JOptionPane.showOptionDialog(null,
                    "Choose hero type!",
                    "Choose Hero",
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
    }

    /**
     * Returns the information of the given entity type.
     * @return the information of the given entity type.
     */
    public String typeInfo(EntityType type) {
        return type.getTypeName() +
                "\n\n" +
                type.getDescription();
    }



}
