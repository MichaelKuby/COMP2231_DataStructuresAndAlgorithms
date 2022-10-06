import jsjf.exceptions.EmptyCollectionException;
import java.util.Iterator;

/**
 * LinkedListStackDriver employs the methods of the LinkedListStack class,
 * exercising its operations.
 *
 * @author MichaelKuby
 * @version January 26, 2022
 */
public class LinkedListStackDriver
{
    public static void main (String[] args)
    {
        //-----------------------------------------------------------------
        // Create a stack using an LinkedListStack collection object,
        // add a variety of elements, and test each method.
        //-----------------------------------------------------------------
        StackADT<String> stack = new LinkedListStack<>();

        System.out.println("Pushing some elements onto the stack.");

        stack.push("First");
        stack.push("Second");
        stack.push("Third");

        // test .toString() and .size() methods
        System.out.println ("Current state of the stack: " + stack);
        System.out.println ("The size of the stack: " + stack.size());

        // test .pop() and .peek() methods
        System.out.println ("\nPopping an element");
        String removed = stack.pop();
        System.out.println ("The removed element: " + removed);
        System.out.println ("Current state of the stack: " + stack);
        System.out.println ("Top of the stack: " + stack.peek());

        // test .isEmpty() method
        System.out.println ("\nPopping two elements off the stack.");
        stack.pop();
        stack.pop();
        System.out.println ("Current state of the stack: " + stack);
        System.out.println ("The stack is empty: " + stack.isEmpty());

        // check operation of exceptions
        System.out.println("\nAttempt to remove an element:");
        try
        {
            stack.pop();
        }
        catch (EmptyCollectionException problem)
        {
            System.out.println("Exception thrown and caught: Stack is empty.");
        }

        // test operation of iterator functions
        System.out.println ("Adding three more elements to the stack.");
        stack.push("Fourth");
        stack.push("Fifth");
        stack.push("Sixth");

        System.out.println ("Testing iterator function:");
        Iterator<String> itr = ((LinkedListStack<String>) stack).iterator();
        while (itr.hasNext())
        {
            System.out.println (itr.next());
        }

        // check for handling of null values
        System.out.println();
        System.out.println ("Adding a null element.");
        stack.push(null);
        System.out.println ("Current state of the stack: " + stack);
        System.out.println ("The stack is empty: " + stack.isEmpty());
        System.out.println ("The size of the stack: " + stack.size());
    }
}
