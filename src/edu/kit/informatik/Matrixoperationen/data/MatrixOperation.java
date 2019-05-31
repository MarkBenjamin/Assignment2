package edu.kit.informatik.Matrixoperationen.data;

/**
 * This class models the operations of one or two matrix.
 */
public class MatrixOperation {
    /**
     * This method is empty, because all functions are below.
     */
    public MatrixOperation() {
    }

    /**
     * This method add tow matrix and return the sum matrix.
     *
     * @param matrix1 the first matrix to be added.
     * @param matrix2 the second matrix to be added.
     * @return the sum matrix.
     */
    public static Matrix matrixAddition(Matrix matrix1, Matrix matrix2) {
        Matrix resultMatrix = new Matrix(matrix1.getRow(), matrix1.getColumn());
        for (int row = 1; row <= resultMatrix.getRow(); row++) {
            for (int column = 1; column <= resultMatrix.getColumn(); column++) {
                resultMatrix.setMatrix(row, column, matrix1.getNumber(row, column) + matrix2.getNumber(row, column));
            }
        }
        return resultMatrix;
    }

    /**
     * This method can calculate multiplication with two matrix.
     *
     * @param matrix1 the first matrix to be multiplied.
     * @param matrix2 the second matrix to be multiplied.
     * @return the result matrix.
     */
    public static Matrix matrixMultiplication(Matrix matrix1, Matrix matrix2) {
        Matrix resultMatrix = new Matrix(matrix1.getRow(), matrix2.getColumn());
        for (int row = 1; row <= matrix1.getRow(); row++) {
            for (int column = 1; column <= matrix2.getColumn(); column++) {
                for (int num = 1; num <= matrix1.getColumn(); num++) {
                    resultMatrix.setMatrix(row, column,
                            resultMatrix.getNumber(row, column)
                                    + matrix1.getNumber(row, num) * matrix2.getNumber(num, column));
                }
            }
        }
        return resultMatrix;
    }

    /**
     * This method returns the multiplied matrix with a number.
     *
     * @param scalar the number to be multiplied.
     * @param matrix the matrix to be multiplied.
     * @return the result matrix.
     */
    public static Matrix scalarMultiplication(int scalar, Matrix matrix) {
        Matrix resultMatrix = new Matrix(matrix.getRow(), matrix.getColumn());
        for (int row = 1; row <= matrix.getRow(); row++) {
            for (int column = 1; column <= matrix.getColumn(); column++) {
                resultMatrix.setMatrix(row, column, scalar * matrix.getNumber(row, column));
            }
        }
        return resultMatrix;
    }

    /**
     * This method can return the transposition of a matrix.
     *
     * @param matrix the matrix to be transported.
     * @return the result matrix.
     */
    public static Matrix transposition(Matrix matrix) {
        Matrix resultMatrix = new Matrix(matrix.getColumn(), matrix.getRow());
        for (int row = 1; row <= matrix.getColumn(); row++) {
            for (int column = 1; column <= matrix.getRow(); column++) {
                resultMatrix.setMatrix(row, column, matrix.getNumber(column, row));
            }
        }
        return resultMatrix;
    }

    /**
     * This class returns the main diagonal of the given matrix.
     *
     * @param dimension the dimension of the given matrix.
     * @param matrix    the given matrix.
     * @return the main diagonal.
     */
    public static Matrix mainDiagonal(int dimension, Matrix matrix) {
        Matrix resultMatrix = new Matrix(1, dimension);
        for (int num = 1; num <= dimension; num++) {
            resultMatrix.setMatrix(1, num, matrix.getNumber(num, num));
        }
        return resultMatrix;
    }
}
