/**
 * This is the binary search tree class.
 * all the seminars are stored in here
 *
 * @author Hafsa Khan (hfsakhn)
 * @author Mary Zeno (maryzeno)
 * @version 10/02/2023
 *
 * @param <K>
 *            is the key
 * @param <E>
 *            is the element
 */
public class BinarySearchTree<K extends Comparable<K>, E> {
    private BSTNode<KVPair<K, E>> root;
    private int nodeCount;
    private boolean dupAllowed;
    // private Comparable k;
    
    /**
     * This is the constructor, it sets up the tree
     * for the rest of the class
     * 
     * @param dupAllowed
     *            is the boolean
     */
    BinarySearchTree(boolean dupAllowed) {
        root = null;
        nodeCount = 0;
        this.dupAllowed = dupAllowed;

    }

    /**
     * This method lets you get the nodeCount
     * 
     * @return returns the int
     */
    public int getNodeCount() {
        return nodeCount;
    }

    /**
     * this method inserts seminars into the bst
     * 
     * @param kvPair
     *            the kvPair to be inserted
     * @return returns true if inserted
     */
    public boolean insert(KVPair<K, E> kvPair) { // dsa returns void, good
        if (isEmpty()) {
            root = new BSTNode<KVPair<K, E>>(kvPair);
            nodeCount++;
            return true;
        }

        if (!dupAllowed) {
            if (find(kvPair.key()) != null) {
                return false;
            }
        }

        root = insertHelp(root, kvPair);
        nodeCount++;
        return true;

    }

    /**
     * this is a helper method for the insert method
     * 
     * @param curr
     *            the node
     * @param kvPairParam
     *            the kvPair
     * @return returns the node
     */
    private BSTNode<KVPair<K, E>> insertHelp(
        BSTNode<KVPair<K, E>> curr,
        KVPair<K, E> kvPairParam) { // dsa returns node,good
        if (curr == null) {
            return new BSTNode<KVPair<K, E>>(kvPairParam);
        }

        if (curr.getValueElement().compareTo(kvPairParam) >= 0) {
            curr.setLeft(insertHelp(curr.getLeft(), kvPairParam));
        }

        else {
            curr.setRight(insertHelp(curr.getRight(), kvPairParam));
        }

        return curr;
    }

    /**
     * this method checks if the root is null
     * 
     * @return true if null
     */
    public boolean isEmpty() {
        return (root == null);
    }

    /**
     * this method finds the seminar in the bst
     * 
     * @param key
     *            is the key to be found
     * @return returns true if found
     */
    public KVPair<K, E> find(K key) {
        return findHelp(root, key);
    }

    /**
     * this is a helper method for the find method
     * 
     * @param curr
     *            is the node
     * @param key
     *            is the key to be found
     * @return returns the node
     */
    private KVPair<K, E> findHelp(BSTNode<KVPair<K, E>> curr, K key) { // dsa
        if (curr == null) {
            return null;
        }
        
        if (curr.getValueElement().key().compareTo(key) > 0) {
            return findHelp(curr.getLeft(), key);
        }

        else if (curr.getValueElement().key().compareTo(key) == 0) {
            return curr.getValueElement();
        }

        else {
            return findHelp(curr.getRight(), key);
        }
    }


    /**
     * this is the remove method. it removes the seminar from
     * the bst.
     * 
     * @param kvPair
     *            is the node to be removed
     * @return returns true if removed
     */
    public boolean remove(KVPair<K, E> kvPair) { // dsa returns key, good
        K key = kvPair.key();
        KVPair<K, E> temp = findHelp(root, key);
        if (temp != null) {
            root = removeHelp(root, kvPair);
            nodeCount--;
            return true;
        }

        else {
            return false;
        }
    }

    /**
     * this is the remove helper method.
     * 
     * @param curr
     *            the node to be removed
     * @param key
     *            the key to be removed
     * @return returns the node
     */
    private BSTNode<KVPair<K, E>> removeHelp(
        BSTNode<KVPair<K, E>> curr,
        KVPair<K, E> kvPair) {
        K key = kvPair.key();
        if (curr.getValueElement().key().compareTo(key) > 0) {
            curr.setLeft(removeHelp(curr.getLeft(), kvPair));
        }

        else if (curr.getValueElement().key().compareTo(key) < 0) {
            curr.setRight(removeHelp(curr.getRight(), kvPair));
        }
        else if (curr.getValueElement().value() != kvPair.value()) {
            curr.setLeft(removeHelp(curr.getLeft(), kvPair));
        }
        else { // found it
            if (curr.getRight() != null) {
                if (curr.getLeft() == null) {
                    return curr.getRight();
                }

                else {// 2 children
                    BSTNode<KVPair<K, E>> temp = getMax(curr.getLeft());
                    curr.setValueElement(temp.getValueElement());
                    curr.setLeft(deleteMax(curr.getLeft()));
                }
            }

            else {
                return curr.getLeft();
            }
        }
        
        return curr;
    }

