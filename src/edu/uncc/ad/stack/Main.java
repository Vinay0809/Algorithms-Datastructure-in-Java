package edu.uncc.ad.stack;

/**
 * @author venky on 2019-03-02
 * @project AlgorithmAndDataStructure
 * @package edu.uncc.ad.stack
 */
public class Main {
    public static void main(String[] args) {
//        arrayStackDemo ();
        linkedStackDemo ();
    }

    private static void linkedStackDemo() {
        Stack<Integer> stack = new Stack<> ();

        stack.push (15);
        stack.push (43);
        stack.push (19);
        stack.push (59);

        stack.printStack ();
        System.out.println ("Peek - " + stack.peek ());
        System.out.println ("Pop - " + stack.pop ());
        stack.printStack ();
    }

    private static void arrayStackDemo() {
        ArrayStack<Integer> stack = new ArrayStack<> (10);

        stack.push (10);
        stack.push (15);
        stack.push (2);
        stack.printStack ();
        System.out.println ("Peek - " + stack.peek ());
        stack.printStack ();
        System.out.println ("Pop - " + stack.pop ());
        stack.printStack ();
    }
}
