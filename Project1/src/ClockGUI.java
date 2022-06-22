import javax.swing.*;
import java.awt.GridLayout;

/*
 * this class sets up a JFrame ith a grid layout
 * sets up 2 JTextAreas on the left and right side
 * prints the unsorted array on the left and the sorted array on the right.
 */
public class ClockGUI {
    
    public ClockGUI(Clock[] array1, Clock[] array2, int size) {
        
        JFrame frame = new JFrame("Project1");
        frame.setLayout(new GridLayout(1, 2));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(100,100);
        frame.setLocation(200,200);

        
        JTextArea unsorted = new JTextArea(5,20);
        unsorted.setEditable(false);
        frame.getContentPane().add(unsorted);
        
        unsorted.setText("Unsorted: " + " \n");
        for(int i = 0; i < size; i++) {
            unsorted.append(array1[i] + "\n");
        }


        JTextArea sorted = new JTextArea(5,20);
        sorted.setEditable(false);
        frame.getContentPane().add(sorted);
        sorted.setText("Sorted: " + " \n");
        
        for(int i = 0; i < size; i++) {
            sorted.append(array2[i] + "\n");
        }
        
        frame.pack();
        frame.setVisible(true);
        
        
    }
}