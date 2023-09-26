import student.TestCase;

public class KVPairTest extends TestCase {
    KVPair<Integer, String> kv;

    public void setUp() {
        kv = new KVPair<Integer, String>(3, "hello");
    }


    public void testKey() {
        assertTrue(kv.key().equals(3));
    }


    public void testValue() {
        assertTrue(kv.value().equals("hello"));
    }
    
    public void testCompareToWithKey() {
        assertEquals(0, kv.compareTo(3));
    }


    public void testToString() {
        assertTrue(kv.toString().equals("(3, hello)"));

        KVPair<Integer, String> kv2 = new KVPair<Integer, String>(null, null);

        assertTrue(kv2.toString().equals("(null, null)"));

        KVPair<Integer, String> kv3 = new KVPair<Integer, String>(4, "bye");
        assertEquals(kv.compareTo(kv), 0);

        assertEquals(kv.compareTo(kv3), -1);
    }
}