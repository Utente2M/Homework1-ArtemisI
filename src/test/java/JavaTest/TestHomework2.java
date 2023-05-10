package JavaTest;

import JavaCode.CombineString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestHomework2 {

    private CombineString myStringTest;

    @BeforeEach
    void setup (){
        myStringTest = new CombineString();
    }


    @ParameterizedTest
    //@NullAndEmptySource
    @CsvSource( {
            "hello, world, Java, Java#world#helloAAAAAAAAAABBBBBBBBBBCCCCCCCCCCDDDDDDDDDDEEEEEEEEEE, 66",
            "foo, bar, baz, baz#bar#fooAAAAAAAAAABBBBBBBBBBCCCCCCCCCCDDDDDDDDDDEEEEEEEEEE, 61",
            "a, b, c, c#b#aAAAAAAAAAABBBBBBBBBBCCCCCCCCCCDDDDDDDDDDEEEEEEEEEE, 55",
            "123, 456, 789, 789#456#123AAAAAAAAAABBBBBBBBBBCCCCCCCCCCDDDDDDDDDDEEEEEEEEEE, 61",
            ",,, ##AAAAAAAAAABBBBBBBBBBCCCCCCCCCCDDDDDDDDDDEEEEEEEEEE , 52 ",
            "ITPS BARI,\\n,\t, ##ITPS BARIAAAAAAAAAABBBBBBBBBBCCCCCCCCCCDDDDDDDDDDEEEEEEEEEE , 61 ",
            "@,!,& &, & &#!#@AAAAAAAAAABBBBBBBBBBCCCCCCCCCCDDDDDDDDDDEEEEEEEEEE , 57 ",
            "ITPS,\\n,\t, ##ITPSAAAAAAAAAABBBBBBBBBBCCCCCCCCCCDDDDDDDDDDEEEEEEEEEE , 56 ",
            "\t,\t,\t,##AAAAAAAAAABBBBBBBBBBCCCCCCCCCCDDDDDDDDDDEEEEEEEEEE , 52 ",
            "\\n,\\n,\\n,##AAAAAAAAAABBBBBBBBBBCCCCCCCCCCDDDDDDDDDDEEEEEEEEEE , 52 " ,
            "null,null,null, ##AAAAAAAAAABBBBBBBBBBCCCCCCCCCCDDDDDDDDDDEEEEEEEEEE , 52 ",
            "null,,, ##AAAAAAAAAABBBBBBBBBBCCCCCCCCCCDDDDDDDDDDEEEEEEEEEE , 52 ",
            ",null,, ##AAAAAAAAAABBBBBBBBBBCCCCCCCCCCDDDDDDDDDDEEEEEEEEEE , 52 ",
            ",,null, ##AAAAAAAAAABBBBBBBBBBCCCCCCCCCCDDDDDDDDDDEEEEEEEEEE , 52 ",
            "12345678901234567890123456789012345678901234567890, abcdefghijklmnopqrstuvwxyz, Hello World!, Hello World!#abcdefghijklmnopqrstuvwxyz#12345678901234567890123456789012345678901234567890AAAAAAAAAABBBBBBBBBBCCCCCCCCCCDDDDDDDDDDEEEEEEEEEE, 140"
    })
    void testCombineStrings(String s1, String s2, String s3, String expected, int expectedLength) {

        String actual = myStringTest.combineStrings(s1, s2, s3);
        assertEquals(expected, actual);
        assertEquals(expectedLength, actual.length());
    }

}
