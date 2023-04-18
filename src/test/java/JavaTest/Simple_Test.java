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

        Assertions.assertEquals("PNN111111000", createStrings.creaStringa("panna", "111111","000"));
    }

    @Test
    @DisplayName("CreateString2")
    void simpleCase2() {

        CreateStrings createStrings = new CreateStrings();

        Assertions.assertEquals("PCC222222000", createStrings.creaStringa("paaaaacaaccaa", "222222","000"));
    }

    @Test
    @DisplayName("CreateString3")
    void simpleCase3() {

        CreateStrings createStrings = new CreateStrings();

        Assertions.assertEquals("PAA333333000", createStrings.creaStringa("paaaaacaaaaaaaa", "333333","000"));
    }
}
