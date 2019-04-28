import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import java.security.NoSuchAlgorithmException;

public class RainbowTable {

    private  int chainLength;
    private BiMap<String, String> rainbowTable;
    private HashFunction hashFunction;
    private ReductionFunction reductionFunction;
    private PasswordCreator passwordCreator;

    public RainbowTable(int chainLength, int passwordLength) {
        this.chainLength = chainLength;
        this.rainbowTable = HashBiMap.create();
        this.hashFunction = new HashFunction();
        this.reductionFunction = new ReductionFunction(passwordLength);
        this.passwordCreator = new PasswordCreator(passwordLength);
    }

    public void initialize() throws NoSuchAlgorithmException {
        this.hashFunction.initializeMd5();
    }

    public void creaetRainbowTable(){

        this.passwordCreator.getPasswords().forEach(password ->
                this.rainbowTable.put(password, this.calcEndValueOfChain(password)));
    }

    private String calcEndValueOfChain(String password){
        String result = password;

        for (int i = 0; i < this.chainLength; i++) {
            result = reductionFunction.executeReductionFunction(hashFunction.MD5(result), i);
        }

        return result;
    }

    public BiMap<String, String> getRainbowTable() {
        return rainbowTable;
    }
}



