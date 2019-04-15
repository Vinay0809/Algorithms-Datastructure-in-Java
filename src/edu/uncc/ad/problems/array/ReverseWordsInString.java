package edu.uncc.ad.problems.array;

/**
 *
 * Reverse Words in a String III
 *
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 *
 * Example 1:
 *
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 *
 *
 * @author venky
 */
public class ReverseWordsInString {

    public static void main(String[] args) {
        String s = reverseWords ("Let's take");
    }

    public static String reverseWords(String s) {

        String[] strArray = s.trim ().split (" ");
        StringBuffer sb= new StringBuffer ();
        for ( int i =0; i< strArray.length; i++){
            char[] tempArray = strArray[i].toCharArray ();
            int p1= 0;
            int p2 = tempArray.length-1;
            while ( p1 < p2 ){
                char temp = tempArray[p1];
                tempArray[p1] = tempArray[p2];
                tempArray[p2] = temp;
                p1++;
                p2--;
            }
            String tempSb = "";
            for ( char c: tempArray ){
                tempSb+= c;
            }

            sb.append (tempSb+" ");
        }

        return sb.toString ().trim ();
    }
}
