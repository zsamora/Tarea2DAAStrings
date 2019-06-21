package main;
import java.util.ArrayList;

public class Leaf implements Node{
    ArrayList<Integer> index;

    public Leaf(int newindex) {
        index = new ArrayList<Integer>();
        index.add(newindex);
    }

    @Override
    public void addSuffix(Integer index, String subtext) {}
    @Override
    public void addSuffixRec(Integer index, String subtext, String rest) {}
    @Override
    public void printEdges(boolean breakline) {
        System.out.print(String.valueOf(index));
    }
    @Override
    public ArrayList<Integer> getValues() { return index; }
    @Override
    public int getNValues() {
        return index.size();
    }
    @Override
    public void addValue(Integer newindex) {
        index.add(newindex);
    }
    /*@Override
    public int countRec(String pattern) { return 0;}*/
    @Override
    public ArrayList<Integer> locate(String pattern) { return getValues(); }

    @Override
    public int getSize(){return Integer.SIZE*index.size(); }
}

