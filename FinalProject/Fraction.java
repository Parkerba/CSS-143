/**
 * @author Parker Amundsen
 * @version 1/28/2019
 */
public class Fraction implements Comparable<Fraction> {
    final public int numerator;
    final public int denominator;

    /**
     * Two arg Fraction constructor
     * @param numerator
     * @param denominator
     */
    public Fraction(int numerator, int denominator) {
        int commonFactor = findFactor(numerator, denominator);
        this.numerator = numerator / commonFactor;
        this.denominator = denominator / commonFactor;
    }

    /**
     * This constructor will create a new fraction object from a formatted string.
     * @param fraction
     */
    public Fraction(String fraction) {
        String[] arr = fraction.split("/");
        int num = Integer.parseInt(arr[0]);
        int den = Integer.parseInt(arr[1]);
        int commonFactor = findFactor(num,den);
        this.denominator = den/commonFactor;
        this.numerator = num/commonFactor;
    }

    /**
     * copy constructor
     *
     * @param frac
     */
    public Fraction(Fraction frac) {
        this.denominator = frac.denominator;
        this.numerator = frac.numerator;
    }

    /**
     *
     * @return a string formatted fraction
     */
    @Override
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }

    /**
     * @param fracTwo
     * @return
     */
    public Fraction add(Fraction fracTwo) {
        int commonDenominator = this.denominator * fracTwo.denominator;
        int adjustedThisNumerator = this.numerator * fracTwo.denominator;
        int adjustedFracTwoDenominator = fracTwo.numerator * this.denominator;
        int newNumerator = adjustedFracTwoDenominator + adjustedThisNumerator;
        int reductionFactor = findFactor(newNumerator, commonDenominator);
        return new Fraction(newNumerator / reductionFactor, commonDenominator / reductionFactor);
    }

    /**
     *
     * @return this.numerator
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     *
     * @return this.denominator
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * @param numerator
     * @param denominator
     * @return the GCF of the numerator and denominator for reduction purposes.
     */
    public int findFactor(int numerator, int denominator) {
        int retVal = 1;
        for (int i = 1; i <= numerator; i++) {
            if (numerator % i == 0 && denominator % i == 0) {
                numerator = numerator / i;
                denominator = denominator / i;
                retVal *= i;
                i = 1;
            }
        }
        return retVal;
    }

    /**
     *
     * @return the floating point value that the decimal represents.
     */
    public double toDouble() {
        return this.numerator*(1.0)/this.denominator;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !Fraction.class.isAssignableFrom(obj.getClass())) return false;
        Fraction other = (Fraction) obj;
        if (this.getDenominator() == other.getDenominator() && this.getNumerator() == other.getNumerator()) return true;
        else return false;
    }

    @Override
    public int compareTo(Fraction o) {
        if (this.equals(o)) return 0;
        else if (((double)this.numerator/this.denominator) > ((double) o.getNumerator()/o.getDenominator())) return 1;
        else return -1;
    }
}
