package edu.uncc.ad.heap.maxheap;

import edu.uncc.ad.heap.Heap;

import java.util.NoSuchElementException;

/**
 * Simple implementation of max heap backed by an array for integers only. It provides following public methods.
 *
 * insert
 * remove
 * delete
 * peek
 * isEmpty
 * getSize
 *
 * @author venky
 */
public class MaxHeap implements Heap {

    /**
     * Array to store heap
     */
    private int[] heap;

    /**
     * size of the heap
     */
    private int size;

    /**
     * Instantiates a new Max heap with specified capacity.
     *
     * @param capacity
     *         the capacity
     */
    public MaxHeap(int capacity) {
        heap = new int[capacity];
    }

    /**
     * Instantiates a new Max heap with fixed capacity of 10.
     */
    public MaxHeap() {
        heap = new int[10];
    }

    /**
     * Instantiates a new Max heap by an array of elements.
     *
     * @param a
     *         the a
     */
    public MaxHeap(int[] a) {
        heap = a;
        buildMaxHeap (heap);
        size = heap.length;
    }


    /**
     * Public Instance methods
     */

    /**
     * method to insert an element to this heap. It thows IndexOutOfBoundsException if heap is full.
     * @param value element to be inserted into this heap.
     */
    @Override
    public void insert(int value) {
        // insert the value
        if ( !isEmpty () ) {
            throw new IndexOutOfBoundsException ("Heap is full");
        }
//        heap[size++] = value;
//        buildMaxHeap (heap, size); // make it as heap
        heap[size] = value;
        maxHeapify (size);
        size++;
    }

    /**
     * Method to remove an element from this heap (In other words maximum element of this heap). Throws
     * NoSuchElementException if heap is empty.
     * @return root node of this heap
     */
    @Override public int remove() {
        if ( isEmpty () ) {
            throw new NoSuchElementException ("Removing from empty heap");
        }
        int e = heap[0]; // remove root node
        heap[0] = heap[size - 1]; // move last element to root node
        heap[size - 1] = 0; // assign last element to 0;
        size--; // decrement the size.
        buildMaxHeap (heap, size); // rearrange the heap
        return e;
    }

    /**
     * This method deletes an element from the heap. If heap is empty it throws NoSuchElementException exception.
     * @param value element to be deleted from this heap.
     * @return deleted element.
     */
    @Override public int delete(int value) {
        if ( value > heap[0] ) {
            throw new NoSuchElementException ();
        }
        // if deleting element is last element of heap
        if ( value == heap[getSize () - 1] ) {
            int e = heap[getSize () - 1];
            heap[getSize () - 1] = 0;
            size--;
            return e;
        }

        // value is root node then calling remove methods.
        if ( value == heap[0] ) {
            return remove ();
        }

        int i = getIndex (value, 0);
        int e = heap[i];
        // swap this with last element (making it to zero).
        heap[i] = heap[getSize () - 1];
        heap[getSize () - 1] = 0;
        size--;
        buildMaxHeap (heap, size);
        return e;
    }

    /**
     * This methods returns the root node of this heap. (This doesn't delete the root node)
     * @return root node of this heap.
     */
    @Override public int peek() {
        return heap[0];
    }

    /**
     * Returns true if the backing array is not full, or false (In other words, returns true if a heap can accommodate
     * any more, otherwise false)
     * elements.
     * @return boolean
     */
    @Override public boolean isEmpty() {
        if ( size < heap.length )
            return true;
        else
            return false;
    }

    /**
     * Returns the size of this heap. (It is not the size of backing array, it returns number of elements in this heap)
     * @return number of elements in this heap.
     */
    @Override public int getSize() {
        return size;
    }


    /**
     * PRIVATE METHODS
     */

    /**
     *
     * @param value
     * @param root
     * @return
     */
    private int getIndex(int value, int root) {
        if ( value == heap[root] ) {
            return root;
        }

        while ( root < getSize () ) {
            int l = leftChildIndex (root);
            int r = rightChildIndex (root);

            if ( l < getSize () && heap[l] == value ) {
                return l;
            }
            if ( r < getSize () && heap[r] == value ) {
                return r;
            }
            root++;
        }
        return -1;

    }



    // core methods

    /**
     * (i/2)
     * returns the index of parent node.
     * @param index
     * @return
     */
    @Override public int parentIndex(int index) {
        return (index - 1) / 2;
    }

    /**
     *Returns the index of left child of specific node
     *  (2i)
     * @param index
     * @return
     */
    @Override public int leftChildIndex(int index) {
        return (2 * index) + 1;
    }

    /**
     * Returns the index of right child.
     * (2i + 1)
     * @param index
     * @return
     */
    @Override public int rightChildIndex(int index) {
        return (2 * index) + 2;
    }

    /**
     * A core method to preserve the max heap property on backed array.
     * @param a A backing array.
     * @param index index to be arranged.
     */
    private void maxHeapify(int[] a, int index) {
        // get the left child index
        int l = leftChildIndex (index);
        int r = rightChildIndex (index); // get the right child index
        int largest;
        // check if left child of new element is greater than new element, if so largest will be left child
        // otherwise, largest element will be new element.
        if ( l < a.length && a[l] > a[index] ) {
            largest = l;
        } else {
            largest = index;
        }

        // check if right child of new element is greater than largest, if so largest will be right child
        if ( r < a.length && a[r] > a[largest] ) {
            largest = r;
        }

        if ( largest != index ) {
            // exchange new element with largest element. i.e the largest element will become the root of tree
            int temp = a[index];
            a[index] = a[largest];
            a[largest] = temp;
            maxHeapify (a, largest);
        }
    }

    /**
     * Method to build heap from an array.
     * @param heap an array
     */
    private void buildMaxHeap(int[] heap) {
        for ( int i = heap.length / 2 ; i >= 0 ; i-- ) {
            maxHeapify (heap, i);
        }

    }

    /**
     * Method to build heap from an array.
     * This method can heapify only specified number of elements in an array
     *
     * @param heap an array
     * @param size upper bond of array to be heapify.
     */
    private void buildMaxHeap(int[] heap, int size) {
        for ( int i = size / 2 ; i >= 0 ; i-- ) {
            maxHeapify (heap, i);
        }
    }

    /**
     * More efficient heapify method, this method works effectively when inserting new value into heap
     * @param index last index of backing array
     */
    private void maxHeapify(int index){
        // get the last value
        int value = heap[index];

        while ( index > 0 && value > heap[parentIndex (index)] ){
            heap[index] = heap[parentIndex (index)];
            index = parentIndex (index);

        }

        heap[index] = value;

    }

}
