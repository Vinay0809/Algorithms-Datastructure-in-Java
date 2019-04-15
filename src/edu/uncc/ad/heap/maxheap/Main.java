package edu.uncc.ad.heap.maxheap;

import edu.uncc.ad.heap.Heap;

/**
 * @author venky
 */
public class Main {

    public static void main(String[] args) {
        int[] input = {20,18,19,16,17,14,15,13};

        Heap newHeap = new MaxHeap (15);

        for ( int i:input ){
            newHeap.insert (i);
        }

        newHeap.insert (21);


    }

}
