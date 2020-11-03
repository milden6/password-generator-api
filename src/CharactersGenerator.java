import java.security.SecureRandom;

public class CharactersGenerator {

    private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "1234567890";
    private static final String SYMBOLS = "!\"#$%&\\'()*+,-./:;<=>?@^[\\\\]^_`{|}~";
    private static final int MIN_PASS_LENGTH = 8;

    public String generatePassword(int length, boolean isUpperCase, boolean isDigits, boolean isSymbols){

        StringBuilder password = new StringBuilder(length);
        SecureRandom random = new SecureRandom();
        int randomIndex = 0;

        if (length < MIN_PASS_LENGTH){
            length = MIN_PASS_LENGTH; //min allowed length
        }

        while (password.length() < length){

            switch (random.nextInt(3)){
                case 1:
                    if (isUpperCase) {
                        randomIndex = random.nextInt(UPPER_CASE.length());
                        password.append(UPPER_CASE.toCharArray()[randomIndex]);
                        break;
                    }
                case 2:
                    if (isDigits) {
                        randomIndex = random.nextInt(DIGITS.length());
                        password.append(DIGITS.toCharArray()[randomIndex]);
                        break;
                    }
                case 3:
                    if (isSymbols) {
                        randomIndex = random.nextInt(SYMBOLS.length());
                        password.append(SYMBOLS.toCharArray()[randomIndex]);
                        break;
                    }
                default:
                    randomIndex = random.nextInt(LOWER_CASE.length());
                    password.append(LOWER_CASE.toCharArray()[randomIndex]);
                    break;
            }

        }

        return password.toString();
    }

}
