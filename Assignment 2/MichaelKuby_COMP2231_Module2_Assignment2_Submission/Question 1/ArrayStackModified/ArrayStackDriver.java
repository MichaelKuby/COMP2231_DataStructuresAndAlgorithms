import java.util.Random;

/**
 * Runs a main method to exercise some of the methods of the ArrayStack<T> class
 *
 * @author Michael
 * @version 1.0
 */
public class ArrayStackDriver
{
    public static void main (String[] args)
    {
        /**
         * Instantiate an Integer based ArrayStack. Before populating it, demonstrate .size(), .isEmpty(),
         * .pop() and .peek() on an empty stack.
         */
        
        int size = 10;
        StackADT<Integer> stack = new ArrayStack<Integer>(size); // Demonstrates the constructor
        
        System.out.println("Stack size before populating: " + stack.size());
        System.out.println("Stack is empty: " + stack.isEmpty());
        try
        {
            stack.pop(); // Demonstrates EmptyCollectionException throw and catch from the .pop() method
        }
        catch (RuntimeException problem)
        {
            System.out.println ("Exception caught: Tried to pop on an empty stack.");
        }
        
        try
        {
            stack.peek(); // Demonstrates EmptyCollectionException throw and catch from the .peek() method
        }
        catch (RuntimeException problem)
        {
            System.out.println ("Exception caught: Tried to peek on an empty stack.");
        }
        
        System.out.println();
        
        /**
         * Populate the stack with random integers using .push().
         * Print the contents of the stack utilizing .toString() method.
         * Re-test .isEmpty() and .size() methods. 
         */
        
        Random rand = new Random();
        
        for (int i = 0; i < size; i++)
        {
            stack.push(rand.nextInt(100)); 
        }
        
        System.out.println ("Push " + size + " random integers. \nContents: " + stack); 
        System.out.println("The stack is empty: " + stack.isEmpty() + "\nThe stack size: " + stack.size());
        
        /**
         * Force the private helper method .expandCapacity() to run by adding an 11th element to the stack.
         * Demonstrate use of the .peek() method with a populated stack.
         * Prove that peek is accurate by printing the contents of the stack.
         */
        
        stack.push(rand.nextInt(100));
        
        System.out.println("\nStack size after a push: " + stack.size() + "\nTop element: " + stack.peek() + "\nContents: " + stack);
        
        /**
         * Test the .pop() method on a populated stack, and re-check the size and contents of the stack to confirm
         * the efficacy of .pop() on a populated stack.
         */
        
        stack.pop();
        stack.pop();
        
        System.out.println("\nStack size after two pops: " + stack.size() + "\nContents: " + stack);
    }
}
