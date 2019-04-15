package edu.uncc.ad.sorting;

public class MergeSortReverse {

    public static void main(String[] args) {
        int[] nums = {10, 2, 6, -12, 5, 12, 16};
        mergeSortReverse(nums, 0, nums.length);

        System.out.println("Sorted Array");

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    /**
     * Method to divide the array into two parts.
     * @param nums input array
     * @param start start index
     * @param end length of array
     */
    public static void mergeSortReverse(int[] nums, int start, int end) {
        // check for the base condition
        if (end - start < 2) {
            return;
        }
        // otherwise break the array [10, 2, 6, -12, 5,12,16] into parts
        int mid = (start + end) / 2;
        // now got the mid and array is divided
        // Left array - [10, 2, 6] & Right array - [-12, 5, 12, 16]
        mergeSortReverse(nums, start, mid);  //calling mergeSort for left array
        mergeSortReverse(nums, mid, end); //calling mergeSort for right array
        // merge the sorted array
        mergeReverse(nums, start, mid, end);
    }

    /**
     * Method to sort the array in reversing order and merge.
     * @param nums input array
     * @param start start index
     * @param mid mid index
     * @param end length of array
     */
    public static void mergeReverse(int[] nums, int start, int mid, int end) {

        if (nums[mid - 1] >= nums[mid]) {
            return;
        }

        int i = start; // i points to first index of left array
        int j = mid;    // j points to first index of right array
        int tempIndex = 0;
        int[] tempArray = new int[end - start]; //new array to hold the sorted elements.
        while (i < mid && j < end) {
            tempArray[tempIndex++] = nums[i] >= nums[j] ? nums[i++] : nums[j++];
        }

        System.arraycopy(nums, i, nums, start + tempIndex, mid - i);
        // now copying complete temp array to input array.
        System.arraycopy(tempArray, 0, nums, start, tempIndex);

    }
}

