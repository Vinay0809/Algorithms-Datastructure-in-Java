package edu.uncc.ad.problems.array;

public class TwoDimensionArray {
    public static void main(String[] args) {
        int[][] first2DArray = new int[3][2];
        int[][] second2DArray = {{1,2},{3,4},{5,6},{7,8,9}};
//        print2DArray(first2DArray);
        print2DArray (second2DArray);
    }

    private static void print2DArray(int[][] twoDArray) {
        //looping through rows
        for(int i=0; i<twoDArray.length; i++){
            for ( int j = 0; j<twoDArray[i].length; j++ ){
                System.out.print (twoDArray[i][j]+" | ");
            }
            System.out.println ();
        }


    }
}
