package purgatory.move.type;

import purgatory.move.Move;
import purgatory.weapon.AttackType;

/**
 *
 */
public enum SupportMove implements VirtualMove {
    ;
    
    // ATTRIBUTES
    private final Move move;
    private final MoveType moveType = MoveType.SUPPORT;
    private final AttackType attackType = AttackType.NONE;

    // CONSTRUCTOR
    SupportMove(String name, int result, int mana, double accuracy, boolean isAffectAll, int levelOfAccess) {
        this.move = Move.of(name, result, mana, accuracy, isAffectAll, levelOfAccess, moveType, attackType);
    }
    
    @Override
    public Move getMove() {
        return move;
    }
}
