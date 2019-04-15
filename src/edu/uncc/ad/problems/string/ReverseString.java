package edu.uncc.ad.problems.string;

/**
 * @author venky
 */

/**
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * You may assume all the characters consist of printable ascii characters.
 *
 *
 *
 * Example 1:
 *
 * Input: ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 *
 * Input: ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 */
public class ReverseString {
    public static void main(String[] args) {
        char[] input1 = {'h','e','l','l','o'};

        input1 = reverseString(input1);

    }

    private static char[] reverseString(char[] input1) {

        int p1 = 0;
        int p2 = input1.length - 1;

        while ( p1 < p2 ){
            swap(input1, p1, p2);

            p1++;
            p2--;
        }

        return input1;
    }

    private static void swap(char[] input1, int p1, int p2) {
        char temp = input1[p1];
        input1[p1] = input1[p2];
        input1[p2] = temp;

    }
}
