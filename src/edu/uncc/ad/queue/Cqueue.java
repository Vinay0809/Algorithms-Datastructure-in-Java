package edu.uncc.ad.queue;

import java.util.NoSuchElementException;

/*
 * @author venky
 */


/**
 * The type Cqueue.
 *
 * @param <E>
 *         the type parameter
 */

public class Cqueue<E> {


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
    public Cqueue() {
        queue = ( E[] ) new Object[10];
    }

    /**
     * Instantiates a new queue.
     *
     * @param initialCapacity
     *         the initial capacity of this queue
     */
    public Cqueue(int initialCapacity) {
        queue = ( E[] ) new Object[initialCapacity];
    }

    /**
     * Add an element to the back of this queue.
     *
     * @param e
     *         the element to be added.
     */
    public void add(E e) {
        // check if queue is full, if so resize queue by double i.e when size (number of elements in this queue) of
        // queue equals
        if ( size () == queue.length) {
            int size = size (); //this will be used to set new back
            E[] temp = ( E[] ) new Object[2 * queue.length];

            System.arraycopy (queue, front, temp, 0, queue.length - front);
            if ( back < front ) { // copy second part only if back is wrapped to front.
                System.arraycopy (queue, 0, temp, queue.length - front, back);
            }
            queue = temp;
            temp = null;

            front = 0; //  font will be first index of new array
            back = size; // back will be pointing to next index of last element.
        }

        queue[back] = e;
        // increment the back only if there are enough space to hold one more element. i.e when back < length - 1.
        // otherwise wrap the back to 0th index.
        if ( back < queue.length - 1 ) {
            back++;
        } else {
            back = 0; // pointing back towards front
        }

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
        if ( front < queue.length - 1 ) {
            front++; // increment front only till last element in this array.
        } else {
            front = 0;
        }

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
     * Size of this queue (in other words number of elements in queue) .
     *
     * @return the size
     */
    public int size() {
        int size;
        if ( back >= front ) {
            size = back - front; // this case if true only if back is greater than front.
        } else {
            size = back - front + queue.length; // when back is less than front
        }
        return size;
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
        if ( back >= front ) {
            for ( int i = front ; i < back ; i++ ) {
                System.out.print (queue[i] + " ");
            }
            System.out.println ();
        } else {
            for ( int i = front ; i < queue.length ; i++ ) {
                System.out.print (queue[i] + " ");
            }
            for ( int i = 0 ; i < back ; i++ ) {
                System.out.print (queue[i] + " ");
            }

            System.out.println ();
        }

    }
}
