package JavaTest;

import JavaCode.CreateStrings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


public class SpecificationBasedTest {

    private CreateStrings createStrings;

    @BeforeEach
    void setUp(){

        createStrings = new CreateStrings();
    }

    @Test
    @DisplayName("T1 - H1 - nome is NULL or EMPTY")
    void nomeIsNullOrEmpty(){

        assertThatThrownBy(()->{
            createStrings.creaStringa(" ", "111111","000");
        }).isInstanceOf(StringIndexOutOfBoundsException.class);

        assertThatThrownBy(()->{
            createStrings.creaStringa(null, "111111","000");
        }).isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("T2 - H1 - codice is NULL or EMPTY")
    void codiceIsNullOrEmpty(){

        assertThatThrownBy(()->{
            createStrings.creaStringa("panna", "","000");
        }).isInstanceOf(StringIndexOutOfBoundsException.class);

        assertThatThrownBy(()->{
            createStrings.creaStringa("panna", null,"000");
        }).isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("T3 - H1 - reparto is NULL or EMPTY")
    void repartoIsNullOrEmpty(){

        assertThatThrownBy(()->{
            createStrings.creaStringa("panna", "111111","");
        }).isInstanceOf(NumberFormatException.class);

        assertThatThrownBy(()->{
            createStrings.creaStringa("panna", "111111",null);
        }).isInstanceOf(NumberFormatException.class);
    }

    @Test
    @DisplayName("T4 - H1 - nome is less than three")
    void nomeIsLessThanThree(){
        assertThatThrownBy(()->{
            createStrings.creaStringa("pa", "111111","000");
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
    @Test
    @DisplayName("T? - H1 - nome is more than three")
    void nomeIsMoreOrEqualThanThree(){
        Assertions.assertEquals("PAN111111123" ,
                createStrings.creaStringa("pan", "111111","123"));
    }


    @Test
    @DisplayName("T5 - H1 - codice is less than six")
    void codiceIsLessThanSix(){
        assertThatThrownBy(()->{
            createStrings.creaStringa("panna", "11111","000");
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
    @Test
    @DisplayName("T5 - H1 - codice is less than six")
    void codiceIsMoreThanSix(){
        Assertions.assertEquals("PNN123456123" ,
                createStrings.creaStringa("panna", "123456","123"));
    }

    @Test
    @DisplayName("T6 - H1 - reparto is less than three")
    void repartoIsLessThanThree(){
        assertThatThrownBy(()->{
            createStrings.creaStringa("panna", "111111","00");
        }).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("T7 - H1 - reparto is more than three")
    void repartoIsMoreThanThree(){
        assertThatThrownBy(()->{
            createStrings.creaStringa("panna", "111111","1234");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("T7 - H1 - reparto is equal three")
    void repartoIsEqualThree(){
        Assertions.assertEquals("PNN111111123" ,
                createStrings.creaStringa("panna", "111111","123"));

    }

}
