/**
 * Stores the file in an unsorted
 * Linked list
 * 
 * @author Christopher Hardy
 *
 */
public class UnsortedClockList extends ClockList {
    
    public UnsortedClockList(){
        
    } // Constructor
    
    /**
     * appends a clock object to the end of an unsorted list
     * @param c
     */
    public void add(Clock c) {
        
        //Inherits from ClockList
        append(c);
    }
    

}
