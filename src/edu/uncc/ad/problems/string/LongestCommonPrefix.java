package edu.uncc.ad.problems.string;

/**
 * @author venky
 */

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 *
 * All given inputs are in lowercase letters a-z.
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] input = {};
        String result = longestCommonPrefix (input);
        System.out.println (result);
    }
    public static String longestCommonPrefix(String[] strs) {

        if ( strs.length == 0 || strs == null ){
            return "";
        }
        if ( strs.length == 1 ){
            return strs[0];
        }

        // find the length smallest string
        int smallLen = strs[0].length ();
        for ( int i = 1; i < strs.length; i++  ){
            int len = strs[i].length ();
            if( len <= smallLen)
                smallLen = len;
        }

        StringBuilder result= new StringBuilder ("");
        // to find maximum prefix.

        // checking every character of each string.
        for ( int i=0; i< smallLen; i++ ){
            int j=0;
            while ( j< strs.length - 1){
                if(strs[j].charAt (i) == strs[j+1].charAt (i)){
                    j++;
                } else {
                    return result.toString ();
                }
            }
            result.append (strs[strs.length-1].charAt (i));

        }
        return result.toString ();
    }
}

