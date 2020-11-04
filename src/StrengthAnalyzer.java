import java.util.regex.Pattern;

public class StrengthAnalyzer {

    private static final String PATTERN_LOWER_UPPER = "([a-z])([A-Z])";
    private static final String PATTERN_UPPER_LOWER = "([A-Z])([a-z])";
    private static final String PATTERN_UP_LOW_MIX = "([a-z])([A-Z])|([A-Z])([a-z])";
    private static final String PATTERN_LETTER_NUMBER = "(?:\\d+[a-z]|[a-z]+\\d)[a-z\\d]*";
    private static final String PATTERN_SYMBOLS = "(?:[-!$%^&*()_+|~=`{}\\[\\]:\";" +
                                                  "'<>?,./]+[a-z]|[a-z]+[-!$%^&*" +
                                                  "()_+|~=`{}\\[\\]:\";'<>?,.\\/])" +
                                                  "[a-z-!$%^&*()_+|~=`{}\\[\\]:\";'<>?,.\\/]*";

    private int checkLength(String word){

        if (word.length() < 8){
            return 1;
        }
        else if (word.length() <= 16){
            return 2;
        }
        else if (word.length() <= 32){
            return 3;
        }
        else if (word.length() <= 64){
            return 4;
        }
        else {
            return 5;
        }
    }

    private int checkLowerUpperCase(String word){
        if (Pattern.compile(PATTERN_LOWER_UPPER).matcher(word).find() ||
            Pattern.compile(PATTERN_UPPER_LOWER).matcher(word).find()){
            return 1;
        }
        else if(Pattern.compile(PATTERN_UP_LOW_MIX).matcher(word).find()){
            return 2;
        }
        return 0;
    }

    private int checkLetterNumber(String word){
        if (Pattern.compile(PATTERN_LETTER_NUMBER).matcher(word).find()){
            return 2;
        }
        return 0;
    }

    private int checkSymbols(String word){
        if (Pattern.compile(PATTERN_SYMBOLS).matcher(word).find()){
            return 3;
        }
        return 0;
    }

    public String analyzeStrength(String word){

        int strengthIndicator = 0;

        strengthIndicator += checkLength(word);
        strengthIndicator += checkLowerUpperCase(word);
        strengthIndicator += checkLetterNumber(word);
        strengthIndicator += checkSymbols(word);

        if (strengthIndicator <= 2) {
            return "Very poor";
        }
        else if (strengthIndicator <= 4) {
            return "Weak";
        }
        else if (strengthIndicator <= 6){
            return "Average";
        }
        else if (strengthIndicator <= 8){
            return "Good";
        }
        else {
            return "Excellent";
        }
    }

}
