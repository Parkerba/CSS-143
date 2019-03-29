import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This is a class that holds a list of people and their desires.
 *
 * @author Parker Amundsen
 * @version 03/8/2019
 */
public class PersonList {
    public List<Person> personList = new List<>();

    public PersonList(String fileName) throws FileNotFoundException {
        Scanner reader = new Scanner(new File(fileName));
        Person tempPerson = new Person("");
        while (reader.hasNextLine()) {
            String[] temp = reader.nextLine().split(" ");
            if (temp.length == 2) {
                tempPerson = new Person(temp[1]);
                personList.append(tempPerson);
            }
            else if (temp.length == 1) {

            }
            else {
                Desire tempDesire = setDesire(temp);
                tempPerson.desireList.append(tempDesire);

            }
        }


    }

    /**
     * PRE: this should be an array of strings read from a file with information formatted as "Desire Descriptor satisfactionFraction"
     *
     * @param temp
     * @return
     */
    public static Desire setDesire(String[] temp) {
        Desire retVal;
        switch (temp[0].toUpperCase()) {
            case "BIKING":
                retVal = new Biking();
                break;
            case "CARBSANDGRAINS":
                retVal = new CarbsAndGrains();
                break;
            case "CLASSICAL":
                retVal = new Classical();
                break;
            case "COUNTRY":
                retVal = new Country();
                break;
            case "EATING":
                retVal = new Eating();
                break;
            case "ELECTRONIC":
                retVal = new Electronic();
                break;
            case "FRUITSANDVEGGIES":
                retVal = new FruitsAndVeggies();
                break;
            case "HIKINGORCAMPING":
                retVal = new HikingOrCamping();
                break;
            case "INTERNET":
                retVal = new Internet();
                break;
            case "MEATANDDAIRY":
                retVal = new MeatAndDairy();
                break;
            case "MOVIESORTV":
                retVal = new MoviesOrTV();
                break;
            case "MUSIC":
                retVal = new Music();
                break;
            case "OTHER":
                retVal = new Other();
                break;
            case "OTHEROUTSIDE":
                retVal = new OtherOutside();
                break;
            case "OUTSIDETIME":
                retVal = new OutsideTime();
                break;
            case "RANDB":
                retVal = new RandB();
                break;
            case "ROCK":
                retVal = new Rock();
                break;
            case "SCREENTIME":
                retVal = new ScreenTime();
                break;
            case "SWEETS":
                retVal = new Sweets();
                break;
            case "VIDEOGAMES":
                retVal = new VideoGames();
                break;
            default:
                retVal = new Eating();

        }
        retVal.descriptor = temp[1].substring(1, temp[1].length() - 1);
        if (temp.length != 2)
            retVal.desireStrength = new Fraction(temp[2]);
        return retVal;
    }

    /**
     * @param person will be added to the end of this.personList
     */
    public void add(Person person) {
        this.personList.append(person);
    }

    @Override
    public String toString() {
        Node<Person> pointer = personList.head;
        String retVal = "";
        while (pointer.next != null) {
            retVal = retVal + " " + pointer.data.toString();
            pointer = pointer.next;
        }
        return retVal;
    }
}
