package edu.uncc.ad.problems.array;

import java.util.Arrays;
import java.util.Collections;

/**
 *
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 *
 * Example:
 *
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 *
 *
 * @author venky
 */
public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        //int[] nums = {2,3,1,2,4,3};
        int[] nums = {5,1,3,5,10,7,4,9,2,8};
        System.out.println (minSubArrayLen (15,nums));
    }

    public static int minSubArrayLen(int s, int[] nums){
        if ( nums == null || nums.length == 0 ){
            return 0;
        }

        int arraySum = 0;



        // first pointer points to starting of array.
        int p1 = 0;
        int p2 = 0;
        int min = nums.length;
        // first pointer adds each element
        while ( p1 < nums.length ){

            arraySum += nums[p1++];
            // if sum is greater or equal to given s, then mind the update the minimum
            // reduce the sum by subtracting value of first pointer and check if greater than given sum, if so update
            // min.
            while ( arraySum >= s ){
                min = Math.min (min,p1 - p2);
                arraySum -= nums[p2++];

            }


        }

        return min;
    }

    public static int sol(int s, int[] a){
        if (a == null || a.length == 0)
            return 0;

        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

        while (j < a.length) {
            sum += a[j++];

            while (sum >= s) {
                min = Math.min(min, j - i);
                sum -= a[i++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

}
