package edu.uncc.ad.problems.string;

/**
 * @author venky
 */

/**
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 */
public class StrStr {
    public static void main(String[] args) {
//        strStr ("hello", "ll");
//        strStr ("", "a");
        strStr ( "aaa", "");

    }
    public static int strStr(String haystack, String needle){

        if( needle.length () < 1)
            return 0;

        int nLen = needle.length ();

        for ( int i=0; i <= haystack.length () - nLen; i++){
//            String sub = haystack.substring (i, i+nLen );
            if ( haystack.substring (i, i+nLen ).equalsIgnoreCase (needle) ){
                return i;
            }
        }


        return -1;
    }


}
