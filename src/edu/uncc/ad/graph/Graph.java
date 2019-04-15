package edu.uncc.ad.graph;

import java.util.*;

/**
 * A Graph ADT, backed by Hash table and Linked list
 * This representation of graph follows Adjacent-list graph representation.
 * Hash map provide optimization over array/ array list
 * This class provides two constructors, one for creating with initial capacity.
 * If initial capacity is not mentioned, a graph with 4 vertices will be created. However, vertices can be added
 * using utility method.
 * The class also provide instance methods to operate on this graph.
 * THIS GRAPH REPRESENTATION IS FOR INTEGER TYPE VERTICES ONLY.
 *
 * @author venky
 */
public class Graph {

    /**
     * to store number of vertices in graph.
     * Initial capacity will be 4
     */
    private int numberOfVertices = 4;

    /**
     * A hash table to store vertices and it's adjacency list, as linked list
     */
    private Map<Integer, LinkedList<Integer>> graph;

    /**
     * Instantiates a new Graph.
     */
    Graph() {
        // initializing the graph
        graph = new Hashtable<> ();
        for ( int i=0; i < this.numberOfVertices; i++ ){
            graph.put (i, new LinkedList<> ());
        }
    }

    /**
     * Instantiates a new Graph.
     *
     * @param initialCapacity
     *         the initial capacity
     */
    Graph(int initialCapacity){
        // initialize graph with initial capacity
        this.numberOfVertices = initialCapacity;
        graph = new Hashtable<> (this.numberOfVertices);
        for ( int i=0; i < this.numberOfVertices; i++ ){
            graph.put (i, new LinkedList<> ());
        }
    }

    /**
     * Adds an edge for set of vertices.
     * This method throw an IndexOutOfBoundsException if source or destination vertex is not in this graph.
     * Runtime - constant
     * @param source
     *         the source vertex
     * @param destination
     *         the destination vertex
     */
    public void addEdge(int source, int destination){
       // check if source and destination are valid
        if ( source < 0 || source >= this.numberOfVertices || destination < 0 || destination >= this.numberOfVertices){
            throw new IndexOutOfBoundsException ("Invalid source or destination vertex");
        }

        // adding an edge from source to destination by updating the respective adjacency graph.
        this.graph.get (source).addLast (destination);

        // since it is an undirected graph, also need to update destination as well.
        this.graph.get (destination).addLast (source);
    }

    /**
     * Adds a vertex to this graph.
     * Throws IllegalArgumentException if vertex already exists.
     * Runtime - constant
     * worst case - log v
     * @param v
     *         the vertex to be added.
     */
    public void addVertex(int v){
        if ( this.graph.containsKey (v)){
            throw new IllegalArgumentException ("Vertex "+ v +" exits in this graph");
        }
        this.graph.put (v, new LinkedList<> ());
    }

    /**
     * Gets list neighbours for an vertex.
     * Throws IllegalArgumentException if vertex doesn't exists in this graph.
     * Runtime - constant
     * @param v
     *         the vertex
     *
     * @return the list
     */
    public List<Integer> getNeighbours(int v){
        // check if vertex is valid or not
        if ( v < 0 || v >= this.numberOfVertices ){
            throw new IllegalArgumentException ("Invalid vertex");
        }
        return this.graph.get (v);
    }

    /**
     * Utility method to print this graph
     * Runtime -
     * worst case O(v^2)
     * average case O(v * degree(v))
     */
    public void print(){

        this.graph.forEach ((k,v) -> {
            System.out.print (k+"->");
            System.out.print ("[");
            ListIterator<Integer> listIterator = v.listIterator ();
            while ( listIterator.hasNext () ){
                System.out.print (listIterator.next ()+",");
            }
            System.out.print ("]");
            System.out.println ();
        });
        System.out.println ();
    }

    /**
     * Prints list of neighbours for a vertex of this graph.
     * Throws IllegalArgumentException if vertex doesn't exists in this graph.
     * Runtime - degree(v).
     * @param v
     *         the v
     */
    public void printNeighbours(int v){
        if ( this.graph.containsKey (v)){
            throw new IllegalArgumentException ("Invalid vertex");
        }
        List<Integer> result = this.graph.get (v);
        ListIterator<Integer> listIterator = result.listIterator ();
        System.out.print (v+" -> [");
        while ( listIterator.hasNext () ){
            System.out.print(listIterator.next ()+" ,");
        }
        System.out.print ("]");
        System.out.println ();
    }

}
