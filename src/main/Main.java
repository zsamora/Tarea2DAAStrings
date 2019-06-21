package main;

import test.DNATest;
import test.EnglishTextTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// 50MB: 49366272 ~ 2**25
// 200MB : 197562020 ~2**27
// 1024MB: 1012930570 ~ 2**30

// DNA
// 200MB: 209714087 ~ 2**27

public class Main {

    static final int MIN_EXP = 11;
    static final int MAX_EXP = 15;

    public static void main(String [] args) {
        SuffixTree t = new SuffixTree();
        t.indexWord("xabxac$", 0);
        t.printTree();
        new EnglishTextTest(MIN_EXP, MAX_EXP);

//        new DNATest(MIN_EXP, MAX_EXP);
    }

}
