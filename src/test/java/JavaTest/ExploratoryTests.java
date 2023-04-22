package JavaTest;

import JavaCode.CreateStrings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
