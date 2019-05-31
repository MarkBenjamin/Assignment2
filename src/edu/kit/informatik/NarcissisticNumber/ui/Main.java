package edu.kit.informatik.NarcissisticNumber.ui;

import edu.kit.informatik.NarcissisticNumber.InputException;
import edu.kit.informatik.NarcissisticNumber.data.NarcissisticNumber;
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
     *
     * @param args An array of command line arguments.
     */
    public static void main(String[] args) {
        NarcissisticNumber narcissisticNumber = new NarcissisticNumber();
        Command command = null;
        do {
            try {
                command = Command.executeMatching(Terminal.readLine(), narcissisticNumber);
                if (command.isRunning()) {
                    Terminal.printLine(command.getOutput());
                }
            } catch (InputException e) {
                Terminal.printError(e.getMessage());
            }
        } while (command == null || command.isRunning());
    }
}
