package net.cadentic.calculator.commander;

import net.cadentic.calculator.operations.OpTree;
import net.cadentic.calculator.parser.StringParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Class to control the terminal UI input and output.
 */
public class TerminalUI {
    private BufferedReader br;

    /**
     * Constructor
     *
     * @param inputStream   The terminal InputStream to read commands from.
     */
    public TerminalUI(InputStream inputStream) {
        this.br = new BufferedReader(new InputStreamReader(inputStream));
    }

    /**
     * Ask for a calculation and process its answer.
     */
    public void askForCalculation() {
        System.out.println("Input calculation...");
        String formula = getFormulaString(this.br);
        double answer = this.runCalculatorIteration(formula);
        System.out.println("Ans: " + answer);
    }

    /**
     * Parse the formula string and compute its value.
     *
     * @param formula   The input formula string read from the terminal.
     * @return double   The answer to the input formula.
     */
    private double runCalculatorIteration(String formula) {
        // Setup StringParser to create the OpTree with
        StringParser parser = new StringParser(formula);

        // Parse the string to an OpTree and return it
        OpTree mainOpTree = parser.parseStringToOpTree();
        return mainOpTree.solveOpTreeRecursively();
    }

    /**
     * Input the formula for calculation and remove whitespace.
     *
     * @param br    The BufferedReader from which to read console input.
     * @return String   The formula string for the input calculation without whitespace.
     */
    private static String getFormulaString(BufferedReader br) {
        try {
            // Read command line input and remove spaces
            return br.readLine().replaceAll(" ", "");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

}
