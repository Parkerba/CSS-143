/**
 * This is the abstract desire class this is used to measure the desirability of all the subclasses.
 * @author Parker Amundsen
 * @version 03/3/2019
 */
public abstract class Desire implements Comparable<Desire> {
    protected String descriptor = "";
    protected Fraction desireStrength;


    /**
     *
     */
    public Desire() {
        this.desireStrength = new Fraction(0,0);
    }

    public Desire(Desire other) {
        this.desireStrength = new Fraction(desireStrength);
        this.descriptor = other.descriptor;
    }

    public Desire(Fraction desirability) {
        this.desireStrength = new Fraction(desirability);
    }

    /**
     * Abstract method from the comparable interface, will be used for sorting subclasses.
     * @return
     */
    @Override
    public int compareTo(Desire o) {
        return desireStrength.compareTo(o.getDesireStrength());
    }

    /**
     * This will be used by subclasses for sorting purposes.
     * @return
     */
    abstract public double CalculateSatisfaction(Desire other);

    public Fraction getDesireStrength() {
        return new Fraction(desireStrength);
    }

    /**
     * Setter for desireStrength
     * @param desireStrength
     */
    public void setDesireStrength(Fraction desireStrength) {
        this.desireStrength = new Fraction(desireStrength);
    }

}
