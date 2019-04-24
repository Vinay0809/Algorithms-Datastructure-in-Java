package edu.uncc.ad.graph.weighted;

/**
 * @author venky
 */
public interface WeightedGraph<E> {
    void addVertex(E v);

    void addEdge(E src, E dest, double w);

    int edgesCount();

    int verticesCount();

    int degree(E v);

    double strength(E v);

    double clusteringCoefficient(E v);
    @Override String toString();
}
