package edu.uncc.ad.stack;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @author venky
 */

/**
 * A simple stack implementation backed by java.util.LinkedList
 *
 * @param <E>
 */
public class Stack<E> {

    private LinkedList<E> stack;

    public Stack() {
        stack = new LinkedList<> ();
    }

    /**
     * Pushes an element onto the stack
     *
     * @param item
     *         the element to push
     */
    public void push(E item) {
        stack.push (item);
    }

    /**
     * Pops an element from the stack.
     *
     * @return the element at  the top of the stack
     */
    public E pop() {
        return stack.pop ();
    }

    /**
     * Retrieves, but does not remove, the top of the stack.
     *
     * @return the top of this stack, or null if this stack is empty
     */
    public E peek() {
        return stack.peek ();
    }

    /**
     * Returns true if this stack contains no elements.
     *
     * @return true if this stack contains no elements
     */
    public boolean empty() {
        return stack.isEmpty ();
    }

    /**
     * Returns the number of elements in this stack.
     *
     * @return number of elements in this stack
     */
    public int size() {
        return stack.size ();
    }

    /**
     * Prints all elements in this stack
     */
    public void printStack() {
        ListIterator<E> listIterator = stack.listIterator ();
        while ( listIterator.hasNext () ) {
            System.out.println (listIterator.next ());
        }
    }
}
