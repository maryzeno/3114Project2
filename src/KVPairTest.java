import student.TestCase;

/**
 * This class tests the KVPair class
 * to ensure that all the methods work properly.
 *
 * @author Hafsa Khan (hfsakhn)
 * @author Mary Zeno (maryzeno)
 * @version 10/02/2023
 */
public class KVPairTest extends TestCase {
    private KVPair<Integer, String> kv; // kvpair the rest of the
    // class uses

    /**
     * This method sets up the kvpair
     * for the rest of the class to use to test
     */
    public void setUp() {
        kv = new KVPair<Integer, String>(3, "hello");
        // the rest of the class uses this to test
    }


    /**
     * This method tests the key method to make
     * sure it works properly
     */
    public void testKey() {
        assertTrue(kv.key().equals(3));
    }


    /**
     * This method tests the value method to make
     * sure it works properly
     */
    public void testValue() {
        assertTrue(kv.value().equals("hello"));
    }


    /**
     * This method tests the compareToWithKey method to make
     * sure it works properly
     */
    public void testCompareToWithKey() {
        assertEquals(0, kv.compareTo(3));
    }


    /**
     * This method tests the toString method to make
     * sure it works properly
     */
    public void testToString() {
        assertTrue(kv.toString().equals("(3, hello)"));

        KVPair<Integer, String> kv2 = new KVPair<Integer, String>(null, null);

        assertTrue(kv2.toString().equals("(null, null)"));

        KVPair<Integer, String> kv3 = new KVPair<Integer, String>(4, "bye");
        assertEquals(kv.compareTo(kv), 0);

        assertEquals(kv.compareTo(kv3), -1);
    }
}



