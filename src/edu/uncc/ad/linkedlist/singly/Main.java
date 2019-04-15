package edu.uncc.ad.linkedlist.singly;

import edu.uncc.ad.Student;

/**
 * @author venky
 */
public class Main {

    public static void main(String[] args) {
        Student kiran = new Student (801201652,"Kiran", "Korey");
        Student sam = new Student (800534276,"Sam","Jotham");
        Student rakshith =  new Student (80045364, "Rakshith","Rao");

        SinglyLinkedList<Student> linkedList = new SinglyLinkedList ();
        linkedList.addToFront (kiran);
        linkedList.addToFront (sam);
        linkedList.addToFront (rakshith);

        linkedList.printList ();
        linkedList.removeFromFront ();
        linkedList.printList ();
    }
}
