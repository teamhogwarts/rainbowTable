import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class PasswordCreatorTest {

    @Test
    void generatePasswords() {
        PasswordCreator pwCreator = new PasswordCreator(7);

//        System.out.println(38 / 36 % 36);

        pwCreator.generatePasswords(2_000);

        pwCreator.getPasswords();

    }
}