public class Main {
    public static void main(String [] args)
    {
        String word = "";
        long position= 0;
        // Crear el arbol y indexar las palabras del texto
        SuffixTree tree = new SuffixTree();
        tree.indexWord(word, position);
        // Imprime el arbol resultante
        tree.printTree();
    }
}
