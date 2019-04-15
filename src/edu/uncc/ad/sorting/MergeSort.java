package edu.uncc.ad.sorting;



public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {10, 2, 6, -12, 5, 12, 16};
        mergeSort(nums, 0, nums.length);

        System.out.println("Sorted Array");

        for(int i = 0; i< nums.length; i++){
            System.out.println(nums[i]);
        }
    }

    /**
     * Method to divide the array
     * @param nums Input array
     * @param start start index of input array
     * @param end last index of input array
     */
    public static void mergeSort(int[] nums, int start, int end) {
        // check for the base condition
        if (end - start < 2) {
            return;
        }
        // otherwise break the array [10, 2, 6, -12, 5,12,16] into parts
        int mid = (start + end) / 2;
        // now got the mid and array is divided
        // Left array - [10, 2, 6] & Right array - [-12, 5, 12, 16]
        mergeSort(nums, start, mid);  //calling mergeSort for left array
        mergeSort(nums, mid, end); //calling mergeSort for right array
        // merge the sorted array
        merge(nums, start, mid, end);
    }

    /**
     * Method to merge the array
     * @param nums input array
     * @param start start index
     * @param mid middle index
     * @param end last index
     */
    private static void merge( int[] nums, int start, int mid, int end) {
        // [10, 2, 6, -12, 5,12,16]
        // if last element of left array is smaller than first element of right array
        if (nums[mid - 1] <= nums[mid]) {
            return;
        }
        // now, creating a temporary array to hold the sorted elements
        int i = start; // i points to first index of left array
        int j = mid;    // j points to first index of right array
        int tempIndex = 0;
        int[] tempArray = new int[end - start]; //new array to hold the sorted elements.
        while (i < mid && j < end) { // this loop runs as long as we don't finish left and right array
            //now, compare the elements of left array and right array and insert the smallest element to temp array
            // and increment
            tempArray[tempIndex++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        }
        // if there any element in left array which is greater than all elements in right array
        // we need to copy that into input array, and that element position will be next position of temp array.
        System.arraycopy(nums, i, nums,start+tempIndex,mid-i);
        // in above step, copying the leftout element of left array which is pointed by i
        //to the new position, that position determined by the last tempIndex+start, lenght is left array.

        // now copying complete temp array to input array.
        System.arraycopy(tempArray,0,nums,start,tempIndex);

    }

}
