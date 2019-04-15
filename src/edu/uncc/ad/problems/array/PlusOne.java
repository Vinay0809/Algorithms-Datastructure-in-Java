package edu.uncc.ad.problems.array;
/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 *
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlusOne {

    public static void main(String[] args) {
        int[] digits = {9,9,9};
        for ( int i: addOne (digits)){
            System.out.println (i);
        }
    }

    public static int[] plusOne(int[] digits) {
        // convert array to array list
        List<Integer> digitsList = new ArrayList<> ();
        for ( int i:digits )
            digitsList.add (i);

        int length = digitsList.size ();
        //add 1 to last digit and find the carry forward
        digitsList.set (length-1,digitsList.get (length-1) + 1);
        int carry = digitsList.get (length-1) / 10;
        // setting the unit digit
        digitsList.set (length-1, digitsList.get (length-1) % 10);

        // looping the list from second last end to add the carry
        for ( int i = length-2; i >=0; i-- ){
            if(carry == 1) {
                digitsList.set (i, digitsList.get (i) + carry); // adding carry to next digit.
                carry = digitsList.get (i) / 10; // update the carry with respect to next digit.
                digitsList.set (i, digitsList.get (i) % 10); // set the unit digit.
            }
        }

        // if there a carry forward after looping all element add that to first position
        if(carry == 1)
            digitsList.add (0, carry);

        // convert arrayList to array
        digits = new int[digitsList.size ()];
        for(int i=0; i< digitsList.size (); i++)
            digits[i] = digitsList.get (i);


    return digits;
    }

    public static int[] addOne(int[] digits){
       // add 1 to last digit.
        int len = digits.length;
        digits[len-1] += 1;
        int carry = 0;

        // loop from end of the array
        for ( int i = len-1; i>=0; i-- ){
            digits[i] += carry;
            if(digits[i] >= 10){
                carry = 1;
                digits[i] = digits[i] % 10;
            } else{
                carry = 0;
            }
        }
        if(carry == 1){
            int[] temp = new int[len+1];
            System.arraycopy (digits,0,temp,1,len);
            temp[0] = carry;
            return temp;
        } else {
            return digits;
        }

    }

}
