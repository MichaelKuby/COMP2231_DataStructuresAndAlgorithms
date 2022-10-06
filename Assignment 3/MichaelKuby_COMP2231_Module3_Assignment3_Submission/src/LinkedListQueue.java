import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import jsjf.exceptions.EmptyCollectionException;

/**
 * LinkedListQueue represents a LinkedList implementation of a queue collection.
 *
 * @author MichaelKuby
 * @version January 26, 2022
 */
public class LinkedListQueue<T> implements QueueADT<T>, Iterable<T>
{
    private LinkedList<T> queue;
    private int modCount;

    /**
     * Creates an empty queue collection using a LinkedList.
     */
    public LinkedListQueue()
    {
        queue = new LinkedList<>();
        modCount = 0;
    }

    /**
     * Adds one element to the rear of this queue.
     * @param element  the element to be added to the rear of the queue
     */
    public void enqueue(T element)
    {
        queue.addLast(element);
        modCount++;
    }

    /**
     * Removes and returns the element at the front of this queue.
     * @return the element at the front of the queue
     * @throws EmptyCollectionException
     */
    public T dequeue()
    {
        if (isEmpty())
            throw new EmptyCollectionException("queue");

        modCount++;
        return queue.pollFirst();
    }

    /**
     * Returns without removing the element at the front of this queue.
     * @return the first element in the queue
     * @throws EmptyCollectionException
     */
    public T first()
    {
        if (isEmpty())
            throw new EmptyCollectionException("queue");

        return queue.getFirst();
    }

    /**
     * Returns true if this queue contains no elements.
     * @return true if this queue is empty
     */
    public boolean isEmpty()
    {
        return (queue.isEmpty());
    }

    /**
     * Returns the number of elements in this queue.
     * @return the integer representation of the size of the queue
     */
    public int size()
    {
        return queue.size();
    }

    /**
     * Returns a string representation of this queue.
     * @return the string representation of the queue
     */
    public String toString ()
    {
        String result = "";

        for (T element :
                queue)
        {
            result += element + " ";
        }
        return result;
    }

    /**
     * Returns an iterator for the elements currently in this list.
     *
     * @return an iterator for the elements in the list
     */
    public Iterator<T> iterator()
    {
        return new LinkedListIterator();
    }

    /**
     * LinkedListIterator iterator over the elements of LinkedList.
     */
    private class LinkedListIterator implements Iterator<T>
    {
        int iteratorModCount;
        int current;

        /**
         * Sets up this iterator using the specified modCount.
         * modCount set as the current modification count for the ArrayList
         */
        public LinkedListIterator()
        {
            iteratorModCount = modCount;
            current = 0;
        }

        /**
         * Returns true if this iterator has at least one more element
         * to deliver in the iteration.
         *
         * @return  true if this iterator has at least one more element to deliver
         *          in the iteration
         * @throws ConcurrentModificationException if the collection has changed
         *          while the iterator is in use
         */
        public boolean hasNext()
        {
            if (iteratorModCount != modCount)
                throw new ConcurrentModificationException();

            return (current < size());
        }

        /**
         * Returns the next element in the iteration. If there are no
         * more elements in this iteration, a NoSuchElementException is
         * thrown.
         *
         * @return  the next element in the iteration
         * @throws NoSuchElementException if an element not found exception occurs
         * @throws  ConcurrentModificationException if the collection has changed
         */
        public T next()
        {
            if (!hasNext())
                throw new NoSuchElementException();

            current++;

            return queue.get(current -1);
        }

        /**
         * The remove operation is not supported in this collection.
         *
         * @throws UnsupportedOperationException if the remove method is called
         */
        public void remove() throws UnsupportedOperationException
        {
            throw new UnsupportedOperationException();
        }
    }
}
