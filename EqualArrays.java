import java.util.Scanner;

public class EqualArrays {

// Step 3: method to compare two 2D int arrays

public static boolean equals(int[][] m1, int[][] m2) {

// Basic checks: nulls and row counts

if (m1 == null || m2 == null) return false;
if (m1.length != m2.length) return false;

// Check each row length and each element

for (int r = 0; r < m1.length; r++) {
if (m1[r].length != m2[r].length) return false;
for (int c = 0; c < m1[r].length; c++) {
if (m1[r][c] != m2[r][c]) return false;
    }
}
return true;
}

// Helper: read a 3x3 array from the user

private static int[][] read3x3(Scanner in, String name) {
int[][] m = new int[3][3];
System.out.println("Enter 9 integers for " + name + " (row by row):");
for (int r = 0; r < 3; r++) {
for (int c = 0; c < 3; c++) {
m[r][c] = in.nextInt();
    }
}
return m;
}
public static void main(String[] args) {
Scanner in = new Scanner(System.in);
System.out.println("This program checks if two 3x3 arrays are identical.");

// Step 2: read arrays

int[][] m1 = read3x3(in, "m1");
int[][] m2 = read3x3(in, "m2");

// Step 4: compare and report

if (equals(m1, m2)) {
System.out.println("The two arrays are identical.");
} else {
System.out.println("The two arrays are not identical.");
        }
    }
}
