/**
 * This class is my implementation of the ADT Stack.
 * @author Parker Amundsen
 * @version 1/29/2019
 */
public class Stack {
    private Object[] stack = new Object[0];
    private int head = 0;

    /**
     *
     * @return the object at the index of the head of the array representing the stack will be assigned to null and returned.
     */
    public Object pop() {
        this.head--;
        Object retval = this.stack[head];
        this.stack[head] = null;
        return retval;
    }

    /**
     * PRE: the object param cannot be null.
     * POST: the object will be added to the array representing the stack at the index of the head.
     * @param obj
     */
    public void push(Object obj) {
        if (nullCheck(obj)) {
            System.out.println("Object cannot be null");
            return;
        }
        resize();
        this.stack[this.head++] = obj;
    }


    private boolean nullCheck(Object obj) {
        if (obj == null) return true;
        return false;
    }

    /**
     * No objects will be removed from the stack when called.
     * @return this will be the object that was most recently added to the stack.
     */
    public Object peak() {
        return this.stack[this.head - 1];
    }

    /**
     * When called the array representing the stack will be copied to a new array with an extra null index to allow, for
     * one more call of push().
     */
    private void resize() {
        if (this.head >= this.stack.length) {
            Object[] newStack = new Object[this.head + 1];
            for (int i = 0; i < this.stack.length; i++) {
                newStack[i] = this.stack[i];
            }
            this.stack = newStack;
        }
    }

    /**
     *
     * @return isEmpty() will return true if there are no elements in the array representing the stack, else false.
     */
    public boolean isEmpty() {
        if (this.head == 0) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String retval = "";
        for (int i = this.head - 1; i >= 0; i --) {
            retval = retval + this.stack[i] + " ";
        }
        return retval;
    }

    /**
     *
     * @return this will be the number of non-null elements in the stack.
     */
    public int size() {
        return this.head;
    }
}
