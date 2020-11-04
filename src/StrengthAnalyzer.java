import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class StrengthAnalyzer {

    private static final String PATTERN_LOWER_UPPER = "([a-z])([A-Z])";
    private static final String PATTERN_UPPER_LOWER = "([A-Z])([a-z])";
    private static final String PATTERN_UP_LOW_MIX = "([a-z])([A-Z])|([A-Z])([a-z])";
    private static final String PATTERN_LETTER_NUMBER = "(\\d+[a-z]|[a-z]+\\d)[a-z\\d]*";
    private static final String PATTERN_SYMBOLS = "\\p{Punct}";

    final Locale currentLocale = new Locale(Runtime.language, Runtime.country);
    final ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);

    private enum Point {
        ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5),
        SIX(6), EIGHT(8);

        private final int value;

        Point(int value){
            this.value = value;
        }
    }

    public String analyzeStrength(String word){

        int strengthIndicator;

        strengthIndicator = checkLength(word) + checkLowerUpperCase(word) + checkLetterNumber(word) + checkSymbols(word);

        if (strengthIndicator <= Point.TWO.value) {
            return messages.getString("very_poor");
        }
        else if (strengthIndicator <= Point.FOUR.value) {
            return messages.getString("weak");
        }
        else if (strengthIndicator <= Point.SIX.value){
            return messages.getString("average");
        }
        else if (strengthIndicator <= Point.EIGHT.value){
            return messages.getString("good");
        }
        else {
            return messages.getString("excellent");
        }
    }

    private int checkLength(String word){

        if (word.length() < 8){
            return Point.ONE.value;
        }
        else if (word.length() <= 16){
            return Point.TWO.value;
        }
        else if (word.length() <= 32){
            return Point.THREE.value;
        }
        else if (word.length() <= 64){
            return Point.FOUR.value;
        }
        else {
            return Point.FIVE.value;
        }
    }

    private int checkLowerUpperCase(String word){
        if (Pattern.compile(PATTERN_LOWER_UPPER).matcher(word).find() ||
            Pattern.compile(PATTERN_UPPER_LOWER).matcher(word).find()){
            return Point.ONE.value;
        }
        else if(Pattern.compile(PATTERN_UP_LOW_MIX).matcher(word).find()){
            return Point.TWO.value;
        }
        return 0;
    }

    private int checkLetterNumber(String word){
        if (Pattern.compile(PATTERN_LETTER_NUMBER).matcher(word).find()){
            return Point.TWO.value;
        }
        return 0;
    }

    private int checkSymbols(String word){
        if (Pattern.compile(PATTERN_SYMBOLS).matcher(word).find()){
            return Point.THREE.value;
        }
        return 0;
    }

}
