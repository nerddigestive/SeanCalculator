package net.cadentic.calculator.operations;

/**
 * Container class to represent an OpTree.
 */
public class OpTree {
    // Class variables
    private Op rootOp;

    /**
     * @param rootOp
     */
    public OpTree(Op rootOp) {
        this.rootOp = rootOp;
    }

    /**
     * Recursively resolve the value for the root of the OpTree.
     *
     * @return double   The answer to the resolved OpTree.
     */
    public double solveOpTreeRecursively() {
        return rootOp.recursiveResolve();
    }

    /**
     * Get the root of the OpTree.
     *
     * @return Op   The root of the OpTree.
     */
    public Op getRootOp() {
        return rootOp;
    }

    /**
     * Set a new root for the OpTree.
     *
     * @param rootOp    The desired new root of the OpTree.
     */
    public void setRootOp(Op rootOp) {
        this.rootOp = rootOp;
    }
}
