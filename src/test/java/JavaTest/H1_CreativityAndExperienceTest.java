package JavaTest;

import JavaCode.CreateStrings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class H1_CreativityAndExperienceTest {

    private CreateStrings createStrings;

    @BeforeEach
    void setUp(){

        createStrings = new CreateStrings();
    }

    //Creativity Test
    //EXTRA TEST
    @Test
    @DisplayName("T20 - H1 - nome Extra Creativity")
    void nomeExtraCreativity(){

        assertThatThrownBy(()->{
            createStrings.creaStringa("ab", "123456","123");
        }).isInstanceOf(StringIndexOutOfBoundsException.class);

        assertThatThrownBy(()->{
            createStrings.creaStringa("123456", "123456","123");
        }).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("T21 - H1 - nome Extra Creativity")
    void codiceExtraCreativity(){

        assertThatThrownBy(()->{
            createStrings.creaStringa("panna", "abc","123");
        }).isInstanceOf(StringIndexOutOfBoundsException.class);

        assertThatThrownBy(()->{
            createStrings.creaStringa("panna", "abcdef","123");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("T22 - H1 - nome Extra Creativity")
    void repartoExtraCreativity(){

        assertThatThrownBy(()->{
            createStrings.creaStringa("panna", "123456","1");
        }).isInstanceOf(NumberFormatException.class);

        assertThatThrownBy(()->{
            createStrings.creaStringa("panna", "123456","abc");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
