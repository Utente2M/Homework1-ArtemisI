package JavaTest;
import JavaCode.CreateStrings;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ExploratoryTests {

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

    //Test aggiuntivo per completare tutti i branch possibili ( a e i o u )
    @Test
    @DisplayName("ST1 - H1 - New Test for complete Branch Coverage")
    void exampleToFinishBranchCoverage() {

        Assertions.assertEquals("PNN111111000", createStrings.creaStringa("paeiounna", "1111110","000"));
    }

    //Creativity Test
    //EXTRA TEST
    @Test
    @DisplayName("T21 - H1 - nome Extra Creativity")
    void nomeExtraCreativity(){

        assertThatThrownBy(()->{
            createStrings.creaStringa("ab", "123456","123");
        }).isInstanceOf(StringIndexOutOfBoundsException.class);

        assertThatThrownBy(()->{
            createStrings.creaStringa("123456", "123456","123");
        }).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("T22 - H1 - nome Extra Creativity")
    void codiceExtraCreativity(){

        assertThatThrownBy(()->{
            createStrings.creaStringa("panna", "abc","123");
        }).isInstanceOf(StringIndexOutOfBoundsException.class);

        assertThatThrownBy(()->{
            createStrings.creaStringa("panna", "abcdef","123");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("T23 - H1 - nome Extra Creativity")
    void repartoExtraCreativity(){

        assertThatThrownBy(()->{
            createStrings.creaStringa("panna", "123456","1");
        }).isInstanceOf(NumberFormatException.class);


        assertThatThrownBy(()->{
            createStrings.creaStringa("panna", "123456","abc");
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
