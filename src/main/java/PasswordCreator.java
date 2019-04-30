import java.util.*;

public class PasswordCreator {

    private int passwordLength;
    private SortedSet<String> passwords;
    private char[] z;

    public PasswordCreator(int passwordLength) {
        this.passwordLength = passwordLength;
        this.passwords = new TreeSet<>();
        initializePossiblePasswordCharacters();
    }

    private void initializePossiblePasswordCharacters() {
        this.z = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
                'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
                'x', 'y', 'z'};
    }

    public void generatePasswords(int amount) {
        int sizeZ = z.length;

        StringBuilder passwordBuilder;
        for (int i = 0; i < amount; i++) {
            passwordBuilder = new StringBuilder() ;

            for (int j = this.passwordLength -1 ; j >= 0; j--){

                passwordBuilder.append(calculateCharacter(i, sizeZ, j));
            }

            this.passwords.add(passwordBuilder.toString());
        }
    }

    private char calculateCharacter(int i, int sizeZ, int pow){
        return z[(i / (int) Math.pow(sizeZ, pow)) % sizeZ];
    }

    public Set<String> getPasswords() {
        return passwords;
    }
}
