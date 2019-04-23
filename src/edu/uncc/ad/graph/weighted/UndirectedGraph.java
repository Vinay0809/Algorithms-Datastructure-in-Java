package edu.uncc.ad.graph.weighted;

import java.util.*;

/**
 * The type Undirected graph.
 *
 * @param <E>
 *         the type parameter
 *
 * @author venky
 */
public class UndirectedGraph<E> implements WeightedGraph<E> {
    /**
     * to store number of vertices in graph.
     */
    private int numberOfVertices = 0;
    private int edges = 0;

    /**
     * A hash table to store vertices and it's adjacency list, as linked list
     */
    private Map<E, Set<Edge<E>>> graph;

    /**
     * Instantiates a new UndirectedGraph.
     */
    public UndirectedGraph() {
        // initializing the graph
        graph = new Hashtable<> ();

    }

    /**
     * Instantiates a new UndirectedGraph.
     * User can pass List of vertices to this constructor to create a graph with predefined vertices.
     *
     * @param vertices
     *         the list of vertices
     */
    public UndirectedGraph(List<E> vertices) {
        this.numberOfVertices = vertices.size ();
        graph = new Hashtable<> (this.numberOfVertices);
        for ( int i = 0 ; i < vertices.size () ; i++ ) {
            graph.put (vertices.get (i), new LinkedHashSet<Edge<E>> ());
        }
    }

    /**
     * Add vertex.
     *
     * @param v
     *         the v         runtime O(1) - average case         worst case O(log n)
     */
    @Override public void addVertex(E v) {
        if ( this.graph.containsKey (v) ) {
            throw new IllegalArgumentException ("Vertex exits in this graph");
        }
        this.graph.put (v, new LinkedHashSet<Edge<E>> ());
        this.numberOfVertices += 1;
    }

    /**
     * Add edge.
     *
     * @param src
     *         the src
     * @param dest
     *         the dest
     * @param w
     *         the w         runtime O(1) - average case         worst case O(log n)
     */
    @Override public void addEdge(E src, E dest, double w) {
        boolean edgeAdded = false;
        // check if source and destination are valid
        if ( !this.graph.containsKey (src) ) {
            throw new IndexOutOfBoundsException ("Invalid source or destination vertex");
        } else if ( !this.graph.containsKey (dest) ) {
            throw new IndexOutOfBoundsException ("Invalid source or destination vertex");
        }

        Edge e = new Edge (dest, w);
        edgeAdded = this.graph.get (src).add (e);

        e = new Edge (src, w);
        edgeAdded = this.graph.get (dest).add (e);

        if ( edgeAdded ) {
            this.edges += 1;
        }
    }


    /**
     * Edges int.
     *
     * @return the int         runtime O(1)
     */
    @Override public int edgesCount() {
        return this.edges;
    }


    /**
     * Vertices count int.
     *
     * @return the int         runtime O(1)
     */
    @Override public int verticesCount() {
        return this.numberOfVertices;
    }

    /**
     * Returns the degree of a vertex.
     * This method throws IllegalArgumentException if vertex is not part of this graph.
     *
     * @param v
     *         vertex
     *
     * @return degree of v.         Runtime O(1) - average case         worst case - O(log n)
     */
    @Override public int degree(E v) {
        // check if vertex is part of this graph
        if ( !this.graph.containsKey (v) ) {
            throw new IllegalArgumentException ("Vertex " + v + " is doesn't exists");
        }
        return this.graph.get (v).size ();
    }

    /**
     * Returns the strength of a node in this graph
     *
     * @param v
     *         vertex
     *
     * @return strength of v         Runtime - O(e)
     */
    @Override public double strength(E v) {
        double st = 0;

        // check if vertex is defined in graph.
        if ( !this.graph.containsKey (v) ) {
            throw new IllegalArgumentException ("Vertex " + v + " is doesn't exists");
        }
        Set<Edge<E>> edges = this.graph.get (v);
        Iterator<Edge<E>> it = edges.iterator ();
        while ( it.hasNext () ) {
            Edge<E> e = it.next ();
            st = st + e.getW ();
        }
        return st;
    }

    /**
     * toString method is overridden to represent graph.
     *
     * @return Adjacency list representation of this graph.
     *         runtime - O(v)
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
     * Private class represents a weighted edge in this graph
     * @param <E>
     */
    private class Edge<E> {
        private E dest;
        private double w;

        /**
         * Instantiates a new Edge.
         *
         * @param dest
         *         the dest
         * @param w
         *         the w
         */
        public Edge(E dest, double w) {
            this.dest = dest;
            this.w = w;
        }

        /**
         * Gets dest.
         *
         * @return the dest
         */
        public E getDest() {
            return dest;
        }

        /**
         * Sets dest.
         *
         * @param dest
         *         the dest
         */
        public void setDest(E dest) {
            this.dest = dest;
        }

        /**
         * Gets w.
         *
         * @return the w
         */
        public double getW() {
            return w;
        }

        /**
         * Sets w.
         *
         * @param w
         *         the w
         */
        public void setW(double w) {
            this.w = w;
        }

        @Override public String toString() {
            return "[" + dest + "|(" + w + ")]";
        }
    }
}

