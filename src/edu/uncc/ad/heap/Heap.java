package edu.uncc.ad.heap;

/**
 * @author venky
 */
public interface Heap {

    void insert(int value);

    int remove();

    int delete(int value);

    int peek();

    boolean isEmpty();

    int getSize();

    int parentIndex(int index);

    int leftChildIndex(int index);

    int rightChildIndex(int index);
}
