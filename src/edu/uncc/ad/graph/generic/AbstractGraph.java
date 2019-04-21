package edu.uncc.ad.graph.generic;

import java.util.List;
import java.util.Set;

/**
 * @author venky
 */
public interface AbstractGraph<E> {
    void addEdge(E src, E dest);

    void addVertex(E v);

    List<E> getNeighbours(E v);

    void removeVertex(E v);

    void removeEdge(E src, E dest);

    int degree(E v);

//    int edges();

    List<E> vertices();

    List<Integer> size();
}
