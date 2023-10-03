/**
 * Bin node empty class used for bin tree
 *
 * @author Hafsa Khan (hfsakhn)
 * @author Mary Zeno (maryzeno)
 * @version 10/2/2023
 */
public class BinNodeEmpty implements BinNode {
    private BinNodeEmpty binNodeEmpty; // empty node
    private BinNodeEmpty getInstance; // instance of bin node empty
    /**
     * this is the flyweight
     */
    static public BinNodeEmpty flyweight = null; // fly weight

    /**
     * constructor of bin node empty
     */
    private BinNodeEmpty() {

    }


    /**
     * checks if bin node is empty
     */
    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }


    /**
     * checks if the node is a leaf
     */
    @Override
    public boolean isLeaf() {
        // TODO Auto-generated method stub
        return false;
    }


    /**
     * inserts into bin tree
     */
    @Override
    public boolean insert() {
        // TODO Auto-generated method stub
        return false;
    }


    /**
     * deletes node from bin tree
     */
    @Override
    public boolean delete() {
        // TODO Auto-generated method stub
        return false;
    }


    /**
     * checks if bin node is intersecting
     */
    @Override
    public boolean isIntersecting() {
        // TODO Auto-generated method stub
        return false;
    }


    /**
     * prints the bin node
     */
    @Override
    public void print() {
        // TODO Auto-generated method stub

    }

}



