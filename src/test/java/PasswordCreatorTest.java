import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class PasswordCreatorTest {

    @Test
    void generatePasswords() {
        PasswordCreator pwCreator = new PasswordCreator(3);

        pwCreator.generatePasswords(10);

        pwCreator.getPasswords();

    }
}