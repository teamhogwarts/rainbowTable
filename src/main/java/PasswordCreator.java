import java.util.Set;

public class PasswordCreator {

    private int passwordLength;
    private Set<String> passwords;
    private char[] z;

    public PasswordCreator(int passwordLength, Set<String> passwords) {
        this.passwordLength = passwordLength;
        this.passwords = passwords;
        initializePossiblePasswordCharacters();
    }

    private void initializePossiblePasswordCharacters() {
        this.z = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a','b','c','d','e', 'f', 'g', 'h', 'i','j', 'k', 'l',
                'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
                'x', 'y', 'z'};
    }

    public void generatePasswords(int amount){
        for (int i = 0; i < amount; i++) {
            String permutedPW = passwordPermutation(i);
            System.out.println(permutedPW);
            passwords.add(permutedPW);
        }
    }

    private String passwordPermutation(int i){

        return "";
    }
}
