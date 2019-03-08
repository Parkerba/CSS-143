/**
 * @author Parker Amundsen
 * @version 3/1/2019
 * This is a linked list implementation of the ADT stack.
 */
public class Stack<T> extends List {
    private List<T> stack = new List<T>();

    /**
     *
     * @param args
     * @throws LinkedListException
     */
    public static void main(String[] args) throws LinkedListException {
        Stack<Character> characterStack = new Stack<>();
       characterStack.push('a');
       characterStack.push('b');
       characterStack.push('c');
       characterStack.push('d');
       characterStack.push('e');
       characterStack.push('f');

       while (!characterStack.isEmpty()) {
           System.out.println(characterStack.pop());
       }

       try {
           characterStack.pop();
       } catch (LinkedListException e){
           System.out.println("The stack is empty!");
       }


    }

    /**
     * This inserts a new node at the head position.
     *
     * @param data
     */
    public void push(T data) {
         this.stack.head= new Node<>(data, this.stack.head);
    }

    /**
     *
     * @return This will return the element that is "popped" off of the top of the stack
     */
    public T pop() throws LinkedListException {
        if (isEmpty()) throw new LinkedListException("The Stack is empty");
        T retVal = this.stack.head.data;
        this.stack.head = this.stack.head.next;
        if (this.head == null) return retVal;
        this.stack.head.prev = null;
        return retVal;

    }

    @Override
    public void printLinkedList() {
        super.printLinkedList(this.stack.head);
    }

    /**
     *
     * @return The number of elements in the Stack
     */
    public int size() {
        return stack.size();
    }

    /**
     *
     * @return true if the linkedList is node
     */
    public boolean isEmpty() {
        if (this.size() == 0)return true;
        else return false;
    }

    public Node<T> getHead() {
        return this.stack.head;
    }

    @Override
    public boolean equals(Object obj) {
        return stack.equals(obj);
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}
