import java.util.Random;

/**
 * Driver for Sorting class. Creates an Integer array using an initializer list, 
 * and two additional random sets of 10 and 20 integers.
 *
 * @author Michael Kuby
 * @version Thursday January 13, 2022
 */
public class Question1Driver
{
    public static void main (String[] args)
    {
        /**
         * Create an array of Integer objects with an initializer list of particular
         * values, sorts the array using the Shell Sort algorithm, printing the 
         * array each time a swap takes place. Prints the sorted array.
         */
        
        Integer[] first = {9, 6, 8, 12, 3, 1, 7};
        
        System.out.print ("Starting array: ");
        
        for (int i = 0; i < first.length; i++)
        {
            System.out.print (first[i] + " ");
        }            
        
        System.out.println ("\n\nSorting: ");
        
        Sorting.shellSort(first);
    
        System.out.print ("\nSorted array: ");
        
        for (int i = 0; i < first.length; i++)
        {
            System.out.print (first[i] + " ");
        }
        
        /**
         * Create an array of 10 Integer objects with a random generator.
         * Sort the list using the Shell Sort algorithm, printing the array
         * each time a swap takes place. Prints the sorted array.
         */
        
        Random rand = new Random();
        
        Integer[] second = new Integer[10];
        
        for (int i = 0; i < second.length; i++)
        {
            second[i] = rand.nextInt(100);
        }
        
        System.out.print ("\n\nStarting array: ");
        
        for (int i = 0; i < second.length; i++)
        {
            System.out.print (second[i] + " ");
        }
        
        System.out.println ("\n\nSorting: ");
        
        Sorting.shellSort(second);
    
        System.out.print ("\nSorted array: ");
        
        for (int i = 0; i < second.length; i++)
        {
            System.out.print (second[i] + " ");
        }
        
        /**
         * Create an array of 20 Integer objects with a random generator.
         * Sort the list using the Shell Sort algorithm, printing the array
         * each time a swap takes place. Prints the sorted array.
         */
        
        Integer[] third = new Integer[20];
        
        for (int i = 0; i < third.length; i++)
        {
            third[i] = rand.nextInt(1000);
        }
        
        System.out.print ("\n\nStarting array: ");
        
        for (int i = 0; i < third.length; i++)
        {
            System.out.print (third[i] + " ");
        }
        
        System.out.println ("\n\nSorting: ");
        
        Sorting.shellSort(third);
    
        System.out.print ("\nSorted array: ");
        
        for (int i = 0; i < third.length; i++)
        {
            System.out.print (third[i] + " ");
        }
    }
}
