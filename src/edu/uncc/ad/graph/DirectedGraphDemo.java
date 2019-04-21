package edu.uncc.ad.graph;

import edu.uncc.ad.graph.generic.DirectedGraph;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author venky
 */
public class DirectedGraphDemo {

    public static void main(String[] args) {
        DirectedGraph<Integer> directedGraph = new DirectedGraph<> ();

        for ( int i = 1 ; i <= 8 ; i++ ) {
            directedGraph.addVertex (i);
        }

        System.out.println (directedGraph);

        directedGraph.addEdge (1, 3);
        directedGraph.addEdge (1, 4);
        directedGraph.addEdge (1, 5);

        directedGraph.addEdge (2, 3);
        directedGraph.addEdge (2, 8);

        directedGraph.addEdge (3, 6);
        directedGraph.addEdge (3, 1);

        directedGraph.addEdge (4, 6);
        directedGraph.addEdge (4, 8);

        directedGraph.addEdge (5, 8);

        directedGraph.addEdge (6, 7);

        directedGraph.addEdge (7, 8);

        System.out.println (directedGraph);

        List<Integer> inDegree = new ArrayList<> ();
        List<Integer> outDegree = new ArrayList<> ();
        List<Integer> degree = new ArrayList<> ();

        for ( int i = 1 ; i <= 8 ; i++ ) {
            inDegree.add (directedGraph.inDegree (i));
            outDegree.add (directedGraph.outDegree (i));
            degree.add (directedGraph.degree (i));
        }
        System.out.println ("In degree - "+ inDegree);
        System.out.println ("Out degree - "+ outDegree);
        System.out.println ("Degree - "+ degree);
        System.out.println ("Size - "+directedGraph.size ());

//        directedGraph.removeVertex (1);

        System.out.println (directedGraph);
        System.out.println ("Indegree - "+directedGraph.inDegree (4));
    }
}
