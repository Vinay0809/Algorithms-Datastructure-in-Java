package edu.uncc.ad.tree;

import java.util.Comparator;

/**
 * Class to implement simple Binary Search Tree for Numbers.
 *
 * @param <E>
 *         the type parameter
 *
 * @author venky
 */
public class Tree<E extends Number & Comparable<? super E>> {
   private Node<E> root;

    /**
     * Inserts a new value into BST.
     *
     * @param value
     *         the value to be inserted into this tree
     */
    public void insert(E value){
        if ( root == null ){
            root = new Node<E> (value);
        } else {
            root.insert (value);
        }
    }

    /**
     * Traverses the tree in order.
     * Left subtree -> root -> right subtree
     */
    public void traverseInOrder(){
        if ( root != null ){
            root.traverseInOrder ();
        }
    }
    /**
     * Traverses this tree in pre order.
     * root -> left sub tree -> right sub tree
     */
    public void traversePreOrder(){
        if ( root!=null ){
            root.traversePreOrder ();
        }
    }

    /**
     * Traverses this tree in post order.
     * right sub tree -> root -> left sub tree
     */
    public void traversePostOrder(){
        if ( root != null ){
            root.traversePostOrder ();
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
    public E get(E value){
        if ( root != null ){
            return root.get (value);
        } else {
            return null;
        }
    }

    /**
     * Get minimum value from tree
     *
     * @return the minimum value from this tree.
     */
    public E getMin(){
        if ( root != null){
            return root.getMin ();
        }
        return null;
    }

    /**
     * Get max value from this tree
     *
     * @return e the maximum value from this tree
     */
    public E getMax(){
        if ( root != null ){
            return root.getMax ();
        }
        return null;
    }
}
