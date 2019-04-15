package edu.uncc.ad.linkedlist.homework;

import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * remove all elements from a linked-list that has the same value as the given value
 *

 * @author venky
 */
public class RemoveAll {
    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<Integer> (Arrays.asList (2,6,1,3,1,4,5,1,0));

        linkedList = removeAll (linkedList, 1);
        System.out.println (linkedList);

    }

    public static LinkedList<Integer> removeAll(LinkedList<Integer> linkedList, int n){

        for ( int i=0; i<linkedList.size (); i++ ){
            int num = linkedList.get (i);
            if (  num== n ){
                linkedList.remove (i);
            }
        }

        return  linkedList;
    };
}
