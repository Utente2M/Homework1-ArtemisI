package JavaTest;
import JavaCode.CreateStrings;
import org.junit.jupiter.api.*;

public class ExploratoryTests {

    private CreateStrings createStrings;

    @BeforeEach
    void setUp(){

        createStrings = new CreateStrings();
    }

    @Test
    @DisplayName("Create String With Three Consonants")
    void createStringsWithThreeConsonants() {

        Assertions.assertEquals("PNN111111000", createStrings.creaStringa("panna", "111111","000"));
    }

    @Test
    @DisplayName("Create String With Less Than Three Consonants")
    void createStringsWithLessThanThreeConsonants() {

        Assertions.assertEquals("PAN111111000", createStrings.creaStringa("pane", "111111","000"));

    }

    //Takes oly the first six numbers anyway but with less than six numbers, throws an exception
    @Test
    @DisplayName("Create String With More Than Six Code Numbers")
    void createStringsWithMoreThanSixCodeNumbers() {

        Assertions.assertEquals("PNN111111000", createStrings.creaStringa("panna", "1111110","000"));
    }

    //Test aggiuntivo per completare tutti i branch possibili ( a e i o u )
    @Test
    @DisplayName("New Test for complete Branch Coverage")
    void exampleToFinishBranchCoverage() {

        Assertions.assertEquals("PNN111111000", createStrings.creaStringa("paeiounna", "1111110","000"));
    }
}
