package edu.uncc.ad.stack.threadsafestack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * @author venky
 */

/**
 * A threadsafe Stack implementation backed by Deque interface.
 * Advantage of this implementation over JDK Stack -
 * As suggested by Java, stack backed by Deque interface is more complete and consistent than one backed by Vector.
 * Stack doesn't constructor to create a new stack with initial capacity.
 * @param <E>
 */
public class Stack<E> {

    private Deque<E> stack;

    /**
     * Default Constructor , if initialCapacity is not specified.
     */
    public Stack() {
        stack = new ArrayDeque<E> ();
    }

    /**
     * Constructs an empty stack backed by deque with an initial capacity sufficient to hold the specified number of elements.
     * @param initialCapacity lower bound on initial capacity of the stack
     */
    public Stack(int initialCapacity) {
        stack = new ArrayDeque<E> (initialCapacity);
    }

    /**
     * Pushes an element onto the head of this stack
     * @param item the element to push
     */
    public synchronized void push(E item){
        stack.push (item);
    }

    /**
     * Pops an element from this stack (removes and returns the element at the top of this stack).
     * @return the element at the top of this stack
     */
    public synchronized E pop(){
        return stack.pop ();
    }

    /**
     * Retrieves, but does not remove, the top element of this stack.
     * @return the element at the top of this stack
     */
    public synchronized E peek(){
        return stack.peek ();
    }

    /**
     * Returns true if this stack contains no elements.
     *
     * @return true if this stack contains no elements
     */
    public synchronized boolean empty(){
        return stack.isEmpty ();
    }

    /**
     * Returns the number of elements in this stack.
     *
     * @return number of elements in this stack
     */
    public synchronized int size(){
        return stack.size ();
    }

    /**
     * Print all elements in this stack
     */
    public synchronized void printStack(){
        Iterator<E> iterator = stack.iterator ();
        while ( iterator.hasNext () ){
            System.out.println (iterator.next ());
        }
    }
}
