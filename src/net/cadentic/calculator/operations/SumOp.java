package net.cadentic.calculator.operations;

public class SumOp extends Op {

    /**
     * Constructor
     *
     * @param leftOp    The left-hand child Op.
     * @param rightOp   The right-hand child Op.
     */
    public SumOp(Op leftOp, Op rightOp) {
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
        return (a + b);
    }
}
