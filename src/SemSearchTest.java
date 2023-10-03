import student.TestCase;

/**
 * This class tests the semSearch
 * class to ensure that is works properly.
 *
 * @author Hafsa Khan (hfsakhn)
 * @author Mary Zeno (maryzeno)
 * @version 10/02/2023
 */
public class SemSearchTest extends TestCase {
    /**
     * Sets up the tests that follow. In general, used for initialization
     */
    public void setUp() {
        // Nothing here
    }


    /**
     * Get code coverage of the class declaration.
     */
    public void testMInitx() {
        SemSearch sem = new SemSearch();
        assertNotNull(sem);
        // SemSearch.main(null);
    }
}


