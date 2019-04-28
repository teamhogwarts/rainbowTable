import com.google.common.collect.BiMap;

import java.math.BigInteger;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws Exception {

        RainbowTable rainbowTable = new RainbowTable(3, 7, 3);
        rainbowTable.initialize();

        rainbowTable.creaetRainbowTable();
        BiMap<String, String > rain = rainbowTable.getRainbowTable();

        // rain.keySet().forEach(key -> System.out.println("Key: " + key + " : " + "Value: " + rain.get(key)));

        SearchPassword searchPassword = new SearchPassword(rainbowTable);

        System.out.println("calculatedEndValue: " + searchPassword.searchForPassword(new BigInteger("29c3eea3f305d6b823f562ac4be35217", 16)));
    }
}
