import java.util.StringTokenizer;

/*
 * The main method calls getLines() which stores the size of the file.
 * The main method initializes 2 arrays of type Clock[] clock1 & clock2.
 * The main method calls inputFromFile() which uses TextFileInput() to read the lines in fileName.
 * inputFromFile() then parses the fileName lines to integer and stores them in clock1 & clock2.
 * inputFromFile() then returns the number of lines filled in the array.
 * The main method then calls selectionSort() which sorts an array of Clocks by hours.
 * The main method uses the class ClockGUI() to print the sorted & unsorted arrays.
 */

public class Project1 {
    
    private static int inputFromFile(String fileName, Clock[] clock1, Clock[] clock2, int size) {
        
        //Open Input File
        TextFileInput in = new TextFileInput(fileName);
        int lengthFilled = 0;
        String line = in.readLine();
            
        //Loop Trough File Line by line so the values can be passed to the array one line at a time.
        while (lengthFilled < size  && line != null) {
        
            //Create Tokenizer object
            StringTokenizer st = new StringTokenizer(line, ":");
                            
            //Initialize Array for Int Times
            int [] values = new int[3];
            int cols = st.countTokens();
            
            //Converts tokens from string to int and passes into array
            for(int i = 0; i < cols; ++i) {
                values[i]=Integer.parseInt(st.nextToken(":"));
            } 
            
            //Store ints in values[] into a Clock object.
            Clock clock = new Clock(values[0], values[1], values[2]);
            
            //Eliminates any lines with less then 3 tolkens.
            if(cols < 3) {
                System.out.println(clock);
                --size;
            } else {
                clock1[lengthFilled] = clock;
                clock2[lengthFilled] = clock;
                ++lengthFilled;
            }  
            
            //Read Next Line
            line = in.readLine();
        } // While
                
        //Close Input File
        in.close();
        
        return lengthFilled;
    }
    
    //Uses the selection sorting method to sort an array of Clocks
    private static void selectionSort (Clock[] array, int length) { 
        
        //Find the Smalles value
        for ( int i = 0; i < length; i++ ) { 
            int indexLowest = i; 
            for ( int j = i + 1; j < length; j++ ) {
                if ( array[j].gethours() < array[indexLowest].gethours() ) {
                    indexLowest = j;
                }
            }
            
            //Swap the smallest value with the current index
            if ( array[indexLowest] != array[i] ) { 
                Clock temp = new Clock(array[indexLowest].gethours(), array[indexLowest].getmins(), array[indexLowest].getsecs());
                array[indexLowest] = array[i]; 
                array[i] = temp; 
            }  // if
            
        } 
    }
        
    
    //Finds number of lines in the file
    private static int getLines(String filename) { 
        TextFileInput in = new TextFileInput(filename); 
        int counter = 0; 
        String line = in.readLine();
        while(line != null){
            line = in.readLine();
            counter++;
        }
        return counter;
    }
    
    public static void main(String[] args) {

        //time.txt is in the project folder
        String fileName = "time.txt";
        
        //Stores String Lines In File To Array;
        int size = getLines(fileName);
        
        //Initializes Array of Clock Objects
        Clock[] clock1 = new Clock[size];
        Clock[] clock2 = new Clock[size];
        
        //Stores an unsorted array in clock1 & a sorted array in clock2.
        size = inputFromFile(fileName, clock1, clock2, size);
        
        selectionSort(clock2, size);

        
        //Displays clock1 & clock2.
        new ClockGUI(clock1, clock2, size);
        
    }
    
}
