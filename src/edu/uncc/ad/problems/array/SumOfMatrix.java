package edu.uncc.ad.problems.array;

/**
 * @author venky
 */
public class SumOfMatrix {

    public static void main(String[] args) {
        int[][]  arary= {{1,2},{3,4}};

        int m = arary.length;
        int n = arary[0].length;

        int i =0 , j, sum = 0;
        while ( i<m ){
            j=0;
            while ( j<n ){
                sum += arary[i++][j++];
            }
        }
        System.out.println (sum);
    }
}
