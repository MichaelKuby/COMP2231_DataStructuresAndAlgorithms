
/**
 * LinkedDequeDriver showcases the LinkedDeque<T> class and it's methods. We create a moderate sized array, and
 * add elements to both the front and the rear, showcasing each of the features and operations of the 
 * deque as we go.
 *
 * @author Michael Kuby
 * @version January 19, 2022
 */
public class LinkedDequeDriver
{
    public static void main (String[] args)
    {
        DequeADT<String> deque = new LinkedDeque<String>();
        
        System.out.println("Collection is currently empty: " + deque.isEmpty());
        
        /**
         * Showcase the thrown exceptions caused by trying to view elements when the collection is empty 
         */
        try
        {
            deque.first();
        }
        catch (RuntimeException problem)
        {
            System.out.println ("Exception caught: Collection is empty.");
        }
        
        try
        {
            deque.last();
        }
        catch (RuntimeException problem)
        {
            System.out.println ("Exception caught: Collection is empty.");
        }
        
        /**
         * Showcase the thrown exceptions caused by trying to remove elements when the collection is empty 
         */
        try
        {
            deque.dequeueRear();
        }
        catch (RuntimeException problem)
        {
            System.out.println ("Exception caught: Collection is empty.");
        }
        
        try
        {
            deque.dequeueFront();
        }
        catch (RuntimeException problem)
        {
            System.out.println ("Exception caught: Collection is empty.");
        }
        
        System.out.println("\n--------------------------------------------------------");
        
        /**
         * Add five elements to the front, outputting the contents of the collection as well as 
         * the size, front element, and last element each time.
         */
        
        System.out.println("\nAdding elements to the front of the collection:");
        
        deque.enqueueFront("First");
        System.out.println("\nContents:\n" + deque);
        System.out.println("Size: " + deque.size());
        System.out.println("Front element: " + deque.first());
        System.out.println("Rear element: " + deque.last());
        
        deque.enqueueFront("Second");
        System.out.println("\nContents:\n" + deque);
        System.out.println("Size: " + deque.size());
        System.out.println("Front element: " + deque.first());
        System.out.println("Rear element: " + deque.last());
        
        deque.enqueueFront("Third");
        System.out.println("\nContents:\n" + deque);
        System.out.println("Size: " + deque.size());
        System.out.println("Front element: " + deque.first());
        System.out.println("Rear element: " + deque.last());
        
        deque.enqueueFront("Fourth");
        System.out.println("\nContents:\n" + deque);
        System.out.println("Size: " + deque.size());
        System.out.println("Front element: " + deque.first());
        System.out.println("Rear element: " + deque.last());
        
        deque.enqueueFront("Fifth");
        System.out.println("\nContents:\n" + deque);
        System.out.println("Size: " + deque.size());
        System.out.println("Front element: " + deque.first());
        System.out.println("Rear element: " + deque.last());
        
        System.out.println("\n--------------------------------------------------------");
        
        /**
         * Remove five elements from the front, outputting the contents of the collection as well as 
         * the size, front element, and last element each time.
         */
        
        System.out.println("\nRemoving elements from the front of the collection:");
        
        deque.dequeueFront();
        System.out.println("\nContents:\n" + deque);
        System.out.println("Size: " + deque.size());
        System.out.println("Front element: " + deque.first());
        System.out.println("Rear element: " + deque.last());
        
        deque.dequeueFront();
        System.out.println("\nContents:\n" + deque);
        System.out.println("Size: " + deque.size());
        System.out.println("Front element: " + deque.first());
        System.out.println("Rear element: " + deque.last());
        
        deque.dequeueFront();
        System.out.println("\nContents:\n" + deque);
        System.out.println("Size: " + deque.size());
        System.out.println("Front element: " + deque.first());
        System.out.println("Rear element: " + deque.last());
        
        deque.dequeueFront();
        System.out.println("\nContents:\n" + deque);
        System.out.println("Size: " + deque.size());
        System.out.println("Front element: " + deque.first());
        System.out.println("Rear element: " + deque.last());
        
        deque.dequeueFront();
        System.out.println("\nContents:\n" + deque);
        System.out.println("Size: " + deque.size());
        
        System.out.println("\n--------------------------------------------------------");
        
        /**
         * Add five elements to the rear, outputting the contents of the collection as well as 
         * the size, front element, and last element each time.
         */
        
        System.out.println("\nAdding elements to the rear of the collection:");
        
        deque.enqueueRear("Sixth");
        System.out.println("\nContents:\n" + deque);
        System.out.println("Size: " + deque.size());
        System.out.println("Front element: " + deque.first());
        System.out.println("Rear element: " + deque.last());
        
        deque.enqueueRear("Seventh");
        System.out.println("\nContents:\n" + deque);
        System.out.println("Size: " + deque.size());
        System.out.println("Front element: " + deque.first());
        System.out.println("Rear element: " + deque.last());
        
        deque.enqueueRear("Eigth");
        System.out.println("\nContents:\n" + deque);
        System.out.println("Size: " + deque.size());
        System.out.println("Front element: " + deque.first());
        System.out.println("Rear element: " + deque.last());
        
        deque.enqueueRear("Ninth");
        System.out.println("\nContents:\n" + deque);
        System.out.println("Size: " + deque.size());
        System.out.println("Front element: " + deque.first());
        System.out.println("Rear element: " + deque.last());
        
        deque.enqueueRear("Tenth");
        System.out.println("\nContents:\n" + deque);
        System.out.println("Size: " + deque.size());
        System.out.println("Front element: " + deque.first());
        System.out.println("Rear element: " + deque.last());
        
        System.out.println("\n--------------------------------------------------------");
        
        
        /**
         * Remove five elements from the rear, outputting the contents of the collection as well as 
         * the size, front element, and last element each time.
         */
        
        System.out.println("\nRemoving elements from the rear of the collection:");
        
        deque.dequeueRear();
        System.out.println("\nContents:\n" + deque);
        System.out.println("Size: " + deque.size());
        System.out.println("Front element: " + deque.first());
        System.out.println("Rear element: " + deque.last());
        
        deque.dequeueRear();
        System.out.println("\nContents:\n" + deque);
        System.out.println("Size: " + deque.size());
        System.out.println("Front element: " + deque.first());
        System.out.println("Rear element: " + deque.last());
        
        deque.dequeueRear();
        System.out.println("\nContents:\n" + deque);
        System.out.println("Size: " + deque.size());
        System.out.println("Front element: " + deque.first());
        System.out.println("Rear element: " + deque.last());
        
        deque.dequeueRear();
        System.out.println("\nContents:\n" + deque);
        System.out.println("Size: " + deque.size());
        System.out.println("Front element: " + deque.first());
        System.out.println("Rear element: " + deque.last());
        
        deque.dequeueRear();
        System.out.println("\nContents:\n" + deque);
        System.out.println("Size: " + deque.size());
        
        System.out.println("\n--------------------------------------------------------");
    }
}
