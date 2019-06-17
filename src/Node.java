import java.util.ArrayList;

public interface Node {
    void addSuffix(long index, String subtext);
    void addSuffixRec(long index, String subtext, String rest);
    ArrayList<Integer> getValues();
    void addValue(long newindex);
    void printEdges(boolean breakline);
}
