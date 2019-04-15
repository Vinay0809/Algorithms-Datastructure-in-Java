package edu.uncc.ad.queue;

/**
 * @author venky
 */
public class Main {

    public static void main(String[] args) {
        Aqueue<Integer> queue = new Aqueue<> ();
        queue.add (10);
        queue.add (15);
        queue.add (2);
        queue.add (18);

        queue.print ();

        System.out.println ("Peek - "+queue.peek ());

        System.out.println ("Remove - "+queue.remove ());

        queue.print ();

        System.out.println ("Size - "+queue.size ());
        System.out.println ("Is empty? - "+queue.empty ());

        queue.remove ();
        queue.remove ();
        queue.remove ();

        System.out.println ("Is empty? - "+queue.empty ());

        queue.add (14);

        queue.print ();

        Cqueue<Integer> integerCqueue = new Cqueue<> (4);

        integerCqueue.add (10);
        integerCqueue.add (15);
        integerCqueue.add (20);

        integerCqueue.remove ();
        integerCqueue.remove ();

        integerCqueue.add (10);
        integerCqueue.add (15);

        integerCqueue.remove ();


        integerCqueue.print ();
    }
}
