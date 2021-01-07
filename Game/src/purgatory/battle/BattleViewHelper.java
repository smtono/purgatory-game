package purgatory.battle;

import javax.swing.*;

/**
 *
 */
public class BattleViewHelper {
    private DefaultListModel<String> moves;
    private final JList<String> menuSet;
    private final JList<String> moveSet;
    private String moveSelected;
    private String menuSelected;

    BattleViewHelper(DefaultListModel<String> moves, JList<String> menuSet, JList<String> moveSet) {
        this.moves = moves;
        this.menuSet = menuSet;
        this.moveSet = moveSet;
    }

    // ACCESSORS/MUTATORS
    public DefaultListModel<String> getMoves() {
        return moves;
    }

    public JList<String> getMenuSet() {
        return menuSet;
    }

    public JList<String> getMoveSet() {
        return moveSet;
    }


}
