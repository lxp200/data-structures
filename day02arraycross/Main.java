public class Main {

    public static void main(String[] args) {
        System.out.println("\nArray Cross: Start...");

        int[][] data2d = {
                {1, 3, 6, 8, 9, 1},
                {7, 1, 2, 3},
                {8, 3, 2},
                {1, 7, 1, 9},
        };

        int minRow = 0, minCol = 0;
        int minSum = sumOfCross(data2d, minRow, minCol);

        // find the cell with the minimum cross sum
        for(int row = 0; row < data2d.length; row++) {
            for(int col = 0; col < data2d[row].length; col++) {
                int sum = sumOfCross(data2d, row, col);
                if(sum < minSum) {
                    minSum = sum;
                    minRow = row;
                    minCol = col;
                }
            }
        }

        System.out.println("minSum: " + minSum + " @ row[" + minRow + "] col[" + minCol + "]");

        // creating a duplicate array with sums
        int[][] data2dSums = duplicateEmptyArray2d(data2d);
        for(int row = 0; row < data2d.length; row++) {
            for(int col = 0; col < data2d[row].length; col++) {
                data2dSums[row][col] = sumOfCross(data2d, row, col);
            }
        }

        // printing original array
        System.out.println("\nOriginal array:");
        print2d(data2d);

        // printing array with sums
        System.out.println("\nArray with sums:");
        print2d(data2dSums);
    }

    static int getIfExists(int[][] data, int row, int col) {
        if(row >= 0 && row < data.length && col >= 0 && col < data[row].length) {
            return data[row][col];
        } else {
            return 0;
        }
    }

    static int sumOfCross(int[][] data, int row, int col) {
        int sum = getIfExists(data, row, col);
        sum += getIfExists(data, row - 1, col);
        sum += getIfExists(data, row + 1, col);
        sum += getIfExists(data, row, col - 1);
        sum += getIfExists(data, row, col + 1);
        return sum;
    }

    static void print2d(int[][] data) {
        for(int[] row : data) {
            for(int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    static int[][] duplicateEmptyArray2d(int[][] orig2d) {
        int[][] newArray = new int[orig2d.length][];
        for (int i = 0; i < orig2d.length; i++) {
            newArray[i] = new int[orig2d[i].length];
        }
        return newArray;
    }
}
