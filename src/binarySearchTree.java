
public class binarySearchTree<E> {
    private BSTNode root;
    private int nodeCount;
    
    public binarySearchTree() {
        
    }
    
    public boolean insert(E element) {
        //if empty makes element root
        if (isEmpty()) {
            root = new BSTNode<E>(element);
            return true;
        }
        return false;
    }
    
    private boolean isEmpty() {
        return (root == null);
    }
    
    public E find() {
        return null;
    }
    
    public boolean remove() {
        return false;
    }
    
    public void print() {
        
    }
}
