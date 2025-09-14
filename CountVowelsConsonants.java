import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CountVowelsConsonants {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt for file name
        System.out.print("Enter a filename: ");
        String filename = input.nextLine();
        input.close();
        // Define vowels in a set
        Set<Character> vowels = new HashSet<>();
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        int vowelCount = 0;
        int consonantCount = 0;

        try {
            File file = new File(filename);
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().toUpperCase();

                for (char ch : line.toCharArray()) {
                    if (Character.isLetter(ch)) {
                        if (vowels.contains(ch)) {
                            vowelCount++;
                        } else {
                            consonantCount++;
                        }
                    }
                }
            }

            fileScanner.close();

            // Output result
            System.out.println("Number of vowels: " + vowelCount);
            System.out.println("Number of consonants: " + consonantCount);

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
    }
}
