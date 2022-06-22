import javax.swing.*;
import java.awt.GridLayout;
import java.util.*;

/**
 * FileGUI(); This class sets up a JFrame with a JMenuBar that allows 
 * you to open a file or quit. This is done with the 
 * constructor. 
 * 
 * inputFromFile(); Uses to read from any file of clocks.
 * 
 * lists(); Displays 2 JTextAreas which print the unsorted array 
 * on the left and the sorted array on the right.
 * 
 * @author Christopher Hardy
 *
 */
    public class FileGUI extends JFrame{
        private static String fileName;


    
    /*
     * FileGui          (title, height, width);
     * createFileMenu   ();
     * lists            ();
     * listGUI          ();
     * inputFromFile    ();
     * getLines         ();
     */
    
    /**
     * Creates a JFrame that will use a JMenuBar using createFileMenu();
     * 
     * @param size Size of input file
     * @param unsort
     * @param sort
     */
     public FileGUI(String title, int height, int width) {
        
        setTitle(title);
        setSize(height,width);
       setLocation  (400,200);
        createFileMenu();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
       setVisible(true);
       
    } // Constructor
    
    /**
     * Creates a menu with JMenuBar and uses 
     * FileMenuHandler & EditMenuHandler to
     * select and edit files
     */
    private void createFileMenu( ) {
        
        // Menu Bar setup
        JMenuItem   item;
        JMenuBar    menuBar  = new JMenuBar();
        JMenu       fileMenu = new JMenu("File");
        JMenu       editMenu = new JMenu("Edit");
        
        FileMenuHandler fmh  = new FileMenuHandler(this);
        EditMenuHandler emh  = new EditMenuHandler(this);
        
                                        // File Menu
        item = new JMenuItem("Open");
        item.addActionListener( fmh );
        fileMenu.add( item );

        fileMenu.addSeparator();
      
        item = new JMenuItem("Quit");       
        item.addActionListener( fmh );
        fileMenu.add( item );
        
                                      // Edit Menu
        item = new JMenuItem("Search");
        item.addActionListener( emh );
        editMenu.add( item );

        setJMenuBar(menuBar);
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
    
    } //createMenu
    
    /**
     * Grabs the fileName from FileMenuHandler,
     * Uses inputFromFile() to store Clocks in UnsortedClockList & TreeMap,
     * Passes unsort & map to listsGUI();
     * 
     */
    public static void lists(int max) {
        fileName = FileMenuHandler.fileName;

        // TreeMap & UnsortedClockList init
        UnsortedClockList unsort = new UnsortedClockList();
        TreeMap <Clock, Integer> map = new TreeMap<Clock, Integer>(new ClockComparator());

        
        //Stores an unsorted array in clock1 & a sorted array in clock2.
        inputFromFile(fileName, unsort, map);
        
        listsGUI(max, unsort, map);
        
    } // lists
    

    
    
    /**
     * Creates a JFrame that will list 
     * UnsortedClockList & SortedTreeMap
     */
    private static void listsGUI(int max, UnsortedClockList unsort, TreeMap map) {
     // Initialize the JFrame with a grid layout
        JFrame frame = new JFrame("Project 4");
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
        
        
// TEST <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        
        // Initialize left JTextArea sorted TreeMap
        JTextArea tree = new JTextArea(5,20);
        tree.setEditable(false);
        frame.getContentPane().add(tree);
        tree.setText("Sorted Map: " + " \n");
        
        // add the UnsortedClockList to the text area in String format
        
        Set set = map.entrySet();
        Iterator i = set.iterator();
        Map.Entry <Clock,Integer> me;

        while(i.hasNext()) { 
           me = (Map.Entry)i.next();
           if(me.getValue() > max)
               break;
           tree.append(me.getKey().toString() + "\n");
            
        } 
//        for(Clock key : map.keySet())
//            tree.append(key.toString() + "\n");
        
// END ==============================================================================================================
        

        frame.pack();
        frame.setVisible(true);
        
    }
    
    /**
     * Reads lines from selected file and stores them
     * in a UnsortedClockList & SortedTreeMap
     */
    private static void inputFromFile(String fileName,UnsortedClockList unsort, TreeMap map) {
        
        TextFileInput in = new TextFileInput(fileName);
        
        // Find file size
        int size = getLines();
        
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
                for(int i = 0; i < cols; ++i) 
                    values[i]=Integer.parseInt(st.nextToken(":"));
                
                // Store ints in values[] into a Clock object.
                Clock clock = new Clock(values[0], values[1], values[2]);
                
                //If time is invalid, skip and print line.
                if(cols == 3) {
                    
                    unsort.add(clock);
// TEST <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                    
                    map.put(clock, values[0]);
                    
// END =============================================================================================
                    
                } 
                
                // Else store line in sort & unsort
                else
                    System.out.println(clock);
                    
                
            }
            
            catch(IllegalClockException e) {
                System.out.println(e.getMessage() + ": " + line);
            }
            
            // Next Line
            line = in.readLine();
            lengthFilled++;
            
        } // While
 // TEST <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 
        
        System.out.println(map);
       

        
 // END ==========================================================================================

                
        in.close();
        
    } // inputFromFile
    
    /**
     * Counts the number of lines in a file.
     * 
     * @param filename
     * @return File Size
     */
    private static int getLines() { 
        TextFileInput in = new TextFileInput(fileName); 
        int counter = 0; 
        String line = in.readLine();
        while(line != null){
            line = in.readLine();
            counter++;
        }
        return counter;
        
    } // getLines
    
}