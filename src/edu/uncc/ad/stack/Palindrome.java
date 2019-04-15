package edu.uncc.ad.stack;

/**
 * @author venky
 */

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

/**
 * Using a stack determine whether a string is palindrome.
 * Strings may contain punctuations and spaces, they should be ignored.
 * Case should be ignored.
 * Examples -
 * "I did, did I?" - is a palindrome
 * "Racecar" - is a palindrome
 * "hello" is not a palindrome
 *
 */

public class Palindrome {

    public static void main(String[] args) {
        String str = "I did, did I?";
        boolean isPalindrome = checkForPalindrome(str);
        System.out.println (isPalindrome);
    }

    public static boolean checkForPalindrome(String str) {
        // convert all to lower case
        str = str.toLowerCase ();
        StringBuilder cleanString = new StringBuilder (str.length ());
        Stack<Character> characterStack = new Stack<> ();


        for ( int i=0; i< str.length ();i++ ){
            if ( Character.isLetter (str.charAt (i)) ){
                characterStack.push (str.charAt (i));
                cleanString.append (str.charAt (i));
            }
        }

        StringBuilder temp = new StringBuilder (characterStack.size ());

        while ( !characterStack.isEmpty () ){
            temp.append (characterStack.pop ());
        }

        return cleanString.toString ().equals (temp.toString ());
    }


}
