package main;
import java.util.ArrayList;

public class SuffixTree {
    Node root;

    public SuffixTree() {
        root = new InnerNode();
    }

    public void indexWord(String word) {
        int l = word.length();

        for (int i = l-1; i >=0; i--) {
            System.out.println(i);
            String subtext = word.substring(i, l);
            root.addSuffix(i, subtext);
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
