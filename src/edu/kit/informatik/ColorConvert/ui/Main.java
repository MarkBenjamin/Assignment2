package edu.kit.informatik.ColorConvert.ui;

import edu.kit.informatik.ColorConvert.Color.Convert;
import edu.kit.informatik.ColorConvert.InputException;
import edu.kit.informatik.Terminal;

/**
 * Entry point for the program.
 *
 * @author SiyanLi
 * @version 1.0
 */
public class Main {
    /**
     * The main methof that is the entry point to the program.
     *
     * @param args An array of command line arguments.
     */
    public static void main(String[] args) {
        Convert convert = new Convert();
        Command command = null;
        do {
            try {
                command = Command.executeMatching(Terminal.readLine(), convert);
                if (command.isRunning()) {
                    if (command.getOutput() != null) {
                        Terminal.printLine(command.getOutput());
                    }
                }
            } catch (InputException e) {
                Terminal.printError(e.getMessage());
            }
        } while (command == null || command.isRunning());
    }
}
