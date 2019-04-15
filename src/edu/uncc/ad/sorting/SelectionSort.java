package edu.uncc.ad.sorting;

public class SelectionSort {

    /**
     * Method to implement the classic version of selection sort
     *
     * @param intArray an unsorted array
     * @param n        size of an array
     */
    public static void selectionSortClassic(int[] intArray, int n) {

        for (int i = 0; i <= n - 2; i++) {
            int iMin = i;
            for (int j = i + 1; j <= n - 1; j++) {
                if (intArray[j] < intArray[iMin]) {
                    iMin = j;
                }// end of if
            }

            // now swap the ith element with minimum
            swap(intArray, i, iMin);
        }
    } // end of method

    /**
     * Method to implement selection sort
     *
     * @param intArray an unsorted array
     * @param n        size of an array
     */
    public static void selectionSort(int[] intArray, int n) {
        // now considering the first element as largest element
        // coparing it with all the orher elements in the array and moving the lagest to last index
        for (int lastUnsortedIndex = n - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            int iLarge = 0;
            for (int i = 1; i <= lastUnsortedIndex; i++) {
                if (intArray[i] > intArray[iLarge]) {
                    iLarge = i;
                }
            }
            // now we found the index of largest element and move it to last index

            swap(intArray, lastUnsortedIndex, iLarge);
        }
    }// end of method

    public static void main(String[] args) {
        int[] intArray = {15, 2, 1, 6, 5, 8};

        int[] temp = intArray.clone();

        selectionSort(temp, temp.length);
        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i]);
        }

        temp = intArray.clone();
        System.out.println("------------------------");
        selectionSortClassic(temp, temp.length);

        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i]);
        }
    }

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
}// end of the class

