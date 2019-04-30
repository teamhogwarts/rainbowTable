import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Programmieraufgabe Rainbow-Table
 * krysi FS 2019
 *
 * @author Pascal Andermatt, Benjamin Brodwolf, Nadia Kramer
 */
public class HashFunction {

    private MessageDigest md5;

    public void initializeMd5() throws NoSuchAlgorithmException {
        this.md5 = MessageDigest.getInstance("MD5");
    }

    public BigInteger executeHashFunctionMD5(String s) {
        if (this.md5 != null) {
            this.md5.update(s.getBytes(), 0, s.length());
            return new BigInteger(1, this.md5.digest());
        } else {
            System.out.println("Fehler: md5 is null !");
            return null;
        }
    }
}
