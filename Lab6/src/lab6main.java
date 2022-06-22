/*  
    This program parses a file of integers, stores them in an array, and
    finds the sum as well as the average
    
    @author Christopher Hardy
*/
public class lab6main {

    public static void main(String[] args) {
        // text.txt is in the project folder
        String fileName = "text.txt";
        int[] array = new int[getLines(fileName)];
        int size = getLines(fileName);

        inputFromFile(fileName, array);

        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + ", ");
        }

        System.out.println();
        System.out.println("SUM: " + sum(array, size));
        System.out.println("AVE: " + ave(array, size));
    }

    private static int getLines(String filename) {
        TextFileInput in = new TextFileInput(filename);
        int counter = 0;
        String line = in.readLine();
        while (line != null) {
            line = in.readLine();
            counter++;
        }
        return counter;
    }

    private static int inputFromFile(String filename, int[] nums) {
        TextFileInput in = new TextFileInput(filename);
        int lengthFilled = 0;
        String line = in.readLine();
        while (lengthFilled < nums.length && line != null) {
            int x = Integer.parseInt(line);

            nums[lengthFilled++] = x;
            line = in.readLine();

        }
        if (line != null) {
            System.out.println("File contains too many numbers.");
            System.out.println("This program can process only " + nums.length + " numbers.");
            System.exit(1);
        }
        in.close();
        return lengthFilled;
    }

    public static int sum(int[] nums, int size) {
        int sum = 0;
        for (int i = 0; i < size; ++i) {
            sum += nums[i];
        }
        return sum;

    }

    public static int ave(int[] nums, int size) {
        return sum(nums, size) / size;
    }

}
