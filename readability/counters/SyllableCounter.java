package readability.counters;

import java.util.Arrays;
import java.util.List;

public class SyllableCounter implements ICounter {
    private List<Character> vovels =
        Arrays.asList('a', 'e', 'i', 'o', 'u', 'y');

    @Override
    public Double count(String text) {
        String[] words = new WorldSplitter().getWords(text);
        double result = 0;
        for (String word : words) {
            result += syllableInWord(word.replaceAll("[\\.,\\?!]+", ""));
        }
        return result;
    }

    @Override
    public CounterType getCounterType() {
        return CounterType.SYLLABLES;
    }

    public Double syllableInWord (String word){
        char[] chars = word.toLowerCase().toCharArray();
        if('e' == chars[chars.length - 1]){
            chars[chars.length - 1] = '$';
        }
        double result = vovels.contains(chars[0])?1.0:0.0;
        for (int i = 1; i < chars.length ; i++) {
            if (vovels.contains(chars[i]) && !vovels.contains(chars[i - 1])) {
                result += 1.0D;
            }

        }
        return 0 == result ?1:result;
    }

}
