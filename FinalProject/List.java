/**
 * @author Parker Amundsen
 * Second attempt at a linked list
 * @version 2/28/2019
 */
public class List<T> {
    public Node<T> head;

    /**
     *
     */
    public void printLinkedList() {
        printLinkedList(this.head);
    }

    /**
     * @param head
     */
    public void printLinkedList(Node<T> head) {
        Node<T> pointer = head;
        if (head == null) {
            System.out.println("Empty linked list");
            return;
        }
        System.out.println(pointer.data);
        while (pointer.next != null) {
            System.out.println(pointer.next.data);
            pointer = pointer.next;
        }
    }

    /**
     * This is an insert function that will insert a node with the data parameter as its data in the position.
     * PRE: There cannot be null elements in the linked list, so a position greater than the number of elements will
     * have the same affect as simply appending to the end of the linkedList.
     *
     * @param data
     * @param position
     */
    public void insert(T data, int position) {
        if (this.head == null) {
            append(data);
            return;
        }

        if (position == 0) {
            head = new Node<T>(data, head);
            head.next.prev = head;
            return;
        }

        int count = 0;
        Node<T> pointer = head;
        while (pointer.next != null) {
            if (count == position) {
                Node<T> newNode = new Node<>(data, pointer.next, pointer);
                pointer.next = newNode;
                return;
            }
            pointer = pointer.next;
            count++;
        }
        this.append(data);
    }

    /**
     * This method will add a node with the data inputted to the end of the list.
     *
     * @param data
     */
    public void append(T data) {
        if (this.head == null) {
            this.head = new Node<T>(data);
            return;
        }

        Node<T> pointer = this.head;
        while (pointer.next != null) {
            pointer = pointer.next;
        }
        pointer.next = new Node<>(data, null, pointer);
    }


    /**
     * PRE: if the position does not exist then null will be returned and nothing will be removed from the list.
     *
     * @param position the node at this position will be removed from the linked list
     */
    public T remove(int position) throws LinkedListException {
        if (this.isEmpty()) throw new LinkedListException("There are no elements to remove!");
        if (this.size() == 1 && position == 0) {
            T retval = head.data;
            head = null;
            return retval;

        }
        if (position == 0) {
            T retval = head.data;
            head = head.next;
            head.prev = null;
            return retval;
        }
        Node<T> pointer = head;
        int counter = 0;
        while (pointer.next != null && counter < position) {
            pointer = pointer.next;
            counter++;
        }
        if (pointer == null || position > counter) {
            throw new LinkedListException("Position does not exist.");
        } else if (pointer.next == null) {
            T retval = pointer.data;
            pointer.prev.next = null;
            return retval;
        }
        T retval = pointer.data;
        pointer.prev.next = pointer.next;
        pointer.next.prev = pointer.prev;
        return retval;
    }

    public void delete(int position) throws LinkedListException {
        remove(position);
    }

    public int indexOf(T data) {
        if (this.isEmpty() == true) return -1;
        Node<T> pointer = head;
        int counter = 0;
        while (pointer.next != null) {
            if (pointer.data.equals(data)) {
                return counter;
            }
            pointer = pointer.next;
            counter++;
        }
        return -1;

    }

    public boolean isEmpty() {
        if (this.head == null || (this.head.data == null && this.head.next == null)) return true;
        return false;
    }

    public int size() {
        if (this.isEmpty()) return 0;
        Node<T> pointer = head;

        int counter = 1;
        while (pointer.next != null) {
            counter++;
            pointer = pointer.next;
        }
        return counter;
    }

    /**
     * @return this.head
     */
    public Node<T> getHead() {
        return this.head;
    }

    /**
     * @return This will print the data in each node with the corresponding index of that node.
     */
    @Override
    public String toString() {
        if (this.isEmpty()) return "Empty";
        String retval = "";
        Node<T> pointer = head;

        while (pointer.next != null) {

            retval = retval + "\n" + pointer.data + "   ";
            pointer = pointer.next;

        }
        retval = retval + "\n" + pointer.data;
        return retval;
    }

    @Override
    public boolean equals(Object obj) {
        return this.toString().equals(obj.toString());
    }
}



