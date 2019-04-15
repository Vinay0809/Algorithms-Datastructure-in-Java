package edu.uncc.ad.tree;

/**
 * Represents a node in BST for Numbers
 *
 * @param <E>
 *         the type parameter
 *
 * @author venky
 */
public class Node<E extends Number & Comparable<? super E>> {

    /**
     * Stores the data
     */
    private E data;

    /**
     * reference to left sub tree
     */
    private Node<E> leftChild;

    /**
     * Reference to right sub tree
     */
    private Node<E> rightChild;


    /**
     * Instantiates a new Node.
     *
     * @param data
     *         the data
     */
    public Node(E data) {
        this.data = data;
    }

    /**
     * Inserts a new value into BST
     *
     * @param value
     *         the value to be inserted into this tree
     */
    public void insert(E value) {
        // check if the value is already in tree, if so do not add
        if ( value.compareTo (data) == 0 ) {
            return;
        }
        // if value is less than data explore left sub tree
        if ( value.compareTo (data) < 0 ) {
            if ( leftChild == null ) {
                leftChild = new Node (value);
            } else {
                leftChild.insert (value);
            }
        } else { //  otherwise explore right sub tree.
            if ( rightChild == null ) {
                rightChild = new Node (value);// there is no value on right node create a new node/
            } else {
                rightChild.insert (value); // if there right sub tree then insert.
            }
        }

    }

    /**
     * Traverses the tree in order.
     * Left subtree -> root -> right subtree
     */
    public void traverseInOrder() {
        // check if the left sub tree is null, if not traverse left subtree inorder recursively
        if ( leftChild != null ) {
            leftChild.traverseInOrder ();
        }
        System.out.print (data + ", ");
        // check if the right sub tree is null, if not traverse right subtree inorder
        if ( rightChild != null ) {
            rightChild.traverseInOrder ();
        }
    }
    /**
     * Traverses this tree in pre order.
     * root -> left sub tree -> right sub tree
     */
    public void traversePreOrder(){
        // root -> left sub tree -> right sub tree
        System.out.print (data+", ");
        if ( leftChild != null ){
            leftChild.traversePreOrder ();
        }
        if ( rightChild != null ){
            rightChild.traversePreOrder ();
        }
    }

    /**
     * Traverses this tree in post order.
     * right sub tree -> root -> left sub tree
     */
    public void traversePostOrder(){
        if ( rightChild != null ){
            rightChild.traversePostOrder ();
        }
        System.out.print (data+", ");
        if ( leftChild != null ){
            leftChild.traversePostOrder ();
        }
    }


    /**
     * Get an element from the tree
     *
     * @param value
     *         the value required from this tree
     *
     * @return the value specified if the value exists in tree, otherwise null.
     */
    public E get(E value) {
        // check if value equals to root
        if ( value.compareTo (data) == 0 ) {
            return this.data;
        }
        // if value is less than root then explore left sub tree
        if ( value.compareTo (data) < 0 && leftChild != null ) {
            return leftChild.get (value);
        } else {
            if ( rightChild != null ) {
                return rightChild.get (value);
            }
        }
        return null;
    }

    /**
     * Get minimum value from tree
     *
     * @return the minimum value from this tree.
     */
    public E getMin() {
        // minimum value in tree is the leftmost leaf node.
        if ( leftChild == null ) {
            return data; // if tree doesn't have left child root node will be the minimum
        } else {
            return leftChild.getMin (); // if tree has a left child node, recursively explore left child node, until
            // last node.
        }
    }

    /**
     * Get max value from this tree
     *
     * @return e the maximum value from this tree
     */
    public E getMax() {
        // maximum value in tree is the rightmost leaf node.
        if ( rightChild == null ) {
            return data; // if tree doesn't have right child, root node will be the maximum.
        } else {
            return rightChild.getMax ();//recursively explore left child node, until
            // last node.
        }
    }


    /**
     * Gets data.
     *
     * @return the data
     */
    public E getData() {
        return data;
    }

    /**
     * Sets data.
     *
     * @param data
     *         the data
     */
    public void setData(E data) {
        this.data = data;
    }

    /**
     * Gets left child.
     *
     * @return the left child
     */
    public Node<E> getLeftChild() {
        return leftChild;
    }

    /**
     * Sets left child.
     *
     * @param leftChild
     *         the left child
     */
    public void setLeftChild(Node<E> leftChild) {
        this.leftChild = leftChild;
    }

    /**
     * Gets right child.
     *
     * @return the right child
     */
    public Node<E> getRightChild() {
        return rightChild;
    }

    /**
     * Sets right child.
     *
     * @param rightChild
     *         the right child
     */
    public void setRightChild(Node<E> rightChild) {
        this.rightChild = rightChild;
    }
}
