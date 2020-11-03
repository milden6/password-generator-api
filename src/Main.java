public class Main {

    public static void main(String[] args) {

        CharactersGenerator generator = new CharactersGenerator();
        System.out.println(generator.generatePassword(4, true, false, false));
    }
}
