
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
    
    public void setValueElement(E elementParam) {
        valueElement = elementParam;
    }
    
    public BSTNode<E> getLeft() {
        return left;
    }

    public BSTNode<E> getRight() {
        return right;
    }
    
    public void setLeft(BSTNode<E> leftParam) {
        left = leftParam;
    }
    
    public void setRight(BSTNode<E> rightParam) {
        right = rightParam;
    }
}
