/**
 * This class is my implementation of the ADT Queue.
 * @author Parker Amundsen
 * @version 1/29/2019
 */
public class Queue {

    private Object[] queue;
    private int head;
    private int tail;

    public Queue() {
        this.queue = new Object[10];
        this.head = 0;
        this.tail = 0;
    }

    /**
     * PRE: the object param cannot be null.
     * Post: the Object will be added to the array representing the queue at the index of the tail.
     * @param obj obj is added to the tail of the queue.
     */
    public void enqueue(Object obj) {
        if(obj == null) {
            System.out.println("Object is null, queue cannot hold null values.");
            return;
        }
        resize();
        this.queue[tail++] = obj;
    }

    /**
     *
     * @return this will be the object at the value of the head of the array that is representing the queue.
     */
    public Object dequeue() {
        Object retval = this.queue[head];
        this.queue.clone()[head++] = null;
        return retval;
    }

    /**
     *
     * @return returns the number of non null elements in the array representing the queue.
     */
    public int size() {
        return this.tail - this.head;
    }

    /**
     *
     * @return true if there are no elements in the queue.
     */
    public boolean isEmpty() {
        if (this.tail == this.head) return true;
        return false;
    }

    /**
     * When called the array representing the stack is copied to a new array with 10 extra elements to allow for more calls
     * to the enqueue() without calling dequeue().
     */
    private void resize() {
        if (this.head != 0) this.trim();
        if (this.tail < this.queue.length) {return;}
        Object[] newQueue = new Object[this.queue.length + 10];
        for (int i = 0; i < this.queue.length; i++) {
            newQueue[i] = this.queue[i];
        }
        this.queue = newQueue;
    }

    /**
     * when called the array representing the stack is copied to a new array containing no null elements, the tail and
     * the head will be adjusted  accordingly.
     */
    public void trim() {
        Object[] trimmedQueue = new Object[this.size()];
        for (int i = 0; i < this.size(); i ++) {
            trimmedQueue[i] = this.queue[head + i];
        }
        this.queue = trimmedQueue;
        this.head = 0;
        this.tail = this.size();
    }

    @Override
    public String toString() {
        String retval = "";
        for (int i = head; i < tail; i++) {
            retval = retval + this.queue[i];
        }
        return retval;
    }
}