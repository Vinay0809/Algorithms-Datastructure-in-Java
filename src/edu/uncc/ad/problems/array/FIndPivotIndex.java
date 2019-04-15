package edu.uncc.ad.problems.array;

/**
 * Given an array of integers nums, write a method that returns the "pivot" index of this array. We define the pivot
 * index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the
 * right of the index. If no such index exists, we should return -1. If there are multiple pivot indexes, you should
 * return the left-most pivot index.
 * Input: nums = [1, 7, 3, 6, 5, 6] Output: 3 Explanation: The sum of the numbers to the left of index 3 (nums[3] = 6)
 * is equal to the sum of numbers to the right of index 3. Also, 3 is the first index where this occurs.
 * Example 2:
 * <p>
 * Input: nums = [1, 2, 3] Output: -1 Explanation: There is no index that satisfies the conditions in the problem
 * statement.
 */


public class FIndPivotIndex {

    public static void main(String[] args) {
    //  int[] nums = {1, 7, 3, 6, 5, 6};
//     int[] nums = {1, 2, 3};
//       int[] nums = { 1, 2, 3, 4, 5, 8, 10, 5 };
//       int[] nums = {-1,-1,-1,-1,-1,0};
//        int[] nums = {};
//        int[] nums = {-1,-1,-1,0,1,1};
       int[] nums = {-1, 1, 1};

//        System.out.println (pivotIndex (nums));
        System.out.println (pivotIndexSolution (nums));
    }

    public static int pivotIndex(int[] nums) {

        if(nums.length < 2)
            return -1;
        int pivot = 0;
        while ( pivot < nums.length  ){
            if(findSum (nums,0,pivot) == findSum (nums,pivot+1, nums.length)){
                return pivot;
            }
            pivot += 1;
        }

        return -1;

    }

    /**
     * Method to find the sum
     **/
    private static int findSum(int[] nums, int start, int end) {
        int sum = 0;
        for ( int i = start ; i < end ; i++ ) {
            sum = sum + nums[i];
        }
        return sum;
    }

    private static int pivotIndexSolution(int[] nums){
        int sum = 0, leftsum = 0;
        for (int x: nums) sum += x;
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }
}
