import jsjf.exceptions.EmptyCollectionException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ArrayListStack represents an ArrayList implementation of a Stack.
 *
 * @author MichaelKuby
 * @version January 26, 2022
 */
public class ArrayListStack<T> implements StackADT<T>, Iterable<T>
{
    private int top, modCount;
    private ArrayList<T> stack;

    /**
     * Creates an empty Stack using the default ArrayList capacity of 10.
     */
    public ArrayListStack()
    {
        stack = new ArrayList<T>();
        top = modCount = 0;
    }

    /**
     * Creates an empty Stack using a specified capacity.
     *
     * @param capacity the specified capacity of the stack.
     */
    public ArrayListStack(int capacity)
    {
        stack = new ArrayList<T>(capacity);
        top = modCount = 0;

    }

    /**
     * Adds the specified element to the top of this stack.
     * @param element element to be pushed onto the stack
     */
    public void push(T element)
    {
        stack.add(element);
        top++;
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

        top--;
        modCount++;
        return stack.remove(top);
    }

    /**
     * Returns without removing the top element of this stack.
     * @return the element on top of the stack
     * @throws EmptyCollectionException if the stack is empty.
     */
    public T peek()
    {
        if (isEmpty())
            throw new EmptyCollectionException ("stack");

        return stack.get(top-1);
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
     * @return a string representation of the stack
     */
    public String toString()
    {
        String result = "";
        for (int scan = 0; scan < top; scan++)
        {
            result += stack.get(scan) + " ";
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
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<T>
    {
        int iteratorModCount;
        int current;

        /**
         * Sets up this iterator using the specified modCount.
         * modCount set as the current modification count for the ArrayList
         */
        public ArrayListIterator()
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
         * @throws  ConcurrentModificationException if the collection has changed
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

            return stack.get(current-1);
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
