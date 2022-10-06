/**
 * HeapSort sorts a given array of Comparable objects by building a heap in place.
 *
 * @author MichaelKuby
 * @version Feb 22, 2022
 */
public class HeapSort<T>
{
    /**
     * Sorts a given array into a minheap.
     */
    public void heapSort(T[] data)
    {
        // find the first internal node
        int focusNode = (data.length - 2) / 2;

        minHeapSort(data, focusNode);
    }

    /**
     * Recursively sorts the specified array by turning it into a minheap.
     * Starting with the first internal node in the array, we compare it
     * to its children, swapping if necessary. If a parent node is swapped
     * with a child, we recursively call the method on the minheap below.
     * We work backward through the array until we reach the root.
     *
     * @param data the array of objects to be sorted into a heap
     * @param focusNode the parent node that is in focus
     */
    private void minHeapSort(T[] data, int focusNode)
    {
        if (focusNode < 0)
            return;

        int parent = focusNode, left = (2 * focusNode) +1, right = (2 * focusNode) + 2,
                internalNodeCutoff = (data.length - 2) / 2, smallest;

        // Compare the children to find the smaller of the two
        if (left < data.length && right < data.length)
            if (((Comparable<T>)data[left]).compareTo(data[right]) > 0)
                smallest = right;
            else
                smallest = left;
        else if (left < data.length)
            smallest = left;
        else
            smallest = parent;

        // If the smallest of the two children is smaller than the parent, swap
        if (((Comparable<T>)data[smallest]).compareTo(data[parent]) < 0)
        {
            swap(smallest, parent, data);

            // If we have swapped with an internal node, we need to recursively
            // call minHeapSort on the heap below.
            if (smallest <= internalNodeCutoff)
                minHeapSort(data, smallest);
        }
        focusNode--;
        minHeapSort(data, focusNode);
    }

    /**
     * Swaps the two prescribed elements locations in the given binary tree array.
     *
     * @param swap the child node
     * @param parent the parent node
     * @param data array in which the data reside.
     */
    private void swap(int swap, int parent, T[] data)
    {
        T temp = data[parent];
        data[parent] = data[swap];
        data[swap] = temp;
    }
}