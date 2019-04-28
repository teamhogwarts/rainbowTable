import com.google.common.collect.BiMap;

import java.math.BigInteger;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws Exception {

        RainbowTable rainbowTable = new RainbowTable(2000, 7);
        rainbowTable.initialize();

        rainbowTable.creaetRainbowTable();
        BiMap<String, String > rain = rainbowTable.getRainbowTable();

        rain.keySet().forEach(key -> System.out.println("Key: " + key + " : " + "Value: " + rain.get(key)));
    }
}
