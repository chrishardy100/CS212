/*
    This program uses the TextFileInput class to parse a list of integers
    and prints out the even numbers only, replacing the odd numbers with a *.

    @author Christopher Hardy

*/

public class lab7main {

    public static int[][] myArray = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    public static String file = "array.txt";

    public static void main(String[] args) {
        printArray(myArray);
        printArrayEven(myArray);
        System.out.println();
        System.out.println();
        fillArray(file);
    }

    private static void printArray(int[][] theArray) {
        for (int i = 0; i < theArray.length; i++) {
            for (int j = 0; j < theArray[i].length; j++)
                display(theArray[i][j]);
            System.out.println();
        }
    }

    private static void display(int num) {
        System.out.print(num + " ");
    }

    private static void printArrayEven(int[][] theArray) {
        for (int i = 0; i < theArray.length; i++) {
            for (int j = 0; j < theArray[i].length; j++)
                if (theArray[i][j] % 2 == 0) {
                    display(theArray[i][j]);
                } else {
                    System.out.print("* ");
                    ;
                }
            System.out.println();
        }
    }

    public static int[][] fillArray(String myFile) {
        TextFileInput in = new TextFileInput(myFile);
        int row = Integer.parseInt(in.readLine());
        int col = Integer.parseInt(in.readLine());

        int[][] array = new int[row][col];

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                array[r][c] = Integer.parseInt(in.readLine());
                System.out.println(array[r][c]);

            }
        }
        // int array[in.readLine(Integer.parseInt())][in.readLine(Integer.parseInt())] =
        // { }

        return array;
    }
}