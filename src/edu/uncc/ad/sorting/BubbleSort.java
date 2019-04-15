package edu.uncc.ad.sorting;

public class BubbleSort {

    /**
     * Method to implement the classical version of Bubble sort
     *
     * @param intArray an unsorted array
     * @param n        size of an array
     */
    public static void bubbleSort(int[] intArray, int n) {

        for (int i = 0; i <= n - 2; i++) {
            for (int j = 0; j <= n - 2 - i; j++) {

                if (intArray[j + 1] < intArray[j]) {
                    // swap two adjacent elements
                    swap(intArray, j, j + 1);
                } // end of if
            } // inner for loop
        } // end of outer for loop
    } // end of method


    /**
     * Optimized version of Bubble sort
     *
     * @param intArray an unsorted array
     * @param n        size of input array
     */
    public static void optimizedBubbleSort(int[] intArray, int n) {

        //consider last index as unsortedLastIndex
        for (int unsortedLastIndex = n - 1; unsortedLastIndex > 0; unsortedLastIndex--) {
            // now start from first element unsorted last index
            for (int i = 0; i < unsortedLastIndex; i++) {

                if (intArray[i] > intArray[i + 1]) {
                    //swap two elements
                    swap(intArray, i, i + 1);
                } //end of if

            }
        } // end of outer loop
    } // end of method

    public static void main(String[] args) {
        int[] intArray = {3, 2, 1, 6, 5};

        // calling bubble sort

        int[] temp = intArray.clone();

        bubbleSort(temp, temp.length);

        System.out.println("Sorted Array - ");
        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i]);
        }

        temp = intArray.clone();
        optimizedBubbleSort(temp, temp.length);

        System.out.println("Sorted Array - ");
        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i]);
        }

    } // end of main


    /**
     * Method to swap two elements of an array
     *
     * @param array an array
     * @param i     first index
     * @param j     second index
     */
    public static void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}