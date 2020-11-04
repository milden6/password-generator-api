public class Main {

    public static void main(String[] args) {

        Runtime.language = "en";
        Runtime.country = "US";

        CharactersGenerator generator = new CharactersGenerator();
        StrengthAnalyzer strengthAnalyzer = new StrengthAnalyzer();

        String password = generator.generatePassword(10, true, true, false);

        System.out.println(password);
        System.out.println(strengthAnalyzer.analyzeStrength(password));
    }
}
