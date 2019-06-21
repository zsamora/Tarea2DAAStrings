package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import main.SuffixTree;

public abstract class AbstractTest {

    public AbstractTest(String filePath, int min_exp, int max_exp) {

        StringBuilder textBuilder = new StringBuilder();
        ArrayList<String> randomWords = new ArrayList<>();

        int currentExp = min_exp;
        int currentLimit = (int)Math.pow(2, currentExp);

        int randomWordsLimit = Math.round(currentLimit/10);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.equals("")){
                    line = line.replaceAll("[^(A-z| |\\d|\\-)]"," ").replaceAll(" {2,}", " ").trim() ;
                    String subLine = new StringBuilder(line).append(" ").toString();

                    while (!subLine.equals("")){
                        if (textBuilder.length() + subLine.length() > currentLimit){
                            int a = currentLimit-textBuilder.length();
                            textBuilder.append(subLine.substring(0, a>0 ? a-1 : a));
                            startTest(new StringBuilder(textBuilder.toString()).append("$").toString(), randomWords);
                            subLine = subLine.substring(a>0 ? a-1 : subLine.length()-1);
                            if (currentExp == max_exp) {
                                return;
                            } else {
                                currentExp += 1;
                                currentLimit = (int)Math.pow(2, currentExp);
                                randomWordsLimit = Math.round(currentLimit/10);
                            }
                        } else {
                            textBuilder.append(subLine);
                            subLine = "";
                        }

                    }

                    if (Math.random() < 0.5 && randomWords.size() < randomWordsLimit) {
                        randomWords.add(getRandomSubstring(line));
//                        randomWords.add();
                    }


                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract String getRandomSubstring(String line);

    private void startTest(String text, List<String> randomWords){
        System.out.println(text);
        SuffixTree suffixTree = new SuffixTree();

        long startTime = System.nanoTime();
        suffixTree.indexWord(text, 0);
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);
        System.out.println("Creation time: " + duration + "ns");
        System.out.println("Size: " + suffixTree.getSize() + "bytes");


        startTime = System.nanoTime();
        for (String word : randomWords){
            suffixTree.locate(word);
        }
        endTime = System.nanoTime();

        duration = (endTime - startTime);
        System.out.println("Search Time: " + duration + "ns");

        startTime = System.nanoTime();
        for (String word : randomWords){
            suffixTree.count(word);
        }
        endTime = System.nanoTime();

        duration = (endTime - startTime);
        System.out.println("Count Time: " + duration + "ns");

        int[] ks = {3, 5, 10};
        int[] qs = getqs();
        startTime = System.nanoTime();

        for (int k : ks){
            for (int q: qs)
                suffixTree.topkq(k,q);
        }
        endTime = System.nanoTime();

        duration = (endTime - startTime);
        System.out.println(" Time: " + duration + "ns");

    }


    public abstract int[] getqs();

    public String getRandom(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }


}
