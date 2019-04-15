package edu.uncc.ad.linkedlist.dlinkedlist;

import edu.uncc.ad.Student;


/**
 * @author venky
 */
public class Main {

    public static void main(String[] args) {
        Student kiran = new Student (801201652,"Kiran", "Korey");
        Student sam = new Student (800534276,"Sam","Jotham");
        Student rakshith =  new Student (80045364, "Rakshith","Rao");
        Student prashanth = new Student (80243876,"Prashanth","Desai");


        DoublyLinkedLists<Student> doublyLinkedList = new DoublyLinkedLists ();


        doublyLinkedList.addToFront (sam);
        doublyLinkedList.addToFront (kiran);
        doublyLinkedList.addToLast (rakshith);
        doublyLinkedList.printList ();

        try {
            doublyLinkedList.addBefore (prashanth,rakshith);
        }
        catch ( Exception e ) {
            e.printStackTrace ();
        }

//        doublyLinkedList.removeFromFront ();
//        doublyLinkedList.printList ();
//
//     doublyLinkedList.removeFromLast ();
//        doublyLinkedList.printList ();
//
//        doublyLinkedList.removeFromLast ();
//        doublyLinkedList.printList ();
//
//        doublyLinkedList.printList ();
//        doublyLinkedList.removeFromFront ();
        doublyLinkedList.printList ();

    }
}
