import jsjf.exceptions.EmptyCollectionException;
import java.util.Iterator;

/**
 * LinkedListQueueDriver employs the methods of the LinkedListQueue class,
 * exercising its operations.
 *
 * @author MichaelKuby
 * @version January 26, 2022
 */
public class LinkedListQueueDriver
{
    public static void main (String[] args)
    {
        //-----------------------------------------------------------------
        // Create a queue using an LinkedListQueue collection object,
        // add a variety of elements, and test each method.
        //-----------------------------------------------------------------
        QueueADT<String> queue = new LinkedListQueue<>();

        System.out.println("Adding some elements to the queue.");

        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");

        // test .toString() and .size() methods
        System.out.println ("Current state of the queue: " + queue);
        System.out.println ("The size of the queue: " + queue.size());

        // test .dequeue() and .first() methods
        System.out.println ("\nRemoving an element");
        String removed = queue.dequeue();
        System.out.println ("The removed element: " + removed);
        System.out.println ("Current state of the queue: " + queue);
        System.out.println ("Head of the queue: " + queue.first());

        System.out.println ("\nRemoving two elements from the queue.");
        queue.dequeue();
        queue.dequeue();

        // test .isEmpty() method
        System.out.println ("Current state of the queue: " + queue);
        System.out.println ("The queue is empty: " + queue.isEmpty());

        // check operation of exceptions
        System.out.println("\nAttempt to remove an element:");
        try
        {
            queue.dequeue();
        }
        catch (EmptyCollectionException problem)
        {
            System.out.println("Exception thrown and caught: Queue is empty.");
        }

        // test operation of iterator function
        System.out.println ("Adding three more elements to the queue.");
        queue.enqueue("Fourth");
        queue.enqueue("Fifth");
        queue.enqueue("Sixth");

        System.out.println ("Testing iterator function:");
        Iterator<String> itr = ((LinkedListQueue<String>) queue).iterator();
        while (itr.hasNext())
        {
            System.out.println (itr.next());
        }

        // check for handling of null values
        System.out.println();
        System.out.println ("Adding a null element.");
        queue.enqueue(null);
        System.out.println ("Current state of the queue: " + queue);
        System.out.println ("The queue is empty: " + queue.isEmpty());
        System.out.println ("The size of the queue: " + queue.size());
    }
}
