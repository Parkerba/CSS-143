/**
 * @author Parker Amundsen
 * @version 3/5/2019
 */
public class OtherOutside extends OutsideTime implements Cloneable {
    /**
     * copy constructor
     * @param obj
     */
    public OtherOutside (OtherOutside obj) {
        this.descriptor = obj.descriptor;
        this.desireStrength = new Fraction(obj.desireStrength);
    }

    public OtherOutside() {
    }

    /**
     *
     * @return deep clone of this.
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return  new OtherOutside(this);
    }
    /**
     *
     * @param other
     * @return the amount of satisfaction from performing the "other" desire.
     */
    @Override
    public double CalculateSatisfaction(Desire other) {
        if (other instanceof OtherOutside && (this.descriptor.equals(((OtherOutside) other).descriptor) || this.descriptor.equals(""))) {
            return 1;
        } else if (other instanceof OtherOutside) return .65;
        else if (other instanceof OutsideTime) return .3;
        else return 0;
    }

    @Override
    public String toString() {
        return "Other outside: " + descriptor;
    }
}
