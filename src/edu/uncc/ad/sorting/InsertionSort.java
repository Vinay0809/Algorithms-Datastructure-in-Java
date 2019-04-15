package edu.uncc.ad.sorting;

public class InsertionSort {

    /**
     * Method to that implements the insertion sort
     * @param array an input unsorted array
     * @param n  Size of an array
     */
    public static void insertionSort(int[] array, int n){

        // loop from 1 to n
        for(int i=1; i<n; i++){
            // assign the ith element as key to compare
            int key = array[i];

            // sorted part
            int j = i -1;

            while (j>= 0 && array[j] > key){
                array[j+1] = array[j];
                j = j - 1;
            }
            array[j+1] = key;

        }

    } // end of method insertionSort

    /**
     * Divide the array into two parts, sorted and unsorted. Pick one element from sorted position and insert into
     * sorted position. Start from the first index of the array.
     * @param nums
     * @param n
     */
    public static void insertionSortV2(int[] nums, int n){

        for (int firstUsortedIndex = 1; firstUsortedIndex < nums.length; firstUsortedIndex++){

            int key = nums[firstUsortedIndex];
            int i;
            for (i=firstUsortedIndex;i>0 && nums[i-1] > key; i--){
                nums[i] = nums[i-1];
            }
            nums[i] = key;

        }

    }

    /**
     * Recursive version of insertion loop.
     * Here reducing the unsorted partition by one and calling recursively, which makes the sorted
     * partition to grow by one
     * @param nums input array.
     * @param numberOfItems number of items to be sorted.
     */
    public static void insertionSortRec(int[] nums, int numberOfItems){
        System.out.println("Recursion version of insertion sort - "+ numberOfItems);
        // base condition, if there is only one item then return
        if(numberOfItems < 2){
            return;
        }

        // recursively call the sort method for unsorted partition
        insertionSortRec(nums, numberOfItems -1);

        int key = nums[numberOfItems -1];
        int i;
        for (i=numberOfItems-1;i>0 && nums[i-1] > key;i--){
            nums[i] = nums[i-1];
        }
        nums[i] = key;

    }

    public static void main(String[] args){
        int[] array = {11, 2, 8, -1, -16, 10};

//        insertionSort(array,array.length);
//        insertionSortV2(array, array.length);
        insertionSortRec(array, array.length);

        for (int i = 0; i<array.length; i++){
            System.out.println(array[i]);
        }
    }
}// end of the class
