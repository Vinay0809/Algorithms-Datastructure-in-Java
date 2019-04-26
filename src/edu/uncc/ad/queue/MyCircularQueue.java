package edu.uncc.ad.queue;

/**
 * @author venky
 */
class MyCircularQueue {

    /** data structure to store the queue **/
    int[] queue;
    int front; // to track front of queue
    int rear; // to track rear of queue
    boolean isQueueFull = false; // to track if queue is full or not

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        queue = new int[k];
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        boolean success = false;
        if(!isFull()){
            // add value to back of the queue
            queue[rear] = value;
            if(rear < queue.length - 1){
                rear++;
            } else{
                rear = 0;
                isQueueFull = true;
            }
            success = true;
        }

        return success;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        boolean success = false;
        if(!isEmpty()){
            if( front < queue.length - 1){
                front++;
            } else{
                front = 0;
            }
            success = true;
            isQueueFull = false;
        }
        return success;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(!isEmpty()){
            if( front == 0){
                return queue[front];
            } else {
                return queue[front - 1];
            }
        }
        return -1;
    }

    /** Get the last item from the queue. */
    public int Rear() {

        if(!isEmpty()){
            if( rear == 0 && isQueueFull){
                return queue[queue.length - 1];
            } else{
                return queue[rear - 1];
            }
        }
        return -1;
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {

        if( rear== 0 && front == 0 && !isQueueFull){
            return true;
        }else{
            return false;
        }
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return isQueueFull;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */