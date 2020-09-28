package readability.counters;

import java.util.regex.Pattern;

public class WorldSplitter {
    private static final Pattern WORD_PATTERN = Pattern.compile("[\\s]+");
    private static final String PUNCTUATION = "[.!?,]+";
    private static final Pattern PUNCTUATION_PATTERN = Pattern.compile(PUNCTUATION);

    public String[] getWords (String text){
        String textWoPuncts = PUNCTUATION_PATTERN.matcher(text).replaceAll(" ");
        String[] words = WORD_PATTERN.split(textWoPuncts);
//        for (int i = 0; i < words.length; i++) {
//          words[i]= PUNCTUATION_PATTERN.matcher(words[i]).replaceAll("");
//        }
        return words;
    }
}
