package edu.uncc.ad.problems.array;

/**
 * @author venky
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = { 0,1,0,0,3,12 };
        moveZeroes (nums);
    }

    public static void moveZeroes(int[] nums) {


//        for ( int i = 0 ; i < nums.length - 1 ; i++ ) {
//            if ( nums[i] == 0 ) {
//                int p1 = i + 1;
//                while ( nums[p1] == 0 && p1 < nums.length - 1 ) {
//                    p1++;
//                }
//                int temp = nums[i];
//                nums[i] = nums[p1];
//                nums[p1] = temp;
//            }
//        }

        int p1 =0; // slow moving pointer
        for ( int i=0; i< nums.length;i++ ){ // i is fast moving pointer
            if ( nums[i] != 0 ){ // if ith element not zero move to left otherwise move forward to next element.
                int temp = nums[i]; // moving no zero elements to left
                nums[i] = nums[p1]; // p1 points to first zero
                nums[p1] = temp;

                p1++;
            }
        }

    }
}
