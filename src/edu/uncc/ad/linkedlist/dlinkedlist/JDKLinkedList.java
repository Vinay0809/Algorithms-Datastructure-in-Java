package edu.uncc.ad.linkedlist.dlinkedlist;

import edu.uncc.ad.Student;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author venky
 */
public class JDKLinkedList {
    public static void main(String[] args) {
        Student venky   = new Student (801053064,"Venkataramana", "Hegde");
        Student kiran = new Student (800342562, "Kiran", "Korey");
        Student rakshith = new Student (800243535, "Rakshith", "Rao");

        LinkedList<Student> linkedList = new LinkedList<> ();

        linkedList.addLast (venky);
        linkedList.addLast (kiran);
        linkedList.addLast (rakshith);

        Iterator iterator = linkedList.iterator ();

        while ( iterator.hasNext () ){
            System.out.print (iterator.next ());
        }
    }
}
