package edu.uncc.ad.graph.weighted;

/**
 * @author venky
 */
class Edge<E> {
    private E dest;
    private double w;

    public Edge(E dest, double w){
        this.dest = dest;
        this.w = w;
    }

    public E getDest() {
        return dest;
    }

    public void setDest(E dest) {
        this.dest = dest;
    }

    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
    }

    @Override public String toString() {
        return "["+ dest +"|("+ w +")]";
    }
}
