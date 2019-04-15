package edu.uncc.ad.sorting;

public class ShellSort {

    /**
     * Method to implement Shell sort
     *
     * @param nums unsorted array of numbers
     * @param n    size of an array
     */
    public static void shellSort(int[] nums, int n) {

        // traverse through the gap
        for (int gap = n / 2; gap > 0; gap /= 2) {

            //traverse from gap to end of an array
            for (int i = gap; i < n; i++) {
                int newElement = nums[i];

                int j = i;
                while (j >= gap && nums[j - gap] > newElement) {
                    nums[j] = nums[j - gap];
                    j -= gap;
                }
                nums[j] = newElement;

            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -2, 8, 4, 9, 6};

        shellSort(nums, nums.length);
        System.out.println("Sorted Array");
        for (int i : nums) {
            System.out.println(i);
        }
    }

}
