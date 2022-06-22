/**
 * Creates a framework for ClockNode
 * to be used in a linked list.
 * 
 * @author Christopher Hardy
 *
 */
public class ClockNode {
    protected Clock data;
    protected ClockNode next;
    
    public ClockNode(Clock c) {
        data = c;
        next = null;
    } // Constructor
} // class ClockNode
