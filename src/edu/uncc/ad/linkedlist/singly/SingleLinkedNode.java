package edu.uncc.ad.linkedlist.singly;

/**
 * This class represents a single node in Linked list.
 * It has one Student object and reference to next node.
 *
 * @author venky
 */
public class SingleLinkedNode<E> {
    private SingleLinkedNode<E> next;
    private E item;

    public SingleLinkedNode(E item) {
        this.item = item;
    }

    public SingleLinkedNode getNext() {
        return next;
    }

    public void setNext(SingleLinkedNode next) {
        this.next = next;
    }

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    @Override public String toString() {
        return item.toString ();
    }

}
