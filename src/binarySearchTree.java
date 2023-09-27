
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
        KVPair<K, E> temp = findHelp(root, kvPair.key());
        if (temp != null) {
            root = removeHelp(root, kvPair);
            nodeCount--;
            return true;
        }
        else {
            return false;
        }
    }


    private BSTNode<KVPair<K, E>> removeHelp(
        BSTNode<KVPair<K, E>> curr,
        KVPair<K, E> kvPair) {// dsa returns node, good
// if (curr == null) {
// return null;
// }
        if (curr.getValueElement().key().compareTo(kvPair.key()) > 0) {
            curr.setLeft(removeHelp(curr.getLeft(), kvPair));
        }
        else if (curr.getValueElement().key().compareTo(kvPair.key()) < 0) {
            curr.setRight(removeHelp(curr.getRight(), kvPair));
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


    public void printID() {// need to take in depth to
        // figure out the spaces, need for loops
        //
        printIDHelper(root, 0);
    }


    public void printCost() {// need to take in depth to
        // figure out the spaces, need for loops
        //
        printCostHelper(root, 0);
    }


    private void printIDHelper(BSTNode<KVPair<K, E>> curr, int depth) {
        if (curr == null) {
            for (int i = 0; i < depth; i++) {
                System.out.print("  ");
            }
            System.out.println("null");
            return;
        }
        printIDHelper(curr.getRight(), depth + 1); // print the right side of
                                                   // the tree

        for (int i = 0; i < depth; i++) {
            System.out.print("  ");
        }
        System.out.println(curr.getValueElement().key() + " "); // visit the
        // current node
        printIDHelper(curr.getLeft(), depth + 1); // print the right side of the
                                                  // tree
    }


    private void printCostHelper(BSTNode<KVPair<K, E>> curr, int depth) {
        if (curr == null) {
            for (int i = 0; i < depth * 2; i++) {
                System.out.print("  ");
            }
            System.out.println("null");
            return;
        }
        printCostHelper(curr.getRight(), depth + 1); // print the right side of
                                                     // the tree

        for (int i = 0; i < depth * 2; i++) {
            System.out.print("  ");
        }
        System.out.println(curr.getValueElement().key() + " "); // visit the
        // current node
        printCostHelper(curr.getLeft(), depth + 1); // print the right side of
                                                    // the
                                                    // tree
    }


    private void visitID(BSTNode<KVPair<K, E>> curr) {
        // how do i actually get the format for printing
        System.out.println(curr.getValueElement().key() + " ");
    }


    private void searchRange() {

    }

}