package edu.uncc.ad.problems.array;

/**
 * @author venky on 2019-02-23
 * @project AlgorithmAndDataStructure
 * @package edu.uncc.ad.list.arrays
 */
public class DiagonalTraverse {
    // 1 2 3
   //  4 5 6
   //  7 8 9

    public static void main(String[] args) {
     int[][] matrix = {{1,2}, {3,4}};
       // int[][] matrix = {{1,2}, {3,4}};
//        printMatrixDiagonal (matrix, matrix.length);
        int[] result = findDiagonalOrder (matrix);
        for ( int i:result ){
            System.out.println (i);
        }

    }

    public static int[] findDiagonalOrder(int[][] matrix){
        // if matrix has no elements or has only one elements
            if( matrix == null || matrix.length == 0)
                return new int[0];
            int i = 0;
            int j =0;
            int k = 0;
            int size = matrix.length * matrix[0].length;
            int[] result = new int[size];
            boolean moveUp =true;
            while(k< size){

                if(moveUp){
                    for(;i >=0 && j<= matrix[0].length-1;i--, j++){
                        result[k] = matrix[i][j];
                        k++;
                    }
                    // while moving up there are two conditions
//                    1. only row moves beyod 0 th row and column is in range (check for both row and column)
                    //2. both row and column moves out ( check for column only)
                    //case 1
                    if(i<0 && j <= matrix[0].length-1){
                        i = 0; // reset row to 0 and move down
                        moveUp = !moveUp;
                    }
                   //case 2
                    if(j == matrix[0].length){
                        i = i+2; // reset row
                        j--; // reduce column and move down
                        moveUp = !moveUp;
                    }

                }
                else
                {
                    // moving down increment row and decrement column
                    for(;j>=0 && i <= matrix.length - 1; i++, j-- ){
                        result[k] = matrix[i][j];
                        k++;
                    }
                    // while moving down there are two cases
                    // 1. column goes out but rows in order (we need to check both)
                    // 2. both column and row goes out (we can only have row check)
                    if(j < 0 && i<= matrix.length-1){
                        j = 0;
                        moveUp = !moveUp;
                    }
                    if( i == matrix.length){
                        j = j+2;
                        i--;
                        moveUp = !moveUp;
                    }

                }


            }
        return result;
    }



}
