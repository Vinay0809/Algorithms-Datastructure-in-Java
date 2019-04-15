package edu.uncc.ad.tree;

/**
 * @author venky
 */
public class Main {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<> ();
        tree.insert (10);
        tree.insert (15);
        tree.insert (9);
        tree.insert (2);
        tree.insert (8);

        tree.traverseInOrder ();
        System.out.println ();
        tree.traversePreOrder ();
        System.out.println ();
        tree.traversePostOrder ();
        System.out.println ();

        System.out.println (tree.get (2));
        System.out.println (tree.get (38));

        System.out.println (tree.getMin ());
        System.out.println (tree.getMax ());
    }
}
