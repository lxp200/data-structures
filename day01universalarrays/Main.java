import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // tests
        int[][] a1 = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
        int[][] a2 = { {10, 11, 4}, {12, 6, 5, 0}, {13, 14, 15, 16, 9, 4} };

        printArray(a1);
        printArray(a2);

        int[] duplicates = findDuplicates(a1, a2);

        System.out.println("\nDuplicate values: ");
        printArray(duplicates);

    }

    // input methods
    static void inputArray(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.println("Enter value for index " + i + ": ");
            data[i] = scanner.nextInt();
        }
    }

    static void inputArray(int[][] data2d) {
        for (int i = 0; i < data2d.length; i++) {
            for (int j = 0; j < data2d[i].length; j++) {
                boolean validInput = false;
                while (!validInput) {
                    try {
                        System.out.println("Enter value for row " + i + " column " + j + ": ");
                        data2d[i][j] = scanner.nextInt();
                        validInput = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter an integer.");
                        scanner.next(); // consume invalid token
                    }
                }
            }
        }
    }

    // print methods
    static void printArray(int[] data) {
        for (int i = 0; i < data.length; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(data[i]);
        }
        System.out.println();
    }

    static void printArray(int[][] data2d) {

        System.out.println("\nprintArray()\n---");

        for (int i = 0; i < data2d.length; i++) {
            for (int j = 0; j < data2d[i].length; j++) {
                if (j != 0) {
                    System.out.print(", ");
                }
                System.out.print(data2d[i][j]);
            }
            System.out.println();
        }
    }

    static void printArrayAligned(int[][] data2d) {

        // find max number of digits
        int[] maxLengths = new int[data2d[0].length];
        for (int[] row : data2d) {
            for (int j = 0; j < row.length; j++) {
                int length = String.valueOf(row[j]).length();
                maxLengths[j] = Math.max(maxLengths[j], length);
            }
        }

        // print
        System.out.println("\nprintArrayAligned()\n---");

        for (int[] row : data2d) {
            for (int j = 0; j < row.length; j++) {
                if (j != 0) {
                    System.out.print(", ");
                }
                System.out.printf("%" + maxLengths[j] + "d", row[j]);
            }
            System.out.println();
        }

        // print computed column sizes
        System.out.println("Column sizes: " + Arrays.toString(maxLengths));
    }

    // find duplicates methods
    static int[] findDuplicates(int[] a1, int[] a2) {
        int[] temp = new int[a1.length + a2.length];
        int index = 0;
        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a2.length; j++) {
                if (a1[i] == a2[j]) {
                    if (!isInArray(temp, index, a1[i])) {
                        temp[index++] = a1[i];
                    }
                    break;
                }
            }
        }
        int[] result = new int[index];
        System.arraycopy(temp, 0, result, 0, index);
        return result;
    }

    static boolean isInArray(int[] array, int length, int value) {
        for (int i = 0; i < length; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

    // flatten multidimensional array into single-dimensional array
    static int[] flatten(int[][] array) {
        int totalLength = 0;
        for (int[] row : array) {
            totalLength += row.length;
        }
        int[] flattened = new int[totalLength];
        int index = 0;
        for (int[] row : array) {
            for (int value : row) {
                flattened[index++] = value;
            }
        }
        return flattened;
    }

    // find duplicates in two multidimensional arrays
    static int[] findDuplicates(int[][] a1, int[][] a2) {
        return findDuplicates(flatten(a1), flatten(a2));
    }
}
