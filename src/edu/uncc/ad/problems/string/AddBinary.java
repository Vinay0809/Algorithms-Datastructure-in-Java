package edu.uncc.ad.problems.string;

/**
 * @author venky on 2019-03-03
 * @project AlgorithmAndDataStructure
 * @package edu.uncc.ad.string
 */

/**
 * Given two binary strings, return their sum (also a binary string).
 * The input strings are both non-empty and contains only characters 1 or 0.
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
public class AddBinary {
    public static void main(String[] args) {
//        String a = "11", b = "1";
        String a = "100", b = "110010";
        System.out.println (optimizedSolution (a, b));
    }

    private static String addBinary(String a, String b) {

        StringBuilder result = new StringBuilder ();
        int digitSum = 0;
        int carry = 0;
        int i = a.length () - 1;
        int j = b.length () - 1;

        // lopping from right to left till any one of string exhausted
        while ( i >= 0 && j >= 0 ) {
            // find the sum of last bits of two strings and carry if there any
            digitSum = Character.getNumericValue (a.charAt (i)) + Character.getNumericValue (b.charAt (j)) + carry;

            if ( digitSum > 1 ) { // if sum is greater than 1, finding carry forward and adding
                carry = digitSum / 2;
                result.append (digitSum % 2);
            } else {
                result.append (digitSum);
                carry = 0;
            }

            i--;
            j--;
            digitSum = 0;  // reassigning digitSum with zero after one cycle.
        }

        // if the first string has more bits than second string, considering remaining bits.
        while ( i >= 0 ) {
            digitSum = Character.getNumericValue (a.charAt (i)) + carry;
            if ( digitSum > 1 ) {
                carry = digitSum / 2;
                result.append (digitSum % 2);
            } else {
                result.append (digitSum);
                carry = 0;
            }
            i--;
            digitSum = 0;
        }

        // if the second string has more bits than first string, considering remaining bits.
        while ( j >= 0 ) {
            digitSum = Character.getNumericValue (b.charAt (j)) + carry;
            if ( digitSum > 1 ) {
                carry = digitSum / 2;
                result.append (digitSum % 2);
            } else {
                result.append (digitSum);
                carry = 0;
            }
            j--;
            digitSum = 0;
        }
        if ( carry > 0 ) // if there any carry
            result.append (carry);

        return result.reverse ().toString ();
    }

    public static String optimizedSolution(String a, String b) {
        // String builder for result.
        StringBuilder result = new StringBuilder ();

        // Initialize digit sum, it also stores carry
        int sum = 0;

        int i = a.length () - 1, j = b.length () - 1;
        // moving from right till last bit in any of the strings or carry  is 1
        while ( i >= 0 || j >= 0 || sum == 1 ) {
            // if string a is not exhausted add ith bit to sum, if string is exhausted add 0 since it makes no difference to sum
            sum += ((i >= 0) ? Character.getNumericValue (a.charAt (i)) : 0);
            // if string a is not exhausted add ith bit to sum, if string is exhausted add 0 since it makes no difference to sum
            sum += ((j >= 0) ? Character.getNumericValue (b.charAt (j)) : 0);

            // the sum has ith bit of a + jth bith of b
            // sum is greater than 1, taking sum % 2 gives appropriate binary bit. otherwise no difference
            result.insert (0, sum % 2);
            // finding the carry forward if sum is greater than 1
            sum = sum / 2;

            // Move to next digits
            i--; j--;
        }

        return result.toString ();
    }
}
