/**
 * @author Parker Amundsen
 * @version 3/8/2019
 * This is used to represent an option of what to do tonight, stores the desire and the level of satisfaction it would bring.
 */
public class Options implements Comparable<Options> {

    public double amountOfSatisfaction;
    private Desire whatToDo;

    /**
     * Getter for instance variable what to do.
     * @return
     */
    public Desire getWhatToDo() {
        return whatToDo;
    }

    /**
     *One param constructor for options
     * @param desire
     * @throws Exception
     */
    public Options(Desire desire) throws Exception {
        if (desire.descriptor.equals("")) {
            throw new Exception("There is no descriptor");
        } else {
            this.whatToDo = desire;
            this.amountOfSatisfaction = 0;
        }
    }


    /**
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Options o) {
        if (this.amountOfSatisfaction == o.amountOfSatisfaction) return 0;
        else if (this.amountOfSatisfaction > o.amountOfSatisfaction ) return 1;
        else return -1;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return this.whatToDo.toString() + " will bring " + amountOfSatisfaction + " points of satisfaction.";
    }

    /**
     * Setter for instance variable what to do.
     * @param whatToDo
     */
    public void setWhatToDo(Desire whatToDo) {
        this.whatToDo = whatToDo;
    }

}
