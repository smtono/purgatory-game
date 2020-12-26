package purgatory.move;

/**
 *
 */
public enum SupportMoves implements Move {
    ;

    @Override
    public int useMana(int currMana) {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getResult() {
        return 0;
    }

    @Override
    public int getMana() {
        return 0;
    }

    @Override
    public double getAccuracy() {
        return 0;
    }

    @Override
    public boolean isAffectAll() {
        return false;
    }

    @Override
    public int getLevelOfAccess() {
        return 0;
    }

    @Override
    public MoveType getMoveType() {
        return null;
    }

    @Override
    public AttackType getAttackType() {
        return null;
    }
}
