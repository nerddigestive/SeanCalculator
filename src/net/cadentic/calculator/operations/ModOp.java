package net.cadentic.calculator.operations;

/**
 * Implementation of an Op to get the remainder when dividing one value by another.
 */
public class ModOp extends Op {

    /**
     * Constructor
     *
     * @param leftOp    The left-hand child Op.
     * @param rightOp   The right-hand child Op.
     */
    public ModOp(Op leftOp, Op rightOp) {
        this.leftOp = leftOp;
        this.rightOp = rightOp;
    }

    // Override Abstract Methods
    @Override
    public double getOpIdentity() {
        return 0.0D;
    }

    @Override
    public double applyOperation(double a, double b) {
        return (a % b);
    }

}
