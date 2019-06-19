package main;

public class SuffixTree {
    String text;
    Node root;

    public SuffixTree() {
        root = new Leaf(-1);
    }

    public SuffixTree(String newText) {
        text = newText;
        // Crear indices como un arbol de sufijos
        root = indexText(text);
    }

    public Node indexText(String text) {
        InnerNode newroot = new InnerNode();
        // Iterar sobre cada sufijo desde el ultimo al primero
        for (int i = text.length()-1; i >= 0; i--) {
            String subtext = text.substring(i);
            newroot.addSuffix(i, subtext);
        }
        return newroot;
    }
    public void printTree(){
        root.printEdges();
    }
}