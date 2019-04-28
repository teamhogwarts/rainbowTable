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

        SearchPassword searchPassword = new SearchPassword(rainbowTable);

        System.out.println("calculated Password: " + searchPassword.searchForPassword(new BigInteger("1d56a37fb6b08aa709fe90e12ca59e12", 16)));
    }
}
