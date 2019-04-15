package edu.uncc.ad.problems.array;

/**
 *
 * Reverse Words in a String
 *
 * Given an input string, reverse the string word by word.
 *
 *
 *
 * Example 1:
 *
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 *
 * Input: "  hello world!  "
 * Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 *
 * Input: "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 *
 * Note:
 *
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 *
 * @author venky
 */
public class ReverseWords {

    public static void main(String[] args) {
//        String s = reverseWords ("a good   example");
        String s = sol2 ("  hello world!  ");
    }

    public static String reverseWords(String s) {
        String[] strArray = s.split (" ");

        int p1 = 0;
        int p2 = strArray.length-1;

        while ( p1 < p2 ){
            swap(strArray, p1, p2);
            p1++;
            p2--;
        }
        StringBuffer sb = new StringBuffer ();
        for ( String st:strArray ){
            if ( st != null && !st.equalsIgnoreCase ("") )
                sb.append (st+" ");
        }
        return sb.toString ().trim ();
    }

    private static void swap(String[] strArray, int p1, int p2) {
        String temp = strArray[p1].trim ();
        strArray[p1] = strArray[p2].trim ();
        strArray[p2] = temp;
    }

    public static String sol2(String s){
        String[] strArray = s.trim ().split (" ");
        StringBuffer sb = new StringBuffer ();

        for ( int i = strArray.length-1; i >=0; i-- ){
            if ( !strArray[i].trim ().equalsIgnoreCase ("") ){
                sb.append (strArray[i]+" ");
            }
        }


        return sb.toString ().trim ();
    }
}
