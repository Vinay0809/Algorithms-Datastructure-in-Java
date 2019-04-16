package edu.uncc.ad.graph.generic;

import java.util.*;

/**
 * A Graph ADT (This is an directed unweighted graph implementation), backed by Hash table and LinkedHashSet.
 * Hashtable to store vertices and adjacency list as key, value pair. LinkedHasSet is to store adjacent vertices for
 * every vertex. This representation of graph follows Adjacent-list graph representation. This implementation is not
 * thread safe.
 *
 * Hashtable provides better optimization over array/ array list. Hashtable ensures there won't be a null vertex.
 * Since this implementation is for undirected graph, there won't be any parallel edges so LinkedHashSet
 * ensures, there only one undirected edge between any two vertices. It provides constant-time performance for most
 * of it's operations such as add a new vertex into graph, add an edge, get adjacent vertices for a give vertex. This
 * class provides two constructors to create a graph. The class also provides instance methods to operate on this graph.
 *
 * Instance Methods -
 *
 * 1. public void addEdge(E src, E dest) - Adds an edge for set of vertices.This method throw an
 * IndexOutOfBoundsException if source or destination vertex is not in this graph.
 *
 * 2. public void addVertex(E v) - Adds new vertex to graph.
 *
 * 3. Set<E> getNeighbours(E v) - returns a list of neighbour vertices,IllegalArgumentException if vertex doesn't
 * exists in this graph.
 *
 * 4. public void removeVertex(E v) - Removes an vertex from this graph. Throw IllegalArgumentException if v doesn't
 * exists in this graph. Throws UnsupportedOperationException if v have an adjacent vertex.
 *
 * 5. public void removeEdge(E src, E dest) - Removes an edge between two vertices. Throw IllegalArgumentException if
 * source or destination vertices are not in this graph. Throw UnsupportedOperationException if there is no edge
 * between source, and destination vertices.
 *
 *6. public Set<E> vertices() - returns set of vertices of this graph.
 *
 *
 * @param <E>
 *         the type parameter
 *
 * @author venky
 */
public class DirectedGraph<E> implements AbstractGraph<E> {
    /**
     * to store number of vertices in graph.
     */
    private int numberOfVertices = 0;
    private int edges = 0;

    /**
     * A hash table to store vertices and it's adjacency list, as linked list
     */
    private Map<E, Set<E>> graph;

    /**
     * Instantiates a new Graph.
     */
    public DirectedGraph() {
        // initializing the graph
        graph = new Hashtable<> ();

    }

    /**
     * Instantiates a new Graph.
     * User can pass List of vertices to this constructor to create a graph with predefined vertices.
     *
     * @param vertices
     *         the list of vertices
     */
    public DirectedGraph(List<E> vertices) {
        this.numberOfVertices = vertices.size ();
        graph = new Hashtable<> (this.numberOfVertices);
        for ( int i = 0 ; i < vertices.size () ; i++ ) {
            graph.put (vertices.get (i), new LinkedHashSet<> ());
        }
    }

    /**
     * Adds an edge for set of vertices.
     * This method throw an IndexOutOfBoundsException if source or destination vertex is not in this graph.
     * Runtime -
     * constant
     * worst case - log v
     *
     * @param src
     *         the source vertex
     * @param dest
     *         the destination vertex
     */
    @Override public void addEdge(E src, E dest) {
        boolean edgeAdded = false;
        // check if source and destination are valid
        if ( !this.graph.containsKey (src) ) {
            throw new IndexOutOfBoundsException ("Invalid source or destination vertex");
        } else if ( !this.graph.containsKey (dest) ) {
            throw new IndexOutOfBoundsException ("Invalid source or destination vertex");
        }

        // adding an edge from source to destination by updating the respective adjacency graph.
        edgeAdded = this.graph.get (src).add (dest);

        if ( edgeAdded )
            edges++;

    }

    /**
     * Adds a vertex to this graph.
     * Throws IllegalArgumentException if vertex already exists.
     * Runtime - constant
     * worst case - log v
     *
     * @param v
     *         the vertex to be added.
     */
    @Override public void addVertex(E v) {
        if ( this.graph.containsKey (v)  ) {
            throw new IllegalArgumentException ("Vertex exits in this graph");
        }
        this.graph.put (v, new LinkedHashSet<> ());
        this.numberOfVertices += 1;
    }


    /**
     * Gets list of neighbour vertices.
     * Throws IllegalArgumentException if vertex doesn't exists in this graph.
     * Runtime - constant
     *
     * @param v
     *         the vertex
     *
     * @return the list
     */
    @Override public Set<E> getNeighbours(E v) {
        // check if vertex is valid or not
        if ( !this.graph.containsKey (v) ) {
            throw new IllegalArgumentException ("Invalid vertex");
        }
        return this.graph.get (v);
    }

    /**
     * Removes an vertex from this graph.
     * Throw IllegalArgumentException if v doesn't exists in this graph.
     * Throws UnsupportedOperationException if v have an adjacent vertex.
     *
     * @param v
     *         the vertex in this graph
     */
    @Override public void removeVertex(E v){
        if ( !this.graph.containsKey (v) ){
            throw new IllegalArgumentException("Vertex doesn't exist in graph");
        } else if (  this.graph.get (v).size () > 0){
            throw new UnsupportedOperationException ("Vertex have one or more edges.");
        }
        graph.remove (v);
    }

    /**
     * Removes an edge from this graph.
     * Throw IllegalArgumentException if source or destination vertices are not in this graph.
     * Throw UnsupportedOperationException if there is no edge between source, and destination vertices.
     * @param src
     *         the source
     * @param dest
     *         the destination
     */
    @Override public void removeEdge(E src, E dest){
        if ( !(this.graph.containsKey (src) && this.graph.containsKey (dest))){
            throw new IllegalArgumentException ("Invalid source or destination vertex");
        } else if ( this.graph.get (src).contains (dest) ){
            this.graph.get (src).remove (dest);
        } else {
            throw new UnsupportedOperationException ("No edge exists between vertices");
        }
    }

    /**
     * Returns the degree of a vertex.
     * This method throws IllegalArgumentException if vertex is not part of this graph.
     * @param v vertex
     * @return degree of v.
     */
    @Override public int degree(E v){
        // check if vertex is part of this graph
        if ( !this.graph.containsKey (v)){
            throw new IllegalArgumentException ("Vertex "+v+" is doesn't exists");
        }
        return this.graph.get (v).size ();
    }
    /**
     *
     * toString method is overridden to represent graph.
     * @return Adjacency list representation of this graph.
     */
    @Override public String toString() {
        StringBuilder stringBuilder = new StringBuilder ();

        this.graph.forEach ((k, v) -> {
            stringBuilder.append (k + " -> ");
            stringBuilder.append (v);
            stringBuilder.append ("\n");
        });
        return stringBuilder.toString ();
    }

    /**
     * Edges int.
     *
     * @return the int
     */
    private int edges() {
        return edges;
    }

    /**
     * Vertices set
     *
     * @return the set of vertices  in this graph.
     */
    @Override public Set<E> vertices(){
        return this.graph.keySet ();
    }

    /**
     * this method return size in form of (#vertices, #edges) as a string.
     *
     * @return the string representation of (#vertices, #edges)
     */
    @Override public String size(){
        StringBuilder stringBuilder = new StringBuilder ();
        stringBuilder.append ("( "+this.graph.size ()+" , "+this.edges+" )");
        return stringBuilder.toString ();
    }

}
