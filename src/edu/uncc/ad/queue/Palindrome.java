package edu.uncc.ad.queue;

/**
 * @author venky
 */

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Using a queue and stack determine whether a string is palindrome.
 * Strings may contain punctuations and spaces, they should be ignored.
 * Case should be ignored.
 * Examples -
 * "I did, did I?" - is a palindrome
 * "Racecar" - is a palindrome
 * "hello" is not a palindrome
 */
public class Palindrome {

    public static void main(String[] args) {
        String str = "I did, did I?";
        boolean isPalindrome = isPalindrome (str);
        System.out.println (isPalindrome);

    }

    /**
     * @param s
     *
     * @return
     */
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase ();
        // Idea here is, stack is LIFO so when we put each character in stack and then pop, we get reverse of the
        // string.
        // Queue is FIFO, so place each character in queue and the compare front with popped character.
        Stack<Character> characterStack = new Stack<> ();
        Queue<Character> characterQueue = new LinkedList<> ();
        for ( int i = 0 ; i < s.length () ; i++ ) {
            if ( Character.isLetter (s.charAt (i)) ) {
                // push to stack and queue
                characterStack.push (s.charAt (i));
                characterQueue.add (s.charAt (i));
            }
        }

        while ( !characterStack.isEmpty () ) {
            if ( !characterStack.pop ().equals (characterQueue.remove ()) ) {
                return false;
            }
        }
        return true;
    }

}
