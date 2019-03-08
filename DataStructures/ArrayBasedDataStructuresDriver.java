/**
 * Driver showing the tests for my implementation of stack, queue, and list.
 * @author Parker Amundsen
 * @version 1/30/2019
 */

public class ArrayBasedDataStructuresDriver {

    public static void main(String[] args) {
        System.out.println("--------Below are the tests for Stack-------");
        stackTests();
        System.out.println("--------Below are the tests for Queue-------");
        queueTests();
        System.out.println("--------Below are the tests for ArrayList-------");
        arrayListTests();
    }

    private static void arrayListTests() {
        ArrayList test = new ArrayList();
        test.insert("Object one");
        System.out.println("index of \"Object one\" is: " + test.indexOf("Object one"));
        test.insert("Object two");
        test.insert("Object three");
        System.out.println(test);
        test.insert("Object zero", 0);
        System.out.println("index of \"Object one\" after \"Object zero\" is inserted into the list is: " + test.indexOf("Object one"));

        System.out.println(test);
        ArrayList a = new ArrayList();

        a.insert('B', 0);
        a.insert('a', 0);
        a.insert('t', 1);

        System.out.println(a.toString());

        while (a.isEmpty() == false) {
            System.out.println(a.remove(0));
        }

    }

    private static void queueTests() {
        Queue test = new Queue();
        for (int i = 0; i <= 1000; i += 50) {
            System.out.println("Adding " + i + " to the test queue!");
            test.enqueue(i);
        }
        while (!test.isEmpty()) {
            System.out.println(test.dequeue() + " is being removed from the queue!");
        }

        Queue a = new Queue();

        a.enqueue('B');
        a.enqueue('a');
        a.enqueue('t');

        System.out.println(a.toString());

        while (a.isEmpty() == false) {
            System.out.println(a.dequeue());
        }

    }

    private static void stackTests() {
        //Below is showing the functionality of the stack by printing a design as we are adding strings to the stack, then
        //printing the strings as we pop them from the stack, this should show a symmetrical design.
        Stack test = new Stack();
        String filler = "";
        for (int i = 0; i <= 35; i++) {
            filler = filler + " ";
            String fillerAndStars = filler + "*" + filler + "*" + test.size();
            System.out.println(fillerAndStars);
            test.push(fillerAndStars);
        }

        while (!test.isEmpty()) {
            System.out.println(test.pop());
        }
        Stack a = new Stack();

        a.push('B');
        a.push('a');
        a.push('t');

        System.out.println(a.toString());

        while (a.isEmpty() == false) {
            System.out.println(a.pop());
        }
    }


}
