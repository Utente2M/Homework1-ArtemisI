package JavaTest;

import JavaCode.CreateStrings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StructuralTest {

    private CreateStrings createStrings;

    @BeforeEach
    void setUp(){

        createStrings = new CreateStrings();
    }

    //Test aggiuntivo per completare tutti i branch possibili ( a e i o u )
    @Test
    @DisplayName("ST1 - H1 - New Test for complete Branch Coverage")
    void exampleToFinishBranchCoverage() {

        Assertions.assertEquals("PNN111111000", createStrings.creaStringa("paeiounna", "1111110","000"));
    }
}
