
/**
 * bin node class for internal node bin tree test
 *
 *             
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
     * inserts into bin tree
     */
    public BinNode insert(Seminar seminar, int xCoord, int yCoord, int xWidth, int yWidth, int depth) {
        //check to see if we can split
        //split function: just make sure the seminar is within the bounds
        // insert % 2  == 0 for left and right side
        // insert should check if the node should go on the left or on the right hand side.
        //check to see if left and right nodes are interanl or leaf or empty 
        // 
        if(depth % 2 == 0) {
            if(isIntersecting(seminar, seminar.x(), seminar.y(), xWidth, yWidth, depth)) { //either xWidth or yWidth divide by 2
                insert(seminar, seminar.x(), seminar.y(), xWidth, yWidth, depth);
            }
            else {
            }
        }
        else {
            if(isIntersecting(seminar, seminar.x(), seminar.y(), xWidth, yWidth, depth)) { //either xWidth or yWidth divide by 2
                insert(seminar, seminar.x(), seminar.y(), xWidth, yWidth, depth);
            }
            else {
            }
        }
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
    public boolean isIntersecting(Seminar seminar, int xCoord, int yCoord, int xWidth, int yWidth, int depth) {
        return false;
    }


    /**
     * prints the node
     */
    @Override
    public void print() {

    } 
      
}



