/**
 * This is an exception class that is tailored to the linked list data structures.
 * @author Parker Amundsen
 * @version 3/7/2019
 */
public class LinkedListException extends Exception {
    /**
     * Default constructor, simply prints somthing went wrong.
     */
    public LinkedListException() {
        super("Something went wrong.");
    }

    /**
     * This allows use of this exception in multiple situations.
     * @param errorMessage
     */
    LinkedListException(String errorMessage) {
        super(errorMessage);
    }
}
