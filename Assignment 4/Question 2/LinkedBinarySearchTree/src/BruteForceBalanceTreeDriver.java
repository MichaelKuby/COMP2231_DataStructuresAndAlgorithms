import jsjf.LinkedBinarySearchTree;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

/**
 * BruteForceBalanceTreeDriver tests the balanceTree() method of the
 * LinkedBinarySearchTree class. We use a brute force method for balancing.
 * We create a degenerate tree, then output the height of the tree
 * before and after balancing the tree. We also demonstrate insertions into
 * a balanced tree that result in degenerate trees, and balance the tree
 * again.
 *
 * @author MichaelKuby
 * @version Feb. 6, 2022
 */
public class BruteForceBalanceTreeDriver
{
    public static void main (String[] args)
    {
        LinkedBinarySearchTree<Integer> tree = new LinkedBinarySearchTree<>();

        // Prompt the user to input the number of elements the tree should have,
        // then populate the tree with randomized integer elements.

        Random rand = new Random();
        Scanner keyboard = new Scanner(System.in);
        Integer elements = null;

        while (elements == null)
        {
            System.out.println("How many elements should the tree have?");

            try
            {
                String input = keyboard.nextLine().trim();
                elements = Integer.parseInt(input);
            }
            catch (NumberFormatException problem)
            {
                System.out.println("Please input an integer value.");
            }
        }

        System.out.println ("Populating the tree with " + elements +
                    " elements.");

        for (int scan = 0; scan < elements; scan++)
        {
            tree.addElement(scan);
        }

        // Print relevant information about the current tree
        System.out.println("The height of the tree: " + tree.getHeight());
        System.out.println("The size of the tree: " + tree.size());
        System.out.println("The elements of the tree listed in order: \n" +
                tree.toString());
        System.out.println("Balancing the tree");
        tree.balanceTree();
        System.out.println("\nThe height of the tree: " + tree.getHeight());
        System.out.println("The size of the tree: " + tree.size());
        System.out.print("The elements of the tree listed in order: \n" +
                tree.toString());

        System.out.println("\n-------------------------------------------------------------");

        // Insert elements into the existing tree, unbalancing the tree
        // then balance the tree and re print relevant information.
        System.out.println("\nNext we add a series of elements to unbalance the tree.");

        elements = null;

        while (elements == null)
        {
            System.out.println("How many elements should we add to the tree?");

            try
            {
                String input = keyboard.nextLine().trim();
                elements = Integer.parseInt(input);
            }
            catch (NumberFormatException problem)
            {
                System.out.println("Please input an integer value.");
            }
        }
        System.out.println ("Unbalancing the tree by adding " + elements +
                " elements to the rightmost side of the tree.");

        for (int scan = 0; scan < elements; scan++)
        {
            tree.addElement(tree.findMax()+1);
        }

        // Print relevant information about the current tree
        System.out.println("The height of the tree: " + tree.getHeight());
        System.out.println("The size of the tree: " + tree.size());
        System.out.println("The elements of the tree listed in order: \n" +
                tree.toString());

        // Balance the tree and re print relevant information
        System.out.println("Balancing the tree");
        tree.balanceTree();
        System.out.println("\nThe height of the tree: " + tree.getHeight());
        System.out.println("The size of the tree: " + tree.size());
        System.out.print("The elements of the tree listed in order: \n" +
                tree.toString());
    }
}
