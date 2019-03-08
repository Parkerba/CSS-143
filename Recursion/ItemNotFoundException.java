/**
 * This is a class that represents a custom exception
 * @author Parker Amundsen
 * @version 02/23/2019
 */
public class ItemNotFoundException extends Exception {
    public ItemNotFoundException() {
        super("Item was not found!");
    }
}
