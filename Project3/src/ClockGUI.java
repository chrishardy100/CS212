import javax.swing.*;
import java.awt.GridLayout;
import java.util.StringTokenizer;

/**
 * this class sets up a JFrame with a grid layout sets 
 * up 2 JTextAreas on the left and right side prints the 
 * unsorted array on the left and the sorted array on the right.
 * 
 * @author Christopher Hardy
 *
 */
public class ClockGUI extends JFrame{
    
    static String fileName;
    static UnsortedClockList unsort = new UnsortedClockList();
    static SortedClockList sort = new SortedClockList();
    
    
    /**
     * Creates a gui that displays the sorted 
     * and unsorted lists
     * 
     * @param size Size of input file
     * @param unsort
     * @param sort
     */
    
    public ClockGUI(String title, int height, int width) {
        
        setTitle(title);
        setSize(height,width);
       setLocation  (400,200);
        createFileMenu();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
       setVisible(true);
       
       
       
    } // Constructor
    
    /**
     * Creates a menu with JMenuBar and uses 
     * FileMenuHandler to implement actions 
     * preformed.
     */
    private void createFileMenu( ) {
        JMenuItem   item;
        JMenuBar    menuBar  = new JMenuBar();
        JMenu       fileMenu = new JMenu("File");
        
        FileMenuHandler fmh  = new FileMenuHandler(this);

        item = new JMenuItem("Open");    //Open...
        item.addActionListener( fmh );
        fileMenu.add( item );

        fileMenu.addSeparator();           //add a horizontal separator line
      
        item = new JMenuItem("Quit");       //Quit
        item.addActionListener( fmh );
        fileMenu.add( item );

        setJMenuBar(menuBar);
        menuBar.add(fileMenu);
    } //createMenu
    
    
    /**
     * Grabs the fileName from FileMenuHandler and then implements
     * the sorted and unsorted array in a JFrame
     */
    public static void lists() {
        
        fileName = FileMenuHandler.fileName;
        
        
        //Stores an unsorted array in clock1 & a sorted array in clock2.
        inputFromFile(fileName, unsort, sort);
        
        
        
        // Initialize the JFrame with a grid layout
        JFrame frame = new JFrame("Project3");
        frame.setLayout(new GridLayout(1, 2));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(100,100);
        frame.setLocation(200,200);
        
        // Initialize left JTextArea unsorted
        JTextArea unsorted = new JTextArea(5,20);
        unsorted.setEditable(false);
        frame.getContentPane().add(unsorted);
        unsorted.setText("Unsorted: " + " \n");
        
        // add the UnsortedClockList to the text area in String format
        unsorted.append(unsort.toString());
        
        // Initialize right JTextArea sorted
        JTextArea sorted = new JTextArea(5,20);
        sorted.setEditable(false);
        frame.getContentPane().add(sorted);
        sorted.setText("Sorted: " + " \n");
        
        // add the SortedClockList to the text area in String format
        sorted.append(sort.toString());

        frame.pack();
        frame.setVisible(true);
    } // lists
    
    /**
     * Reads lines from selected file and stores them
     * in and unsorted and sorted array.
     * 
     * @param fileName
     * @param unsort
     * @param sort
     * 
     */
    private static void inputFromFile(String fileName,UnsortedClockList unsort, SortedClockList sort) {
        
        TextFileInput in = new TextFileInput(fileName);
        
        // Find file size
        int size = getLines(fileName);
        
        int lengthFilled = 0;
        String line = in.readLine();
            
        // Loop Trough File Line by line so the values can be passed to the array one line at a time.
        while (lengthFilled < size  && line != null) {
            try {
        
                StringTokenizer st = new StringTokenizer(line, ":");
                                
                // Array to store tokens in line
                int [] values = new int[3];
                int cols = st.countTokens();
                
                // Converts tokens from string to int and passes into array
                for(int i = 0; i < cols; ++i) {
                    values[i]=Integer.parseInt(st.nextToken(":"));
                } 
                
                
                // Store ints in values[] into a Clock object.
                Clock clock = new Clock(values[0], values[1], values[2]);
                
                //If time is invalid, skip and print line.
                if(cols != 3) {
                    line = in.readLine();
                    System.out.println(clock);
                } 
                
                // Else store line in sort & unsort
                else{
                    unsort.add(clock);
                    sort.add(clock);
                }
            }
            
            catch(IllegalClockException e) {
                System.out.println(e.getMessage() + ": " + line);
            }
            
            // Next Line
            line = in.readLine();
            lengthFilled++;
            
        } // While
                
        in.close();
        
    } // inputFromFile
    

    /**
     * Counts the number of lines in a file.
     * 
     * @param filename
     * @return File Size
     */
    private static int getLines(String filename) { 
        TextFileInput in = new TextFileInput(filename); 
        int counter = 0; 
        String line = in.readLine();
        while(line != null){
            line = in.readLine();
            counter++;
        }
        return counter;
        
    } // getLines
    
}