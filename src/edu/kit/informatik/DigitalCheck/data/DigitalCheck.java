package edu.kit.informatik.DigitalCheck.data;

/**
 * This class models the function of digital check, which checks whether the number illegal.
 */
public class DigitalCheck {
    private String input;
    private long digitSum;
    private StringBuilder digitSumString = new StringBuilder("");
    private int sum = 0;

    /**
     * This is a empty constructor, because all functions are below.
     */
    public DigitalCheck() {
    }

    /**
     * Read the input number.
     *
     * @param input  the input number to be tested.
     * @param withP1 prof whether this number is with p1.
     */
    public void input(String input, boolean withP1) {
        this.input = input;
        char[] charInput = this.input.toCharArray();
        digitSumString = new StringBuilder("");
        digitSumString.append(charInput[0] - 64);
        digitSumString.append(charInput[1] - 64);
        if (withP1) {
            digitSumString.append(input.substring(2, input.length() - 1));
        } else {
            digitSumString.append(input.substring(2, input.length()));
        }
        digitSum = Long.valueOf(digitSumString.toString());
    }

    /**
     * Get the digit sum which is calculated by the first characters and the last 9 numbers.
     *
     * @return the calculated number.
     */
    public long getDigitSum() {
        sum = 0;
        for (int i = 0; i < digitSumString.length(); i++) {
            sum += Integer.valueOf(digitSumString.toString().charAt(i) - '0');
        }
        return sum;
    }

    /**
     * Calculate the p1 digit.
     *
     * @return p1.
     */
    public int checkSum() {
        sum = 0;
        for (int i = 0; i < digitSumString.length(); i++) {
            sum += Integer.valueOf(digitSumString.toString().charAt(i) - '0');
        }
        int rest = (int) (sum % 9);
        if (rest == 7) {
            return 9;
        } else if (rest == 8) {
            return 8;
        } else {
            return 7 - rest;
        }
    }

    /**
     * Test whether the digit number valid.
     *
     * @return true when it is valid.
     */
    public boolean isValid() {
        return checkSum() == Integer.valueOf(input.substring(input.length() - 1, input.length()));
    }

}
