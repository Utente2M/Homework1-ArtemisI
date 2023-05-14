package JavaTest;

import net.jqwik.api.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PropertyBased {

    @Property
    public void isPalindrome_shouldReturnTrueForPalindromes(@ForAll("palindromes") String s) {
        assertTrue(isPalindrome(s));
    }

    @Property
    public void isPalindrome_shouldReturnFalseForNonPalindromes(@ForAll("nonPalindromes") String s) {
        assertFalse(isPalindrome(s));
    }

    @Provide
    public Arbitrary<String> palindromes() {
        return Arbitraries.strings()
                .withCharRange('a', 'z')
                .ofMinLength(1)
                .filter(s -> isPalindrome(s));
    }

    @Provide
    public Arbitrary<String> nonPalindromes() {
        return Arbitraries.strings()
                .withCharRange('a', 'z')
                .ofMinLength(2)
                .filter(s -> !isPalindrome(s));
    }

    private boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}
