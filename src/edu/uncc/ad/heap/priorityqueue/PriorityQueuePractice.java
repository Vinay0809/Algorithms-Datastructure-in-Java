package edu.uncc.ad.heap.priorityqueue;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author venky
 */
public class PriorityQueuePractice {

    public static void main(String[] args) {

        int[] nums = {26,7,19,-8,11,2,4};

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<> ();

        for ( int i : nums ){
            priorityQueue.offer (i);
        }

        for ( int i: priorityQueue ){
            System.out.print (i+" ");
        }
        System.out.println ();
      System.out.println (priorityQueue.poll ());
        System.out.println (priorityQueue.poll ());
    }
}
