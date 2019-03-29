/**
 * @author Parker Amundsen
 * @version 3/5/2019
 * This is a class that will hold the persons name and their list of desires.
 */
public class Person {
    public String name;
    public List<Desire> desireList = new List<>();

    public Person(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "\n" + this.name + "     " + desireList.toString();
    }
}
