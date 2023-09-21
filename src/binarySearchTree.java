
public class binarySearchTree<K extends Comparable<K>, E>{
    
    private BSTNode<KVPair<K, E>> root;
    private int nodeCount;
    private boolean dupAllowed;
    //private Comparable k;
    
    binarySearchTree(boolean dupAllowed) {
        root = null;
        nodeCount = 0;
        this.dupAllowed = dupAllowed;
    }
    
    public boolean insert(KVPair<K, E> kvPair) { //dsa returns void, good
        //if empty makes element root
        if (isEmpty()) {
            root = new BSTNode<KVPair<K, E>>(kvPair);
            nodeCount++;
            return true;
        }
        else if(!dupAllowed && find(kvPair) != null) {
            return false;
        }
        root = insertHelp(root, kvPair);
        nodeCount++;
        return true;
    }
    
    private BSTNode<KVPair<K, E>> insertHelp(BSTNode<KVPair<K, E>> rootParam, KVPair<K, E> kvPairParam) {//dsa returns node,good
        if(rootParam == null) {
            return
                new BSTNode<KVPair<K, E>>(kvPairParam);
        }
        if(rootParam.getValueElement().key().compareTo(kvPairParam.key()) >= 0) {
            root.setLeft(insertHelp(rootParam.getLeft(), kvPairParam));
        }
        else {
            root.setRight(insertHelp(rootParam.getRight(), kvPairParam));
        }
        return root;
    }
    
    private boolean isEmpty() {
        return (root == null);
    }
    
    public K find(KVPair<K, E> kvPair) { //dsa returns key, good
        return findHelp(root, kvPair);
    }
    
    private K findHelp(BSTNode<KVPair<K, E>> rootParam, KVPair<K, E> kvPairParam){ //dsa returns key, good
        if(rootParam == null) {
            return null;
        }
        if(rootParam.getValueElement().key().compareTo(kvPairParam.key()) > 0) {
            return findHelp(rootParam.getLeft(), kvPairParam);
        }
        else if (rootParam.getValueElement().key().compareTo(kvPairParam.key()) ==0) {
            return rootParam.getValueElement().key();
        }
        else {
            return findHelp(rootParam.getRight(), kvPairParam);
        }
    }
    
    public boolean remove(KVPair<K, E> kvPair) { //dsa returns key, good
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
    
    private BSTNode<KVPair<K, E>> removeHelp( BSTNode<KVPair<K, E>> rootParam, KVPair<K, E> kvPairParam) {//dsa returns node, good
        if(rootParam == null) {
            return null;
        }
        if(rootParam.getValueElement().key().compareTo(kvPairParam.key()) > 0) {
            rootParam.setLeft(removeHelp(rootParam.getLeft(), kvPairParam));
        }
        else if(rootParam.getValueElement().key().compareTo(kvPairParam.key()) < 0) {
            rootParam.setRight(removeHelp(rootParam.getRight(), kvPairParam));
        }
        else { //found it
            if (rootParam.getLeft() == null) {
                return rootParam.getRight();
            }
            else if (rootParam.getRight() == null) {
                return rootParam.getLeft();
            }
            else { //2 children
                BSTNode<KVPair<K, E>> temp = getMax(rootParam.getLeft());
                rootParam.setValueElement(temp.getValueElement());
                rootParam.setLeft(deleteMax(rootParam.getLeft()));
            }
        }
        return rootParam;
    }
    
    private BSTNode<KVPair<K, E>> getMax(BSTNode<KVPair<K, E>> rootParam) {
        if(rootParam.getRight() == null) {
            return rootParam;
        }
        return getMax(rootParam.getRight());
    }
    
    private BSTNode<KVPair<K, E>> deleteMax(BSTNode<KVPair<K, E>> rootParam) {
        if(rootParam.getRight() == null) {
            return rootParam.getLeft();
        }
        rootParam.setRight(deleteMax(rootParam.getRight()));
        return rootParam;
    }
    
    public void print() {
        
    }
}
