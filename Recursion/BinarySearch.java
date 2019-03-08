/**
 * This is a class that uses two methods to perform a binary search. Th first is an iterative method, the second is a
 * recursive method.
 * @author Parker Amundsen
 * @version 02/23/2019
 */
public class BinarySearch extends SearchAlgorithm {
    private Integer highIndex;
    private Integer lowIndex;
    private Integer midIndex;

    /**
     * @param words
     * @param wordToFind
     * @return
     */
    @Override
    public int search(String[] words, String wordToFind) throws ItemNotFoundException {
        highIndex = words.length - 1;
        lowIndex = 0;
        midIndex = lowIndex + ((highIndex - lowIndex) / 2);
        while (!compareAndAdjust(words[midIndex], wordToFind)) {
            //If the comparison count (super.count) is greater than the maximum number of searches required (log base 2 of the number of elements) throw ItemNotFoundException
            if (super.getCount() > Math.log(words.length)/Math.log(2)) throw new ItemNotFoundException();
        }
        return midIndex;
    }

    /**
     * @param words
     * @param wordToFind
     * @return
     */
    @Override
    public int recSearch(String[] words, String wordToFind) throws ItemNotFoundException {
       setIndices(words.length);
        if (super.getCount() > Math.log(words.length)/Math.log(2)) throw new ItemNotFoundException();
        if (compareAndAdjust(words[midIndex],wordToFind)) {
           return midIndex;
       } recSearch(words,wordToFind);
       return midIndex;
    }

    /**
     * @param word
     * @param target
     * @return True only if the word is equal to the target. Else return false.
     */
    public boolean compareAndAdjust(String word, String target) {
        incrementCount();
        //Is the word equal to the target?
        if (word.compareTo(target) == 0) return true;
            //Is the word greater than the target?
        else if (word.compareTo(target) > 0) {
            highIndex = midIndex - 1;
            midIndex = lowIndex + ((highIndex - lowIndex) / 2);
            return false;
        } //The word is less than the target.
        else {
            lowIndex = midIndex + 1;
            midIndex = (lowIndex + highIndex) / 2;
            return false;
        }

    }

    /**
     * This will set the new values of the midIndex, lowIndex, and the highIndex based on the value of the param lengthOfArray.
     * @param lengthOfArray
     */
    public void setIndices(int lengthOfArray) {
        highIndex = (highIndex == null) ? lengthOfArray -1 : highIndex;
        lowIndex = (lowIndex == null) ? 0 : lowIndex;
        midIndex = (midIndex == null) ? lowIndex + (highIndex - lowIndex)/2 : midIndex;
    }
}
