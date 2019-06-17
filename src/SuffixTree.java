public class SuffixTree {
    Node root;

    public SuffixTree() {
        root = new InnerNode();
    }

    public void indexWord(String word, long position) {
        // Iterar sobre cada sufijo desde el ultimo al primero
        for (int i = word.length()-1; i >= 0; i--) {
            String subtext = word.substring(i);
            root.addSuffix(i+position, subtext);
        }
    }

    public void printTree() {
        System.out.println("root:");
        root.printEdges(true);
    }
}
