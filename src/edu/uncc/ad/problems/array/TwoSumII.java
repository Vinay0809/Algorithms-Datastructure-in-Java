package edu.uncc.ad.problems.array;

/**
 * @author venky
 */

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 *
 * Note:
 *
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * Example:
 *
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */
public class TwoSumII {
    public static void main(String[] args) {
        int[] input = {2,7,11,15};
        int[] result = twoSum (input, 13);
    }
    public static int[] twoSum(int[] numbers, int target) {
       // check if array has only one element or null
        if(numbers.length == 0 || numbers == null){
            return new int[0];
        }

        // make first pointer to point to first element & second pointer to last element.
        int leftPointer = 0;
        int rightPointer = numbers.length -1;

        // traverse from both the end
        while ( leftPointer < rightPointer ){
            // check if element at first pointer + element at second pointer == target
            if ( target == (numbers[leftPointer] + numbers[rightPointer]) ){
                int[] indices = { leftPointer + 1, rightPointer + 1 };
                return indices;
            } else if ( (numbers[leftPointer] + numbers[rightPointer]) < target ){
                leftPointer++; // if sum of two numbers less than target, need larger number. Since right pointer
                // already pointing to larger number, leftPointer should be incremented.
            } else {
                rightPointer--; // if sum greater than target, need a smaller numebr. Since left pointer is already
                // pointing to smaller number, decrement right pointer.
            }
        }

        // if target don't match return 0
        return new int[0];
    }
}
