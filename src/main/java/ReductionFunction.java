import java.math.BigInteger;

/**
 * Programmieraufgabe Rainbow-Table
 * krysi FS 2019
 *
 * @author Pascal Andermatt, Benjamin Brodwolf, Nadia Kramer
 */
public class ReductionFunction {

    private char[] z;
    private int passwordLength;

    public ReductionFunction(int passwordLength) {
        this.passwordLength = passwordLength;
        initializePossiblePasswordCharacters();
    }

    private void initializePossiblePasswordCharacters() {
        this.z = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
                'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
                'x', 'y', 'z'};
    }

    public String executeReductionFunction(BigInteger hashValue, int round) {
        BigInteger roundHashValue = hashValue.add(BigInteger.valueOf(round));

        BigInteger[] divideAndRemainders;
        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= this.passwordLength; i++) {
            divideAndRemainders = roundHashValue.divideAndRemainder(BigInteger.valueOf(this.z.length));
            roundHashValue = divideAndRemainders[0];
            result.append(this.z[divideAndRemainders[1].intValue()]);
        }

        return result.reverse().toString();
    }
}
