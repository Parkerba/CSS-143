/**
 * @author Parker Amundsen
 * @version 3/1/2019
 * This is a linked list implementation of the ADT queue
 */
public class Queue<T> extends List {
    private List<T> queue = new List<>();


    /**
     *
     * @param args
     * @throws LinkedListException
     */
    public static void main(String[] args) throws LinkedListException {
        Queue<String> stringQueue = new Queue<>();

        stringQueue.enqueue("item 1");
        stringQueue.enqueue("item 2");
        stringQueue.enqueue("item 3");
        stringQueue.queue.printLinkedList();
        System.out.println("Size is: " + stringQueue.size());
        System.out.println(stringQueue.dequeue());
        System.out.println("Size is: " + stringQueue.size());
        System.out.println("isEmpty? " + stringQueue.isEmpty());


        System.out.println(stringQueue.dequeue());
        System.out.println("Size is: " + stringQueue.size());
        System.out.println("isEmpty? " + stringQueue.isEmpty());


        System.out.println(stringQueue.dequeue());
        System.out.println("Size is: " + stringQueue.size());
        System.out.println("isEmpty? " + stringQueue.isEmpty());
        try {
            stringQueue.dequeue();
        } catch (LinkedListException E) {
            System.out.println("The Queue is empty");
        }


    }

    public Node<T> getHead() {
        return queue.head;
    }

    /**
     * This will add the data param to the queue.
     * @param data
     */
    public void enqueue(T data) {
        if (queue.head == null) {
            queue.head = new Node<T>(data);
        } else {
            Node pointer = queue.head;
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            pointer.next = new Node(data);
        }
    }

    public T dequeue() throws LinkedListException {
        if (this.queue.head == null) {
            throw new LinkedListException("The queue is empty");
        } else {
            T retval = this.queue.head.data;
            this.queue.head = this.queue.head.next;
            return retval;
        }
    }

    /**
     *
     * @return The number of elements in the Stack
     */
    public int size() {
        return queue.size();
    }

    public void printQueue() {
        this.queue.printLinkedList();
    }

    public boolean isEmpty() {
        if (this.size() == 0) {
            return true;
        } return false;
    }

    @Override
    public String toString() {
        return queue.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return queue.equals(obj);
    }
}
