import java.security.SecureRandom;

public class CharactersGenerator {

    private final String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String lowerCase = "abcdefghijklmnopqrstuvwxyz";
    private final String digits = "1234567890";
    private final String symbols = "!\"#$%&\\'()*+,-./:;<=>?@^[\\\\]^_`{|}~";

    public String GeneratePassword(int length, boolean isUpperCase, boolean isDigits, boolean isSymbols){

        StringBuilder password = new StringBuilder(length);
        SecureRandom random = new SecureRandom();

        if (length < 4){
            length = 4; //min allowed length
        }

        for (int i = 1; i < length; i++) {

            int randomIndex = random.nextInt(lowerCase.length());
            password.append(lowerCase.toCharArray()[randomIndex]);

            if (isUpperCase) {
                randomIndex = random.nextInt(upperCase.length());
                password.append(upperCase.toCharArray()[randomIndex]);
            }
            if (isDigits) {
                randomIndex = random.nextInt(digits.length());
                password.append(digits.toCharArray()[randomIndex]);
            }
            if (isSymbols) {
                randomIndex = random.nextInt(symbols.length());
                password.append(symbols.toCharArray()[randomIndex]);
            }

        }

        return password.toString();
    }

}