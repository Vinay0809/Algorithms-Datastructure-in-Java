package edu.uncc.ad.queue;

/**
 * @author venky
 */
public class Main {

    public static void main(String[] args) {
//        Aqueue<Integer> queue = new Aqueue<> ();
//        queue.add (10);
//        queue.add (15);
//        queue.add (2);
//        queue.add (18);
//
//        queue.print ();
//
//        System.out.println ("Peek - "+queue.peek ());
//
//        System.out.println ("Remove - "+queue.remove ());
//
//        queue.print ();
//
//        System.out.println ("Size - "+queue.size ());
//        System.out.println ("Is empty? - "+queue.empty ());
//
//        queue.remove ();
//        queue.remove ();
//        queue.remove ();
//
//        System.out.println ("Is empty? - "+queue.empty ());
//
//        queue.add (14);
//
//        queue.print ();

        Cqueue<Integer> integerCqueue = new Cqueue<> (3);

        boolean result;
        int rear;
        integerCqueue.add (1);  // return true
        integerCqueue.add (2);  // return true
       integerCqueue.add (3);  // return true
        integerCqueue.add (4); // return false, the queue is full
        rear =  integerCqueue.peek ();  // return 3
//         integerCqueue.();  // return true
        integerCqueue.remove ();  // return true
        integerCqueue.remove ();  // return true
       integerCqueue.peek ();  // return 4
    }
}
