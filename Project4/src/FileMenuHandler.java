import javax.swing.*;
import java.awt.event.*;
import java.io.*;

/**
 * Creates a file menu handler which lets you 
 * choose between files to run through the program
 * 
 * @author Christopher Hardy
 *
 */


public class FileMenuHandler implements ActionListener {
   JFrame jframe;
   static String fileName;
   
   /**
    * One argument constructor creates JFrame
    * 
    * @param jf
    */
   public FileMenuHandler (JFrame jf) {
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
      if (menuName.equals("Open")) {
          JFileChooser choose = new JFileChooser("./");
          choose.setFileSelectionMode(JFileChooser.FILES_ONLY);
          choose.showOpenDialog(null);
          
          File f = choose.getSelectedFile();
          fileName = f.getAbsolutePath();
          FileGUI.lists(100);
      }
      
      else if (menuName.equals("Quit"))
          System.exit(0);
      
   } // actionPerformed
} // FileMenuHandler