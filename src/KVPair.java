/**
 * This class is the KVPair class, it is
 * used throughout the rest of the project.
 * 
 * @author Hafsa Khan (hfsakhn)
 * @author Mary Zeno (maryzeno)
 * @version 10/02/2023
 * @param <K>
 *            is the key
 * @param <E>
 *            is the element
 */
public class KVPair<K extends Comparable<K>, E>
    implements Comparable<KVPair<K, E>> {

    private K theKey; // this is the key for the KVPair
    private E theVal; // this is the value for the KVPair

    /**
     * This is the constructor, it sets up the key
     * and the value for the KVPair.
     *
     * @param k
     *            is the key
     * @param v
     *            is the value
     */
    KVPair(K k, E v) {
        theKey = k;
        theVal = v;
    }


    /**
     * This method is able to compare
     * keys.
     * 
     * @param it
     *            is the kvpair
     * @return returns the int
     */
    public int compareTo(KVPair<K, E> it) {
        return theKey.compareTo(it.key());
    }


    /**
     * This method is able to compare KVPairs.
     * 
     * @param it
     *            is the key
     * @return returns a number
     */
    public int compareTo(K it) {
        return theKey.compareTo(it);
    }


    /**
     * This method returns the key.
     * 
     * @return returns the key
     */
    public K key() {
        return theKey;
    }


    /**
     * This method returns the value.
     * 
     * @return returns the element
     */
    public E value() {
        return theVal;
    }


    /**
     * This method returns the KVPair as a string,
     * it is able to print the pair out.
     * 
     * @return returns the string
     */
    public String toString() {
        String s = "(";
        if (theKey != null) {
            s += theKey.toString();
        }
        else {
            s += "null";
        }
        s += ", ";
        if (theVal != null) {
            s += theVal.toString();
        }
        else {
            s += "null";
        }
        s += ")";
        return s;
    }

}


