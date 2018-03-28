package net.cadentic.calculator.operations;

/**
 * Implementation of an Op to get one value to the power of an other.
 */
public class PowerOp extends Op {

    /**
     * Constructor
     *
     * @param leftOp    The left-hand child Op.
     * @param rightOp   The right-hand child Op.
     */
    public PowerOp(Op leftOp, Op rightOp) {
        this.leftOp = leftOp;
        this.rightOp = rightOp;
    }

    // Override Abstract Methods
    @Override
    public double getOpIdentity() {
        return 1.0D;
    }

    @Override
    public double applyOperation(double a, double b) {
        return Math.pow(a, b);
    }

}
