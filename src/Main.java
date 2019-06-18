import java.util.ArrayList;
public class Main {
    public static void main(String [] args)
    {
        String word = "xabxac";
        String pattern = "xa";
        long position= 0;
        int k = 0;
        int q = 0;
        // Crear el arbol y indexar las palabras del texto
        SuffixTree tree = new SuffixTree();
        tree.indexWord(word, position);
        // Imprime el arbol resultante
        tree.printTree();
        // Numero de ocurrencias
        int ocurrences = tree.count(pattern);
        System.out.println("");
        System.out.println("N° de ocurrencias " + String.valueOf(ocurrences));
        // Lista de indices de ocurrencia del patron
        //ArrayList<Long> locations = tree.locate(pattern);
        // Top k strings de largo q
        //ArrayList<String> topkq = tree.topkq(k,q);
    }
}
