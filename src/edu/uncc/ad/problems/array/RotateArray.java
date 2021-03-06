package edu.uncc.ad.problems.array;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * Example 1:
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 * CYCLIC Replacement Algorithm
 *
 * @author venky
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {-1,-100,3,99};
        int k = 2;
//        rotate (nums, k);
        rotateExtraArray (nums, k);
    }

    public static void rotate(int[] nums, int k) {
        // from right side.
        for ( int i = 1; i <= k; i++){
            rotateByOne (nums);
        }
    }

    public static void rotateByOne(int[] nums){
        int temp = nums[nums.length-1]; // last element of array to be shifted.
        int i;
        for (  i = nums.length - 1; i > 0; i-- ){
            nums[i] = nums[i-1];
        }
        nums[i] = temp;
    }

    public static void rotateExtraArray(int[] nums, int k){
        int length = nums.length;
        int[] temp = new int[length];

        for ( int i=0; i < nums.length; i++ ){
            int pos = (k + i) % length;
            temp[pos] = nums[i];
        }

        for ( int i = 0;i<length; i++ ){
            nums[i] = temp[i];
        }
    }
}
