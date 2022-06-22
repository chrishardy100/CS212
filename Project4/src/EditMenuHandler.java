import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


import javax.swing.JOptionPane;

public class EditMenuHandler implements ActionListener {
    JFrame jframe;
    static String fileName;
    
    /**
     * One argument constructor creates JFrame
     * 
     * @param jf
     */
    public EditMenuHandler (JFrame jf) {
       jframe = jf;
    }
    
    /**
     * Tests what action is done with in
     * the menu bar
     * 
     * @param event inputs event
     */
    public void actionPerformed(ActionEvent event) {
       String menuName = event.getActionCommand();
       if (menuName.equals("Search")) {
           
           try {
               String s = JOptionPane.showInputDialog(null, "Enter an Hour Value: ");
               
               int hour = Integer.parseInt(s);
               
               if (hour > 23)
                   throw new IllegalClockException(s);
               
               FileGUI.lists(hour);
               
           }
           catch(NumberFormatException e){
               JOptionPane.showMessageDialog(null, "Enter a number");
               
           }
           catch(IllegalClockException x) {
               JOptionPane.showMessageDialog(null, "Enter a valid number");
           }
       }
       
       
       
    } // actionPerformed
    

 } // FileMenuHandler