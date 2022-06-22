//import java.util.StringTokenizer;



public class Clock {
    private int hours;
    private int mins;
    private int secs;
    
    public Clock(int hours, int mins, int secs) 
    {
        /*
         * This class initilizes 3 properties beloning to the Clock class (hour, mins, secs).
         * the method Clock() sets the properties.
         * Getter and setter methods are produced for all properties.
         * The toString() function prints the Clock in the file format.
         */
        this.hours = hours;
        this.mins = mins;
        this.secs = secs;
    }
    // Getter
    public int gethours() {return hours;}

    // Setter
    public void sethours(int h) {hours = h;}
      
    // Getter
    public int getmins() {return mins;}
    
    // Setter
    public void setmins(int m) {mins = m;}
    
    // Getter
    public int getsecs() {return secs;}
    
    // Setter
    public void setsecs(int s) {secs = s;}
    
    public String toString() {
        return hours + ":" + mins + ":" + secs;
    }//toString

}
