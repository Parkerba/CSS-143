/**
 * This is a class that is used to test the FindFile class.
 * @author Parker Amundsen
 * @version 02/23/2019
 */
public class Driver {
    public static void main(String[] args) {
        FindFile finder = new FindFile(100);
        finder.directorySearch("lesson.css","C:\\WCWC");
        finder.printPathnames();

        //This is the code that I used to test on my computer.
//        finder.directorySearch("Driver.java","/Users/parkeramundsen/Desktop");
//        finder.printPathnames();
    }
}
