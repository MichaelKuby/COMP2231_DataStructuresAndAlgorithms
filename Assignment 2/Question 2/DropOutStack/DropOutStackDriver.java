
/**
 * Tests the methods of the LinkedStack class. Creates a stack of moderate size composed of String elements
 * representing people's names. Utilizes the size(), peek(), and toString() operations.
 *
 * @author Michael Kuby
 * @version Wednesday Januray 19 2022
 */
public class DropOutStackDriver
{
    public static void main (String[] args)
    {
        /**
         * Create a drop-out stack of a certain size and test its .size() and .isEmpty() methods.
         */
        
        int size = 5;
        StackADT<String> stack = new DropOutStack<String>(size);
        
        System.out.println("Size of the stack: " + stack.size());
        System.out.println ("Stack is empty: " + stack.isEmpty());
        System.out.println ("Pushing five elements onto the stack.");
        
        /**
         * Push five elements onto the stack, in this case making the stack "full".
         */
        
        stack.push("Michael Kuby");
        stack.push("Ron Swanson");
        stack.push("Tom Haverford");
        stack.push("Ann Perkins");
        stack.push("Andy Dwyer");
        
        /**
         * Print the contents of the stack and test some of the drop-out stack's methods.
         */
        
        System.out.println("\nContents of the stack: \n");
        System.out.println (stack);
        System.out.println("Top element: " + stack.peek());
        System.out.println("Size of the stack: " + stack.size());
        System.out.println();
        
        /**
         * Push two more elements onto the stack, causing two elements to "drop out".
         */
        
        System.out.println("Pushing two more elements onto the stack.");
        stack.push("April Ludgate");
        stack.push("Leslie Knope");
        
        /**
         * Print the contents of the stack and test some of the drop-out stack's methods.
         */
        
        System.out.println("\nCurrent contents of the stack: \n");
        System.out.println (stack);
        System.out.println("Current top element: " + stack.peek());
        System.out.println("Current size of the stack: " + stack.size());
    }
}
