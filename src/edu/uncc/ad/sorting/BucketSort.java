package edu.uncc.ad.sorting;

/**
 * @author venky
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



/**
 * Bucket sort makes use of hash function.
 * Sorts in three steps -
 * 1. Scattering items into buckets (Distributing values into buckets based on hash values)
 * 2. Sort each bucket (We can use any stable sort algorithm for this)
 * 3. Merge each bucket.
 */
public class BucketSort {
    public static void main(String[] args) {
        int[] input = {32, 48, 21, 11, 16, 4, 50};

        bucketSort(input);
        for ( int value: input){
            System.out.println (value);
        }
    }

    public static void bucketSort(int[] input) {
        // 1. scattering items into bucket.

        // will use ArrayList as bucket.
        List<Integer>[] buckets = new List[input.length]; // bucket is an array of List
        // creating buckets for each elements.
        for ( int i=0; i<input.length;i++ ){
            buckets[i] = new ArrayList<Integer> ();
        }

        // Adding item to bucket.
        for ( int i=0; i<input.length; i++){
            buckets[hash(input[i])].add (input[i]);
        }

        // 2. Sort each bucket.
        /**
         * here I'm using the JDK's sort on collection
         * Using insertion sort would be more ideal.
         */
        for ( List<Integer> bucket: buckets){
//            Collections.sort (bucket);
            insertionSort (bucket);
        }

        // 3. merge the buckets
        int j=0;
        for ( int i=0; i< buckets.length; i++ ){
            for ( int value: buckets[i] ){
                input[j++] = value;
            }
        }
    }

    private static int hash(int value){
        final int hash = value / 10;
        return hash;
    }

    private static void insertionSort(List<Integer> list){


        for ( int i=1; i<list.size (); i++ ){
            // key
            int key = list.get (i);
            // sorted part
            int j = i-1;

            while ( j>=0 && list.get (j) > key ){
                list.set (j+1, list.get (j));
                j = j-1;
            }


            list.set (j+1,key);

        }
    }
}
