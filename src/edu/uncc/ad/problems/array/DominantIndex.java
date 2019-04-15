package edu.uncc.ad.problems.array;


import java.util.Arrays;

/**
 * In a given integer array nums, there is always exactly one largest element.
 *
 * Find whether the largest element in the array is at least twice as much as every other number in the array.
 *
 * If it is, return the index of the largest element, otherwise return -1.
 *
 * Example 1:
 *
 * Input: nums = [3, 6, 1, 0]
 * Output: 1
 * Explanation: 6 is the largest integer, and for every other number in the array x,
 * 6 is more than twice as big as x.  The index of value 6 is 1, so we return 1.
 *
 * Example 2:
 *
 * Input: nums = [1, 2, 3, 4]
 * Output: -1
 * Explanation: 4 isn't at least as big as twice the value of 3, so we return -1.
 */
public class DominantIndex {

    public static void main(String[] args) {
        int[] nums = {0,0,3,2};
        System.out.println (updatedSolution (nums));
    }
    public static int dominantIndex(int[] nums){

        int len = nums.length;
        if(len == 0) return -1;
        if ( len == 1 ) return 0;
        int[] temp = nums.clone ();
        Arrays.sort (temp);
        if(temp[len -1] >= 2*temp[len-2]){
            for ( int i=0; i<len;i++ ){
                if(nums[i] == temp[len-1]){
                    return i;
                }
            }
        }

        return -1;

    }

    public static int updatedSolution(int[] nums){

        int len = nums.length;
        if(len == 0) return -1;

        int indexMax = 0;
        int max = nums[indexMax];

        // finding the maximum element and its index
        for(int i=0; i< len; i++){
            if(nums[i] > max){
                indexMax = i;
                max = nums[i];
            }
        }

        // to check if max number is twice than other numbers
        for(int i=0; i<len; i++){
            if( i == indexMax){
               continue;
            }
            if(2*nums[i] > max){
                return -1;
            }
        }

        return indexMax;

    }

}
