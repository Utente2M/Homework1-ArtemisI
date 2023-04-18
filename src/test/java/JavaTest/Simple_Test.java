package JavaTest;

import JavaCode.CreateStrings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Simple_Test {

    @Test
    @DisplayName("CreateString")
    void simpleCase() {

        CreateStrings createStrings = new CreateStrings();

        Assertions.assertEquals("PNN123456LTT", createStrings.creaStringa("panna", "123456","ltt"));
    }

    @Test
    @DisplayName("CreateString2")
    void simpleCase2() {

        CreateStrings createStrings = new CreateStrings();

        Assertions.assertEquals("PCC123456LTT", createStrings.creaStringa("paaaaacaaccaa", "123456","ltt"));
    }

    @Test
    @DisplayName("CreateString3")
    void simpleCase3() {

        CreateStrings createStrings = new CreateStrings();

        Assertions.assertEquals("PAC123456LTT", createStrings.creaStringa("paaaaacaaaaaaaa", "123456","ltt"));
    }
}
