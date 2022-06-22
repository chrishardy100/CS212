
public class SortedClockList extends ClockList {

    public SortedClockList() {
        super();
    }
    
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
            if(nextNode.data.compareTo(tempNode.data) > 0)
                break;
            
            //Otherwise move to the next node and keep track of the previous node as well
            prevNode=nextNode;
            nextNode=nextNode.next;
        }
        
        //Add the new box node to the right position
        prevNode.next = tempNode;
        tempNode.next=nextNode;
    
    }//add

    /**
     * Sorts a linked list of ClockNodes
     * 
     * @param c
     */
    
//      public void add(Clock c) { 
//          ClockNode newNode = new ClockNode(c); 
//          ClockNode prev = first; ClockNode curr = first.next;
//          while(curr != null && newNode.data.toString().compareTo(curr.data.toString()) > 0) { 
//              prev = prev.next; 
//              curr = curr.next; 
//          } 
//          newNode.next = curr; 
//          prev.next = newNode; 
//          if(curr == null) last = newNode; 
//          length++; 
//      }
     
             
        
        
        
        
        
        
    

}
