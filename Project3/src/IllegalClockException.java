/**
 * Creates an IlligalArgumentException for
 * invalid Clocks
 * 
 * @author Christopher Hardy
 *
 */
public class IllegalClockException extends IllegalArgumentException
{
    public IllegalClockException(String s)
    {
        super(s);
    }
}