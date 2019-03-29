/**
 * @author Parker Amundsen
 * @version 3/5/2019
 */
public class Internet extends ScreenTime implements Cloneable {
    public Internet() {
    }

    /**
     * copy constructor
     * @param obj
     */
    public Internet (Internet obj) {
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
        return  new Internet(this);
    }
    /**
     *
     * @param other
     * @return the amount of satisfaction from performing the "other" desire.
     */
    @Override
    public double CalculateSatisfaction(Desire other) {
        if (other instanceof Internet && (this.descriptor.equals(((Internet) other).descriptor) || this.descriptor.equals(""))) {
            return 1;
        } else if (other instanceof Internet) return .65;
        else if (other instanceof ScreenTime) return .3;
        else return 0;
    }
    @Override
    public String toString() {
        return "Internet " + descriptor;
    }
}
