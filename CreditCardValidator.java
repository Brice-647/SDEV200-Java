import java.util.Scanner;

public class CreditCardValidator {

//Scans user input and checks if the credit card number is valid
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter a credit card number as a long integer: ");
            long number = input.nextLong();

            if (isValid(number)) {
                System.out.println(number + " is valid");
            } else {
                System.out.println(number + " is invalid");
            }
        }
    }

    // Return true if the card number is valid
    public static boolean isValid(long number) {
        int sum = sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);
        return sum % 10 == 0;
    }

    // Get the result from Step 2
    public static int sumOfDoubleEvenPlace(long number) {
        String num = String.valueOf(number);
        int sum = 0;

    // Start from second-to-last digit and move left
        for (int i = num.length() - 2; i >= 0; i -= 2) {
            int digit = Character.getNumericValue(num.charAt(i));
            sum += getDigit(digit * 2);
        }

        return sum;
    }

    //Return this number if it is a single digit, otherwise, return the sum of the two digits
    public static int getDigit(int number) {
        if (number < 10) {
            return number;
        }
        return number / 10 + number % 10;
    }

    //Return sum of odd placed digits in number
    public static int sumOfOddPlace(long number) {
        String num = String.valueOf(number);
        int sum = 0;

    // Start from the last digit and move left
    for (int i = num.length() - 1; i >= 0; i -= 2) {
        int digit = Character.getNumericValue(num.charAt(i));
        sum += digit;
    }

        return sum;
    }
}