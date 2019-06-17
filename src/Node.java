import java.util.ArrayList;

public interface Node {
    void addSuffix(int index, String subtext);
    void addSuffixRec(int index, String subtext, String rest);
    ArrayList<Integer> getValues();
    void addValue(int newindex);
    void printEdges(boolean breakline);
}
