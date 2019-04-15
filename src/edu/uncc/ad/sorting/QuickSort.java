package edu.uncc.ad.sorting;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {8, -12, 15, 2, 6,9,25,-26,0,10};
        quickSort(nums, 0,nums.length);
        for(int i=0; i< nums.length; i++){
            System.out.print(nums[i]+"\t");
        }
    }

    public static void quickSort(int[] nums, int start, int end){
        // base condition
        if(end -start < 2){
            return;
        }

        // other wise we need to find pivot element.
        int pivotIndex = partition(nums, start, end);
        // from the above call we get the left array which is less than pivot
        // right array which is greater than pivot, so now,I call quickSort() recursively for left and right array.
        quickSort(nums,start,pivotIndex);
        quickSort(nums, pivotIndex+1, end);

    }

    private static int partition(int[] nums, int start, int end) {
        // taking first element as pivot element
        int pivot = nums[start];
        int i = start; // i points to first element and to move from left to right
        int j = end; // j points to right most element and move from right to left

        // Alternatively compare as long as i and j are not crossing
        while (i < j){

            // now, moving right to left looking for smallest element that is less than pivot element.
            // hence loop should run as long as element in position j >= pivot element
            // pre decrementing j because, I'm taking jth position as size of array initially.
            // this is a empty loop body only to check and move j
            while (i < j && nums[--j] >= pivot);
            if(i < j){
                nums[i] = nums[j]; // now assigning the small element to ith position. i.e left to pivot element.
            }
            // now, moving left to right, looking for first greater element then pivot.
            // so loop will run as long as elements lesser than pivot element.
            while ( i < j && nums[++i] <= pivot); // empty loop body
            if( i < j){
                nums[j] = nums[i]; // assigning the greater element to jth positon. i.e right to pivot element.
            }
        }
        // now, once i crossed j, assigning the pivot value to jth position.
        nums[j] = pivot;
        //returning the pivot index.
        return j;


    }
}
