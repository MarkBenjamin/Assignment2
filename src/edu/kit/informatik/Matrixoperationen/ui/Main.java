package edu.kit.informatik.Matrixoperationen.ui;

import edu.kit.informatik.Matrixoperationen.InputException;
import edu.kit.informatik.Matrixoperationen.data.MatrixOperation;
import edu.kit.informatik.Terminal;

/**
 * Entry point for the program.
 *
 * @author SiyanLi
 * @version 1.0
 */
public class Main {
    /**
     * The main method that is the entry point to the program.
     * @param args An array of command line arguments.
     */
    public static void main(String[] args) {
        MatrixOperation matrixOperation = new MatrixOperation();
        Command command = null;
        do {
            try {
                command = Command.executeMatching(Terminal.readLine(), matrixOperation);
                if (command.isRunning()) {
                    Terminal.printLine(command.getOutput());
                }
            } catch (InputException e) {
                Terminal.printError(e.getMessage());
            }
        } while (command == null || command.isRunning());
    }
}
