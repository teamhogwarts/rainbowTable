import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PasswordCreator {

    private int passwordLength;
    private Set<String> passwords;
    private char[] z;

    public PasswordCreator(int passwordLength) {
        this.passwordLength = passwordLength;
        this.passwords = new HashSet<>();
        initializePossiblePasswordCharacters();
    }

    private void initializePossiblePasswordCharacters() {
        this.z = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
                'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
                'x', 'y', 'z'};
    }

    public void generatePasswords(int amount) {

        String result = "";

        int sizeZ = z.length;

        char[] allChars = new char[passwordLength];

//        System.out.println("TEST: " + inSizeValue(1,36*3));
        String allKeys = "";

        for (int i = 0; i <= amount; i++) {
            allChars[6] = z[i % sizeZ];
            allChars[5] = z[i / sizeZ % sizeZ];
            allChars[4] = z[i / (sizeZ * sizeZ) % sizeZ];
            allChars[3] = z[i / (sizeZ * sizeZ * sizeZ) % sizeZ];
            allChars[2] = z[i / (sizeZ * sizeZ * sizeZ * sizeZ) % sizeZ];
            allChars[1] = z[i / (sizeZ * sizeZ * sizeZ * sizeZ * sizeZ) % sizeZ];
            allChars[0] = z[i / (sizeZ * sizeZ * sizeZ * sizeZ * sizeZ * sizeZ ) % sizeZ];
//            System.out.println(i + " = " + Arrays.toString(allChars));

        }
    }

//    private int inSizeValue(int index, int iteration) {
//        int result = z.length;
//        System.out.println(result);
//
//        for (int i = 0; i < index; i++) {
//            result = result * result;
//            System.out.println(result);
//        }
//        result = iteration / result;
//        System.out.println(result);
//        return result % z.length;
//    }

    public Set<String> getPasswords() {
        return passwords;
    }

    //    private String passwordPermutation(int i) {
//
//        StringBuilder result = new StringBuilder();
//        for (int j = 0; j < z.length; j++) {
//            result.append(z[j]);
//            while (result.length() < passwordLength) {
//                result.append(0);
//            }
//
//        }
//
//        return "";
//    }
}
