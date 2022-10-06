import java.util.Random;

/**
 * HeapSortDriver for testing a heap sort.
 */
public class HeapSortDriver
{
    public static void main (String[] args)
    {
        int size = 10;
        Random rand = new Random();

        Integer[] arrayToBeSorted = new Integer[size];

        for (int i = 0; i < arrayToBeSorted.length; i++)
            arrayToBeSorted[i] = rand.nextInt(100);

        System.out.println("Starting randomized array: ");
        for (int i = 0; i < arrayToBeSorted.length; i++)
            System.out.println(arrayToBeSorted[i]);

        HeapSort<Integer> sort = new HeapSort<>();
        sort.heapSort(arrayToBeSorted);

        System.out.println();

        System.out.println("HeapSorted randomized array: ");
        for (int i = 0; i < arrayToBeSorted.length; i++)
            System.out.println(arrayToBeSorted[i]);

        String[] arrayToBeSorted2 = {"a", "b", "b", "c", "c", "c", "c",
                "d", "d", "d", "d", "d", "d", "d", "d", "d",};

        System.out.println();

        System.out.println("Starting sorted string array: ");
        for (int i = 0; i < arrayToBeSorted2.length; i++)
            System.out.println(arrayToBeSorted2[i]);

        HeapSort<String> sort2 = new HeapSort<>();
        sort2.heapSort(arrayToBeSorted2);

        System.out.println();

        System.out.println("HeapSorted string array: ");
        for (int i = 0; i < arrayToBeSorted2.length; i++)
            System.out.println(arrayToBeSorted2[i]);
    }
}
