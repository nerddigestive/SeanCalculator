package net.cadentic.calculator;

import net.cadentic.calculator.commander.TerminalUI;

/**
 * The Main class
 */
public class Main {

    /**
     * The main method; automatically run when executed from a command line.
     *
     * @param args  Command line arguments
     */
    public static void main(String[] args) {
        // Create a terminal interface and get input from System.in
        TerminalUI terminal = new TerminalUI(System.in);

        // Keep looping, asking for more calculations
        while (true) {
            terminal.askForCalculation();
        }

    }
}
