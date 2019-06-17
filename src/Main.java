public class Main {
    public static void main(String [] args)
    {
        String text = args[0];
        SuffixTree tree = new SuffixTree(text);
        tree.printTree();
    }

}
