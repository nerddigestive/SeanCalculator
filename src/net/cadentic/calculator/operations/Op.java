package net.cadentic.calculator.operations;

/**
 * Abstract base class for all binary Ops.
 */
public abstract class Op {
    /**
     * The left-hand child Op of this Op.
     */
    Op leftOp;
    /**
     * The right-hand child Op of this Op.
     */
    Op rightOp;

    /**
     * Recursively resolves the value of the op by resolving the OpTree that it is at the root of.
     *
     * @return double   The answer that the Op returns when it has been resolved.
     */
    double recursiveResolve() {
        double leftSolution, rightSolution;

        // resolve left subtree
        if (leftOp == null) {
            leftSolution = this.getOpIdentity();
        } else {
            leftSolution = this.leftOp.recursiveResolve();
        }

        // resolve right subtree
        if (rightOp == null) {
            rightSolution = this.getOpIdentity();
        } else {
            rightSolution = this.rightOp.recursiveResolve();
        }

        // apply current op to resolved left and right subtree
        return this.applyOperation(leftSolution, rightSolution);
    }

    /**
     * Apply the current Op's operation to 2 doubles.
     *
     * @param a         The left-hand input to the operation.
     * @param b         The right-hand input to the operation.
     * @return double   The answer to the operation applied.
     */
    public abstract double applyOperation(double a, double b);

    /**
     * Get the identity constant for the given transformation.
     *
     * @return double   The identity for the transformation/operation.
     */
    public abstract double getOpIdentity();

    /**
     * Returns the left-hand child Op.
     *
     * @return Op   The left-hand child of the current Op.
     */
    public Op getLeftOp() {
        return leftOp;
    }

    /**
     * Sets the left-hand child Op.
     *
     * @param leftOp   The desired left-hand child of the current Op.
     */
    public void setLeftOp(Op leftOp) {
        this.leftOp = leftOp;
    }

    /**
     * Returns the right-hand child Op.
     *
     * @return Op   The right-hand child of the current Op.
     */
    public Op getRightOp() {
        return rightOp;
    }

    /**
     * Sets the right-hand child Op.
     *
     * @param rightOp   The desired right-hand child of the current Op.
     */
    public void setRightOp(Op rightOp) {
        this.rightOp = rightOp;
    }

}
