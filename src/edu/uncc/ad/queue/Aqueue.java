package edu.uncc.ad.queue;

import java.util.NoSuchElementException;

/*
  @author venky
 */

/*
 * A simple queue implementation backed by an Array
 * This implementation can't be used in practical scenario, because it has many serious problems
 * 1. Typecasting from Object to Generic is not for the practical purpose.
 * 2. The Size of the queue keep on doubling once back pointer reaches to length-1 of backing array, even if backing
 * array is has many empty spaces.
 *
 * @param <E>
 *         the type parameter
 */
public class Aqueue<E> {

    private E[] queue;
    /**
     * Pointer to front of this queue
     */
    private int front;
    /**
     * pointer to back of queue
     */
    private int back;

    /**
     * Instantiates a new queue with default initial capacity 10.
     */
    public Aqueue() {
        queue = ( E[] ) new Object[10];
    }

    /**
     * Instantiates a new queue.
     *
     * @param initialCapacity
     *         the initial capacity of this queue
     */
    public Aqueue(int initialCapacity) {
        queue = ( E[] ) new Object[initialCapacity];
    }

    /**
     * Add an element to the back of this queue.
     *
     * @param e
     *         the element to be added.
     */
    public void add(E e) {
        // check if queue is full, is so resize queue by double
        if ( back == queue.length ) {
            E[] temp = ( E[] ) new Object[2 * queue.length];
            System.arraycopy (queue, front, temp, 0, queue.length);
            queue = temp;
            temp = null;
        }
        queue[back] = e;
        back++;
    }

    /**
     * Remove an element at the front of this queue.
     *
     * @return the element at the front of this queue.
     */
    public E remove() {
        // check if size is 0.
        if ( size () == 0 ) {
            throw new NoSuchElementException ();
        }
        // otherwise return an element from front.
        E eRemoving = queue[front];
        queue[front] = null;
        front++;
        // check if there was only one element in queue, in that case both front and back points to same place.
        if ( size () == 0 ) {
            front = 0;
            back = 0;
        }
        return eRemoving;
    }

    /**
     * Peeks (but not remove) an element at the front of this queue.
     *
     * @return the element at the front of this queue.
     */
    public E peek() {
        // check if size is 0.
        if ( size () == 0 ) {
            throw new NoSuchElementException ();
        }

        E ePeek = queue[front];
        return ePeek;
    }

    /**
     * Size of this queue.
     *
     * @return the size
     */
    public int size() {
        final int i = back - front;
        return i;
    }

    /**
     * To check if queue is empty.
     *
     * @return the true if there is no element in this queue.
     */
    public boolean empty() {
        return ((size () == 0 ? true : false));
    }

    /**
     * Prints all elements in this queue.
     */
    public void print() {
        for ( int i = front ; i < back ; i++ ) {
            System.out.print (queue[i] + " ");
        }
        System.out.println ();
    }

}
