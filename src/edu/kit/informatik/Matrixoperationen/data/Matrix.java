package edu.kit.informatik.Matrixoperationen.data;

/**
 * This class models a Matrix with the given numbers.
 *
 * @author SiyanLi
 * @version 1.0
 */
public class Matrix {
    private int row;
    private int column;
    private int[][] matrix;

    /**
     * This method create a new Matrix with the given row number.
     *
     * @param row    the row number.
     * @param column the column number
     */
    public Matrix(int row, int column) {
        this.row = row;
        this.column = column;
        matrix = new int[row][column];
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.column; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    /**
     * Set the given number in the position.
     *
     * @param row    the row number.
     * @param column the column number.
     * @param value  the value in the position.
     */
    public void setMatrix(int row, int column, int value) {
        matrix[row - 1][column - 1] = value;
    }

    /**
     * Format the Matrix into String.
     *
     * @return the String format of the matrix.
     */
    public String matrixToString() {
        String printMat = "";
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                printMat = printMat + String.valueOf(matrix[i][j]);
                printMat = printMat + ",";
            }
        }
        return printMat.substring(0, printMat.length() - 1);
    }

    /**
     * Get the row number for a position.
     *
     * @return the row number.
     */
    public int getRow() {
        return row;
    }

    /**
     * Get the column number for the position.
     *
     * @return the column number.
     */
    public int getColumn() {
        return column;
    }

    /**
     * Get the value of the position.
     *
     * @param row    the row number.
     * @param column the column number.
     * @return the value with the given position.
     */
    public int getNumber(int row, int column) {
        return matrix[row - 1][column - 1];
    }
}