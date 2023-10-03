/**
 * This is the binNode interface class.
 *
 * @author Hafsa Khan (hfsakhn)
 * @author Mary Zeno (maryzeno)
 * @version 09/19/2023
 */
public interface BinNode {

    /**
     * this is the isempty method
     * 
     * @return returns a boolean
     */
    public boolean isEmpty();


    /**
     * this is the isleaf method
     * 
     * @return returns a boolean
     */
    public boolean isLeaf();


    /**
     * this is the insert method
     * 
     * @return returns a boolean
     */
    public boolean insert();


    /**
     * this is the delete method
     * 
     * @return returns a boolean
     */
    public boolean delete();


    /**
     * this is the isInteresting method
     * 
     * @return returns a boolean
     */
    public boolean isIntersecting();


    /**
     * this is the print method
     * 
     */
    public void print();
}


