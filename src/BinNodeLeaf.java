
public class BinNodeLeaf<E> implements BinNode{
    //private DLList list;
    private int numCount;
    private E element;
    
    public BinNodeLeaf(E element){
        this.element = element;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isLeaf() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean insert() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isIntersecting() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void print() {
        // TODO Auto-generated method stub
        
    }

}
