package net.cadentic.calculator.parser;

import net.cadentic.calculator.operations.*;

import java.util.Stack;

/**
 * Class for parsing Strings representing formulae into OpTree objects.
 */
public class StringParser {
    /**
     * The string to parse to an OpTree.
     */
    private String stringToParse;

    /**
     * Constructor
     *
     * @param stringToParse     The string to parse to an OpTree.
     */
    public StringParser(String stringToParse) {
        this.stringToParse = "(" + stringToParse + ")";
    }

    /**
     * Parse the current string to an OpTree and return it.
     *
     * @return OpTree   The parsed OpTree.
     */
    public OpTree parseStringToOpTree() {
        // Initialise working stacks
        Stack<Op> workingOpStack = new Stack<Op>();
        Stack<String> workingOpTypeStack = new Stack<String>();
        Stack<Character> doubleConstructionStack = new Stack<Character>();

        // Loop through each character in the string to parse once
        for (char ch : stringToParse.toCharArray())
            if (ch == '(') {
                continue;
            } else if (ch == ')') {
                // If the last values we parsed were a number, convert them into a ConstantOp on the stack.
                convertCharsToConstantOp(workingOpStack, doubleConstructionStack);

                // Create the left and right child Ops for the new Op.
                Op rightOp = workingOpStack.pop();
                Op leftOp = workingOpStack.pop();

                if (workingOpTypeStack.size() == 0) {
                    continue;
                }

                // Add the operation on the top of the working type stack to the Op stack
                if (workingOpTypeStack.peek() == "SUM") {
                    workingOpStack.push(new SumOp(leftOp, rightOp));
                } else if (workingOpTypeStack.peek() == "SUB") {
                    workingOpStack.push(new SubtractOp(leftOp, rightOp));
                } else if (workingOpTypeStack.peek() == "DOT") {
                    workingOpStack.push(new DotOp(leftOp, rightOp));
                } else if (workingOpTypeStack.peek() == "DIV") {
                    workingOpStack.push(new DivideOp(leftOp, rightOp));
                } else if (workingOpTypeStack.peek() == "MOD") {
                    workingOpStack.push(new ModOp(leftOp, rightOp));
                } else if (workingOpTypeStack.peek() == "POW") {
                    workingOpStack.push(new PowerOp(leftOp, rightOp));
                }

                workingOpTypeStack.pop();

            } else if (Character.isDigit(ch) || ch == '.') {
                // Push digits onto the stack to construct a ConstantOp
                doubleConstructionStack.push(ch);
            } else {
                // If the last values we parsed were a number, convert them into a ConstantOp on the stack.
                convertCharsToConstantOp(workingOpStack, doubleConstructionStack);

                // Work out which Op type to create
                switch (ch) {
                    case '+':
                        workingOpTypeStack.push("SUM");
                        break;
                    case '-':
                        workingOpTypeStack.push("SUB");
                        break;
                    case '*':
                        workingOpTypeStack.push("DOT");
                        break;
                    case '/':
                        workingOpTypeStack.push("DIV");
                        break;
                    case '%':
                        workingOpTypeStack.push("MOD");
                        break;
                    case '^':
                        workingOpTypeStack.push("POW");
                        break;
                    default:
                        break;
                }
            }

        return new OpTree(workingOpStack.pop());
    }

    /**
     * Convert a stack of Characters into a single ConstantOp.
     *
     * @param workingOpStack    The current working stack of Ops to be added to the OpTree.
     * @param workingCharStack  The current working stack of Characters to make up the ConstantOp from.
     */
    private void convertCharsToConstantOp(Stack<Op> workingOpStack, Stack<Character> workingCharStack) {
        if (workingCharStack.size() != 0) {
            // Build a string from the digit Characters on the working stack
            StringBuilder sb = new StringBuilder(workingCharStack.size());
            for (Character c : workingCharStack)
                sb.append(c.charValue());

            // Parse this string to a double, and push a ConstantOp with that value to the working Op stack
            double d = Double.parseDouble(sb.toString());
            workingCharStack.removeAllElements();
            workingOpStack.push(new ConstantOp(d));
        }
    }

}





