import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * This program reads a .txt file filled with fractions and prints to the console the number of occurrences of each fraction.
 * @author Parker Amundsen
 * @version 1/8/2019
 */
public class FactionsV1 {
    public static void main(String[] money) throws Exception {
        FileInputStream fis = new FileInputStream("fractions.txt");
        int[] numerator = new int[100];
        int[] denominator = new int[100];

        int counter = readFile(fis,numerator,denominator);
        int[] trimmedNumerator = Arrays.copyOf(numerator, counter);
        int[] trimmedDenominator = Arrays.copyOf(denominator, counter);

        int[][] originalIndexAndCount = uniqueArrayConversion(trimmedNumerator, trimmedDenominator);
        printResults(trimmedNumerator,trimmedDenominator,originalIndexAndCount);
        }

    /**
     * When called, printResults() prints to the console the formatted results of
     * @param trimmedNumerator
     * @param trimmedDenominator
     * @param originalIndexAndCount
     */
    public static void printResults(int[] trimmedNumerator, int[] trimmedDenominator, int[][] originalIndexAndCount) {
        for (int i = 0; i < originalIndexAndCount.length; i++) {
            System.out.println(trimmedNumerator[originalIndexAndCount[i][0]] + "/" + trimmedDenominator[originalIndexAndCount[i][0]] +
                    " occurs " + originalIndexAndCount[i][1] + " times.");
        }
    }
    /**
     * When called, readFile() reads the param FileInputStream object and assigns values to the int param arrays.
     * Then readFile() returns an int counter representing the number of elements read from the FileInputStream this is for creating a trimmed array later.
     *
     * @param fis
     * @param numerator
     * @param denominator
     * @return count
     * @author Parker Amundsen
     */
    public static int readFile(FileInputStream fis, int[] numerator, int[] denominator){
        Scanner reader = new Scanner(fis);
        int counter = 0;
        while (reader.hasNext()) {
            String temp = reader.nextLine();
            numerator[counter] = Integer.parseInt(temp.substring(0, temp.indexOf('/')));
            denominator[counter++] = Integer.parseInt(temp.substring(temp.indexOf('/') + 1));
        }
        reader.close();
        return counter;
    }

    /**
     * When called, doubleConversion converts two arrays representing the numerator and denominator into a single double array.
     *
     * @param numerator
     * @param denominator
     * @return doubleArr
     * @author Parker Amundsen
     */
    public static double[] doubleConversion(int[] numerator, int[] denominator) {
        double[] doubleArr = new double[numerator.length];
        for (int i = 0; i < doubleArr.length; i++) {
            doubleArr[i] = (double) numerator[i] / denominator[i];
        }
        return doubleArr;
    }

    /**
     * When called, uniqueArrayConversion takes the two int[] parameters representing a group of fractions and converts them to a single double[] by calling doubleConversion().
     * The each element of the double converted array is processed, placing the index of first occurrence (from the original array) in the first column of uniqueArr[][].
     * Each index placed in the uniqueArr[][] will also have corresponding count (number of times it occurs in the original array[]) placed in the second column of uniqueArr[][].
     *
     * @param numerator
     * @param denominator
     * @return uniqueArr
     * @author Parker Amundsen
     */
    public static int[][] uniqueArrayConversion(int[] numerator, int[] denominator) {
        double[] arr = doubleConversion(numerator, denominator);
        int[][] uniqueArr = new int[arr.length][2];

        double[] alreadyCounted = new double[arr.length]; //Used to keep track of the elements already accounted for.
        Arrays.fill(alreadyCounted, Math.pow(2, .5)); //Filled with an irrational number so any fractions equaling zero will not be overlooked.

        int uniqueArrIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < uniqueArr.length; j++) {
                if (arr[i] == alreadyCounted[j]) {
                    break;
                } else if (j == uniqueArr.length - 1) {
                    uniqueArr[uniqueArrIndex][0] = i;
                    uniqueArr[uniqueArrIndex][1] = fractionCount(arr[i], arr);
                    alreadyCounted[uniqueArrIndex++] = arr[i];
                }
            }
        }
        int[][] trimmedUniqueArray = Arrays.copyOf(uniqueArr, uniqueArrIndex);
        return trimmedUniqueArray;
    }

    /**
     * When called this method returns the number of occurences of the double test parameter in the double[] arr parameter.
     * @param test
     * @param arr
     * @return count
     * @author Parker Amundsen
     */
    public static int fractionCount(double test, double[] arr) {
        int count = 0;
        for (double element : arr) {
            if (test == element) {
                count++;
            }
        }
        return count;
    }
}



