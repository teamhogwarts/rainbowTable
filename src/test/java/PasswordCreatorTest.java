import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class PasswordCreatorTest {

    @Test
    void generatePasswords() {
        PasswordCreator pwCreator = new PasswordCreator(4);

        System.out.println(35<<35);

        pwCreator.generatePasswords(50_000);

        pwCreator.getPasswords();

    }
}