import javax.swing.*;
import java.awt.GridLayout;

/**
 * this class sets up a JFrame with a grid layout
 * sets up 2 JTextAreas on the left and right side
 * prints the unsorted array on the left and the sorted array on the right.
 * @author chris
 *
 */
public class ClockGUI {
    
    public ClockGUI(int size, UnsortedClockList unsort, SortedClockList sort) {
        
        // Initialize the JFrame with a grid layout
        JFrame frame = new JFrame("Project2");
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
        
        
    }
}