import jsjf.exceptions.*;

/**
 * Represents a linked implementation of a drop-out stack.
 *
 * @author Michael Kuby
 * @version January 19, 2022
 */
public class DropOutStack<T> implements StackADT<T>
{
    private final static int DEFAULT_CAPACITY = 100;
    private int capacity;
    private int count;  
    private LinearNode<T> top; 

    /**
     * Creates an empty drop-out stack using the default capacity.
     */
    public DropOutStack()
    {
        this(DEFAULT_CAPACITY);
    }
    
    /**
     * Creates an empty drop-out stack using a custom capacity.
     */
    public DropOutStack(int capacity)
    {
        count = 0;
        top = null;
        this.capacity = capacity;
    }
    
    /**
     * Adds the specified element to the top of this stack.
     * @param element element to be pushed on stack
     */
    public void push(T element)
    {
        // Check to see if the drop out stack is full. If it is, traverse the list 
        // to the node at the bottom + 1 and set its next reference to null.
        if (size() == capacity)
        {
            LinearNode<T> current = top;
            
            for (int index = 1; index < capacity-1; index++)
                current = current.getNext();
                
            current.setNext(null);
            count--;
        }
        
        LinearNode<T> temp = new LinearNode<T>(element);

        temp.setNext(top);
        top = temp;
        count++;
    }

    /**
     * Removes the element at the top of this stack and returns a
     * reference to it. 
     * @return element from top of stack
     * @throws EmptyCollectionException if the stack is empty
     */
    public T pop() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("stack");
    
        T result = top.getElement();
        top = top.getNext();
        count--;
    
        return result;
    }
    
    /**
     * Returns a reference to the element at the top of this stack.
     * The element is not removed from the stack.  
     * @return element on top of stack
     * @throws EmptyCollectionException if the stack is empty  
     */
    public T peek() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("stack");
        
        return top.getElement();    
    }
    
    /**
     * Returns true if this stack is empty and false otherwise. 
     * @return true if stack is empty
     */
    public boolean isEmpty()
    {
        return (count == 0);
    }
    
    /**
     * Returns the number of elements in this stack.
     * @return number of elements in the stack
     */
    public int size()
    {
        return count;
    }
    
    /**
     * Returns a string representation of this stack. 
     * @return string representation of the stack
     */
    public String toString()
    {
        String result = "";
        LinearNode current = top;
        
        while (current != null)
        {
            result = result + current.getElement() + "\n";
            current = current.getNext();
        }
        
        return result;
    }
}
