package edu.uncc.ad.problems.array;

import java.util.HashMap;

/**
 * @author venky
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {3,2,3};
        twoSum (nums, 6);
    }
    public static int[] twoSum(int[] nums, int target) {

        if ( nums.length <= 0 ){
            return new int[0];
        }

        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<> (nums.length);
        for(int i=0;i<nums.length; i++){
            map.put(nums[i],i);
        }
        for(int i = 0; i<nums.length-1; i++){
            int comp = target - nums[i];
            if(map.containsKey (comp) && map.get (comp) != i){
                result[0] = i;
                result[1] = map.get (comp);
                break;
            }

        }

        return result;

    }
}
