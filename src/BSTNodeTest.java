import student.TestCase;

public class BSTNodeTest extends TestCase {
    BSTNode<Integer> node;

    public void setUp() {
        node = new BSTNode<Integer>(0);

    }


    public void testSetValueElement() {
        node.setValueElement(9);
        BSTNode<Integer> node1 = new BSTNode<Integer>(0);
        assertTrue(node.getValueElement().equals(9));
    }


    public void testSetLeft() {
        BSTNode<Integer> node1 = new BSTNode<Integer>(0);
        node1.setLeft(node);
        assertTrue(node1.getLeft().equals(node));
    }


    public void testSetRight() {
        BSTNode<Integer> node1 = new BSTNode<Integer>(0);
        node1.setRight(node);
        assertTrue(node1.getRight().equals(node));
    }

}


