import student.TestCase;

/**
 * bst node test class
 *
 * @author Hafsa Khan (hfsakhn)
 * @author Mary Zeno (maryzeno)
 * @version 10/02/2023
 */
public class BSTNodeTest extends TestCase {
    // node for tests
    private BSTNode<Integer> node;

    /**
     * this is the setUp. it helps the rest of the methods have
     * a node to test.
     */
    public void setUp() {
        node = new BSTNode<Integer>(0); // node for test

    }


    /**
     * test setter for element value
     */
    public void testSetValueElement() {
        node.setValueElement(9);
        BSTNode<Integer> node1 = new BSTNode<Integer>(0);
        assertTrue(node.getValueElement().equals(9));
    }


    /**
     * test setter for left
     */
    public void testSetLeft() {
        BSTNode<Integer> node1 = new BSTNode<Integer>(0);
        node1.setLeft(node);
        assertTrue(node1.getLeft().equals(node));
    }


    /**
     * test setter for right
     */
    public void testSetRight() {
        BSTNode<Integer> node1 = new BSTNode<Integer>(0);
        node1.setRight(node);
        assertTrue(node1.getRight().equals(node));
    }

}



