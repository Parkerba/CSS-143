/**
 * @author Parker Amundsen
 * @version 3/5/2019
 */
public class FruitsAndVeggies extends Eating implements Cloneable {
    public FruitsAndVeggies() {
    }

    /**
     * copy constructor
     * @param obj
     */
    public FruitsAndVeggies (FruitsAndVeggies obj) {
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
        return  new FruitsAndVeggies(this);
    }
    /**
     *
     * @param other
     * @return the amount of satisfaction from performing the "other" desire.
     */
    @Override
    public double CalculateSatisfaction(Desire other) {
        if (other instanceof FruitsAndVeggies && (this.descriptor.equals(((FruitsAndVeggies) other).descriptor) || this.descriptor.equals(""))) {
            return 1;
        } else if (other instanceof FruitsAndVeggies) return .65;
        else if (other instanceof Eating) return .3;
        else return 0;
    }
    @Override
    public String toString() {
        return "Eating fruits and veggies: " + descriptor;
    }
}
