package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.EnumMap;
import main.SuffixTree;

public abstract class AbstractTest {

    private File file;
    private SuffixTree tree;

    private static final EnumMap<FIleTextOption, String> stateMap = new EnumMap<FIleTextOption, String>(FIleTextOption.class){{
        put(FIleTextOption.MB50, "src/texts/english.50MB");
    }};


    public AbstractTest(String filePath, SuffixTree tree) throws SuffixTreeException {
        this.file = new File(filePath);
        if (!this.file.exists()){
            throw  new SuffixTreeException("Invalid file path provided");
        }
        this.tree = tree;
    }


    public AbstractTest(FIleTextOption options){
        this.tree = new SuffixTree("awdsad");
        String filePath = stateMap.get(options);
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.equals("")){
                    line = line.replaceAll("[^(A-z| |\\d|\\-)]"," ").replaceAll(" {2,}", " ").trim();
                    System.out.println(line);
//                    for (String w : line.split(" ")){
//                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
