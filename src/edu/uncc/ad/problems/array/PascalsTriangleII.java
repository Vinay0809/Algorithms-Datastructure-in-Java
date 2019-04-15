package edu.uncc.ad.problems.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 *
 * Note that the row index starts from 0.
 *
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 3
 * Output: [1,3,3,1]
 * Follow up:
 *
 * Could you optimize your algorithm to use only O(k) extra space?
 *
 *
 * @author venky
 */
public class PascalsTriangleII {

    public static void main(String[] args) {
        List<Integer> result = getRowN (2);
    }

    public static List<Integer> getRow(int rowIndex) {
        //[[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
        List<List<Integer>> resultList = new ArrayList<> ();

//        if ( rowIndex == 0 ){
//            return new ArrayList<> (0);
//        }

        // loop for each row
        for ( int rowNum = 0; rowNum <= rowIndex ; rowNum++){
            List<Integer> row = new ArrayList<> ();

            // 1st row should have 1 element, 2nd row 2, and so on
            for ( int nEle = 0; nEle <= rowNum; nEle++ ){
                if ( nEle == 0 || nEle == rowNum ){
                    row.add (nEle,1); // first and last elements are 1.
                } else {
                    int temp = resultList.get (rowNum-1).get (nEle-1) + resultList.get (rowNum-1).get (nEle);
                    row.add (nEle,temp);
                }
            }

            resultList.add (row);
        }


        return resultList.get (rowIndex);
    }

    public static List<Integer> getRowN(int rowIndex) {   // rowIndex = 4,   1 4 6 4 1
        if (rowIndex < 0)
            return new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        list.add(1);

        if (rowIndex == 0)
            return list;

        List<Integer> pRow = getRowN (rowIndex-1); // Row 4, 0..4
        for (int i = 0; i < rowIndex-1; i++)
        {
            list.add(pRow.get(i) + pRow.get(i+1));
        }
        list.add(1);
        return list;
    }
}
