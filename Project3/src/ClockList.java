/**
 * Encapsulates a linked list of <code>Clock</code>.
 * 
 * @author Christopher Hardy
 *
 */

public class ClockList {
    
    // Creates first Dummy Node
    protected ClockNode first = new ClockNode(null);
    
    // Initialize a last Node
    protected ClockNode last;
    
    protected int length;
    
    /**
     * Constructor that initializes an empty ClockList
     */
    public ClockList() {
        
        // Creates an empty list of length 0 
        last = first; // First and last both pointing to null
        length = 0;
    }
    
    /**
     * Appends a Clock object to this LinkedList.
     * 
     * @param clock
     *            the data element to be appended.
     */
    public void append(Clock c) {
        ClockNode newNode = new ClockNode(c);
        
        // loop through ClockNodes in the file
        ClockNode p = first;
        while(p.next != null)
            p=p.next; // pointer
        p.next = newNode; // next node
        last = newNode; // update last
        length++;
    }
    
    /**
     * @return String representation of elements in linked list delimited by a
     *         new line character
     */
    public String toString() { // textArea.append(unsortedList.toString));
        ClockNode p = first.next;
        String returnString = "";
        while (p != null) {
            returnString += p.data + "\n";
            p = p.next;
        }
        return returnString;
    }
    
    
   
}
