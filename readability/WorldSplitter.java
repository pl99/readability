package readability;

import java.util.regex.Pattern;

public class WorldSplitter {
    private static final Pattern WORD_PATTERN = Pattern.compile("[\\s]+");
    private static final String PUNCTUATION = "[.!?,]+";

    public String[] getWords (String text){
        String[] words = WORD_PATTERN.split(text);
        for (int i = 0; i < words.length; i++) {
          words[i]= words[i].replaceAll(PUNCTUATION, "");
        }
        return words;
    }
}
