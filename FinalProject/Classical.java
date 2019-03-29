/**
 * @author Parker Amundsen
 * @version 3/5/2019
 */
public class Classical extends Music implements Cloneable {
    public Classical() {
    }

    /**
     * copy constructor
     * @param obj
     */
    public Classical (Classical obj) {
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
        return  new Classical(this);
    }
    /**
     *
     * @param other
     * @return the amount of satisfaction from performing the "other" desire.
     */
    @Override
    public double CalculateSatisfaction(Desire other) {
        if (other instanceof Classical && (this.descriptor.equals(((Classical) other).descriptor) || this.descriptor.equals(""))) {
            return 1;
        } else if (other instanceof Classical) return .65;
        else if (other instanceof Music) return .3;
        else return 0;
    }

    @Override
    public String toString() {
        return "Listening to Classical " + descriptor;
    }
}
