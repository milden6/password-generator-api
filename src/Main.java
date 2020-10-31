public class Main {

    public static void main(String[] args) {

        CharactersGenerator generator = new CharactersGenerator();
        System.out.println(generator.GeneratePassword(4, true, false, false));
    }
}
