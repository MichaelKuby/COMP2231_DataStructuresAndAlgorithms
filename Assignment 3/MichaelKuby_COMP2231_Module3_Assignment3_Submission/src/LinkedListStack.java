import jsjf.exceptions.EmptyCollectionException;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * LinkedListStack represents a LinkedList implementation of a stack collection.
 *
 * @author MichaelKuby
 * @version January 26, 2022
 */
public class LinkedListStack<T> implements StackADT<T>, Iterable<T>
{
    private LinkedList<T> stack;
    private int modCount;

    /**
     * Creates an empty stack collection using a LinkedList
     */
    public LinkedListStack()
    {
        stack = new LinkedList<T>();
        modCount = 0;
    }

    /**
     * Adds the specified element to the top of this stack.
     * @param element element to be pushed onto the stack
     */
    public void push(T element)
    {
        stack.push(element);
        modCount++;
    }

    /**
     * Removes and returns the top element from this stack.
     * @return the element removed from the stack
     * @throws EmptyCollectionException
     */
    public T pop()
    {
        if (isEmpty())
            throw new EmptyCollectionException("stack");

        modCount++;
        return stack.pop();
    }

    /**
     * Returns without removing the top element of this stack.
     * @return the element on top of the stack
     */
    public T peek()
    {
        return stack.peek();
    }

    /**
     * Returns true if this stack contains no elements.
     * @return true if the stack is empty
     */
    public boolean isEmpty()
    {
        return (stack.isEmpty());
    }

    /**
     * Returns the number of elements in this stack.
     * @return the number of elements in the stack
     */
    public int size()
    {
        return stack.size();
    }

    /**
     * Returns a string representation of this stack.
     * @return a string representation of this stack
     */
    public String toString()
    {
        String result = "";
        for (int scan = size()-1; scan >=0; scan--)
            result += stack.get(scan) + " ";
        return result;
    }

    /**
     * Returns an iterator for the elements in this list.
     *
     * @return an iterator over the elements of the list
     */
    public Iterator<T> iterator()
    {
        return new LinkedListIterator();
    }

    /**
     * LinkedIterator represents an iterator for a linked list of linear nodes.
     */
    private class LinkedListIterator implements Iterator<T>
    {
        private int iteratorModCount;
        private int current;

        /**
         * Sets up this iterator using the specified items.
         *
         * Collection: the collection the iterator will move over
         * Size: the integer size of the collection
         */
        public LinkedListIterator()
        {
            iteratorModCount = modCount;
            current = size()-1;
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

            return (current >= 0);
        }

        /**
         * Returns the next element in the iteration. If there are no
         * more elements in this iteration, a NoSuchElementException is
         * thrown.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iterator is empty
         */
        public T next()
        {
            if (!hasNext())
                throw new ConcurrentModificationException();

            current--;

            return stack.get(current +1);
        }

        /**
         * The remove operation is not supported.
         *
         * @throws UnsupportedOperationException if the remove operation is called
         */
        public void remove() throws UnsupportedOperationException
        {
            throw new UnsupportedOperationException();
        }
    }
}
