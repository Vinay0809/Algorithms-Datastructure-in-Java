package edu.uncc.ad.problems.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author venky on 2019-02-23
 * @project AlgorithmAndDataStructure
 * @package edu.uncc.ad.list.arrays
 */
public class SpiralMatrix {
    public static void main(String[] args) {
//       int[][] matrix = {{1,2,3,4},{5,6, 7,8},{9,10,11,12}};
       int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//        int[][] matrix = {{2,3}};
        spiralOrder (matrix);
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 )
            return new ArrayList<Integer>();

        List<Integer> result = new ArrayList<> ();
        if(matrix.length == 1) {
            for ( int i=0; i<matrix[0].length;i++ ){
                result.add (matrix[0][i]);
            }
            return result;
        }



        int i = 0, j=0,k=0;
        int size = matrix.length * matrix[0].length;
        boolean moveRight = true;
        boolean moveDown = false;
        boolean moveLeft = false;
        boolean moveUp = false;
        while ( k < size ){

            if(moveRight){
                for ( ;j < matrix[0].length; j++ ){
                    result.add (matrix[i][j]);
                    k++;
                }
                if ( j == matrix[0].length && i < matrix.length ){
                    i++;
                    j--;
                    moveRight = !moveRight;
                    moveDown = !moveDown;

                }
            }
            if(moveDown){
                for(;i< matrix.length; i++){
                    result.add (matrix[i][j]);
                    k++;
                }
                if(i == matrix.length){
                    j--;
                    i--;
                    moveDown = !moveDown;
                    moveLeft = !moveLeft;
                }
            }
            if(moveLeft){
                for(;j>=0;j--){
                    result.add (matrix[i][j]);
                    k++;
                }
                if( j< 0 && i > 0){
                    j++;
                    i--;
                    moveLeft = !moveLeft;
                    moveUp = !moveUp;
                }
            }
           else {
               for(;j<matrix[i].length - 1; j++){
                   result.add (matrix[i][j]);
                   k++;
               }
               if(j==matrix[i].length - 1){
                   moveUp = !moveUp;
               }
            }

        }

        return null;
    }
}
