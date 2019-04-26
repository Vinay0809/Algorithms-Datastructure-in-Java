package edu.uncc.ad.queue;

/**
 * @author venky
 */
public class Demo {
    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(26);

        boolean result;
        int rear;



        result = circularQueue.enQueue (3);
        rear = circularQueue.Rear ();
        rear = circularQueue.Front ();
        result = circularQueue.deQueue ();
        rear = circularQueue.Front ();
        result = circularQueue.deQueue ();
        rear = circularQueue.Front ();
        result = circularQueue.enQueue (4);
        result = circularQueue.enQueue (2);
        result = circularQueue.enQueue (2);
        result = circularQueue.enQueue (3);


    }
}
