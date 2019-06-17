import java.util.ArrayList;

public class Leaf implements Node{
    ArrayList<Long> index;

    public Leaf(long newindex) {
        index = new ArrayList<Long>();
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
    public ArrayList getValues() {
        return index;
    }
    @Override
    public void addValue(long newindex) {
        index.add(newindex);
    }
}
