import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import java.security.NoSuchAlgorithmException;

/**
 * Programmieraufgabe Rainbow-Table
 * krysi FS 2019
 *
 * @author Pascal Andermatt, Benjamin Brodwolf, Nadia Kramer
 */
public class RainbowTable {

    private int chainLength;
    private int passwordAmount;
    private BiMap<String, String> rainbowTable;
    private HashFunction hashFunction;
    private ReductionFunction reductionFunction;
    private PasswordCreator passwordCreator;

    public RainbowTable(int chainLength, int passwordLength, int passwordAmount) {
        this.passwordAmount = passwordAmount;
        this.chainLength = chainLength;
        this.rainbowTable = HashBiMap.create();
        this.hashFunction = new HashFunction();
        this.reductionFunction = new ReductionFunction(passwordLength);
        this.passwordCreator = new PasswordCreator(passwordLength);
    }

    public void initialize() throws NoSuchAlgorithmException {
        this.hashFunction.initializeMd5();
        this.passwordCreator.generatePasswords(this.passwordAmount);
    }

    public void createRainbowTable() {
        this.passwordCreator.getPasswords().forEach(password ->
                this.rainbowTable.put(password, this.calcEndValueOfChain(password)));
    }

    private String calcEndValueOfChain(String password) {
        String result = password;

        for (int i = 0; i < this.chainLength; i++) {
            result = reductionFunction.executeReductionFunction(hashFunction.executeHashFunctionMD5(result), i);
        }

        return result;
    }

    public BiMap<String, String> getRainbowTable() {
        return rainbowTable;
    }

    public ReductionFunction getReductionFunction() {
        return reductionFunction;
    }

    public HashFunction getHashFunction() {
        return hashFunction;
    }

    public int getChainLength() {
        return chainLength;
    }
}



