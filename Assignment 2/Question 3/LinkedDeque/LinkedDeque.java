import jsjf.exceptions.*;

/**
 * LinkedDeque represents a doubly linked implementation of a queue.
 *
 * @author Michael Kuby
 * @version January 19, 2022
 */
public class LinkedDeque<T> implements DequeADT<T>
{
    private int count;
    private DoublyLinkedNode<T> head, tail;
    
    /**
     * Creates an empty queue.
     */
    public LinkedDeque()
    {
        count = 0;
        head = tail = null;
    }
    
    /**
     * Adds the specified element to the rear of this queue.
     * @param element  the element to be added to the rear of the queue
     */
    public void enqueueRear(T element)
    {
        DoublyLinkedNode<T> node = new DoublyLinkedNode<T>(element);
        
        if (isEmpty())
            head = node;
        else
        {
            tail.setNext(node);
            node.setPrevious(tail);    
        }
        tail = node;
        count++;
    }
    
    /**  
     * Removes and returns the element at the rear of this queue.
     * @return the element at the rear of the queue
     */
    public T dequeueRear()
    {
        if (isEmpty())
            throw new EmptyCollectionException("deque");
        
        T result = tail.getElement();
        tail = tail.getPrevious();
        if (count > 1)
            tail.setNext(null);
        count--;
        
        if (count == 0)
            head = null;
        
        return result;
    }
    
    /**
     * Adds one element to the front of this queue.
     * @param element  the element to be added to the front of the queue
     */
    public void enqueueFront(T element)
    {
        DoublyLinkedNode<T> node = new DoublyLinkedNode<T>(element);
        
        if (isEmpty())
            tail = node;
        else
        {
            head.setPrevious(node);
            node.setNext(head);
        }
        head = node;
        count++;
    }
    
    /**  
     * Removes and returns the element at the front of this queue.
     * @return the element at the front of the queue
     */
    public T dequeueFront()
    {
        if (isEmpty())
            throw new EmptyCollectionException("deque");
            
        T result = head.getElement();
        head = head.getNext();
        if (count > 1)
            head.setPrevious(null);
        count--;
        
        if (count == 0)
            tail = null;
        
        return result;
    }
    
    /**  
     * Returns without removing the element at the front of this queue.
     * @return the first element in the queue
     */
    public T first() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("queue");
            
        return head.getElement();
    }
    
    /**  
     * Returns without removing the element at the rear of this queue.
     * @return the last element in the queue
     */
    public T last()
    {
        if (isEmpty())
            throw new EmptyCollectionException("queue");
        
        return tail.getElement();
    }
    
    /**  
     * Returns true if this queue contains no elements.
     * @return true if this queue is empty
     */
    public boolean isEmpty()
    {
        return (count == 0);
    }
    
    /**  
     * Returns the number of elements in this queue. 
     * @return the integer representation of the size of the queue
     */
    public int size()
    {
        return count;
    }

    /**  
     * Returns a string representation of this queue. 
     * @return the string representation of the queue
     */
    public String toString()
    {
        String str = "";
        DoublyLinkedNode<T> current = head;
        
        while (current != null)
        {
            str += current.getElement() + "\n";
            current = current.getNext();
        }
        
        return str;
    }
}
