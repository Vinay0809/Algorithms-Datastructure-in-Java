package edu.uncc.ad.problems.array;

/**
 * @author venky
 */
public class RemoveAll {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 2};
        removeElement (nums, 2);
    }

    public static int removeElement(int[] nums, int val) {
        int k = 0; // this pointer
        for ( int i = 0 ; i < nums.length ; ++i ) {
            if ( nums[i] != val ) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
