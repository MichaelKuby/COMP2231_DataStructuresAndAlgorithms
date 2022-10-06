import java.util.Arrays;
import java.util.Random;

/**
 * Write a description of class Question3Driver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Question3Driver
{
    public static void main (String[] args)
    {
        Random rand = new Random();
        
        /**
         * Create three lists of size 10, 100, and 1000. 
         */
        
        Integer[] size10 = new Integer[10];
        
        for (int i = 0; i < size10.length; i++)
            size10[i] = rand.nextInt(10000);
        
        Integer[] size100 = new Integer[100];
        
        for (int i = 0; i < size100.length; i++)
            size100[i] = rand.nextInt(10000);
            
        Integer[] size1000 = new Integer[1000];
        
        for (int i = 0; i < size1000.length; i++)
            size1000[i] = rand.nextInt(10000);
        
        /**
         * Create sorted versions of the three lists of size 10, 100, and 1000. 
         */
        
        Integer[] size10sorted = Arrays.copyOf(size10, size10.length);
        Arrays.sort(size10sorted);
        
        Integer[] size100sorted = Arrays.copyOf(size100, size100.length);
        Arrays.sort(size100sorted);
        
        Integer[] size1000sorted = Arrays.copyOf(size1000, size1000.length);
        Arrays.sort(size1000sorted);
        
        /**
         * Sort the size10 RANDOMIZED list with the shellSort, bubbleSort, and bubbleSort2 methods, respectively.
         */
        
        System.out.println("Array size 10 unsorted\n\n");
        
        // Create a duplicate array and sort with shellSort
        Integer[] size10duplicate = Arrays.copyOf(size10, size10.length);
        System.out.println ("Shell sort:");
        Sorting3.shellSort(size10duplicate);
        
        // Create a duplicate array and sort with bubbleSort
        Integer[] size10duplicate2 = Arrays.copyOf(size10, size10.length);
        System.out.println ("\n\nBubble sort:");
        Sorting3.bubbleSort(size10duplicate2);
        
        // Create a duplicate array and sort with bubbleSort2
        Integer[] size10duplicate3 = Arrays.copyOf(size10, size10.length);
        System.out.println ("\n\nBubble sort 2:");
        Sorting3.bubbleSort2(size10duplicate3);
        
        System.out.println("\n\n---------------------------------------------------------------------------- ");
        
        /**
         * Sort the size10 SORTED list with the shellSort, bubbleSort, and bubbleSort2 methods, respectively.
         */
        
        System.out.println("\n\nArray size 10 pre-sorted\n\n");
        
        // Sort the pre sorted array with shellSort
        System.out.println ("Shell sort:");
        Sorting3.shellSort(size10sorted);
        
        // Sort the pre sorted array with bubbleSort
        System.out.println ("\n\nBubble sort:");
        Sorting3.bubbleSort(size10sorted);
        
        // Sort the pre sorted array with bubbleSort2
        System.out.println("\n\nBubble sort 2:");
        Sorting3.bubbleSort2(size10sorted);
        
        System.out.println("\n\n---------------------------------------------------------------------------- ");
        
        /**
         * Sort the size100 RANDOMIZED list with the shellSort, bubbleSort, and bubbleSort2 methods, respectively.
         */
        
        System.out.println("\n\nArray size 100 unsorted\n\n");
        
        // Create a duplicate array and sort with shellSort
        Integer[] size100duplicate = Arrays.copyOf(size100, size100.length);
        System.out.println ("Shell sort:");
        Sorting3.shellSort(size100duplicate);
        
        // Create a duplicate array and sort with bubbleSort
        Integer[] size100duplicate2 = Arrays.copyOf(size100, size100.length);
        System.out.println ("\n\nBubble sort:");
        Sorting3.bubbleSort(size100duplicate2);
        
        // Create a duplicate array and sort with bubbleSort2
        Integer[] size100duplicate3 = Arrays.copyOf(size100, size100.length);
        System.out.println ("\n\nBubble sort 2:");
        Sorting3.bubbleSort2(size100duplicate3);
        
        System.out.println("\n\n---------------------------------------------------------------------------- ");
        
        /**
         * Sort the size100 SORTED list with the shellSort, bubbleSort, and bubbleSort2 methods, respectively.
         */
        
        System.out.println("\n\nArray size 100 pre-sorted\n\n");
        
        // Sort the pre sorted array with shellSort
        System.out.println ("Shell sort:");
        Sorting3.shellSort(size100sorted);
        
        // Sort the pre sorted array with bubbleSort
        System.out.println ("\n\nBubble sort:");
        Sorting3.bubbleSort(size100sorted);
        
        // Sort the pre sorted array with bubbleSort2
        System.out.println("\n\nBubble sort 2:");
        Sorting3.bubbleSort2(size100sorted);
        
        System.out.println("\n\n---------------------------------------------------------------------------- ");
        /**
         * Sort the size1000 RANDOMIZED list with the shellSort, bubbleSort, and bubbleSort2 methods, respectively.
         */
        
        System.out.println("\n\nArray size 1000 unsorted\n\n");
        
        // Create a duplicate array and sort with shellSort
        Integer[] size1000duplicate = Arrays.copyOf(size1000, size1000.length);
        System.out.println ("Shell sort:");
        Sorting3.shellSort(size1000duplicate);
        
        // Create a duplicate array and sort with bubbleSort
        Integer[] size1000duplicate2 = Arrays.copyOf(size1000, size1000.length);
        System.out.println ("\n\nBubble sort:");
        Sorting3.bubbleSort(size1000duplicate2);
        
        // Create a duplicate array and sort with bubbleSort2
        Integer[] size1000duplicate3 = Arrays.copyOf(size1000, size1000.length);
        System.out.println ("\n\nBubble sort 2:");
        Sorting3.bubbleSort2(size1000duplicate3);
        
        System.out.println("\n\n---------------------------------------------------------------------------- ");
        
        /**
         * Sort the size1000 SORTED list with the shellSort, bubbleSort, and bubbleSort2 methods, respectively.
         */
        
        System.out.println("\n\nArray size 1000 pre-sorted\n\n");
        
        
        // Sort the pre sorted array with shellSort
        System.out.println ("Shell sort:");
        Sorting3.shellSort(size1000sorted);
        
        // Sort the pre sorted array with bubbleSort
        System.out.println ("\n\nBubble sort:");
        Sorting3.bubbleSort(size1000sorted);
        
        // Sort the pre sorted array with bubbleSort2
        System.out.println("\n\nBubble sort 2:");
        Sorting3.bubbleSort2(size1000sorted);
        
        System.out.println("\n\n---------------------------------------------------------------------------- ");
    }
}
