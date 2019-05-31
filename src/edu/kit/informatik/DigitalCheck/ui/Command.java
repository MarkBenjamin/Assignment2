package edu.kit.informatik.DigitalCheck.ui;

import edu.kit.informatik.DigitalCheck.data.DigitalCheck;
import edu.kit.informatik.DigitalCheck.InputException;

/**
 * Encapsulates the available commands with description. *
 *
 * @author SiyanLi
 * @version 1.0
 */
public enum Command {
    /**
     * Represents the digit sum command.
     */
    DIGIT_SUM("digitsum " + InteractionStrings.TWO_LETTERS + InteractionStrings.NUMBER_WITHOUT_P) {
        @Override
        public void execute(final String parameters, final DigitalCheck digitalCheck) throws InputException {
            digitalCheck.input(parameters, false);
            output = String.valueOf(digitalCheck.getDigitSum());
        }
    },
    /**
     * Represents the check sum command.
     */
    CHECK_SUM("checksum " + InteractionStrings.TWO_LETTERS + InteractionStrings.NUMBER_WITHOUT_P) {
        @Override
        public void execute(final String parameters, final DigitalCheck digitalCheck) throws InputException {
            digitalCheck.input(parameters, false);
            output = String.valueOf(digitalCheck.checkSum());
        }
    },
    /**
     * Represents the valid
     */
    IS_VALID("isValid " + InteractionStrings.TWO_LETTERS + InteractionStrings.NUMBER_WITH_P) {
        @Override
        public void execute(final String parameters, final DigitalCheck digitalCheck) throws InputException {
            //  output = String.valueOf(new DigitalCheck(parameters,true).isValid());
            digitalCheck.input(parameters, true);
            output = String.valueOf(digitalCheck.isValid());
        }
    },
    /**
     * Finishes the interaction.
     */
    QUIT("quit") {
        @Override
        public void execute(final String parameters, final DigitalCheck digitalCheck) {
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
     * @param pattern The regex pattern to use for command validation
     *                and processing.
     */
    Command(String pattern) {
        this.isRunning = true;
        this.pattern = pattern;
    }

    /**
     * Checks an input against all available commands and calls the command if one
     * is found.
     *
     * @param input the user input.
     * @param digitalCheck The instance of the digital check object.
     * @return the command that got executed.
     * @throws InputException if no matching command is found. Contains an error message.
     */
    public static Command executeMatching(String input, DigitalCheck digitalCheck) throws InputException {
        for (Command command : Command.values()) {
            if (input.matches(command.pattern)) {
                command.execute(input.substring(input.indexOf(" ") + 1), digitalCheck);
                return command;
            }
        }

        throw new InputException("not a valid command!");
    }

    /**
     * Executes a command.
     * @param parameters The regex matcher that contains the groups of input of the command.
     * @param digitalCheck Teh instance of the digital check object.
     * @throws InputException if the command contains syntactical or semantic errors.
     */
    public abstract void execute(String parameters, DigitalCheck digitalCheck)
            throws InputException;

    /**
     * Checks if the program is still running or was exited.
     * @return true if the program is still running, false otherwise.
     */
    public boolean isRunning() {
        return isRunning;
    }

    /**
     * Returns the string passed by the last active command.
     * @return string to display to the user.
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
