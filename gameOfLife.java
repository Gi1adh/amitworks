import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] mat = new int[50][50];

        System.out.println("hello\n");

        fillmat(mat);
        printmat(mat);
        putblocks(mat);
        printmat(mat);
        checkMat(mat);
    }
    // func to install 0s in the mat
    public static void fillmat(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = 0;
            }
        }
    }
   // just a normal print to the mat
    public static void printmat(int[][] mat) {
        int size = 10; // limit  10x10
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(mat[i][j]);
                if (j != size - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
   // func to put new blocks
    public static void putblocks(int[][] mat) {
        Scanner scanner = new Scanner(System.in);
        boolean cont = true;

        System.out.println("You can place blocks on the mat (50x50).\n");

        while (cont) {
            System.out.print("Enter Y: ");
            int x = scanner.nextInt();
            System.out.print("Enter X: ");
            int y = scanner.nextInt();

            if (x >= 0 && x < mat.length && y >= 0 && y < mat[0].length) {
                mat[x][y] = 1;
            } else {
                System.out.println("invalid coordinates. Try again.\n");
            }

            System.out.print("do you wish to continue? (true/false): ");
            cont = scanner.nextBoolean();
        }

        scanner.close();
    }
  // func to check the rules
    public static void checkMat(int[][] mat) {
        int[][] temp = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                temp[i][j] = mat[i][j];
            }
        }

        int counter;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                counter = 0;
                // right
                if (i + 1 < mat.length && temp[i + 1][j] == 1) counter++;
                // left
                if (i - 1 >= 0 && temp[i - 1][j] == 1) counter++;
                // up
                if (j + 1 < mat[i].length && temp[i][j + 1] == 1) counter++;
                // down
                if (j - 1 >= 0 && temp[i][j - 1] == 1) counter++;
                // top right
                if (i + 1 < mat.length && j + 1 < mat[i].length && temp[i + 1][j + 1] == 1) counter++;
                // down left
                if (i - 1 >= 0 && j - 1 >= 0 && temp[i - 1][j - 1] == 1) counter++;
                // up left
                if (i - 1 >= 0 && j + 1 < mat[i].length && temp[i - 1][j + 1] == 1) counter++;
                // down right
                if (i + 1 < mat.length && j - 1 >= 0 && temp[i + 1][j - 1] == 1) counter++;

                if (counter <= 1 || counter >= 4)
                    mat[i][j] = 0;
                else if (counter >= 3)
                    mat[i][j] = 1;
            }
        }

        printmat(mat);
    }
}
