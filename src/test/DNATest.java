package test;

import java.util.Random;

public class DNATest extends AbstractTest{

    public DNATest(int min_exp, int max_exp) {
        super("src/texts/dna.200MB", min_exp, max_exp);
    }

    @Override
    public String getRandomSubstring(String line) {

        int rnd = new Random().nextInt(getqs().length);
        int size = getqs()[rnd];

        rnd = new Random().nextInt(line.length()-size);

        return line.substring(rnd, rnd+size);
    }

    @Override
    public int[] getqs() {
        return new int[]{4, 8 , 16 ,32};
    }
}
