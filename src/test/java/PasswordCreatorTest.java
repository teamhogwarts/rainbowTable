import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;

class PasswordCreatorTest {

    @Test
    void generatePasswords() {
        PasswordCreator pwCreator = new PasswordCreator(7);

        pwCreator.generatePasswords(2_000);

        pwCreator.getPasswords();
    }

    @Test
    void hashReductionFunctionTest() throws NoSuchAlgorithmException {
        HashFunction hashFunction = new HashFunction();
        hashFunction.initializeMd5();

        BigInteger hashValue = hashFunction.MD5("0000000");

        ReductionFunction reductionFunction = new ReductionFunction(7);
        String result = reductionFunction.executeReductionFunction(hashValue, 0);
        hashValue = hashFunction.MD5(result);
        result = reductionFunction.executeReductionFunction(hashValue, 1);
        hashValue = hashFunction.MD5(result);
        result = reductionFunction.executeReductionFunction(hashValue, 2);
        System.out.println(result);

        PasswordCreator passwordCreator = new PasswordCreator(7);
        passwordCreator.getPasswords().forEach(System.out::println);
    }
}