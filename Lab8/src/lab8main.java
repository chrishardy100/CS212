/*
    This Program reads a list of integers from a text file seperated by commas
    and uses the Tokens class to make tokens out of the integers and prints out
    only the integers.

    @author Christopher Hardy

*/

import java.util.*;

public class lab8main {

    public static void main(String[] args) {
        String file = "array.txt";
        fillArray(file);

    }

    public static int[][] fillArray(String myFile) {
        TextFileInput in = new TextFileInput(myFile);

        StringTokenizer size = new StringTokenizer(in.readLine(), ",");

        int rows = Integer.parseInt(size.nextToken());
        int cols = Integer.parseInt(size.nextToken());
        int[][] array = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            StringTokenizer st = new StringTokenizer(in.readLine(), ",");
            for (int c = 0; c < cols; c++) {
                array[r][c] = Integer.parseInt(st.nextToken());
                System.out.print(array[r][c] + " ");
            }
            System.out.println();

        }

        // int array[in.readLine(Integer.parseInt())][in.readLine(Integer.parseInt())] =
        // { }

        return array;
    }

}
