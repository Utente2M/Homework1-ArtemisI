package JavaTest;
import JavaCode.CreateStrings;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ExploratoryTest {

    private CreateStrings createStrings;

    @BeforeEach
    void setUp(){

        createStrings = new CreateStrings();
    }

    @Test
    @DisplayName("E1 - H1 - Create String With Three Consonants")
    void createStringsWithThreeConsonants() {

        Assertions.assertEquals("PNN111111000", createStrings.creaStringa("panna", "111111","000"));
    }

    @Test
    @DisplayName("E2 - H1 - Create String With Less Than Three Consonants")
    void createStringsWithLessThanThreeConsonants() {

        Assertions.assertEquals("PAN111111000", createStrings.creaStringa("pane", "111111","000"));

    }

    //Takes oly the first six numbers anyway but with less than six numbers, throws an exception
    @Test
    @DisplayName("E3 - H1 - Create String With More Than Six Code Numbers")
    void createStringsWithMoreThanSixCodeNumbers() {

        Assertions.assertEquals("PNN111111000", createStrings.creaStringa("panna", "1111110","000"));
    }





}
