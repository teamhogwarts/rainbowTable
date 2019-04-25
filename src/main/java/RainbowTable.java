import java.math.BigInteger;
import java.security.MessageDigest;

public class RainbowTable {

    public static void main(String[] args) throws Exception {
        BigInteger hashValue = MD5("0000000");

        ReductionFunction reductionFunction = new ReductionFunction(7);
        String result = reductionFunction.executeReductionFunction(hashValue,0);
        System.out.println(result);

    }

    public static BigInteger MD5(String s) throws Exception {
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(s.getBytes(), 0, s.length());
        return new BigInteger(1, m.digest());
    }

//    public static String reduktionsFunktion(BigInteger hashValue, int round) {
//        BigInteger roundHashValue = hashValue.add(BigInteger.valueOf(round));
//        char[] z = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
//                'a','b','c','d','e', 'f', 'g', 'h', 'i','j', 'k', 'l',
//                'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
//                'x', 'y', 'z'};
//        BigInteger[] divideAndRemainders;
//        StringBuilder builder = new StringBuilder();
//
//        for (int i = 1; i <= 7; i++) {
//            divideAndRemainders = roundHashValue.divideAndRemainder(BigInteger.valueOf(z.length));
//            roundHashValue = divideAndRemainders[0];
//            builder.append(z[divideAndRemainders[1].intValue()]);
//        }
//
//        return builder.reverse().toString();
//    }
}



