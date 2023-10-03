
/**
 * This class tests bstnode class
 *
 * @author Hafsa Khan (hfsakhn)
 * @author Mary Zeno (maryzeno)
 * @version 10/02/2023
 *
 * @param <E>
 *            takes in generic type
 */
public class BSTNode<E extends Comparable<? super E>> {
    private E valueElement; // element of the node
    private BSTNode<E> left; // left node
    private BSTNode<E> right; // right node

    /**
     * constructor for bstNode with provided elements
     * 
     * @param valueElement
     *            elements node
     */
    public BSTNode(E valueElement) {
        this.valueElement = valueElement; // element of node
        left = null; // left of node
        right = null; // right of node
    }


    /**
     * gets value of node
     * 
     * @return E value of node
     */
    public E getValueElement() {
        return valueElement;
    }


    /**
     * sets the value of the node
     * 
     * @param elementParam
     *            value set at
     */
    public void setValueElement(E elementParam) {
        valueElement = elementParam;
    }


    /**
     * returns the left node
     * 
     * @return BSTNode<E> left node
     */
    public BSTNode<E> getLeft() {
        return left;
    }


    /**
     * returns the right node
     * 
     * @return BSTNode<E> right node
     */
    public BSTNode<E> getRight() {
        return right;
    }


    /**
     * sets the left node
     * 
     * @param leftParam
     *            the left node
     */
    public void setLeft(BSTNode<E> leftParam) {
        left = leftParam;
    }


    /**
     * sets the right node
     * 
     * @param rightParam
     *            the right node
     */
    public void setRight(BSTNode<E> rightParam) {
        right = rightParam;
    }
}
