/**
 * @author Parker Amundsen
 * @version 3/5/2019
 */
public class Other extends Desire implements Cloneable{
    /**
     * copy constructor
     * @param obj
     */
    public Other (Other obj) {
        this.descriptor = obj.descriptor;
        this.desireStrength = new Fraction(obj.desireStrength);
    }

    public Other() {
    }

    /**
     *
     * @return deep clone of this.
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return  new Other(this);
    }

    @Override
    public double CalculateSatisfaction(Desire other) {
        if (this.getClass() == other.getClass()) {
           if (this.descriptor.equalsIgnoreCase(((Other) other).descriptor) || this.descriptor.equals("") || ((Other) other).descriptor.equals("")) {
               return 1;
           } else return .5;

        } else return 0;
    }

    @Override
    public String toString() {
        return "Other " + descriptor;
    }
}
