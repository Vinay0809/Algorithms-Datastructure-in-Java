package edu.uncc.ad.graph;

import edu.uncc.ad.graph.generic.UndirectedGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author venky
 */
public class BFS {

    public static void main(String[] args) {
        UndirectedGraph<Integer> graph = new UndirectedGraph<> ();

        for ( int i=1; i<=10; i++ ){
            graph.addVertex (i);
        }

        graph.addEdge (1,2);
        graph.addEdge (1,3);
        graph.addEdge (1,4);
        graph.addEdge (2,3);
        graph.addEdge (4,5);
        graph.addEdge (4,8);
        graph.addEdge (5,6);
        graph.addEdge (5,7);
        graph.addEdge (6,7);
        graph.addEdge (6,8);
        graph.addEdge (6,9);
        graph.addEdge (8,9);
        graph.addEdge (9,10);

        new BFS ().bfs (graph,6);

    }

    public void bfs(UndirectedGraph graph, int start){

        // an array for to track visited nodes
        int[] visited = new int[graph.vertices ().size () + 1];
        // list to store nodes in order they visited.
        List<Integer> bfsOrder = new ArrayList<> ();

        // queue to track visited nodes.
        Queue<Integer> queue = new LinkedList<> ();

        //start exploring from start node
        visited[start] = 1; // marking start node as visited.
        queue.offer (start); // adding start node to queue as it is visited.
        bfsOrder.add (start);

        // run till queue is not empty
        while ( !queue.isEmpty () ){
            int j = queue.poll (); // getting next visited unexplored node from queue.

            // get this node's neighbours
            List<Integer> neighbours = graph.getNeighbours (j);

            // check if neighbours are visited or not
            for ( int i=0; i<neighbours.size (); i++ ){
                if ( visited[neighbours.get (i)] == 0 ){ // if not visited, visit the node and add to queue
                    visited[neighbours.get (i)] = 1; // mark as visited
                    queue.offer (neighbours.get (i)); // add to queue to explore later
                    bfsOrder.add (neighbours.get (i)); // add to order list
                }
            } // end of for

        }// end of while

        System.out.println (bfsOrder);
    }
}
