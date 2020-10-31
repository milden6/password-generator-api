import java.security.SecureRandom;

public class CharactersGenerator {

    private final String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String lowerCase = "abcdefghijklmnopqrstuvwxyz";
    private final String digits = "1234567890";
    private final String symbols = "!\"#$%&\\'()*+,-./:;<=>?@^[\\\\]^_`{|}~";

    public String GeneratePassword(int length, boolean isUpperCase, boolean isDigits, boolean isSymbols){

        StringBuilder password = new StringBuilder(length);
        SecureRandom random = new SecureRandom();
        int randomIndex = 0;

        if (length < 4){
            length = 4; //min allowed length
        }

        while (password.length() < length){

            switch (random.nextInt(4)){
                case 1:
                    if (isUpperCase) {
                        randomIndex = random.nextInt(upperCase.length());
                        password.append(upperCase.toCharArray()[randomIndex]);
                        break;
                    }
                case 2:
                    if (isDigits) {
                        randomIndex = random.nextInt(digits.length());
                        password.append(digits.toCharArray()[randomIndex]);
                        break;
                    }
                case 3:
                    if (isSymbols) {
                        randomIndex = random.nextInt(symbols.length());
                        password.append(symbols.toCharArray()[randomIndex]);
                        break;
                    }
                case 4:
                    randomIndex = random.nextInt(lowerCase.length());
                    password.append(lowerCase.toCharArray()[randomIndex]);
                    break;
            }

        }

        return password.toString();
    }

}