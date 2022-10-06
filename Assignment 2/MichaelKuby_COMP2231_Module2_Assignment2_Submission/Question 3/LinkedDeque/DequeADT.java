
/**
 * DequeADT defines the interface for a double ended queue collection.
 *
 * @author Michael Kuby
 * @version January 19, 2022
 */
public interface DequeADT<T>
{
    /**
     * Adds one element to the rear of this queue.
     * @param element  the element to be added to the rear of the queue
     */
    public void enqueueRear(T element);
    
    /**  
     * Removes and returns the element at the rear of this queue.
     * @return the element at the rear of the queue
     */
    public T dequeueRear();
    
    /**
     * Adds one element to the front of this queue.
     * @param element  the element to be added to the front of the queue
     */
    public void enqueueFront(T element);
    
    /**  
     * Removes and returns the element at the front of this queue.
     * @return the element at the front of the queue
     */
    public T dequeueFront();
    
    /**  
     * Returns without removing the element at the front of this queue.
     * @return the first element in the queue
     */
    public T first();
    
    /**  
     * Returns without removing the element at the rear of this queue.
     * @return the last element in the queue
     */
    public T last();
    
    /**  
     * Returns true if this queue contains no elements.
     * @return true if this queue is empty
     */
    public boolean isEmpty();

    /**  
     * Returns the number of elements in this queue. 
     * @return the integer representation of the size of the queue
     */
    public int size();

    /**  
     * Returns a string representation of this queue. 
     * @return the string representation of the queue
     */
    public String toString();
}
