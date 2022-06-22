import java.util.StringTokenizer;

public class Project3 {
    
    private static int inputFromFile(String fileName,UnsortedClockList unsort, SortedClockList sort, int size) {
            
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
            
            // Eliminates any lines with less then 3 tolkens.
            // & stores clocks in sorted & unsorted array
            if(cols != 3) {
                --size;
                System.out.println(clock);
                
            } else {
                unsort.add(clock);
                
                sort.add(clock);
            }
            
            //Read Next Line
            line = in.readLine();
        } // While
                
        //Close Input File
        in.close();
        
        return lengthFilled;
    }
    
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
        
        UnsortedClockList unsort = new UnsortedClockList();
        SortedClockList sort = new SortedClockList();
    
    
        //Stores an unsorted array in clock1 & a sorted array in clock2.
        inputFromFile(fileName, unsort, sort, size);
        
        //System.out.println(sort);
        
        //Displays clock1 & clock2.
        new ClockGUI(size, unsort, sort);
    
    }
    
}