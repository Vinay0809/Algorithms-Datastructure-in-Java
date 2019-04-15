package edu.uncc.ad.problems.array;

import java.util.Arrays;

/**
 * @author venky
 */
public class ReverseArray {

    public static void main(String[] args) {
        int[] array = {1,3,6,2,5,4,8};
        long strartTime = System.currentTimeMillis ();
       array =  reverseArray(array, array.length);
        System.out.println ("finished in "+(System.currentTimeMillis () - strartTime)+" ms");

    }

    private static int[] reverseArray(int[] array, int length) {
        // using two points
        int p1 = 0;
        int p2= length - 1;

        while ( p1 < p2 ){
            int temp = array[p1];
            array[p1] = array[p2];
            array[p2] = temp;

            p1++;
            p2--;
        }

        return array;

    }
}
