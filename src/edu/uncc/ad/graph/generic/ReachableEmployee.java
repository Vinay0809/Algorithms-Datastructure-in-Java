package edu.uncc.ad.graph.generic;

import edu.uncc.ad.graph.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author venky
 */
public class ReachableEmployee {

    public static void main(String[] args) {
        UndirectedGraph<Integer> graph = new UndirectedGraph<> ();

        graph.addVertex (1);
        graph.addVertex (2);
        graph.addVertex (3);
        graph.addVertex (4);
        graph.addVertex (5);

        graph.addEdge (1,2);
        graph.addEdge (2,4);
        graph.addEdge (1,3);
        graph.addEdge (1,5);
        graph.addEdge (3,5);

        solution (graph, 1);

    }

    public static void solution(UndirectedGraph graph, int start){

        // an array for to track visited nodes
        int[] visited = new int[graph.vertices ().size () + 1];
        // list to store nodes in order they visited.
        List<Integer> bfsOrder = new ArrayList<> ();

        // queue to track visited nodes.
        Queue<Integer> queue = new LinkedList<> ();

        //start exploring from start node
        visited[start] = 1; // marking start node as visited.
        queue.offer (start); // adding start node to queue as it is visited.
//        bfsOrder.add (start);

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
