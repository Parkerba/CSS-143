/**
 * @author Parker Amundsen
 * @version 3/5/2019
 */
public class ScreenTime extends Desire implements Cloneable {

    /**
     * copy constructor
     * @param obj
     */
    public ScreenTime (ScreenTime obj) {
        this.descriptor = obj.descriptor;
        this.desireStrength = new Fraction(obj.desireStrength);
    }

    /**
     *
     * @return deep clone of this.
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return  new ScreenTime(this);
    }
    /**
     *
     */
    public ScreenTime() {
        super();
    }

    /**
     *
     * @param desirability
     */
    public ScreenTime(Fraction desirability) {
        super(new Fraction(desirability));
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Desire o) {
        return super.compareTo(o);
    }

    /**
     *
     * @param other
     * @return
     */
    @Override
    public double CalculateSatisfaction(Desire other) {
        if (other instanceof ScreenTime) return 1 * other.desireStrength.toDouble();
        else return 0;
    }

    @Override
    public String toString() {
        return "Staring at a back-lit panel.";
    }
}
