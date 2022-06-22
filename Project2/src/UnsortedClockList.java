
public class UnsortedClockList extends ClockList {
    
    public UnsortedClockList(){
        
    }
    
    /**
     * appends a clock object to the end of an unsorted list
     * @param c
     */
    public void add(Clock c) {
        
        //inherits from ClockList
        append(c);
    }
    

}
