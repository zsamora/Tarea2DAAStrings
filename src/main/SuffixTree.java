package main;
import java.util.ArrayList;

public class SuffixTree {
    Node root;

    public SuffixTree() {
        root = new InnerNode();
    }

    public void indexWord(String word, Integer position) {
        // Iterar sobre cada sufijo desde el mas grande al mas pequeño
        for (int i = 0; i <= word.length(); i++) {
            String subtext = word.substring(i);
            root.addSuffix(i+position, subtext);
        }
    }
    public void printTree() {
        System.out.println("root:");
        root.printEdges(true);
    }

    public int count(String pattern) {
        return root.locate(pattern).size();
    }

    public ArrayList<Integer> locate(String pattern) {
        return root.locate(pattern);
    }

    public ArrayList<String> topkq(int k, int q) {
        return null;
    }

    public int getSize(){
        return  root.getSize();
    }
}
