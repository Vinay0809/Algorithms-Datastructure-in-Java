package edu.uncc.ad.problems.array;

/**
 * @author venky
 */
public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println (findMaxConsecutiveOnes(nums));


    }

    private static int findMaxConsecutiveOnes(int[] nums) {

        int count = 0;
        int k = 0;

        for(int i = 0; i < nums.length; i++){
            if( nums[i] != 0){
                k++;
            } else{
                if(k > count){
                    count = k;
                }

                k = 0;
            }

        }
        if(k> count)
            count = k;

        return count;
    }

}
