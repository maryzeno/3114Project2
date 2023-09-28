
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


    private boolean isEmpty() {
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


//    public void printID() {
//        printIDHelper(root, 0);
//    }
//
//
//    private void printIDHelper(BSTNode<KVPair<K, E>> curr, int depth) {
//        if (curr == null) {
//            for (int i = 0; i < depth; i++) {
//                System.out.print("  ");
//            }
//            System.out.println("null");
//            return;
//        }
//        printIDHelper(curr.getRight(), depth + 1); // print the right side of
//                                                   // the tree
//
//        for (int i = 0; i < depth; i++) {
//            System.out.print("  ");
//        }
//        System.out.println(curr.getValueElement().key() + " "); // visit the
//        // current node
//        printIDHelper(curr.getLeft(), depth + 1); // print the right side of the
//                                                  // tree
//    }
//
//
//    public void printCost() {
//        printCostHelper(root, 0);
//    }
//
//
//    private void printCostHelper(BSTNode<KVPair<K, E>> curr, int depth) {
//        if (curr == null) {
//            for (int i = 0; i < depth * 2; i++) {
//                System.out.print("  ");
//            }
//            System.out.println("null");
//            return;
//        }
//        printCostHelper(curr.getRight(), depth + 1); // print the right side of
//                                                     // the tree
//
//        for (int i = 0; i < depth * 2; i++) {
//            System.out.print("  ");
//        }
//        System.out.println(curr.getValueElement().key() + " "); // visit the
//        // current node
//        printCostHelper(curr.getLeft(), depth + 1); // print the right side of
//                                                    // the
//                                                    // tree
//    }
//
//
//    public void printKeyword() {
//
//    }
//
//
//    public void printDate() {
//
//    }
//
//
//    // done, just need to figure out how to get sem date
//    public void searchDate(int dateA, int dateB) {
//        int nodeCount = searchDateHelper(root, dateA, dateB);
//        System.out.println("Seminars with dates in range " + dateA + " to "
//            + dateB + ":");
//        searchDateHelper(root, dateA, dateB);
//        System.out.println(nodeCount + " nodes visited in this search");
//
//    }
//
//
//    private int searchDateHelper(
//        BSTNode<KVPair<K, E>> curr,
//        int dateA,
//        int dateB) {
//        if (curr == null) {
//            return 0;
//        }
//
//        KVPair<K, E> seminar = curr.getValueElement();
//        String seminarDateStr = ((Seminar)seminar.value()).date();
//        int seminarDate = Integer.parseInt(seminarDateStr);
//        if (seminarDate >= dateA && seminarDate <= dateB) {
//            System.out.println(seminar.value()); // should i use toString
//        }
//
//        if (seminarDate >= dateA) { // search left for <
//            nodeCount += searchDateHelper(curr.getLeft(), dateA, dateB);
//        }
//
//        if (seminarDate <= dateB) { // search right for >
//            nodeCount += searchDateHelper(curr.getRight(), dateA, dateB);
//        }
//        return nodeCount + 1;
//
//    }
//
//
//    // done j need to figure out how to get sem cost
//    public void searchCost(int costA, int costB) {
//        int nodeCount = searchCostHelper(root, costA, costB);
//        System.out.println("Seminars with costs in range " + costA + " to "
//            + costB + ";");
//        searchCostHelper(root, costA, costB);
//        System.out.println(nodeCount + " nodes visited in this search");
//
//    }
//
//
//    private int searchCostHelper(
//        BSTNode<KVPair<K, E>> curr,
//        int costA,
//        int costB) {
//        if (curr == null) {
//            return 0;
//        }
//
//        KVPair<K, E> seminar = curr.getValueElement();
//        int seminarCost = (int)(((Seminar)seminar.value()).cost());
//        int nodeCount = 0;
//
//        if (seminarCost >= costA && seminarCost <= costB) {
//            System.out.println(seminar.value()); // should i use toString
//        }
//
//        if (seminarCost >= costA) { // search left for >
//            nodeCount += searchCostHelper(curr.getLeft(), costA, costB);
//        }
//
//        if (seminarCost <= costB) { // search right for <
//            nodeCount += searchCostHelper(curr.getRight(), costA, costB);
//        }
//        return nodeCount + 1;
//    }
//
//
//    // still need to implement
//    public void searchKeyWord(String keyword) {
//        StringBuilder string = new StringBuilder();
//        System.out.println("Seminars matching keyword " + keyword + ":");
//        searchKeyWordHelper(root, keyword);
//    }
//
//
//    private void searchKeyWordHelper(
//        BSTNode<KVPair<K, E>> curr,
//        String keyword) {
//        if (curr == null) {
//            return;
//
//        }
//
//        KVPair<K, E> seminar = curr.getValueElement();
//        Seminar seminarObject = (Seminar)seminar.value();
//        String[] seminarKeywords = seminarObject.keywords();
//
//        if (seminarKeywords != null && seminarKeywords.contains(keyword)) {
//            // Print the seminar information
//            System.out.println(seminarObject.toString());
//        }
//
//    }
}



