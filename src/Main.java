public class Main {

    public static void main(String[] args) {

        CharactersGenerator generator = new CharactersGenerator();
        StrengthAnalyzer strengthAnalyzer = new StrengthAnalyzer();

        String password = generator.generatePassword(10, true, true, true);

        System.out.println(password);
        System.out.println(strengthAnalyzer.analyzeStrength(password));
    }
}
