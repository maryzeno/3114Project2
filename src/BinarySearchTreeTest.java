import student.TestCase;

public class BinarySearchTreeTest extends TestCase {
    BinarySearchTree<Integer, String> tree1;
    BinarySearchTree<Integer, String> tree2;
    BinarySearchTree<Integer, String> tree3;
    KVPair<Integer, String> kvTest1;
    KVPair<Integer, String> kvTest2;
    KVPair<Integer, String> kvTest3;
    KVPair<Integer, String> kvTest4;
    KVPair<Integer, String> kvTest5;
    KVPair<Integer, String> kvTest6;
    KVPair<Integer, String> kvTest7;

    public void setUp() {

    }


    public void testInsert() {

        tree1 = new BinarySearchTree<>(true); // allows duplicates
        tree2 = new BinarySearchTree<>(false); // doesn't allow dupes

        kvTest1 = new KVPair<>(2, "hello");
        kvTest2 = new KVPair<>(3, "hello");
        kvTest3 = new KVPair<>(1, "hello");

        assertTrue(tree1.insert(kvTest1));
        assertTrue(tree1.insert(kvTest1));
        assertTrue(tree1.insert(kvTest2));
        assertTrue(tree1.insert(kvTest3));
        tree2.insert(kvTest1);
        assertFalse(tree2.insert(kvTest1));

        KVPair<Integer, String> test = new KVPair<>(1, null);
        tree2.insert(test);
        assertFalse(tree2.insert(kvTest1));

    }


    public void testRemove() {

        tree1 = new BinarySearchTree<>(true); // allows duplicates
        tree2 = new BinarySearchTree<>(false); // doesn't allow dupes

        kvTest1 = new KVPair<>(2, "hello");
        kvTest2 = new KVPair<>(3, "hello");
        kvTest3 = new KVPair<>(1, "hello");

        tree1.insert(kvTest3);
        tree1.insert(kvTest3);

        tree1.insert(kvTest2);
        assertTrue(tree1.remove(kvTest3));
        assertTrue(tree1.remove(kvTest3));

        tree1.insert(kvTest1);
        assertTrue(tree1.remove(kvTest2));

        KVPair<Integer, String> test2 = new KVPair<>(4, "bye");
        tree1.insert(test2);
        assertTrue(tree1.remove(test2));

        tree3 = new BinarySearchTree<>(true);
        KVPair<Integer, String> test3 = new KVPair<>(3, "bye");
        tree3.insert(test3);
        assertTrue(tree3.remove(test3));

        KVPair<Integer, String> test5 = new KVPair<>(4, "bye");
        assertFalse(tree1.remove(test5));

        BinarySearchTree<Integer, String> tree4 =
            new BinarySearchTree<Integer, String>(true);

        // testing first branch that's not tested
        KVPair<Integer, String> test6 = new KVPair<>(0, null);
        tree4.insert(test6);
    }


    public void testRemoveForTwoChildren() {

        tree1 = new BinarySearchTree<>(true); // allows duplicates

        kvTest1 = new KVPair<>(50, "Fifty");//
        kvTest2 = new KVPair<>(30, "Thirty");
        kvTest3 = new KVPair<>(70, "Seventy"); //
        kvTest4 = new KVPair<>(20, "Twenty"); //
        kvTest5 = new KVPair<>(40, "Forty");
        kvTest6 = new KVPair<>(60, "Sixty");
        kvTest7 = new KVPair<>(80, "Eighty"); //

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


    public void testPrint() {
        tree1 = new BinarySearchTree<>(true);
        kvTest4 = new KVPair<>(3, "hello");
        kvTest5 = new KVPair<>(10, "bye");
        kvTest6 = new KVPair<>(2, "hello");
        kvTest7 = new KVPair<>(9, "hello");

        tree1.insert(kvTest6);
        tree1.insert(kvTest5);
        tree1.insert(kvTest4);

// tree1.insert(kvTest7);

        tree1.print();
// assertTrue(tree1.print());
// tree1.printCost();

    }


    public void testSearchCostHelper() {
        BinarySearchTree<Integer, Seminar> tree3;
        KVPair<Integer, Seminar> kvTest9;
        KVPair<Integer, Seminar> kvTest10;
        KVPair<Integer, Seminar> kvTest11;
        KVPair<Integer, Seminar> kvTest12;
        String[] keywords = { "Good", "Bad", "Ugly" };
        Seminar mysem = new Seminar(1729, "Seminar Title", "04042003", 75,
            (short)15, (short)33, 125, keywords, "This is a great seminar");
        Seminar mysem1 = new Seminar(1729, "Seminar Title", "04042003", 75,
            (short)15, (short)33, 12, keywords, "This is a great seminar");
        Seminar mysem2 = new Seminar(1729, "Seminar Title", "04042003", 75,
            (short)15, (short)33, 28237, keywords, "This is a great seminar");
        Seminar mysem3 = new Seminar(1729, "Seminar Title", "04042003", 75,
            (short)15, (short)33, -1, keywords, "This is a great seminar");
        tree3 = new BinarySearchTree<>(true);

        kvTest9 = new KVPair<>(1, mysem);
        kvTest10 = new KVPair<>(1, mysem1);
        kvTest11 = new KVPair<>(1, mysem2);
        kvTest12 = new KVPair<>(1, mysem3);

        tree3.insert(kvTest9);
        tree3.insert(kvTest10);
        tree3.insert(kvTest11);
        tree3.insert(kvTest12);
        tree3.searchCost(1, 125);

    }

// public void testSearchDateHelper() {
// BinarySearchTree<Integer, Seminar> tree3;
// KVPair<Integer, Seminar> kvTest9;
// String[] keywords = { "Good", "Bad", "Ugly" };
//
// Seminar mysem = new Seminar(1729, "Seminar Title", "04042003", 75,
// (short)15, (short)33, 125, keywords, "This is a great seminar");
// tree3 = new BinarySearchTree<>(true);
// kvTest9 = new KVPair<>(1, mysem);
// tree3.insert(kvTest9);
// tree3.searchDate(1, 4042003);
// tree3.searchDate(1, -4042003);
// tree3.searchDate(404200311, 88);
// }

}



