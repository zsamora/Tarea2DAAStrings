import java.util.ArrayList;

public class Leaf implements Node{
    ArrayList<Integer> index;

    public Leaf(int newindex) {
        index = new ArrayList<Integer>();
        index.add(newindex);
    }

    @Override
    public void addSuffix(int index, String subtext) {}
    @Override
    public void addSuffixRec(int index, String subtext, String rest) {}
    @Override
    public void printEdges(boolean breakline) {
        System.out.print(String.valueOf(index));
    }
    @Override
    public ArrayList getValues() {
        return index;
    }
    @Override
    public void addValue(int newindex) {
        index.add(newindex);
    }
}
