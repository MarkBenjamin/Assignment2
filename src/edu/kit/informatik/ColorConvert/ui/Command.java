package edu.kit.informatik.ColorConvert.ui;

import edu.kit.informatik.ColorConvert.Color.Convert;
import edu.kit.informatik.ColorConvert.InputException;

/**
 * A constant of this enum represents a command for color convert program.
 *
 * @author SiyanLi
 * @version 1.0
 */
public enum Command {
    /**
     * Represents the convert command. It converts the RGB color into a CMYK color.
     */
    CONVERT("convert " + InteractionStrings.RED.toString()
            + InteractionStrings.INPUT_SEPARATOR.toString()
            + InteractionStrings.GREEN.toString()
            + InteractionStrings.INPUT_SEPARATOR.toString()
            + InteractionStrings.BLUE) {
        @Override
        public void execute(String parameters, Convert convert) throws InputException {
            String[] params = parameters.split(InteractionStrings.INPUT_SEPARATOR.toString());

            if (Integer.valueOf(params[0]) > 255
                    || Integer.valueOf(params[1]) > 255
                    || Integer.valueOf(params[2]) > 255) {
                throw new InputException("not a valid number!");
            } else {
                output = convert.convert(params[0], params[1], params[2]);
            }


        }
    },
    /**
     * Represents the quit command. Quits the program.
     */
    QUIT("quit") {
        @Override
        public void execute(String parameters, Convert convert) {
            quit();
        }
    };
    /**
     * Contains the output of the command if there is any.
     */
    protected String output;
    /**
     * Contains the game state.
     */
    private boolean isRunning;
    /**
     * Contains this commands input format.
     */
    private String pattern;

    /**
     * Constructs a new command.
     *
     * @param pattern The regex pattern to use for command validation and processing.
     */
    Command(String pattern) {
        this.isRunning = true;
        this.pattern = pattern;
    }

    /**
     * Checks an input against all available commands and calls the command if
     * one is found.
     *
     * @param input   The user input.
     * @param convert The instance of the convert object.
     * @return The command that got executed.
     * @throws InputException if no matching command is found. Contains
     *                        an error message.
     */
    public static Command executeMatching(String input, Convert convert) throws InputException {
        for (Command command : Command.values()) {
            if (input.matches(command.pattern)) {
                command.execute(input.substring(input.indexOf(" ") + 1), convert);
                return command;
            }
        }
        throw new InputException("not a valid command!");

    }

    /**
     * Executes a command.
     *
     * @param parameters The regex matcher that contains the groups of input of the command.
     * @param convert    The instance of the convert object.
     * @throws InputException if the command contains syntactical or semantic errors.
     */
    public abstract void execute(String parameters, Convert convert) throws InputException;

    /**
     * Checks if the porgram is still running or was exited.
     *
     * @return true if the program is still running, false otherwise.
     */
    public boolean isRunning() {
        return isRunning;
    }

    /**
     * Returns the string passed by the last active command.
     *
     * @return String to display to the user.
     */
    public String getOutput() {
        return output;
    }

    /**
     * Exits the program gracefully.
     */
    protected void quit() {
        isRunning = false;
    }


}
