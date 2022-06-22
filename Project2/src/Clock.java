/**
 * This class sets up a template for the Clock type.
 * it stores values for hours, mins and secs
 * @author chris
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
        this.hours = hours;
        this.mins = mins;
        this.secs = secs;
    }
    
    /*
     * public int gethours() { return hours; }public void sethours(int h) { hours =
     * h; }public int getmins() { return mins; }public void setmins(int m) { mins =
     * m; }public int getsecs() { return secs; }public void setsecs(int s) { secs =
     * s; }
     */
    
    /**
     * @return String representation of a Clock object
     */
    public String toString() {
        //String[] string = {Integer.toString(hours), ":", Integer.toString(mins), ":", Integer.toString(secs)}
        return (Integer.toString(hours) + ":" + Integer.toString(mins) + ":" + Integer.toString(secs));
    }
    
    /**
     * 
     * @param c
     * @return int that tells us if the new value is greater then the tested value;
     * 
     */
    public int compareTo(Clock c) {
        if (hours > c.hours) 
            return 1;
        else
            return 0;
    }
    
    

}
