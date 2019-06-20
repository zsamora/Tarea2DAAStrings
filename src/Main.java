//import java.util.ArrayList;
//public class Main {
//    public static void main(String [] args)
//    {
//        // Variables
//        String word = "ana analiza lamana ocekanacana$";
//        String pattern = "ana";
//        long position= 0;
//        int k = 0;
//        int q = 0;
//
//        // Crear el arbol e indexar las palabras del texto
//        SuffixTree tree = new SuffixTree();
//        tree.indexWord(word, position);
//
//        // Imprime el arbol resultante (comentar para el texto final)
//        tree.printTree();
//
//        // Numero de ocurrencias
//        long startTime = System.nanoTime();
//        int ocurrences = tree.count(pattern);
//        long endTime   = System.nanoTime();
//        long totalTime = endTime - startTime;
//        System.out.println("");
//        System.out.println("N° de ocurrencias: " + String.valueOf(ocurrences));
//        System.out.println("Tiempo total: " + String.valueOf(totalTime));
//
//        // Lista de indices de ocurrencia del patron
//        startTime = System.nanoTime();
//        ArrayList<Long> locations = tree.locate(pattern);
//        endTime   = System.nanoTime();
//        totalTime = endTime - startTime;
//        System.out.println("");
//        System.out.print("Indices de ocurrencia: ");
//        System.out.println(locations);
//        System.out.println("Tiempo total: " + String.valueOf(totalTime));
//
//        // Top k strings de largo q
//        //ArrayList<String> topkq = tree.topkq(k,q);
//        //System.out.println("");
//        //System.out.print("Top k strings de largo q: ");
//        //System.out.println(topkq);
//    }
//}
