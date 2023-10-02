
public class BinarySearchTree<K extends Comparable<K>, E> {

    private BSTNode<KVPair<K, E>> root;
    private int nodeCount;
    private boolean dupAllowed;
    // private Comparable k;

    BinarySearchTree(boolean dupAllowed) {
        root = null;
        nodeCount = 0;
        this.dupAllowed = dupAllowed;
    }


    public int getNodeCount() {
        return nodeCount;
    }


    public boolean insert(KVPair<K, E> kvPair) { // dsa returns void, good
        // if empty makes element root
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


    private BSTNode<KVPair<K, E>> insertHelp(
        BSTNode<KVPair<K, E>> curr,
        KVPair<K, E> kvPairParam) {// dsa returns node,good
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


    public boolean isEmpty() {
        return (root == null);
    }


    public KVPair<K, E> find(K key) { // dsa returns key, good
        return findHelp(root, key);
    }


    private KVPair<K, E> findHelp(BSTNode<KVPair<K, E>> curr, K key) { // dsa
        // returns
        // key,
        // good
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


    public boolean remove(KVPair<K, E> kvPair) { // dsa returns key, good
        K key = kvPair.key();
        KVPair<K, E> temp = findHelp(root, key);
        if (temp != null) {
            root = removeHelp(root, key);
            nodeCount--;
            return true;
        }
        else {
            return false;
        }
    }


    private BSTNode<KVPair<K, E>> removeHelp(
        BSTNode<KVPair<K, E>> curr,
        K key) {// dsa returns node, good
// if (curr == null) {
// return null;
// }
        if (curr.getValueElement().key().compareTo(key) > 0) {
            curr.setLeft(removeHelp(curr.getLeft(), key));
        }
        else if (curr.getValueElement().key().compareTo(key) < 0) {
            curr.setRight(removeHelp(curr.getRight(), key));
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


    private BSTNode<KVPair<K, E>> getMax(BSTNode<KVPair<K, E>> curr) {
        if (curr.getRight() == null) {
            return curr;
        }
        return getMax(curr.getRight());
    }


    private BSTNode<KVPair<K, E>> deleteMax(BSTNode<KVPair<K, E>> curr) {
        if (curr.getRight() == null) {
            return curr.getLeft();
        }
        curr.setRight(deleteMax(curr.getRight()));
        return curr;
    }


    public void print() {
        printHelper(root, 0);
    }


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


    public void searchID(K key) { // dsa returns key, good
        searchIDHelper(root, key);
    }


    private void searchIDHelper(BSTNode<KVPair<K, E>> curr, K key) { // dsa
        // returns
        // key,
        // good
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


    // done, just need to figure out how to get sem date
    public void searchDate(String dateA, String dateB) {
        int date1 = Integer.parseInt(dateA);
        int date2 = Integer.parseInt(dateB);

        System.out.println("Seminars with dates in range " + dateA + " to "
            + dateB + ":");
        int nodeCount = searchDateHelper(root, date1, date2);
        System.out.println(nodeCount + " nodes visited in this search");
        // ^this is wrong
    }


    private int searchDateHelper(
        BSTNode<KVPair<K, E>> curr,
        int dateA,
        int dateB) {
        if (curr == null) {
            return 0;
        }

        KVPair<K, E> seminar = curr.getValueElement();
        String seminarDateStr = ((Seminar)seminar.value()).date();
        int nodeCount = 0;
        int seminarDate = Integer.parseInt(seminarDateStr);
        if (seminarDate >= dateA && seminarDate <= dateB) {
            System.out.println(curr.getValueElement().value().toString());
        }

        if (seminarDate >= dateA) { // search left for <
            nodeCount += searchDateHelper(curr.getLeft(), dateA, dateB);
        }

        if (seminarDate <= dateB) { // search right for >
            nodeCount += searchDateHelper(curr.getRight(), dateA, dateB);
        }
        return nodeCount + 1;

    }


    // done j need to figure out how to get sem cost
    public void searchCost(int costA, int costB) {
        System.out.println("Seminars with costs in range " + costA + " to "
            + costB + ":");
        int nodeCount = searchCostHelper(root, costA, costB);
        searchCostHelper(root, costA, costB);
        System.out.println(nodeCount + " nodes visited in this search");

    }


    private int searchCostHelper(
        BSTNode<KVPair<K, E>> curr,
        int costA,
        int costB) {
        if (curr == null) {
            return 0;
        }

        KVPair<K, E> seminar = curr.getValueElement();
        int seminarCost = (int)(((Seminar)seminar.value()).cost());
        int nodeCount = 0;

        if (seminarCost >= costA && seminarCost <= costB) {
            System.out.println(seminar.value()); // should i use toString
        }

        if (seminarCost >= costA) { // search left for >
            nodeCount += searchCostHelper(curr.getLeft(), costA, costB);
        }

        if (seminarCost <= costB) { // search right for <
            nodeCount += searchCostHelper(curr.getRight(), costA, costB);
        }
        return nodeCount + 1;
    }

//
// public void searchID(int id) {
// searchIDHelper(root, id);
// }
//
//
// public void searchIDHelper(BSTNode<KVPair<K, E>> curr, int id) {
// if (curr == null) {
// System.out.println("Search FAILED -- There is no record with ID "
// + id);
// return;
// }
//
// }


    // still need to implement
    public void searchKeyword(String keyword) {
        System.out.println("Seminars matching keyword " + keyword + ":");
        rangeHelper(root, keyword, keyword);

    }


    private void searchKeyWordHelper(
        BSTNode<KVPair<K, E>> curr,
        String keyword) {

        if (curr == null) {
            return;
        }
        
        if (curr.getValueElement().key().compareTo((K)keyword) > 0) {
            searchKeyWordHelper(curr.getLeft(), keyword);
        }
        else if (curr.getValueElement().key().compareTo((K)keyword) == 0) {
            System.out.println(curr.getValueElement().value().toString());
        }
        else {
            searchKeyWordHelper(curr.getRight(), keyword);
        }
    }
    
    public int rangeHelper(BSTNode<KVPair<K, E>> curr, K low, K high)
    {
        int numRecord = 1;
        if (curr == null)
        {
            return 1;
        }
        if (curr.getValueElement().key().compareTo((K)low) < 0)
        {
            numRecord += rangeHelper(curr.getRight(), low, high);
             
            
        }
        else if (curr.getValueElement().key().compareTo(low) >0)
            {
                numRecord += rangeHelper(curr.getLeft(), low, high);
                
                
            }
        else
        {
            System.out.print(curr.getValueElement().key());
            numRecord += rangeHelper(curr.getRight(), low, high);
            if (curr.getValueElement().key().compareTo(high) == 0) {
                numRecord += rangeHelper(curr.getLeft(), low, high);              
         
            }
        }
        return numRecord;
    }
}



 