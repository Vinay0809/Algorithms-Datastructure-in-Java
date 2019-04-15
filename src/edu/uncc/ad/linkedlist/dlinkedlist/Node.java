package edu.uncc.ad.linkedlist.dlinkedlist;

import java.util.Objects;

/**
 * @author venky
 */
public class Node<E> {

    private E item;
    private Node<E> previous;
    private Node<E> next;

    public Node(E item) {
        this.item = item;
    }

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public Node<E> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<E> previous) {
        this.previous = previous;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    @Override public String toString() {
        return item.toString ();
    }

    @Override public boolean equals(Object o) {
        if ( this == o ) return true;
        if ( !(o instanceof Node) ) return false;
        Node<?> node = ( Node<?> ) o;
        return Objects.equals (getItem (), node.getItem ()) &&
                Objects.equals (getPrevious (), node.getPrevious ()) &&
                Objects.equals (getNext (), node.getNext ());
    }

    @Override public int hashCode() {
        return Objects.hash (getItem (), getPrevious (), getNext ());
    }
}
