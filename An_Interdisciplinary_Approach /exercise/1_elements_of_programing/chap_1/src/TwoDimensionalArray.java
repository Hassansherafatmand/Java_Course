public class TwoDimensionalArray {

    public static void main(String[] args) {
        int row = 5;
        int column = 3;
        int[][] a = new int[row + 1][column + 1]; // extra row & column

        // fill with random values
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                a[i][j] = 1 + (int)(Math.random() * 6);
            }
        }

        // compute row averages and store in last column
        for (int i = 0; i < row; i++) {
            int sum = 0;
            for (int j = 0; j < column; j++) {
                sum += a[i][j];
            }
            a[i][column] = sum / column; // store average
        }

        // compute column averages and store in last row
        for (int j = 0; j < column; j++) {
            int sum = 0;
            for (int i = 0; i < row; i++) {
                sum += a[i][j];
            }
            a[row][j] = sum / row; // store column average
        }

        // compute overall average (optional)
        int total = 0;
        for (int i = 0; i < row; i++) {
            total += a[i][column];
        }
        a[row][column] = total / row;

        // print matrix with labels
        System.out.println("Matrix with Row & Column Averages:");
        System.out.println("Col1\tCol2\tCol3\tAverage");
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= column; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
        
        
        
    }
}
