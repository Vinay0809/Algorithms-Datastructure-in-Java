package edu.uncc.ad.search;

/**
 * @author venky
 */
public class LinearSearch {

    /**
     * Most intuitive search algorithm. Runtime of Linear search would be O(n)
     * @param input An input array.
     * @return index of specified search key.
     */
    public static int linearSearch(int[] input, int key){
        if ( input == null || input.length == 0 )
            return -1;
        for ( int i = 0; i<input.length; i++ ){
            if ( input[i] == key )
                return i;
        }

        return  -1;
    }
}
