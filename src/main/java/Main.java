import java.math.BigInteger;


/**
 * Programmieraufgabe Rainbow-Table
 * krysi FS 2019
 *
 * @author Pascal Andermatt, Benjamin Brodwolf, Nadia Kramer
 */
public class Main {
    public static void main(String[] args) throws Exception {

        RainbowTable rainbowTable = new RainbowTable(2000, 7, 2000);
        rainbowTable.initialize();
        rainbowTable.createRainbowTable();

        String hashValue = "1d56a37fb6b08aa709fe90e12ca59e12";

        SearchPassword searchPassword = new SearchPassword(rainbowTable);
        String password = searchPassword.searchForPassword(new BigInteger(hashValue, 16));

        System.out.println("hash value: " + hashValue);
        System.out.println("calculated password: " + password);
        System.out.println("hashed password: " + rainbowTable.getHashFunction().executeHashFunctionMD5(password).toString(16));
    }
}
