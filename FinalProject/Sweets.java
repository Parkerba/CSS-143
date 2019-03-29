/**
 * @author Parker Amundsen
 * @version 3/5/2019
 */
public class Sweets extends Eating implements Cloneable{
    public Sweets() {
    }

    /**
     * copy constructor
     * @param obj
     */
    public Sweets (Sweets obj) {
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
        return  new Sweets(this);
    }
    /**
     *
     * @param other
     * @return the amount of satisfaction from performing the "other" desire.
     */
    @Override
    public double CalculateSatisfaction(Desire other) {
        if (other instanceof Sweets && (this.descriptor.equals(((Sweets) other).descriptor) || this.descriptor.equals(""))) {
            return 1;
        } else if (other instanceof Sweets) return .65;
        else if (other instanceof Eating) return .3;
        else return 0;
    }

    @Override
    public String toString() {
        return "Eating sweets  " + descriptor;
    }
}
