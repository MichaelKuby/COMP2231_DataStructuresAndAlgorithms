import jsjf.Graph;

import java.util.Arrays;
import java.util.Iterator;

/**
 * GraphDriver exercises all methods of the Graph class.
 *
 * @author Michael Kuby
 * @version Feb 23, 2022
 */
public class GraphDriver
{
    public static void main (String[] args)
    {
        Graph<String> graph = new Graph<>();

        // add vertices to the graph
        graph.addVertex("Zero");
        graph.addVertex("One");
        graph.addVertex("Two");
        graph.addVertex("Three");
        graph.addVertex("Four");
        graph.addVertex("Five"); // triggers expandCapacity()

        // connect various vertices via edges
        graph.addEdge("Zero", "One");
        graph.addEdge("Zero", "Two");
        graph.addEdge("Zero", "Three");
        graph.addEdge("One", "Two");
        graph.addEdge("One", "Four");
        graph.addEdge("One", "Five");
        graph.addEdge("Two", "Five");
        graph.addEdge("Three", "Three");
        graph.addEdge("Five", "Four");

        System.out.println("Created and populated the following graph:\n");

        System.out.println(graph);

        // test isConnected() and iteratorBFS(); the latter is used by the former.
        System.out.println("Graph is connected: " + graph.isConnected());

        // test getMST()
        Graph<String> mstGraph = graph.getMST();

        System.out.println("\nMinimum Spanning Tree for the graph:\n");
        System.out.println(mstGraph);

        // add vertices and edges to test shortest path length
        System.out.println("Adding 3 connected vertices.");
        graph.addVertex("Six");
        graph.addVertex("Seven");
        graph.addVertex("Eight");

        graph.addEdge("Five", "Six");
        graph.addEdge("Six", "Seven");
        graph.addEdge("Seven", "Eight");

        System.out.println("\nCurrent vertices: " + Arrays.toString(graph.getVertices()));

        System.out.println("\nShortest path length from vertex" +
                " Zero to vertex Eight: " +
                graph.shortestPathLength("Zero", "Eight"));

        // test iteratorShortestPath
        System.out.println("The path is (tests iteratorShortestPath):");
        Iterator<String> iter = graph.iteratorShortestPath("Zero", "Eight");

        while (iter.hasNext())
            System.out.println(iter.next());

        // test iteratorDFS
        System.out.println("\nA depth first search of our current graph, " +
                "starting with vertex Four:");
        Iterator<String> iter2 = graph.iteratorDFS("Four");

        while (iter2.hasNext())
            System.out.println(iter2.next());

        // test iteratorBFS
        System.out.println("\nA breadth first search of our current graph, " +
                "starting with vertex Four:");
        Iterator<String> iter3 = graph.iteratorBFS("Four");

        while (iter3.hasNext())
            System.out.println(iter3.next());

        // test removal of vertex and associated edges
        System.out.println("\nRemove vertex \"Two,\" \"Five,\" \"Seven,\" \"Eight,\"");
        graph.removeVertex("Two");
        graph.removeVertex("Five");
        graph.removeVertex("Seven");
        graph.removeVertex("Eight");

        // test removal of a specific edge
        System.out.println("Remove edge (Zero, One)");
        graph.removeEdge("Zero", "One");
        System.out.println("\nThe current graph:\n");
        System.out.println(graph);

        // test for disconnected graph
        System.out.println("Graph is connected: " + graph.isConnected());

        // test for getIndex
        System.out.println("Vertex Two has index (-1 if not found): "
                + graph.getIndex("Two"));
        System.out.println("Vertex Four has index (-1 if not found): "
                + graph.getIndex("Four"));


        // test isEmpty and size methods
        System.out.println("\nTesting .size() and .isEmpty():");
        while (!graph.isEmpty())
        {
            System.out.println("Graph size: " + graph.size());
            graph.removeVertex(0);
        }
        System.out.println("Graph size: " + graph.size());
        System.out.println("Graph is empty: " + graph.isEmpty());
    }
}
