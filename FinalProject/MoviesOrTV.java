/**
 * @author Parker Amundsen
 * @version 3/5/2019
 */
public class MoviesOrTV extends ScreenTime implements Cloneable {
    public MoviesOrTV() {
    }

    /**
     * copy constructor
     * @param obj
     */
    public MoviesOrTV (MoviesOrTV obj) {
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
        return  new MoviesOrTV(this);
    }
    /**
     *
     * @param other
     * @return the amount of satisfaction from performing the "other" desire.
     */
    @Override
    public double CalculateSatisfaction(Desire other) {
        if (other instanceof MoviesOrTV && (this.descriptor.equals(((MoviesOrTV) other).descriptor) || this.descriptor.equals(""))) {
            return 1;
        } else if (other instanceof MoviesOrTV) return .65;
        else if (other instanceof ScreenTime) return .3;
        else return 0;
    }

    @Override
    public String toString() {
        return "Watching TV or movies! " + descriptor;
    }
}
