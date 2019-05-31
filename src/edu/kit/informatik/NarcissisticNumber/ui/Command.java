package edu.kit.informatik.NarcissisticNumber.ui;

import edu.kit.informatik.NarcissisticNumber.InputException;
import edu.kit.informatik.NarcissisticNumber.data.NarcissisticNumber;

/**
 * Encapsulates the available commands with description.
 *
 * @author SiyanLi
 * @version 1.0
 */
public enum Command {
    /**
     * Check whether a number is a narcissistic number.
     */
    CHECK_NARCISSISTIC_NUMBER("check-narcissistic-number "
            + InteractionStrings.NUMBER_A.toString()
            + InteractionStrings.NUMBER_SEPARATOR.toString()
            + InteractionStrings.NUMBER_BASIS.toString()) {
        @Override
        public void execute(final String parameters, NarcissisticNumber narcissisticNumber) throws InputException {
            String[] params = parameters.split(InteractionStrings.NUMBER_SEPARATOR.toString());

            if (params[0].length() < 2 || params[0].length() > 8) {
                throw new InputException("the number a should be 2-8 digits!");
            } else {
                if (Integer.valueOf(params[1]) < 2 || Integer.valueOf(params[1]) > 10) {
                    throw new InputException("the basis b should between 2-10!");
                }  else {
                    output = String.valueOf(narcissisticNumber.isNarcissisticNumber(Integer.valueOf(params[0]),
                            Integer.valueOf(params[1])));
                }
            }

            output = String.valueOf(narcissisticNumber.isNarcissisticNumber(Integer.valueOf(params[0]),
                    Integer.valueOf(params[1])));

        }
    },
    /**
     * Finishes the interaction.
     */
    QUIT("quit") {
        @Override
        public void execute(final String parameters,
                            final NarcissisticNumber narcissisticNumber) throws InputException {
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
     * Checks an input against all available commands and calls the command if one
     * is found.
     *
     * @param input              The user input.
     * @param narcissisticNumber The instance of the narcissistic number object.
     * @return The command that got executed.
     * @throws InputException if no matching command is found. Contains an error message.
     */
    public static Command executeMatching(String input, NarcissisticNumber narcissisticNumber) throws InputException {
        for (Command command : Command.values()) {
            if (input.matches(command.pattern)) {
                command.execute(input.substring(input.indexOf(" ") + 1), narcissisticNumber);
                return command;
            }
        }
        throw new InputException("not a valid command");
    }

    /**
     * Executes a command.
     *
     * @param parameters         The regex matcher that contains the groups of input of the
     *                           command.
     * @param narcissisticNumber The instance of the narcissistic number object.
     * @throws InputException if the command contains syntactical or semantic errors.
     */
    public abstract void execute(String parameters, NarcissisticNumber narcissisticNumber) throws InputException;

    /**
     * Checks if the program is still running or was exited.
     *
     * @return true if the program is still running, false otherwise.
     */
    public boolean isRunning() {
        return isRunning;
    }


    /**
     * Checks if the program is still running or was exited.
     *
     * @return true if the program is still running, false otherwise.
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
