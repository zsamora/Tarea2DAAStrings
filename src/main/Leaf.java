package main;

import java.util.ArrayList;

public class Leaf implements Node{
    ArrayList<Integer> index;

    public Leaf(int newindex) {
        index.add(newindex);
    }

    @Override
    public void addSuffix(int index, String subtext) {

    }

    @Override
    public void printEdges() {

    }

    @Override
    public int getValue() {
        return 0;
    }

    public ArrayList getValues() {
        return index;
    }
}
