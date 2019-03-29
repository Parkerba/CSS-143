/**
 * @author Parker Amundsen
 * @version 3/5/2019
 */
public class Music extends Desire implements Cloneable{

    /**
     * copy constructor
     * @param obj
     */
    public Music (Music obj) {
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
        return  new Music(this);
    }
    /**
     *
     */
    public Music() {
        super();
    }

    /**
     *
     * @param desirability
     */
    public Music(Fraction desirability) {
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
        if (other instanceof Music) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Listening to some Jams";
    }
}
