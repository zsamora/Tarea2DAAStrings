package test;

public class EnglishTextTest extends AbstractTest {

    public EnglishTextTest(int min_exp, int max_exp) {
        super("src/texts/english.200MB", min_exp, max_exp);
    }

    @Override
    public String getRandomSubstring(String line) {
        return getRandom(line.split(" "));
    }

    @Override
    public int[] getqs() {
        return new int[]{4, 5 , 6 ,7};
    }
}
