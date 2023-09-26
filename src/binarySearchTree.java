
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


    public K find(K key) { // dsa returns key, good
        return findHelp(root, key);
    }


    private K findHelp(BSTNode<KVPair<K, E>> curr, K key) { // dsa
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
            return curr.getValueElement().key();
        }
        else {
            return findHelp(curr.getRight(), key);
        }
    }


    public boolean remove(K key) { // dsa returns key, good
        K temp = findHelp(root, key);
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

 }
}

