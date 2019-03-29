/**
 * @author Parker Amundsen
 * @version 3/5/2019
 */
public class VideoGames extends ScreenTime implements Cloneable {
    public VideoGames() {
    }

    /**
     * copy constructor
     * @param obj
     */
    public VideoGames (VideoGames obj) {
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
        return  new VideoGames(this);
    }
    /**
     *
     * @param other
     * @return the amount of satisfaction from performing the "other" desire.
     */
    @Override
    public double CalculateSatisfaction(Desire other) {
        if (other.getClass() == this.getClass() && ((this.descriptor.equals(((VideoGames) other).descriptor) || this.descriptor.equals("")))) {
            return 1;
        } else if (other instanceof VideoGames) return .65;
        else if (other instanceof ScreenTime) return .3;
        else return 0;
    }
    @Override
    public String toString() {
        return "Video Games " + descriptor;
    }
}
