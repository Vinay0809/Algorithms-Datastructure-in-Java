package edu.uncc.ad.stack;

/**
 * @author venky on 2019-03-02
 * @project AlgorithmAndDataStructure
 * @package edu.uncc.ad.stack
 */

import java.util.EmptyStackException;

/**
 * Simple stack implementation backed by array.
 *
 * @param <E>
 */
public class ArrayStack<E> {

    private E[] stack;
    private int top;

    public ArrayStack(int initialCapacity) {
        stack = ( E[] ) new Object[initialCapacity];
    }

    /**
     * Method to push an item to the top of stack.
     * if stack is not full, runtime is O(1) else runtime is O(n) because of array copy.
     *
     * @param item
     */
    public void push(E item) {
        // check if stack is full
        if ( top == stack.length ) {
            // if stack is full resize the array with double length
            E[] newArray = ( E[] ) new Object[2 * stack.length];
            // copy old array to new array
            System.arraycopy (stack, 0, newArray, 0, stack.length);
            stack = newArray; // assigning to stack
        }
        // if stack is not full add new item to top
        stack[top] = item;
        // increase the top
        top++;
    }

    /**
     * Method to pop an item from the top of stack. Runtime O(1)
     * @return an item at the top of stack
     */
    public E pop() {
        // check if stack is empty
        if ( isEmpty () ) {
            throw new EmptyStackException ();
        }
        // else return the pop the top item
        E item = stack[--top]; // pre decrementing top, because top is pointing to next available space.
        // Ex - if an item at 0th position top is pointing to 1st position.
        stack[top] = null;
        return item;
    }

    /**
     * Method to access an item at the top of stack. Runtime O(1)
     * @return an item at the top of stack
     */
    public E peek(){
        // check if stack is empty
        if ( isEmpty () ){
            throw new EmptyStackException ();
        }
        E item = stack[top -1]; // here using top-1 because, no need to decrement the top, as it is only accessing
        // top item and returning not popping it.
        return item;
    }
    /**
     * Checks if stack is empty or not. If a stack is empty top will be 0
     *
     * @return true if stack is empty, false if stack is not empty.
     */
    public boolean isEmpty() {
        return top == 0;
    }

    /**
     * Method to return size of stack
     * @return size of stack
     */
    public int size(){
        return top;
    }

    /**
     * Method to print stack items from top.
     */
    public void printStack(){
        for(int i=top-1; i>= 0; i--){
            System.out.println (stack[i]);
        }
    }
}