    /**
     * this is the getMax method. it returns the max node
     * 
     * @param curr
     *            the node
     * @return returns the max node
     */
    private BSTNode<KVPair<K, E>> getMax(BSTNode<KVPair<K, E>> curr) {
        if (curr.getRight() == null) {
            return curr;
        }

        return getMax(curr.getRight());
    }

    /**
     * this is the deleteMax method. it deletes the max node
     * 
     * @param curr
     *            is the node
     * @return returns the node
     */
    private BSTNode<KVPair<K, E>> deleteMax(BSTNode<KVPair<K, E>> curr) {
        if (curr.getRight() == null) {
            return curr.getLeft();
        }

        curr.setRight(deleteMax(curr.getRight()));
        return curr;
    }

    /**
     * this is the print method. it prints the bst.
     */
    public void print() {
        if (root == null) {
            System.out.println("This tree is empty");
        }

        else {
            printHelper(root, 0);
        }
    }

    /**
     * this is the print helper method. it helps print the bst.
     * 
     * @param curr
     *            is the node
     * @param depth
     *            is the dept
     */
    private void printHelper(BSTNode<KVPair<K, E>> curr, int depth) {
        if (curr == null) {
            for (int i = 0; i < depth * 2; i++) {
                System.out.print(" ");
            }

            System.out.println("null");
            return;
        }

        printHelper(curr.getRight(), depth + 1);
        for (int i = 0; i < depth * 2; i++) {
            System.out.print(" ");
        }
        
        System.out.println(curr.getValueElement().key()); // visit the
        // current node
        printHelper(curr.getLeft(), depth + 1); // print the right side of the
        // tree
    }

    /**
     * this method searches for the ID.
     * 
     * @param key
     *            the key to be searched for
     */
    public void searchID(K key) {
        searchIDHelper(root, key);
    }

    /**
     * this is the searchIDHelper method. it helps find the id
     * in the bst.
     * 
     * @param curr
     *            this is the current node
     * @param key
     *            this is the key to be found
     */
    private void searchIDHelper(BSTNode<KVPair<K, E>> curr, K key) {
        if (curr == null) {
            System.out.println("Search FAILED -- There is no record with ID "
                + key);
            return;
        }

        if (curr.getValueElement().key().compareTo(key) > 0) {
            searchIDHelper(curr.getLeft(), key);
        }

        else if (curr.getValueElement().key().compareTo(key) == 0) {
            System.out.println("Found record with ID " + key + ":");
            System.out.println(curr.getValueElement().value().toString());
        }

        else {
            searchIDHelper(curr.getRight(), key);
        }
    }

    /**
     * this is the searchDate method. it helps search for the date.
     * 
     * @param dateA
     *            is the lower date
     * @param dateB
     *            is the higher date
     */
    public void searchDate(K dateA, K dateB) {
        System.out.println("Seminars with dates in range " + dateA + " to "
            + dateB + ":");
        int nodeC = rangeHelper(root, dateA, dateB);
        System.out.println(nodeC + " nodes visited in this search");
    }

    /**
     * this is the search cost method. it searches the bst
     * for the cost
     * 
     * @param costA
     *            is the lower cost
     * @param costB
     *            is the higher cost
     */
    public void searchCost(K costA, K costB) {
        System.out.println("Seminars with costs in range " + costA + " to "
            + costB + ":");
        int nodeC = rangeHelper(root, costA, costB);
        System.out.println(nodeC + " nodes visited in this search");
    }

    /**
     * this is the search keyword method. it searches
     * the bst for the keyword specified
     * 
     * @param keyword
     *            is the keyword to searched for
     */
    public void searchKeyword(K keyword) {
        System.out.println("Seminars matching keyword " + keyword + ":");
        rangeHelper(root, keyword, keyword);
    }

    /**
     * This is the ranger helper method. the other search methods
     * use this as a helper method.
     * 
     * @param curr
     *            is the node
     * @param low
     *            is the lower bound
     * @param high
     *            is the higher bound
     * @return returns an int
     */
    public int rangeHelper(BSTNode<KVPair<K, E>> curr, K low, K high) {
        int numRecord = 1;
        if (curr == null) {
            return 1;
        }

        if (curr.getValueElement().key().compareTo(low) < 0) {
            numRecord += rangeHelper(curr.getRight(), low, high);
        }

        else if (curr.getValueElement().key().compareTo(high) > 0) {
            numRecord += rangeHelper(curr.getLeft(), low, high);
        }

        else {
            numRecord += rangeHelper(curr.getLeft(), low, high);
            System.out.println(curr.getValueElement().value().toString());
            if (curr.getValueElement().key().compareTo(high) != 0) {
                numRecord += rangeHelper(curr.getRight(), low, high);
            }
        }
        
        return numRecord;
    }
}