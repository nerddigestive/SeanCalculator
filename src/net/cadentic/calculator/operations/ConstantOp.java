package net.cadentic.calculator.operations;

public class ConstantOp extends Op {
    // Class variables
    double constantValue;
    Op leftOp = null;
    Op rightOp = null;

    // Constructors
    public ConstantOp(double constantValue) {
        super();
        this.constantValue = constantValue;
    }

    // Override Abstract Methods
    @Override
    public double applyOperation(double a, double b) {
        return constantValue;
    }

    @Override
    public double getOpIdentity() {
        return constantValue;
    }

    // Getters and Setters
    public double getConstantValue() {
        return constantValue;
    }

    public void setConstantValue(double constantValue) {
        this.constantValue = constantValue;
    }

}
