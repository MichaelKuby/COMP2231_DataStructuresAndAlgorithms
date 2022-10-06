
/**
 * Represents a node in a double ended linked list.
 *
 * @author Michael Kuby
 * @version January 19, 2022
 */
public class DoublyLinkedNode<T>
{
    private DoublyLinkedNode<T> next, previous;
    private T element;
    
    /**
     * Creates an empty node.
     */
    public DoublyLinkedNode()
    {
        this(null);
    }
    
    /**
     * Creates a node storing the specified element.
     * @param elem  element to be stored by this node
     */
    public DoublyLinkedNode(T elem)
    {
        next = previous = null;
        element = elem;
    }
    
    /**
     * Returns the node that follows this one.
     * @return reference to the next node
     */
    public DoublyLinkedNode<T> getNext()
    {
        return next;
    }
    
    /**
     * Sets the node that follows this one.
     * @param node  node to follow this one
     */
    public void setNext(DoublyLinkedNode<T> node)
    {
        next = node;
    }
    
    /**
     * Returns the node that preceeds this one.
     * @return reference to the previous node
     */
    public DoublyLinkedNode<T> getPrevious()
    {
        return previous;
    }
    
    /**
     * Sets the node that preceeds this one.
     * @param node  node that preceeds this one
     */
    public void setPrevious(DoublyLinkedNode<T> node)
    {
        previous = node;
    }
    
    /**
     * Returns the element stored in this node.
     * @return element stored by this node
     */
    public T getElement()
    {
        return element;
    }
    
    /**
     * Sets the element stored in this node.
     * @param elem  element to be stored by this node
     */
    public void setElement(T elem)
    {
        element = elem;
    }
    
}
