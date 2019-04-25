import java.math.BigInteger;
import java.security.MessageDigest;

public class RainbowTable {

    public static void main(String[] args) throws Exception {
        BigInteger hashValue = MD5("0000000");

        ReductionFunction reductionFunction = new ReductionFunction(7);
        String result = reductionFunction.executeReductionFunction(hashValue, 0);
        hashValue = MD5(result);
        result = reductionFunction.executeReductionFunction(hashValue, 1);
        hashValue = MD5(result);
        result = reductionFunction.executeReductionFunction(hashValue, 2);
        System.out.println(result);

    }

    public static BigInteger MD5(String s) throws Exception {
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(s.getBytes(), 0, s.length());
        return new BigInteger(1, m.digest());
    }
}



