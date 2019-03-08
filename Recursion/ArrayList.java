/**
 * This class is my implementation of the ADT list.
 * @author Parker Amundsen
 * @version 1/29/2019
 */
public class ArrayList {
    private Object[] list;

    /**
     * Default constructor, initialises the ArrayList with size of zero
     */
    public ArrayList() {
        this.list = new Object[0];
    }

    /**
     * Overloaded constructor to make an ArrayList object from an existing Object[]
     *
     * @param arr
     */
    public ArrayList(Object[] arr) {
        this.list = arr;
        trim();
    }

    /**
     * When called set reassigns the value of the object of the element of the array at the param index to the param object.
     * PRE: The index must be within the range of possible indices
     *
     * @param index
     * @param obj
     */
    public void set(int index, Object obj) {
        this.list[index] = obj;
    }

    public boolean isEmpty() {
        if (this.list.length == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return this.list.length;
    }

    /**
     * Inserts the Object param into the array at the index of the int param.
     *
     * @param obj
     * @param index
     */
    public void insert(Object obj, int index) {
        if (nullcheck(obj)) return;
        resize(index);
        this.list[index] = obj;
    }

    /**
     * Adds the param obj to the end of the list.
     *
     * @param obj
     */
    public void insert(Object obj) {
        insert(obj, this.list.length);
    }

    /**
     * returns the index of the element that is equal to the Object param, if not found -1 is returned.
     *
     * @param obj
     * @return
     */
    public int indexOf(Object obj) {
        for (int i = 0; i < this.list.length; i++) {
            if (obj.equals(this.list[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * returns the Object in the ArrayList at the param index
     *
     * @param index
     * @return
     */
    public Object get(int index) {
        if (index < this.list.length && index >= 0)
            return this.list.clone()[index];
        else {
            System.out.println("Out of bounds error");
            return null;
        }
    }

    /**
     * @param index the Object at this index of the arrayList is returned and removed from the Arraylist.
     *              All other indices with a greater value than the index param will be shifted back one.
     * @return the element of the arraylist at the param index will be returned.
     */
    public Object remove(int index) {
        if (index < this.list.length && index >= 0) {
            Object retval = this.get(index);
            this.list[index] = null;
            this.trim();
            return retval;
        } else {
            System.out.println("Out of bounds error");
            return null;
        }
    }

    /**
     * returns true if the Object param is null, else, false.
     *
     * @param obj
     * @return true/false
     */
    private boolean nullcheck(Object obj) {
        if (obj == null) return true;
        else return false;
    }

    public Object[] toArray() {
        Object[] retVal = new String[this.list.length];
        for (int i = 0; i < this.list.length; i ++) {
            retVal[i] = this.list[i];
        }
        return retVal;
    }

    /**
     * When called, trim() will go through and remove each element that is null, the new ArrayList will be full of non null elements.
     */
    private void trim() {
        //accounts for which elements are null
        boolean[] nullList = new boolean[this.list.length];
        int numNull = 0;
        for (int i = 0; i < this.list.length; i++) {
            if (nullcheck(this.list[i])) {
                nullList[i] = true;
                numNull++;
            }
        }
        //Filling a new array with non null elements
        Object[] trimmedList = new Object[this.list.length - numNull];
        int trimmedListIndex = 0;
        for (int i = 0; i < this.list.length; i++) {
            if (nullList[i] == false) {
                trimmedList[trimmedListIndex++] = this.list[i];
            }
        }
        this.list = trimmedList;

    }

    /**
     * when called, resize() will copy the elements of the current array to a new array with one extra null element at the end.
     */
    private void resize() {
        Object[] largerList = new Object[this.list.length + 1];
        for (int i = 0; i < this.list.length; i++) {
            largerList[i] = this.list[i];
        }
        this.list = largerList;
    }

    /**
     * this overloaded resize method when called will copy this array to a new array with the null element at the provided
     * param index instead of the end of the array.
     *
     * @param index the index of the array that will be left null, all other elements at greater indices will be shifted
     *              by one.
     */
    private void resize(int index) {
        Object[] newList = new Object[this.list.length + 1];
        for (int i = 0; i < this.list.length; i++) {
            if (i >= index) {
                newList[i + 1] = this.list[i];
            }
             else newList[i] = this.list[i];
        }
        this.list = newList;
    }

    @Override
    public String toString() {
        String retval = "";
        for (Object obj : this.list)
            retval = retval + obj + " ";
        return retval;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !ArrayList.class.isAssignableFrom(obj.getClass())) return false;
        ArrayList other = (ArrayList) obj;
        if (this.list.length != other.list.length) return false;
        for (int i = 0; i < this.list.length; i++) {
            if (!this.list[i].equals(other.list[i])) return false;
        }
        return true;
    }
}
