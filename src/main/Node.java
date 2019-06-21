package main;
import java.util.ArrayList;

public interface Node {
    void addSuffix(Integer index, String subtext);
    void addSuffixRec(Integer index, String subtext, String rest);
    ArrayList<Integer> getValues();
    int getNValues();
    void addValue(Integer newindex);
    void printEdges(boolean breakline);
    //int countRec(String pattern);
    ArrayList<Integer> locate(String pattern);
    int getSize();
}
