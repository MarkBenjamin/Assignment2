package edu.kit.informatik.Matrixoperationen.ui;

import edu.kit.informatik.Matrixoperationen.InputException;
import edu.kit.informatik.Matrixoperationen.data.Matrix;
import edu.kit.informatik.Matrixoperationen.data.MatrixOperation;

/**
 * Encapsulates the available commands with description.
 *
 * @author SiyanLi
 * @version 1.0
 */
public enum Command {
    /**
     * matrix addition
     */
    MATRIX_ADDITION("matrix-addition "
            + InteractionStrings.ONE_MATRIX.toString()
            + InteractionStrings.NUM_OF_MATRIX.toString()) {
        @Override
        public void execute(final String parameters, final MatrixOperation matrixOperation) throws InputException {

            String[] rowAndColumn = parameters.split(":");
            String allMatrixNum = rowAndColumn[rowAndColumn.length - 1];
            String[] numOfMatrix = allMatrixNum.split(InteractionStrings.MATRIX_SEPARATOR.toString());
            int row = Integer.valueOf(rowAndColumn[0]);
            int column = Integer.valueOf(rowAndColumn[1]);

            Matrix matrix1 = new Matrix(row, column);
            Matrix matrix2 = new Matrix(row, column);

            int[] firstMatrixNum = new int[row * column];
            int[] secondMatrixNum = new int[row * column];
            //set number to firstMatrixNum
            for (int count = 0; count < row * column; count++) {
                firstMatrixNum[count] = Integer.valueOf(numOfMatrix[count]);
            }
            //set number to secondMatrixNum
            for (int count = 0; count < row * column; count++) {
                secondMatrixNum[count] = Integer.valueOf(numOfMatrix[count + row * column]);
            }

            //set the numbers to matrix1
            for (int i = 0; i < firstMatrixNum.length; i++) {
                matrix1.setMatrix(i / column + 1, i % column + 1, firstMatrixNum[i]);

            }

            //set the numbers to matrix2
            for (int i = 0; i < secondMatrixNum.length; i++) {
                matrix2.setMatrix(i / column + 1, i % column + 1, secondMatrixNum[i]);
            }

            output = MatrixOperation.matrixAddition(matrix1, matrix2).matrixToString();

        }

    },
    /**
     * matrix multiplication
     */
    MATRIX_MULTIPLICATION("matrix-multiplication "
            + InteractionStrings.TWO_MATRIX.toString()
            + InteractionStrings.NUM_OF_MATRIX.toString()) {
        @Override
        public void execute(final String parameters, final MatrixOperation matrixOperation) throws InputException {
            String[] lmn = parameters.split(":");
            String allMatrixNum = lmn[lmn.length - 1];
            String[] numOfMatrix = allMatrixNum.split(InteractionStrings.MATRIX_SEPARATOR.toString());

            int l = Integer.valueOf(lmn[0]);
            int m = Integer.valueOf(lmn[1]);
            int n = Integer.valueOf(lmn[2]);

            Matrix matrix1 = new Matrix(l, m);
            Matrix matrix2 = new Matrix(m, n);

            int[] firstMatrixNum = new int[l * m];
            int[] secondMatrixNum = new int[m * n];

            //set number to firstMatrixNum
            for (int count = 0; count < l * m; count++) {
                firstMatrixNum[count] = Integer.valueOf(numOfMatrix[count]);
            }
            //set number to secondMatrixNum
            for (int count = 0; count < m * n; count++) {
                secondMatrixNum[count] = Integer.valueOf(numOfMatrix[count + l * m]);
            }
            //set the numbers to matrix1
            for (int i = 0; i < firstMatrixNum.length; i++) {
                matrix1.setMatrix(i / m + 1, i % m + 1, firstMatrixNum[i]);

            }

            //set the numbers to matrix2
            for (int i = 0; i < secondMatrixNum.length; i++) {
                matrix2.setMatrix(i / n + 1, i % n + 1, secondMatrixNum[i]);
            }
            output = MatrixOperation.matrixMultiplication(matrix1, matrix2).matrixToString();
        }
    },
    /**
     * scalar and matrix multiplication.
     */
    SCALAR_MULTIPLICATION("scalar-multiplication "
            + InteractionStrings.TWO_MATRIX
            + InteractionStrings.NUM_OF_MATRIX) {
        @Override
        public void execute(final String parameters, final MatrixOperation matrixOperation) throws InputException {
            String[] smn = parameters.split(":");
            String allMatrixNum = smn[smn.length - 1];
            String[] numOfMatrix = allMatrixNum.split(InteractionStrings.MATRIX_SEPARATOR.toString());

            int s = Integer.valueOf(smn[0]);
            int m = Integer.valueOf(smn[1]);
            int n = Integer.valueOf(smn[2]);

            Matrix matrix = new Matrix(m, n);
            int[] matrixNum = new int[n * m];


            //set number to matrixNum
            for (int count = 0; count < n * m; count++) {
                matrixNum[count] = Integer.valueOf(numOfMatrix[count]);
            }
            //set the numbers to matrix
            for (int i = 0; i < matrixNum.length; i++) {
                matrix.setMatrix(i / m + 1, i % m + 1, matrixNum[i]);
            }
            output = MatrixOperation.scalarMultiplication(s, matrix).matrixToString();

        }

    },
    /**
     * transposition
     */
    TRANSPOSITION("transposition "
            + InteractionStrings.ONE_MATRIX
            + InteractionStrings.NUM_OF_MATRIX) {
        @Override
        public void execute(final String parameters, final MatrixOperation matrixOperation) throws InputException {

            String[] mn = parameters.split(":");
            String allMatrixNum = mn[mn.length - 1];
            String[] numOfMatrix = allMatrixNum.split(InteractionStrings.MATRIX_SEPARATOR.toString());

            int m = Integer.valueOf(mn[0]);
            int n = Integer.valueOf(mn[1]);

            Matrix matrix = new Matrix(m, n);
            int[] matrixNum = new int[n * m];


            //set number to matrixNum
            for (int count = 0; count < n * m; count++) {
                matrixNum[count] = Integer.valueOf(numOfMatrix[count]);
            }
            //set the numbers to matrix
            for (int i = 0; i < matrixNum.length; i++) {
                matrix.setMatrix(i / m + 1, i % m + 1, matrixNum[i]);
            }

            output = MatrixOperation.transposition(matrix).matrixToString();
        }
    },
    /**
     * main diagonal
     */
    MAIN_DIAGONAL("main-diagonal "
            + InteractionStrings.DIAGONAL_DIMENSION
            + InteractionStrings.NUM_OF_MATRIX) {
        @Override
        public void execute(final String parameters, final MatrixOperation matrixOperation) throws InputException {

            String[] n = parameters.split(":");
            String allMatrixNum = n[n.length - 1];
            String[] numOfMatrix = allMatrixNum.split(InteractionStrings.MATRIX_SEPARATOR.toString());

            int dimension = Integer.valueOf(n[0]);

            Matrix matrix = new Matrix(dimension, dimension);
            int[] matrixNum = new int[dimension * dimension];


            //set number to matrixNum
            for (int count = 0; count < dimension * dimension; count++) {
                matrixNum[count] = Integer.valueOf(numOfMatrix[count]);
            }
            //set the numbers to matrix
            for (int i = 0; i < matrixNum.length; i++) {
                matrix.setMatrix(i / dimension + 1, i % dimension + 1, matrixNum[i]);
            }
            output = MatrixOperation.mainDiagonal(dimension, matrix).matrixToString();

        }
    },
    /**
     * Finishes the interaction.
     */
    QUIT("quit") {
        @Override
        public void execute(final String parameters, final MatrixOperation matrixOperation) {
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
     * @param input           The user input.
     * @param matrixOperation The instance of the matrix opration object.
     * @return The command that got executed.
     * @throws InputException if no matching command is found. Contains an error message.
     */
    public static Command executeMatching(String input,
                                          MatrixOperation matrixOperation) throws InputException {
        for (Command command : Command.values()) {
            if (input.matches(command.pattern)) {
                command.execute(input.substring(input.indexOf(" ") + 1), matrixOperation);
                return command;
            }
        }
        throw new InputException("not a valid command!");
    }

    /**
     * Executes a command.
     *
     * @param parameters      The regex matcher that contains the groups of input of the command.
     * @param matrixOperation The instance of the matrix operation object.
     * @throws InputException if the command contains syntactical or semantic errors.
     */
    public abstract void execute(String parameters, MatrixOperation matrixOperation) throws InputException;

    /**
     * Checks if the program is still running or was exited.
     *
     * @return true if the program is still running, false otherwise.
     */
    public boolean isRunning() {
        return isRunning;
    }

    /**
     * Returns the string passed by the last active command.
     *
     * @return string to display to the user
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
