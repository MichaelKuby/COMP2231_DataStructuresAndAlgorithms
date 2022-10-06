
/**
 * Testing new methods for null values
 *
 * @author Michael Kuby
 * @version 1.0
 */
public class TestingNull
{
    public static void main (String [] args)
    {
        Integer[] empty = null;
        
        Sorting3.shellSort(empty);
        Sorting3.bubbleSort(empty);
        Sorting3.bubbleSort2(empty);
        
    }
}
