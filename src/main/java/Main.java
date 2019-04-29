import com.google.common.collect.BiMap;

import java.math.BigInteger;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws Exception {

        RainbowTable rainbowTable = new RainbowTable(2000, 7, 2000);
        rainbowTable.initialize();

        rainbowTable.creaetRainbowTable();
        BiMap<String, String > rain = rainbowTable.getRainbowTable();

        // rain.keySet().forEach(key -> System.out.println("Key: " + key + " : " + "Value: " + rain.get(key)));
        String hashValue = "1d56a37fb6b08aa709fe90e12ca59e12"; // vogt
        //String hashValue = "12e2feb5a0feccf82a8d4172a3bd51c3";

        SearchPassword searchPassword = new SearchPassword(rainbowTable);
        String password = searchPassword.searchForPassword(new BigInteger(hashValue, 16));

        System.out.println("Hashwert: " + hashValue);
        System.out.println("calculated Password: " + password);
        System.out.println("passwort gehasht: " + rainbowTable.getHashFunction().MD5(password).toString(16));



    }
}
