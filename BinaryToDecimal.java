import java.util.Scanner;

public class BinaryToDecimal {
    
    // Method to convert binary string to decimal
    public static int bin2Dec(String binaryString) throws NumberFormatException {
        int decimal = 0;

        // Validate each character
        for (int i = 0; i < binaryString.length(); i++) {
            char c = binaryString.charAt(i);
            if (c != '0' && c != '1') {
                throw new NumberFormatException("Invalid binary character: " + c);
            }
            decimal = decimal * 2 + (c - '0');  // shift left and add bit
        }

        return decimal;
    }

    // Test program
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Enter a binary number: ");
            String binaryString = input.nextLine();

            int decimal = bin2Dec(binaryString);
            System.out.println("Decimal equivalent: " + decimal);
        } catch (NumberFormatException ex) {
            System.out.println("Not a binary number");
        } finally {
            input.close();
        }
    }
}
