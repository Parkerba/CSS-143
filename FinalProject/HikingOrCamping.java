/**
 * @author Parker Amundsen
 * @version 3/5/2019
 */
public class HikingOrCamping extends OutsideTime implements Cloneable {
    public HikingOrCamping() {
    }

    /**
     * copy constructor
     * @param obj
     */
    public HikingOrCamping (HikingOrCamping obj) {
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
        return  new HikingOrCamping(this);
    }
    /**
     *
     * @param other
     * @return the amount of satisfaction from performing the "other" desire.
     */
    @Override
    public double CalculateSatisfaction(Desire other) {
        if (other instanceof HikingOrCamping && (this.descriptor.equals(((HikingOrCamping) other).descriptor) || this.descriptor.equals(""))) {
            return 1;
        } else if (other instanceof HikingOrCamping) return .65;
        else if (other instanceof OutsideTime) return .3;
        else return 0;
    }

    @Override
    public String toString() {
        return "Hiking or camping: " + descriptor;
    }
}
