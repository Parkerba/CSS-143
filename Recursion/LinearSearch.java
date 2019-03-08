import java.util.Arrays;

/**
 * This is a class that serves to demonstrate two linear search methods, one recursive one not. When the array of strings that are being
 * searched through gets above 5000, the recursive search method becomes unfeasible. the layer of nesting becomes too great and it results in a stack overflow error.
 * @author Parker Amundsen
 * @version 02/14/2019
 *
 */
public class LinearSearch extends SearchAlgorithm {

    /**
     * This is overridden method from the abstract class SearchAlgorithm. This utilizes the iterative method of linear searching.
     * @param words
     * @param wordToFind
     * @return the number of comparisons needed to find the target value in the words array.
     * @throws ItemNotFoundException
     */
    @Override
    public int search(String[] words, String wordToFind) throws ItemNotFoundException {
        super.resetCount();
        for (int i = 0; i < words.length; i++) {
            super.incrementCount();
            if (words[i].equalsIgnoreCase(wordToFind)) {
                int retVal = super.getCount() -1;
                return retVal;
            }
        }
        throw new ItemNotFoundException();
    }

    /**
     * This is the overridden method from the abstract class SearchAlgorithm. This is the recursive use of the linear search
     * method.
     * PRE: The words param array must be less than 5000 or a stack overflow error will likely occur.
     * @param words
     * @param wordToFind
     * @return this is the number of comparisons that were needed to find the word.
     * @throws ItemNotFoundException
     */
    @Override
    public int recSearch(String[] words, String wordToFind) throws ItemNotFoundException {
        if (words[getCount()].equalsIgnoreCase(wordToFind)) {
            int retVal = super.getCount();
            return retVal;
        }
        super.incrementCount();
        if (super.getCount() == words.length) {
            throw new ItemNotFoundException();
        }
        try {
            recSearch(words, wordToFind);
        }
        catch (IndexOutOfBoundsException e) {
            throw new ItemNotFoundException();
        }
        return 0;
    }



}

