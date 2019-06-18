import java.util.ArrayList;

public class Leaf implements Node{
    ArrayList<Long> index;

    public Leaf(long newindex) {
        index = new ArrayList<>();
        index.add(newindex);
    }

    @Override
    public void addSuffix(long index, String subtext) {}
    @Override
    public void addSuffixRec(long index, String subtext, String rest) {}
    @Override
    public void printEdges(boolean breakline) {
        System.out.print(String.valueOf(index));
    }
    @Override
    public ArrayList<Long> getValues() { return index; }
    @Override
    public int getNValues() {
        return index.size();
    }
    @Override
    public void addValue(long newindex) {
        index.add(newindex);
    }
    /*@Override
    public int countRec(String pattern) { return 0;}*/
    @Override
    public ArrayList<Long> locate(String pattern) { return getValues(); }
}
