
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
        else if (!dupAllowed) {
            if (find(kvPair) != null) {
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
        if (curr.getValueElement().key().compareTo(kvPairParam.key()) >= 0) {
            root.setLeft(insertHelp(curr.getLeft(), kvPairParam));
        }
        else {
            root.setRight(insertHelp(curr.getRight(), kvPairParam));
        }
        return root;
    }


    private boolean isEmpty() {
        return (root == null);
    }


    public K find(KVPair<K, E> kvPair) { // dsa returns key, good
        return findHelp(root, kvPair);
    }


    private K findHelp(BSTNode<KVPair<K, E>> curr, KVPair<K, E> kvPairParam) { // dsa
                                                                               // returns
                                                                               // key,
                                                                               // good
        if (curr == null) {
            return null;
        }
        if (curr.getValueElement().key().compareTo(kvPairParam.key()) > 0) {
            return findHelp(curr.getLeft(), kvPairParam);
        }
        else if (curr.getValueElement().key().compareTo(kvPairParam.key()) == 0
            && curr.getValueElement() == kvPairParam) {
            return curr.getValueElement().key();
        }
        else {
            return findHelp(curr.getRight(), kvPairParam);
        }
    }


    public boolean remove(KVPair<K, E> kvPair) { // dsa returns key, good
        K temp = findHelp(root, kvPair);
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
        KVPair<K, E> kvPairParam) {// dsa returns node, good
        if (curr == null) {
            return null;
        }
        if (curr.getValueElement().key().compareTo(kvPairParam.key()) > 0) {
            curr.setLeft(removeHelp(curr.getLeft(), kvPairParam));
        }
        else if (curr.getValueElement().key().compareTo(kvPairParam
            .key()) < 0) {
            curr.setRight(removeHelp(curr.getRight(), kvPairParam));
        }
        else { // found it
            if (curr.getLeft() == null) {
                return curr.getRight();
            }
            else if (curr.getRight() == null) {
                return curr.getLeft();
            }
            else { // 2 children
                BSTNode<KVPair<K, E>> temp = getMax(curr.getLeft());
                curr.setValueElement(temp.getValueElement());
                curr.setLeft(deleteMax(curr.getLeft()));
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

    }
}


