
public class BSTNode<E> {
    private E valueElement;
    private BSTNode<E> left;
    private BSTNode<E> right;
    
    public BSTNode(E valueElement) {
        this.valueElement = valueElement;
        left = null;
        right = null;
    }
    
    public E getValueElement() {
        return valueElement;
    }
    
    public BSTNode getLeft() {
        return left;
    }

    public BSTNode getRight() {
        return right;
    }
    
    public void setLeft(BSTNode leftParam) {
        left = leftParam;
    }
    
    public void setRight(BSTNode rightParam) {
        left = rightParam;
    }
}
