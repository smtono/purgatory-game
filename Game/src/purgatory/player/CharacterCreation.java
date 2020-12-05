package purgatory.player;

import purgatory.Reference;
import purgatory.entity.Entity;
import purgatory.entity.EntityType;
import purgatory.util.EntityUtil;

import javax.swing.*;

/**
 * CharacterCreation allows the user to create the protagonist of the story with name and class.
 *
 * <p>A CharacterCreation object will prompt the user for their name, then their class type, and confirm each along the way.
 *  These values will then be stored in the Reference.java file</p>
 *
 * @author Shannon Thornton
 * @see Reference
 */
public class CharacterCreation {
    // hero name
    String name = "";
    EntityType heroType = null;

    /**
     * Prompts name, then class type and stores into Reference.hero
     * @see Reference
     */
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

    /** Prompts user for the hero type they want to be */
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
