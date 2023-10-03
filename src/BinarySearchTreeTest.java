import student.TestCase;

/**
 * This class tests binary search tree class
 *
 * @author Hafsa Khan (hfsakhn)
 * @author Mary Zeno (maryzeno)
 * @version 20/2/2023
 */
public class BinarySearchTreeTest extends TestCase {
    // tester tree
    private BinarySearchTree<Integer, String> tree1;
    // tester tree
    private BinarySearchTree<Integer, String> tree2;
    // tester tree
    private BinarySearchTree<Integer, String> tree3;
    // tester kv pair
    private KVPair<Integer, String> kvTest1;
    // tester kv pair
    private KVPair<Integer, String> kvTest2;
    // tester kv pair
    private KVPair<Integer, String> kvTest3;
    // tester kv pair
    private KVPair<Integer, String> kvTest4;
    // tester kv pair
    private KVPair<Integer, String> kvTest5;
    // tester kv pair
    private KVPair<Integer, String> kvTest6;
    // tester kv pair
    private KVPair<Integer, String> kvTest7;

    /**
     * this is the setUp for the test class
     */
    public void setUp() {

    }


    /**
     * tests simple insert for bst
     */
    public void testInsert() {
        // tester tree duplicates allowed
        tree1 = new BinarySearchTree<>(true);
        // tester tree arent duplicates allowed
        tree2 = new BinarySearchTree<>(false);

        // kv tester 1
        kvTest1 = new KVPair<>(2, "hello");
        // kv tester 1
        kvTest2 = new KVPair<>(3, "hello");
        // kv tester 1
        kvTest3 = new KVPair<>(1, "hello");

        assertTrue(tree1.insert(kvTest1));
        assertTrue(tree1.insert(kvTest1));
        assertTrue(tree1.insert(kvTest2));
        assertTrue(tree1.insert(kvTest3));
        tree2.insert(kvTest1);
        assertFalse(tree2.insert(kvTest1));

        // kv test
        KVPair<Integer, String> test = new KVPair<>(1, null);
        tree2.insert(test);
        assertFalse(tree2.insert(kvTest1));

    }


    /**
     * tests simple remove for bst
     */
    public void testRemove() {

        // tester tree duplicates allowed
        tree1 = new BinarySearchTree<>(true);
        // tester tree arent duplicates allowed
        tree2 = new BinarySearchTree<>(false);

        // kv tester 1
        kvTest1 = new KVPair<>(2, "hello");
        // kv tester 1
        kvTest2 = new KVPair<>(3, "hello");
        // kv tester 1
        kvTest3 = new KVPair<>(1, "hello");

        tree1.insert(kvTest3);
        tree1.insert(kvTest3);

        tree1.insert(kvTest2);
        assertTrue(tree1.remove(kvTest3));
        assertTrue(tree1.remove(kvTest3));

        tree1.insert(kvTest1);
        assertTrue(tree1.remove(kvTest2));

        // kv test 2
        KVPair<Integer, String> test2 = new KVPair<>(4, "bye");
        tree1.insert(test2);
        assertTrue(tree1.remove(test2));

        // tree test 3
        tree3 = new BinarySearchTree<>(true);
        // kv test 3
        KVPair<Integer, String> test3 = new KVPair<>(3, "bye");
        tree3.insert(test3);
        assertTrue(tree3.remove(test3));

        // kv test 5
        KVPair<Integer, String> test5 = new KVPair<>(4, "bye");
        assertFalse(tree1.remove(test5));

        // bst tree 4
        BinarySearchTree<Integer, String> tree4 =
            new BinarySearchTree<Integer, String>(true);

        // kv test 4
        KVPair<Integer, String> test6 = new KVPair<>(0, null);
        tree4.insert(test6);
    }


    /**
     * tests simple remove for bst when there is bst
     */
    public void testRemoveForTwoChildren() {

        tree1 = new BinarySearchTree<>(true); // allows duplicates

        kvTest1 = new KVPair<>(50, "Fifty"); // kv test 1
        kvTest2 = new KVPair<>(30, "Thirty"); // kv test2
        kvTest3 = new KVPair<>(70, "Seventy"); // kv test3
        kvTest4 = new KVPair<>(20, "Twenty"); // kv test 3
        kvTest5 = new KVPair<>(40, "Forty"); // kv test 5
        kvTest6 = new KVPair<>(60, "Sixty"); // kv test6
        kvTest7 = new KVPair<>(80, "Eighty"); // kv test7

        tree1.insert(kvTest1);
        tree1.insert(kvTest2);
        tree1.insert(kvTest3);
        tree1.insert(kvTest4);
        tree1.insert(kvTest5);
        tree1.insert(kvTest6);
        tree1.insert(kvTest7);

        assertTrue(tree1.remove(kvTest7));
        assertTrue(tree1.remove(kvTest4));
        assertTrue(tree1.remove(kvTest3));
        assertTrue(tree1.remove(kvTest1));
        assertTrue(tree1.remove(kvTest6));
        assertTrue(tree1.remove(kvTest5));
        assertTrue(tree1.remove(kvTest2));
    }


    /**
     * tests simple print for bst
     */
    public void testPrint() {
        // bst tree
        tree1 = new BinarySearchTree<>(true);
        // kv test
        kvTest4 = new KVPair<>(3, "hello");
        // kv test
        kvTest5 = new KVPair<>(10, "bye");
        // kv test
        kvTest6 = new KVPair<>(2, "hello");
        // kv test
        kvTest7 = new KVPair<>(9, "hello");

        tree1.insert(kvTest6);
        tree1.insert(kvTest5);
        tree1.insert(kvTest4);

        tree1.print();

    }

}



