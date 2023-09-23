import student.TestCase;

public class BinarySearchTreeTest extends TestCase {
    BinarySearchTree<Integer, String> tree1;
    BinarySearchTree<Integer, String> tree2;
    KVPair<Integer, String> rootOfTree1;
    KVPair<Integer, String> rootOfTree2;
    KVPair<Integer, String> rootOfTree3;

    public void setUp() {
        tree1 = new BinarySearchTree<>(true); // allows duplicates
        tree2 = new BinarySearchTree<>(false); // doesn't allow dupes

        rootOfTree1 = new KVPair<>(2, "hello");
        rootOfTree2 = new KVPair<>(3, "hello");
        rootOfTree3 = new KVPair<>(1, "hello");

        assertTrue(tree1.insert(rootOfTree1));
        assertTrue(tree1.insert(rootOfTree1));
        assertTrue(tree1.insert(rootOfTree2));
        assertTrue(tree1.insert(rootOfTree3));

    }


    public void testInsert() {
        KVPair<Integer, String> test = new KVPair<>(2, "bye");
        KVPair<Integer, String> testNull = new KVPair<>(0, null);
        assertTrue(tree2.insert(test));
        assertFalse(tree2.insert(test));
        assertTrue(tree2.insert(testNull));

    }


    public void testIsEmpty() {

    }


    public void testFind() {

    }


    public void testRemove() {
        KVPair<Integer, String> test = new KVPair<>(5, "bye");
        assertFalse(tree1.remove(test));

        KVPair<Integer, String> test1 = new KVPair<>(2, "bye");
        assertFalse(tree1.remove(test1));

         tree1.insert(rootOfTree2);
         
         System.out.println(tree1.nodeCount);

        assertTrue(tree1.remove(rootOfTree3));
//        assertTrue(tree1.remove(rootOfTree2));
//        assertTrue(tree1.remove(rootOfTree1));

    }

}


