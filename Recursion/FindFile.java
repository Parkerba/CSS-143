import java.io.File;
import java.io.FileNotFoundException;

/**
 * This is a class that can search through the files and folders of a computer form a starting directory to find files and locations matching the target name.
 * @author Parker Amundsen
 * @version 02/14/2019
 */
public class FindFile {
    private int maxFiles;
    private String[] fileLocations;
    private int count = 0;

    /**
     * @param max this is the maximum number of occurrences that this fileFinder will be able to account for.
     */
    public FindFile(int max) {
        this.maxFiles = (max > 0) ? max : 1;
        fileLocations = new String[this.maxFiles];
    }

    /**
     * PRE: target must be a file name with appropriate file type ending EX ".txt"
     * dirName must be a directory where the file is believed to be!
     *
     * @param target  this is the file name we will be searching for
     * @param dirName this is the starting point where we will be searching
     */
    public void directorySearch(String target, String dirName) {
        String targetPathName = dirName + "/" + target;

        File temp = new File(dirName);
        if (!temp.isDirectory()) {
            //TODO: throw an exception
            System.out.println("dirName is not a directory");
            System.exit(0);
        }

        File[] files = temp.listFiles();
        try {
            for (File file : (File[]) files) {
                if (file.getName().equals(target) && !file.isDirectory()) {
                    fileLocations[count] = dirName + "/" + target;
                    count++;
                }
                if (file.isDirectory()) {
                    directorySearch(target, file.getAbsolutePath());
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Maximum number of files found");
            printPathnames();
            System.exit(0);
        }
    }

    /**
     * This prints the pathNames that the FindFile object has found.
     */
    public void printPathnames() {
        for (String file : fileLocations) {
            if (file != null)
                System.out.println(file);
        }
    }

    /**
     *
     * @return the number of occurences of the target file that the fileFinder object has found.
     */
    private int getCount() {
        return count;
    }
}
