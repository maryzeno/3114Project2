/**
 * 
 * bin node leaf class
 *
 * @author Hafsa Khan (hfsakhn)
 * @author Mary Zeno (maryzeno)
 * @version 10/2/2023
 *
 * @param <E>
 *            is the element
 */
public class BinNodeLeaf<E> implements BinNode {
    // private DLList list;
    private int numCount; // count for leaf
    private E element; // element of leaf
    private SinglyLinkedList<Seminar> list;

    /**
     * constructor for leaf
     * 
     * @param element
     *            in the node
     */
    public BinNodeLeaf(E element) {
        this.element = element;
    }


    /**
     * checks if leaf is empty
     * 
     * @return boolean true if leaf is empty
     */
    @Override
    public boolean isEmpty() {
        return false;
    }


    /**
     * checks if its a leaf
     * 
     * @return boolean true if its a leaf
     */
    @Override
    public boolean isLeaf() {
        return true;
    }


    /**
     * inserts into bin tree
     */
    @Override
    public BinNode insert() {
        // TODO Auto-generated method stub
        return null;
    }


    /**
     * deletes the node from the tree
     * 
     * @return boolean true if it deletes
     */
    @Override
    public boolean delete() {
        // TODO Auto-generated method stub
        return false;
    }


    /**
     * checks if its intersecting
     * 
     * @return boolean true if intersects
     */
    @Override
    public boolean isIntersecting() {
        // TODO Auto-generated method stub
        return false;
    }


    /**
     * prints the node
     */
    @Override
    public void print() {
        // TODO Auto-generated method stub

    }

}