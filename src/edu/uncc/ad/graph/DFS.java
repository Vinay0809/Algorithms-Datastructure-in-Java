package edu.uncc.ad.graph;

import edu.uncc.ad.graph.generic.UndirectedGraph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author venky
 */
public class DFS {
    static int size;
    static int[] visited;
    static List<Integer> dfsOrder;
    static UndirectedGraph<Integer> graph;

    public static void main(String[] args) {
        graph = new UndirectedGraph<> ();

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
        size = graph.vertices ().size ();

        visited = new int[size+1];
        dfsOrder = new ArrayList<Integer> (size);

       new DFS ().dfs(4);
        System.out.println (dfsOrder);
    }
    //visited array



    private void dfs(int i) {
        // marks the start node as visited
        visited[i] = 1;
        dfsOrder.add (i);


        // explore each neighbours of i recursively
        List<Integer> ne = graph.getNeighbours (i);
        for(int j=0; j< ne.size (); j++){
            if ( visited[ne.get (j)] == 0 ){ // check if the neighbour is visited or not.
                dfs (ne.get (j)); // if not visited visit and explore it's neighbours recursively.
            }
        }

    }

}
