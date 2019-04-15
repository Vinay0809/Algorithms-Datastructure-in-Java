package edu.uncc.ad.graph;

import edu.uncc.ad.graph.generic.Graph;

import java.util.Arrays;
import java.util.List;

/**
 * @author venky
 */
public class Main {

    public static void main(String[] args) {
        Character[] v = {'A','B','C','D','E','F','G','H'};
        List<Character> vertices =  Arrays.asList (v);

        Graph<Character> graph = new Graph<Character> (vertices);



        graph.addEdge ('A','B');
        graph.addEdge ('B','C');
        graph.addEdge ('B','H');
        graph.addEdge ('C','D');
        graph.addEdge ('C','E');
        graph.addEdge ('E', 'F');
        graph.addEdge ('E', 'H');
        graph.addEdge ('E', 'G');
        graph.addVertex ('M');

        System.out.println (graph);
        graph.removeEdge ( 'E', 'F');

        System.out.println (graph);

        System.out.println (graph.size ());
    }
}
