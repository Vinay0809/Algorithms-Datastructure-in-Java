package edu.uncc.ad.problems.array;

/**
 *
 * Add 5 such that it should return maximum possible value
 * @author venky
 */
public class AddFive {
    public static void main(String[] args) {
       int result =  solution (-525);
    }
    public static int solution(int n){
        StringBuilder sb = new StringBuilder (Integer.toString (n));
        int i = 0;
        if ( n >= 0 ){
            while ( i < sb.length () && '5' < sb.charAt (i)){
                i++;
            }
            if ( i > sb.length ()-1 )
                sb.insert (i-1,5);
            else
                sb.insert (i, 5);
        } else {
            while ( i < sb.length () && '5' >= sb.charAt (i)){
                i++;
            }
            sb.insert (i, 5);
        }


        return Integer.parseInt (sb.toString ());
    }

}
