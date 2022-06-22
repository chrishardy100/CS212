/**
 * Uses an add() function to compare and sort ClockNodes
 * and add them to an array.
 * 
 * @author Christopher Hardy
 *
 */
public class SortedClockList extends ClockList {

    public SortedClockList() {
        super();
    } // Constructor
    
    /**
     * Adds a Clock value to a linked list.
     * Tests if the previous value is larger
     * and if so swaps the values
     * 
     * @param b Clock value to be appended
     */
    public void add(Clock b) {
        //The new BoxNode that will be added to the list
        ClockNode tempNode = new ClockNode(b);
        
        //A BoxNode that keeps track of the next node
        ClockNode nextNode = first.next;
        
        //A BoxNode that keeps track of the previous node
        ClockNode prevNode = first;
        
        //Keeps going through the list until there are no more nodes
        while(nextNode!=null) {
            //If the next node has a greater volume than the new node, break out of the loop
            if(nextNode.data.compareTo(tempNode.data) < 1)
                break;
            
            //Otherwise move to the next node and keep track of the previous node as well
            prevNode=nextNode;
            nextNode=nextNode.next;
        }
        
        //Add the new box node to the right position
        prevNode.next = tempNode;
        tempNode.next=nextNode;
    
    }//add

} // SortedClockList
