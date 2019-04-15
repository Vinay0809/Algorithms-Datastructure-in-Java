package edu.uncc.ad.problems.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author venky on 2019-03-03
 * @project AlgorithmAndDataStructure
 * @package edu.uncc.ad.list.arraylist
 */
public class PascalsTriangle {

    public static void main(String[] args) {
        List<List<Integer>> result = generate (0);
        System.out.println (result);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resultList = new ArrayList ();

        if ( numRows == 0 ) {
            return resultList;
        }
        // loop for each row
        for ( int rowNum = 1 ; rowNum <= numRows ; rowNum++ ) {
            List<Integer> rowList = new ArrayList<> ();

            //loop number of elements in each row
            for ( int i = 0 ; i < rowNum ; i++ ) { // row 1 have 1 elements,row 2 have 2 elements and so on.
                // first and last elements are 1
                if ( i == 0 || i == rowNum - 1 ) {
                    rowList.add (i, 1);
                } else {
                    rowList.add (i, resultList.get (rowNum - 2).get (i - 1) + resultList.get (rowNum - 2).get (i));
                }

            }
            resultList.add (rowList);
        }
        return resultList;
    }
}
