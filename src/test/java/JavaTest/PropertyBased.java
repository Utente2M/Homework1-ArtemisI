package JavaTest;

import JavaCode.CreateStrings;
import JavaCode.Palindrome;
import net.jqwik.api.*;
import org.junit.jupiter.api.BeforeEach;

import static JavaCode.Palindrome.isPalindrome;
import static org.junit.jupiter.api.Assertions.*;

public class PropertyBased {

    Palindrome palindrome;
    @BeforeEach
    void setUp(){

         palindrome = new Palindrome();
    }

    @Property
    void testPalindromeProperty(@ForAll("palindromeStrings") String palindrome) {
        assertTrue(Palindrome.isPalindrome(palindrome));
    }

    @Property
    void testLengthyProperty(@ForAll("strings") String s) {
        assertEquals(s.length() > 0, Palindrome.isPalindrome(s));
    }

    @Property
    void testCaseInsensitivityProperty(@ForAll("strings") String s) {
        String lowerCase = s.toLowerCase();
        assertEquals(Palindrome.isPalindrome(s), Palindrome.isPalindrome(lowerCase));
    }

    @Property
    void testWhitespacesProperty(@ForAll("stringsWithWhitespaces") String s) {
        String withoutWhitespaces = s.replaceAll("\\s+", "");
        assertEquals(Palindrome.isPalindrome(s), Palindrome.isPalindrome(withoutWhitespaces));
    }

    @Property
    void testPunctuationProperty(@ForAll("stringsWithPunctuation") String s) {
        String withoutPunctuation = s.replaceAll("\\p{Punct}", "");
        assertEquals(Palindrome.isPalindrome(s), Palindrome.isPalindrome(withoutPunctuation));
    }

    @Provide
    Arbitrary<String> strings() {
        return Arbitraries.strings().alpha().ofMinLength(1);
    }

    @Provide
    Arbitrary<String> palindromeStrings() {
        return strings().filter(Palindrome::isPalindrome);
    }

    @Provide
    Arbitrary<String> stringsWithWhitespaces() {
        return strings().map(s -> s + " " + s);
    }

    @Provide
    Arbitrary<String> stringsWithPunctuation() {
        return strings().map(s -> s + "! " + s);
    }


}
