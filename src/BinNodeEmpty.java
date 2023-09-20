
public class BinNodeEmpty implements BinNode{
    private BinNodeEmpty binNodeEmpty;
    private BinNodeEmpty getInstance;
    static private BinNodeEmpty flyweight = null;
    
    public BinNodeEmpty() {
        
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
