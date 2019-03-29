import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class is used to store the list of options that will be evaluated for satisfaction.
 */
public class OptionList {
    Options[] options;

    public static void main(String[] args) throws Exception {
        System.out.println("*****************************************************************");
        System.out.println("TEST 1: myFriends1.txt with options1.txt.  A normal sort of test.\n" +
                "Everyone wants to play a video game so that should probably come up first.");
        OptionList o = new OptionList("options1.txt");
        PersonList pL = new PersonList("myFriends1.txt");
        System.out.println("Here's the people and what they want: \n" + pL);
        System.out.println("And here's a list of the options for what to do, in order of which would provide the most overall satisfaction:");
        o.printRankedListOfWhichOptionsWouldMostSatisfy(pL);

        System.out.println("*****************************************************************");
        System.out.println("TEST 2: myFriends2.txt with options2.txt.  Even though everyone else wants to listen to music,\n" +
                "Frank's desire for Tetris is so strong that it far outweighs anyone else's desires.\n" +
                "So the video game option should come up first.");
        o = new OptionList("options2.txt");
        pL = new PersonList("myFriends2.txt");
        System.out.println("Here's the people and what they want: \n" + pL);
        System.out.println("And here's a list of the options for what to do, in order of which would provide the most overall satisfaction:");
        o.printRankedListOfWhichOptionsWouldMostSatisfy(pL);

        System.out.println("*****************************************************************");
        System.out.println("TEST 3: myFriends3.txt with options3.txt.  Two people both want to listen to Bach. So Bach should be first,\n" +
                "And it should have 2 points of satisfaction.\n" +
                "Listening to Mozart should be second, then Pink Floyd.");
        o = new OptionList("options3.txt");
        pL = new PersonList("myFriends3.txt");
        System.out.println("Here's the people and what they want: \n" + pL);
        System.out.println("And here's a list of the options for what to do, in order of which would provide the most overall satisfaction:");
        o.printRankedListOfWhichOptionsWouldMostSatisfy(pL);

        System.out.println("*****************************************************************");
        System.out.println("TEST 4: myFriends4.txt with options4.txt.  Testing the Other class,\n" +
                "Staring at the wall should win. Then sleep. Then Led Zep (with 0 satisfaction points).");
        o = new OptionList("options4.txt");
        pL = new PersonList("myFriends4.txt");
        System.out.println("Here's the people and what they want: \n" + pL);
        System.out.println("And here's a list of the options for what to do, in order of which would provide the most overall satisfaction:");
        o.printRankedListOfWhichOptionsWouldMostSatisfy(pL);

    }


    /**
     * @param filename
     * @throws Exception
     */
    public OptionList(String filename) throws Exception {
        Scanner reader = new Scanner(new FileInputStream(filename));
        List<Options> optionsList = new List<>();
        Options option;
        while (reader.hasNextLine()) {
            option = new Options(PersonList.setDesire(reader.nextLine().split(" ")));
            optionsList.append(option);
        }
        this.options = toOptionsList(optionsList);

    }

    /**
     * @param list this converts the linked list to a standard array of options
     * @return
     */
    public Options[] toOptionsList(List<Options> list) {
        Node<Options> pointer = list.head;
        Options[] arr = new Options[list.size()];
        int index = 0;
        while (pointer != null) {
            arr[index++] = pointer.data;
            pointer = pointer.next;
        }
        return arr;
    }

    /**
     * This method takes a personlist and compares each desire of each person in the personlist and evaluated how much satisfaction
     * each desire method would give.
     *
     * @param p
     */
    public void printRankedListOfWhichOptionsWouldMostSatisfy(PersonList p) {
        Node<Person> pointer = p.personList.head; //pointer for iterating through each person

        while (pointer != null) {
            Node<Desire> desirePointer = pointer.data.desireList.head; //pointer for iterating through each persons desireList
            while (desirePointer != null) {
                addSatisfactionToOptions(desirePointer.data);
                desirePointer = desirePointer.next;
            }
            pointer = pointer.next;
        }
        insertionSort();

        for (Options op : options) {
            if (op == null) break;
            System.out.println(op);
        }
    }

    /**
     * This method will go through the options and add the level of satisfaction for each option.
     *
     * @param x
     */
    public void addSatisfactionToOptions(Desire x) {
        for (Options op : options) {
            if (op == null) break;
            op.amountOfSatisfaction += x.CalculateSatisfaction(op.getWhatToDo()) * x.desireStrength.toDouble();
        }
    }

    /**
     * Insertion sorting algorithm
     */
    public void insertionSort() {
        for (int i = 0; i < options.length; i++) {
            Options current = options[i];
            if (options[i] == null) return;
            int hole = i;

            while (hole > 0 && options[hole - 1].amountOfSatisfaction < current.amountOfSatisfaction) {
                options[hole] = options[--hole];
            }
            options[hole] = current;
        }
    }

}

