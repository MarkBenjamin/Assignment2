package edu.kit.informatik.DigitalCheck.ui;

import edu.kit.informatik.DigitalCheck.InputException;
import edu.kit.informatik.DigitalCheck.data.DigitalCheck;
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
        DigitalCheck digitalCheck = new DigitalCheck();
        Command command = null;
        do {
            try {

                command = Command.executeMatching(Terminal.readLine(), digitalCheck);
                if (command.isRunning()) {
                    Terminal.printLine(command.getOutput());
                }
            } catch (InputException e) {
                Terminal.printError(e.getMessage());
            }
        } while (command == null || command.isRunning());
    }
}
