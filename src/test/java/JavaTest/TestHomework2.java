package JavaTest;

import JavaCode.CombineString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestHomework2 {

    private CombineString myStringTest;

    @BeforeEach
    void setup (){
        myStringTest = new CombineString();
    }


    @ParameterizedTest
    @CsvSource({
            "hello, world, Java, Java#world#helloAAAAAAAAAABBBBBBBBBBCCCCCCCCCCDDDDDDDDDDEEEEEEEEEE, 53",
            "foo, bar, baz, baz#bar#fooAAAAAAAAAABBBBBBBBBBCCCCCCCCCCDDDDDDDDDDEEEEEEEEEE, 48",
            "a, b, c, c#b#aAAAAAAAAAABBBBBBBBBBCCCCCCCCCCDDDDDDDDDDEEEEEEEEEE, 43",
            "123, 456, 789, 789#456#123AAAAAAAAAABBBBBBBBBBCCCCCCCCCCDDDDDDDDDDEEEEEEEEEE, 53"
    })
    void testCombineStrings(String s1, String s2, String s3, String expected, int expectedLength) {
       // CombineString combiner = new CombineString();
        String actual = myStringTest.combineStrings(s1, s2, s3);
        assertEquals(expected, actual);
        assertEquals(expectedLength, actual.length());
    }

}
