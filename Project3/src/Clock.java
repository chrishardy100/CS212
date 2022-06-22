/**
 * This class sets up a template for the Clock type.
 * it stores values for hours, mins and secs
 * @author Christopher Hardy
 *
 */

public class Clock {
    private int hours;
    private int mins;
    private int secs;
    
    /**
     * Constructor takes line tokens and creates
     * a clock object out of them
     * @param hours
     * @param mins
     * @param secs
     */
    
    public Clock(int hours, int mins, int secs) 
    {
        //exception handler
        if(hours > 23 || mins > 59 || secs > 59) 
            throw new IllegalClockException("invalid");
          
        this.hours = hours;
        this.mins = mins;
        this.secs = secs;
    }
    
    
    /**
     * @return String representation of a Clock object
     */
    public String toString() {
        //String[] string = {Integer.toString(hours), ":", Integer.toString(mins), ":", Integer.toString(secs)}
        return (Integer.toString(hours) + ":" + Integer.toString(mins) + ":" + Integer.toString(secs));
    }
    
    /**
     * Retuerns one if tested value is greater
     * @param c
     * @return int that tells us if the new value is greater then the tested value;
     * 
     */
    public int compareTo(Clock c) {
        if (hours > c.hours) 
            return 0;
        else
            return 1;
    }
    
    

}
