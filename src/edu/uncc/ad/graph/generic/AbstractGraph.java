package edu.uncc.ad.graph.generic;

import java.util.Set;

/**
 * @author venky
 */
public interface AbstractGraph<E> {
    void addEdge(E src, E dest);

    void addVertex(E v);

    Set<E> getNeighbours(E v);

    void removeVertex(E v);

    void removeEdge(E src, E dest);

    int degree(E v);

//    int edges();

    Set<E> vertices();

    String size();
}
