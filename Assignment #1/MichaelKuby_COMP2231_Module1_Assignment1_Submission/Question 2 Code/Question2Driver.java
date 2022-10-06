import java.util.Random;
import java.util.Arrays;

/**
 * Tests the bubbleSort and BubbleSort2 methods contained in the Sorting class.
 * Includes outputs of the array for both sorts for each pass through the array
 * to show that the code is working correctly. Uses a random set of 10 integers and an
 * already sorted set of 10 integers.
 * 
 * @author Michael Kuby
 * @version Thu Jan 13, 2022
 */
public class Question2Driver
{
    public static void main (String[] args)
    {
        System.out.println ("Start Program\n");
        
        /**
         * Sorting an already sorted set of integers with the original bubbleSort method.
         */
        
        Integer[] sorted = {0, 10, 20, 30, 40, 50, 60, 70, 80, 90};
        
        System.out.print ("Starting sorted array: ");
        for (int i = 0; i < sorted.length; i++)
        {
            System.out.print (sorted[i] + " ");
        }
        
        System.out.println ("\n\nShowing passes with the bubbleSort method: \n");
        Integer[] copyofsorted = Arrays.copyOf(sorted, sorted.length);
        Sorting2.bubbleSort(copyofsorted);
        
        System.out.print ("\nSorted array after sorting: ");
        for (int i = 0; i < copyofsorted.length; i++)
        {
            System.out.print (copyofsorted[i] + " ");
        }
        System.out.println ("\n\n------------------------------------------------------------------------");
        
        /**
         * Sorting an already sorted set of integers with the more efficient bubbleSort2 method.
         */
        
        System.out.print ("\nStarting sorted array: ");
        for (int i = 0; i < sorted.length; i++)
        {
            System.out.print (sorted[i] + " ");
        }
        
        System.out.println ("\n\nShowing passes with the bubbleSort2 method: \n");
        Integer[] copyofsorted2 = Arrays.copyOf(sorted, sorted.length);
        Sorting2.bubbleSort2(copyofsorted2);
        
        System.out.print ("\nSorted array after sorting: ");
        for (int i = 0; i < copyofsorted2.length; i++)
        {
            System.out.print (copyofsorted2[i] + " ");
        }
        System.out.print ("\n\n------------------------------------------------------------------------");
        
        /**
         * Sorting a random array of 10 integers with the original bubbleSort method.
         */
        
        // create an Integer array with 10 cells and populate it with random elements from 0-99
        Random rand = new Random();
        Integer[] random = new Integer[10];
        
        for (int i = 0; i < random.length; i++)
            random[i] = rand.nextInt(100);
        
        System.out.print ("\n\nStarting random array: ");
        for (int i = 0; i < random.length; i++)
        {
            System.out.print (random[i] + " ");
        }
        
        System.out.println ("\n\nShowing passes with the bubbleSort method: \n");
        Integer[] copyofrandom = Arrays.copyOf(random, random.length);
        Sorting2.bubbleSort(copyofrandom);
    
        System.out.print ("\nRandom array after sorting: ");
        for (int i = 0; i < copyofrandom.length; i++)
        {
            System.out.print (copyofrandom[i] + " ");
        }
        System.out.print ("\n\n------------------------------------------------------------------------");
        
        /**
         * Sorting a random array of 10 integers with the more efficient bubbleSort2 method.
         */
        
        System.out.print ("\n\nStarting random array: ");
        for (int i = 0; i < random.length; i++)
        {
            System.out.print (random[i] + " ");
        }
        
        System.out.println ("\n\nShowing passes with the bubbleSort2 method: \n");
        Integer[] copyofrandom2 = Arrays.copyOf(random, random.length);
        Sorting2.bubbleSort2(copyofrandom2);
    
        System.out.print ("\nRandom array after sorting: ");
        for (int i = 0; i < copyofrandom2.length; i++)
        {
            System.out.print (copyofrandom2[i] + " ");
        }
        System.out.print ("\n\n------------------------------------------------------------------------");
        
        System.out.print ("\n\nEnd.");
    }
}
