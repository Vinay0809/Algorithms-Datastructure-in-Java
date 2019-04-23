package edu.uncc.ad.graph.weighted;

/**
 * @author venky
 */
public class Demo {

    public static void main(String[] args) {
        UndirectedGraph<Integer> graph = new UndirectedGraph<Integer> ();

        graph.addVertex (1);
        graph.addVertex (2);
        graph.addVertex (3);
        graph.addVertex (4);
        graph.addVertex (5);
        graph.addVertex (6);


        graph.addEdge (1,2,1);
        graph.addEdge (1,5,3);

        graph.addEdge (2,3,3);
        graph.addEdge (2,5,1);

        graph.addEdge (3,4,1);

        graph.addEdge (4,5,1);
        graph.addEdge (4,6,2);


        System.out.println (graph);
        System.out.println ("Vertices"+graph.verticesCount ());
        System.out.println ("Edges"+graph.edgesCount ());

        for ( int i=1; i<=6;i++ ){
            System.out.print (graph.degree (i)+" ");
        }

        System.out.println ();

        for ( int i=1; i<=6;i++ ){
            System.out.print (graph.strength (i)+" ");
        }
    }
}
