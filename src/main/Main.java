package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String [] args) {
        long cursor = 0
        try (BufferedReader br = new BufferedReader(new FileReader("src/texts/english.50MB"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.equals("")){
                    String[] splittedLine = line.split(" ");
                    for (int i = 0; i<line.length(); i++){

                    }
                    line = line.replaceAll("[^(A-z| |\\d|\\-)]"," ").replaceAll(" {2,}", " ").trim();
                    System.out.println(line+"$");
//                    for (String w : line.split(" ")){
//                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        String text = args[0];
        SuffixTree tree = new SuffixTree(text);
        tree.printTree();
    }

}
