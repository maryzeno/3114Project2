
/**
 * bin node class for internal node bin tree test
 *
 * @author Hafsa Khan (hfsakhn)
 * @author Mary Zeno (maryzeno)
 * @version 09/13/2023
 */
public class BinNodeInternal implements BinNode {
    private BinNode first; // first bin node
    private BinNode second; // second bin node

    /**
     * constructor for bin tree
     * 
     * @param first
     *            the first of the bin node
     * @param second
     *            the second node of the bin node
     */
    public BinNodeInternal(BinNode first, BinNode second) {
        this.first = first;
        this.second = second;
    }


    /**
     * checks if bin node is empty
     * 
     * @return boolean if its a tree
     */
    @Override
    public boolean isEmpty() {
        return false;
    }


    /**
     * checks if bin node is a leaf
     * 
     * @return boolean if its a leaf
     */
    @Override
    public boolean isLeaf() {
        return false;
    }


    /**
     * inserts node into bin tree
     * 
     * @return boolean if it inserts
     */
    @Override
    public boolean insert() {
        return false;
    }


    /**
     * deletes the node
     * 
     * @return delete if its deleted
     */
    @Override
    public boolean delete() {
        return false;
    }


    /**
     * checks if its intersecting
     * 
     * @return boolean if intersecting then true
     */
    @Override
    public boolean isIntersecting() {
        return false;
    }


    /**
     * prints the node
     */
    @Override
    public void print() {

    }

}



