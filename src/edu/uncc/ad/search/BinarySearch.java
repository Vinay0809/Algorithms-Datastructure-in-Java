package edu.uncc.ad.search;

/**
 * - It is a standard search algorithm
 * - Needs sorted data.
 * - Choose middle element and compare for key based on that search only left part or right part.
 * - It keep on dividing the array into two parts so runtime is O(log n)
 *
 * @author venky
 */
public class BinarySearch {
    /**
     * Iterative binary search.
     * @param input A sorted input array.
     * @param key search key.
     * @return index of specified search key.
     */
    public static int binarySearch(int[] input, int key){
        if ( input == null || input.length == 0 )
            return -1;

        int start = 0;
        int end = input.length;

        while ( start < end ){
            int mid = (start + end) / 2;
            if ( input[mid] == key){
                return mid;
            } else if ( input[mid] < key ){
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return -1;
    }

    /**
     * Recursive version of binary search
     * @param input An input array sorted.
     * @param key search key
     * @return an index of key
     */
    public static int recursiveBinarySearch(int[] input, int key){
        if ( input == null || input.length == 0 )
            return -1;
        else
            return recursiveBinarySearch (input,0, input.length, key);
    }

    /**
     * Recursive version of binary search
     * @param input An input array sorted.
     * @param start start index
     * @param end length of array
     * @param key search key
     * @return an index of key
     */
    private static int recursiveBinarySearch(int[] input, int start, int end, int key) {

        if ( start >= end ){
            return -1;
        }
        int mid = (start + end) / 2;
        if ( input[mid] == key ){
            return mid;
        } else if ( input[mid] < key ){
            return recursiveBinarySearch (input,mid +1, end, key);
        } else {
            return recursiveBinarySearch (input, 0, mid, key);
        }
    }
}
