package edu.uncc.ad.linkedlist.singly;

/**
 * @author venky
 */
public class SinglyLinkedList<E> {

    private SingleLinkedNode<E> head;// represents the head
    private int size = 0; // variable to keep track of size.


    public void addToFront(E item) {
        SingleLinkedNode<E> node = new SingleLinkedNode (item); // assigning the student object
        node.setNext (head); // setting the next node to null.
        head = node; // making head to point current node
        size++; // increment the size.
    }

    /**
     * Function to get size of linked list
     *
     * @return size of linked list.
     */
    public int size() {
        return size;
    }

    /**
     * Method to check if linked list is empty or not.
     *
     * @return true if list is empty. false if list is not empty.
     */
    public boolean isEmpty() {
        if ( head == null ) // if the list is empty head will be pointing to null, or head points to last inserted node.
            return true;
        else
            return false;
    }

    public SingleLinkedNode<E> removeFromFront(){
        if(isEmpty ()){
            return null;
        }
        // get the removing node (it is the head node)
        SingleLinkedNode<E> removingNode = head;
        // set head to next node
        head = head.getNext ();
        // decrement the size
        size--;
        // making next of removing node as null (detaching from linked list)
        removingNode.setNext (null);
        return removingNode;
    }

    public void printList(){
        if ( isEmpty () ){
            System.out.println ("No elements to display");
        }
        SingleLinkedNode current = head;
        System.out.print ("head ->");
        while(current!=null){
            System.out.print(current);
            System.out.print (" -> ");
            current = current.getNext ();
        }
        System.out.println("null");
    }
}
