import java.util.ArrayList;

public class SuffixTree {
    Node root;

    public SuffixTree() {
        root = new InnerNode();
    }

    public void indexWord(String word, long position) {
        // Iterar sobre cada sufijo desde el mas pequeño al mas grande
        for (int i = word.length()-1; i >= 0; i--) {
            String subtext = word.substring(i);
            root.addSuffix(i+position, subtext);
        }
    }
    public void printTree() {
        System.out.println("root:");
        root.printEdges(true);
    }

    public int count(String pattern) {
        //return root.countRec(pattern);
        return root.locate(pattern).size();
    }

    public ArrayList<Long> locate(String pattern) {
        return root.locate(pattern);
    }

    public ArrayList<String> topkq(int k, int q) {
        return null;
    }
}
