package edu.uncc.ad.problems.string;

import edu.uncc.ad.stack.Stack;

import java.util.HashMap;

/**
 * @author venky
 */
public class ValidParentheses {
    public static void main(String[] args) {
        String s = "()()()";
        boolean result = isValid (s);
    }
    public static boolean isValid(String s) {

        if(s.length()<=1){
            return false;
        }

        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        Stack<Character> cStack = new Stack<>();

        for ( int i=0; i< s.length (); i++ ){
            char ch = s.charAt(i);
            if ( map.containsKey (ch) ){

                char top = cStack.empty () ? '#': cStack.pop ();

                if ( s.charAt(i) != map.get(top) )
                    return false;
            } else{
                cStack.push(ch);
            }

        }
        return cStack.empty ();
    }
}
