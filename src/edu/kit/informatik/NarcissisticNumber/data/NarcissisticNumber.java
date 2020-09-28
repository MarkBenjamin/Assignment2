package edu.kit.informatik.NarcissisticNumber.data;

/**
 * This class test whether a given number is a narcissistic number with basis.
 *
 * @author SiyanLi
 * @version 1.0
 */
public class NarcissisticNumber {
    /**
     * This method is empty because all functions are below.
     */
    public NarcissisticNumber() {
    }

    /**
     * Test whether the given number and given basis can be a narcissistic number.
     *
     * @param number the number to be tested.
     * @param basis  the basis of the number.
     * @return true, when the number is narcissistic number.
     */
    public boolean isNarcissisticNumber(int number, int basis) {
        int n = 0;
        do {
            n++;
        } while (number > Math.pow(basis, n));

        int[] digit = new int[n];
        int rest = number;
        for (int i = n - 1; i >= 0; i--) {
            digit[i] = (int) (rest / Math.pow(basis, i));
            rest = (int) (rest % Math.pow(basis, i));
        }
        int narcissisticNumber = 0;
        for (int i = 0; i < digit.length; i++) {
            narcissisticNumber = (int) (narcissisticNumber + Math.pow(digit[i], digit.length));
        }
        //Terminal.printLine("nar num = ");
        //Terminal.printLine(narcissisticNumber);

        return number == narcissisticNumber;
    }
}
