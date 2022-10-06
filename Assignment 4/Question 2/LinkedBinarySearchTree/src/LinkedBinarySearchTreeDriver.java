import jsjf.LinkedBinarySearchTree;
import jsjf.exceptions.EmptyCollectionException;

import java.util.Iterator;
import java.util.Random;

/**
 * LinkedBinarySearchTreeDriver tests the implemented methods of the
 * LinkedBinarySearchTree class.
 *
 * @author MichaelKuby
 * @version Feb. 6, 2022
 */
public class LinkedBinarySearchTreeDriver
{
    public static void main(String[] args)
    {
        // Create a LinkedBinarySearchTree and populate it with nodes that
        // reference String elements

        LinkedBinarySearchTree<String> tree = new LinkedBinarySearchTree<>();

        System.out.println("Populating the a LinkedBinarySearchTree with " +
                "Judeo-Christian-Islamic names.");
        tree.addElement("Azrael");
        tree.addElement("Balthazar");
        tree.addElement("Caspar");
        tree.addElement("Cassiel");
        tree.addElement("Dismas");
        tree.addElement("Israfil");
        tree.addElement("Jeremiel");
        tree.addElement("Joachim");
        tree.addElement("Lilith");
        tree.addElement("Lucifer");
        tree.addElement("Melchior");
        tree.addElement("Phanuel");
        tree.addElement("Raziel");
        tree.addElement("Samael");
        tree.addElement("Zephaniel");
        tree.addElement("Zerachiel");

        // Test getHeight(), size(), getRootElement(), getLeft() and getRight() methods
        System.out.println("\nThe height of this tree is: " + tree.getHeight());
        System.out.println("The size of this tree is: " + tree.size());
        System.out.println("The root element of this tree is: " + tree.getRootElement());
        System.out.println("\nThe left subtree of this tree: " +
                tree.getLeft());
        System.out.println("\nThe right subtree of this tree: \n" +
                tree.getRight());

        System.out.println("-------------------------------------------------------------");

        // Test the contains() method, which utilizes the find() method
        System.out.println("\nContains the name \"Joachim\": " +
                tree.contains("Joachim"));
        System.out.println("Contains the name \"Donovan\": " +
                tree.contains("Donovan"));

        // Test the findMax() and findMin() methods
        System.out.println("\nThe \"maximum\" name as ordered by " +
                "the Unicode character set: " + tree.findMax());
        System.out.println("The \"minimum\" name as ordered by " +
                "the Unicode character set: " + tree.findMin());

        // Balance the tree for further examination of previously tested methods
        System.out.println("\nBalancing the tree.\n");
        tree.balanceTree();
        System.out.println("The height of this tree is now: " + tree.getHeight());
        System.out.println("Current root element of the tree: " + tree.getRootElement());
        System.out.println("\nThe left subtree of this tree: \n" +
                tree.getLeft());
        System.out.println("The right subtree of this tree: \n" +
                tree.getRight());

        System.out.println("-------------------------------------------------------------");

        // Test the removal of elements
        System.out.println("\nRemoving element: Israfil.");
        tree.removeElement("Israfil");
        System.out.println("Tree contains the name \"Israfil\": " +
                tree.contains("Israfil"));

        System.out.println("\nRemoving " + tree.findMax() + " and " + tree.findMin() + ".");
        tree.removeMax();
        tree.removeMin();

        System.out.println("\nCurrent elements of the tree:\n" + tree);

        System.out.println("-------------------------------------------------------------");

        // Test the removeAllOccurrences() method
        System.out.println("\nAdding the name \"Karen\" several times...");
        tree.addElement("Karen");
        tree.addElement("Karen");
        tree.addElement("Karen");
        tree.addElement("Karen");

        System.out.println("\nCurrent elements of the tree:\n" + tree);
        System.out.println("Removing all instances of the name \"Karen\".\n");
        tree.removeAllOccurrences("Karen");

        System.out.println("The height of this tree is now: " + tree.getHeight());
        System.out.println("The size of this tree is now: " + tree.size());
        System.out.println("Current root element of the tree: " + tree.getRootElement());
        System.out.println("\nThe left subtree of this tree: \n" +
                tree.getLeft());
        System.out.println("The right subtree of this tree: \n" +
                tree.getRight());

        System.out.println("-------------------------------------------------------------");

        // Test the removeMin() operation for edge cases
        System.out.println("\nCurrent elements of the tree:\n" + tree);
        System.out.println("The size of this tree is now: " + tree.size());
        System.out.println("This tree is empty: " + tree.isEmpty());

        System.out.println("\nRemoving all nodes from the tree using " +
                "remove min operation...\n");

        while (!tree.isEmpty())
        {
            tree.removeMin();
            System.out.println("The size of this tree is now: " + tree.size());
        }

        System.out.println("\nThe height of this tree is now: " + tree.getHeight());
        System.out.println("This tree is empty: " + tree.isEmpty());
        System.out.println("\nCurrent elements of the tree:\n" + tree);

        // Check to see that methods are throwing exceptions when necessary
        try
        {
            System.out.println("The left subtree of this tree: \n" +
                    tree.getLeft());
        }
        catch (EmptyCollectionException problem)
        {
            System.out.println("Exception thrown and caught; The get left operation " +
                    "failed. The tree is empty.");
        }
        try
        {
            System.out.println("The left subtree of this tree: \n" +
                    tree.getRight());
        }
        catch (EmptyCollectionException problem)
        {
            System.out.println("Exception thrown and caught; The get right operation " +
                    "failed. The tree is empty.");
        }

        System.out.println("\n-------------------------------------------------------------");

        // Create a new LinkedBinarySearchTree that holds Integer objects,
        // so we can test each iterator method.
        System.out.println("\nPopulating a new tree with integer elements to " +
                "test the iterator traversal methods.\n");

        LinkedBinarySearchTree<Integer> newTree = new LinkedBinarySearchTree<>();

        Random rand = new Random();
        for (int i = 0; i < 10; i++)
        {
            newTree.addElement(i);
        }

        newTree.balanceTree();

        System.out.println("A level order traversal of the tree:\n");

        Iterator<Integer> itr = newTree.iteratorLevelOrder();

        for (Iterator<Integer> it = itr; it.hasNext(); )
        {
            System.out.println(it.next());
        }

        System.out.println("\n-------------------------------------------------------------");

        System.out.println("\nA pre order traversal of the tree:\n");

        itr = newTree.iteratorPreOrder();

        for (Iterator<Integer> it = itr; it.hasNext(); )
        {
            System.out.println(it.next());
        }

        System.out.println("\n-------------------------------------------------------------");

        System.out.println("\nA post order traversal of the tree:\n");

        itr = newTree.iteratorPostOrder();

        for (Iterator<Integer> it = itr; it.hasNext(); )
        {
            System.out.println(it.next());
        }

        System.out.println("\n-------------------------------------------------------------");

        System.out.println("\nAn in order traversal of the tree:\n");

        itr = newTree.iteratorInOrder();

        for (Iterator<Integer> it = itr; it.hasNext(); )
        {
            System.out.println(it.next());
        }

        System.out.println("-------------------------------------------------------------");

        System.out.println("\nCurrent elements of the tree:\n" + newTree);
        System.out.println("The size of this tree is now: " + newTree.size());
        System.out.println("This tree is empty: " + newTree.isEmpty());

        // Test the removeMax() operation for edge cases
        System.out.println("\nRemoving all nodes from the tree using " +
                "remove max operation...\n");


        while (!newTree.isEmpty())
        {
            newTree.removeMax();
            System.out.println("The size of this tree is now: " + newTree.size());
        }

        System.out.println("\nThe height of this tree is now: " + newTree.getHeight());
        System.out.println("This tree is empty: " + newTree.isEmpty());
        System.out.println("\nCurrent elements of the tree:\n" + newTree);

        try
        {
            System.out.println("The left subtree of this tree: \n" +
                    newTree.getLeft());
        }
        catch (EmptyCollectionException problem)
        {
            System.out.println("Exception thrown and caught; The get left operation " +
                    "failed. The tree is empty.");
        }
        try
        {
            System.out.println("The left subtree of this tree: \n" +
                    newTree.getRight());
        }
        catch (EmptyCollectionException problem)
        {
            System.out.println("Exception thrown and caught; The get right operation " +
                    "failed. The tree is empty.");
        }

        try
        {
            System.out.println("\nThe \"maximum\" element when " +
                    "the tree is empty: " + tree.findMax());
        }
        catch (EmptyCollectionException problem)
        {
            System.out.println("Exception thrown and caught; The findMax() operation " +
                    "failed. The tree is empty.");
        }
        try
        {
            System.out.println("The \"minimum\" element when " +
                    "the tree is empty: " + tree.findMin());
        }
        catch (EmptyCollectionException problem)
        {
            System.out.println("Exception thrown and caught; The findMin() operation " +
                    "failed. The tree is empty.");
        }

    }
}