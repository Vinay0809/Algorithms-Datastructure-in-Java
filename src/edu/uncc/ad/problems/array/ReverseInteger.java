package edu.uncc.ad.problems.array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**
 * @author venky
 */
public class ReverseInteger {
    public static void main(String[] args) {
        int result = reverse (-123);
    }
    public static int reverse(int x) {
        int min = Integer.MIN_VALUE;
        if(x > Integer.MAX_VALUE || x < Integer.MIN_VALUE)
            return 0;

        // Stack<Integer> stack = new Stack<Integer>();
        List<Integer> list = new ArrayList<>();
        int result = 0;
        if( x >= 0){
            while(x > 0){
                list.add(x % 10);
                x = x /10;
            }

            if( list.size() >= 10 && list.get(0) > 2){
                return 0;
            }
            StringBuilder sb = new StringBuilder();
            for( int i = 0; i< list.size(); i++){
                sb.append(list.get(i));
            }

            return Integer.parseInt(sb.toString());
        } else{
            StringBuilder sb = new StringBuilder(""+x);
            sb.deleteCharAt (0);
            System.out.println (sb.toString ());
        }

        return result;
    }

}
