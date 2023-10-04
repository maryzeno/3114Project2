
public class BinTree {
    private BinNode root;
    private int worldSize;
    private BinNode flyWeight;
    
    public BinTree(int worldSize) {
        this.worldSize = worldSize;
        flyWeight = BinNodeEmpty.getInstanceOf();
        root = flyWeight;
    }

    public void insert(Seminar seminar) {
        root = root.insert(seminar, 0, 0, worldSize - 1, worldSize - 1, 0);
//            insert(Seminar it)
//            {
//                root.inert(it, 0, 0, size, size, 0); //seminar, x, y, xwidth, ywidth, depth 
//            }
    }

    /**
     * checks if leaf is empty
     * 
     * @return boolean true if leaf is empty
     */
    public void isEmpty() {
    }


    /**
     * checks if its a leaf
     * 
     * @return boolean true if its a leaf
     */
    public void isLeaf() {
    }

    /**
     * deletes the node from the tree
     * 
     * @return boolean true if it deletes
     */
    public void delete() {
    }


    /**
     * checks if its intersecting
     * 
     * @return boolean true if intersects
     */
    public void isIntersecting() {
    }


    /**
     * prints the node
     */
    public void print() {

    }
    
    public void merge() {

    }


    public void split() {

    }


    public void distance() {

    }

}
