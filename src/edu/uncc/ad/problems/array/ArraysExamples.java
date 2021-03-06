package edu.uncc.ad.problems.array;

import java.util.Arrays;

/**
 * @author venky on 2019-02-23
 * @project AlgorithmAndDataStructure
 * @package edu.uncc.ad.list.arrays
 */
public class ArraysExamples {

    public static void main(String args[]) {

        example1 ();

    }

    public static void example1(){
        {
            int inarr1[] = {1, 2, 3};
            int inarr2[] = {1, 2, 3};
            Object[] arr1 = {inarr1};  // arr1 contains only one element
            Object[] arr2 = {inarr2};  // arr2 also contains only one element
            Object[] outarr1 = {arr1}; // outarr1 contains only one element
            Object[] outarr2 = {arr2}; // outarr2 also contains only one element
            if ( Arrays.deepEquals (outarr1, outarr2))
                System.out.println("Same");
            else
                System.out.println("Not same");
        }
    }
    public  static void example2(){
        final int arr1[] = {1, 2, 3, 4, 5};
        int arr2[] = {10, 20, 30, 40, 50};
        arr2 = arr1;
//        arr1 = arr2;
        for (int i = 0; i < arr2.length; i++)
            System.out.println(arr2[i]);
    }

}
