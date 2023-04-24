package JavaTest;

import JavaCode.CreateStrings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;

public class SpecificationBasedTests {

    private CreateStrings createStrings;

    @BeforeEach
    void setUp(){

        createStrings = new CreateStrings();
    }

    @Test
    void nomeIsNullOrEmpty(){

        assertThatThrownBy(()->{
            createStrings.creaStringa(" ", "111111","000");
        }).isInstanceOf(StringIndexOutOfBoundsException.class);

        assertThatThrownBy(()->{
            createStrings.creaStringa(null, "111111","000");
        }).isInstanceOf(NullPointerException.class);
    }

    @Test
    void codiceIsNullOrEmpty(){

        assertThatThrownBy(()->{
            createStrings.creaStringa("panna", "","000");
        }).isInstanceOf(StringIndexOutOfBoundsException.class);

        assertThatThrownBy(()->{
            createStrings.creaStringa("panna", null,"000");
        }).isInstanceOf(NullPointerException.class);
    }

    @Test
    void repartoIsNullOrEmpty(){

        assertThatThrownBy(()->{
            createStrings.creaStringa("panna", "111111","");
        }).isInstanceOf(NumberFormatException.class);

        assertThatThrownBy(()->{
            createStrings.creaStringa("panna", "111111",null);
        }).isInstanceOf(NumberFormatException.class);
    }

    @Test
    void nomeIsLessThanThree(){
        assertThatThrownBy(()->{
            createStrings.creaStringa("pa", "111111","000");
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }

    @Test
    void codiceIsLessThanSix(){
        assertThatThrownBy(()->{
            createStrings.creaStringa("panna", "11111","000");
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }

    @Test

    void repartoIsLessThanThree(){
        assertThatThrownBy(()->{
            createStrings.creaStringa("panna", "111111","00");
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
