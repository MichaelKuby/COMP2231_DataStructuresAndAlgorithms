package jsjf;

/**
 * GraphNode represents a node in a graph
 *
 * @author MichaelKuby
 * @version Feb. 23, 2022
 */
public class GraphNode<T>
{
    T element;

    /**
     * Creates an empty node in a graph.
     */
    public GraphNode()
    {
        this.element = null;
    }

    /**
     * Creates a node in a graph with an associated element.
     *
     * @param element element to be associated with
     */
    public GraphNode(T element)
    {
        this.element = element;
    }

    /**
     * Returns a string representation of this node.
     *
     * @return a reference to element represented by this node.
     */
    public String toString()
    {
        if (element == null)
            return "null";

        return element.toString();
    }
}
