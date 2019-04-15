package edu.uncc.ad.linkedlist.dlinkedlist;

/**
 * @author venky
 */
public class DoublyLinkedLists<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;


    public void addToFront(E item) {
        Node newNode = new Node (item);
        // when adding a new node to front of the list, new node becomes the head.
        // so it's next points to null.
        newNode.setNext (head);
        // if the new node is first node, both head and tail points to same node
        if ( isEmpty () ) {
            tail = newNode;
        } else {
            // otherwise, current head's previous would be new node.
            head.setPrevious (newNode);

        }
        head = newNode;
        size++;
    }

    public void addToLast(E e) {
        Node<E> newNode = new Node (e);
        // if the list is empty, new node also a head node
        if ( isEmpty () ) {
            head = newNode;
        } else {
            // when adding new node to last the new node becomes the tail
            newNode.setPrevious (tail);
            newNode.setNext (null);
            // current tails next node will be new node
            tail.setNext (newNode);
        }

        // tail will be new node
        tail = newNode;
        size++;

    }

    public Node<E> removeFromFront() {
        if ( isEmpty () ) {
            return null;
        }
        Node removingNode = head; // taking head node as removing node.
        //if there only one node in list then we need to set tail to null.
        if ( head.getNext () == null ) {
            tail = null;
        } else {
            removingNode.getNext ().setPrevious (null); // detaching the removing node from next node.
        }
        head = removingNode.getNext (); // assigning head to next node
        removingNode.setNext (null);
        size--;
        return removingNode;
    }

    public Node<E> removeFromLast() {
        if ( isEmpty () ) {
            return null;
        }
        // get the removing node
        Node removingNode = tail;
        // check if there only one item in list
        if ( tail.getPrevious () == null ) {
            head = null; // if so set head to null
        } else {
            removingNode.getPrevious ().setNext (null);
        }
        tail = removingNode.getPrevious ();
//        removingNode.setPrevious (null);
        // if I don't set the removing node's previous node to null, i can get new tail node information
        size--;
        return removingNode;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    public void printList() {
        if ( isEmpty () ) {
            System.out.println ("List has no element");
        } else {
            Node current = head; System.out.print ("null <=> "); while ( current != null ) {
                System.out.print (current + " ");
                System.out.print ("<=> ");
                current = current.getNext ();
            } System.out.print ("null\n");
        }
    }

    public boolean addBefore(E newItem, E existingItem) throws Exception {
        if ( newItem == null || newItem.getClass () != existingItem.getClass ()  ){
            throw new Exception ("Incompatible instance types");
        }

        Node<E> newNode = new Node<E> (newItem);
        // check if existingItem is in linkedList or not, if so get it's node
        Node<E> existingNode = getExistingNode(existingItem);
        if(null == existingNode){
            return false;
        }

        // check if linked list is empty, if so add the new item to head of the list
        if ( isEmpty () ){
            addToFront (newItem);
        }
        // otherwise add new item before existing
        newNode.setNext (existingNode);
        // check if existing item is head
        if(existingNode.equals (head)){
            existingNode.setPrevious (newNode);
            head = newNode;
        } else {
            newNode.setPrevious (existingNode.getPrevious ());
            existingNode.getPrevious().setNext(newNode);
            existingNode.setPrevious (newNode);
        }

        size++;
        return true;
    }

    private Node<E> getExistingNode(E existingItem) {
        Node<E> existingNode = new Node<E> (existingItem);
        Node<E> current = head;
        while ( current!=null ){
            if ( current.equals (existingNode) ){
                return current;
            }
            current = current.getNext ();
        }
        return null;
    }
}
