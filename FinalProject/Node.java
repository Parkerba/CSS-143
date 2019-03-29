/**
 * @author PArker Amundsen
 * @version 02/28/2019
 * @param <T>
 */
public class Node <T> {
    public T data;
    public Node<T> next;
    public Node<T> prev;

    /**
     * Single param Node constructor, next and previous links are left null.
     * @param data
     */
    public Node(T data) {
        this.data = data;
    }

    /**
     * Three param constructor, all instance members are assigned.
     * @param data
     * @param next
     * @param previous
     */
    public Node(T data, Node<T> next, Node<T> previous) {
        this.data = data;
        this.next = next;
        this.prev = previous;
    }

    /**
     * Two param Node constructor, previous is left as null.
     * @param data
     * @param next
     */
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        String prev = (this.prev == null) ? null: this.prev.data.toString();
        String next = (this.next == null) ? null: this.next.data.toString();
        return "prev: " + prev + "         this: " + this.data.toString() + "         next: " + next;

    }
}
