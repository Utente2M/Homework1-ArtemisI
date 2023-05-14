package JavaTest;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import net.jqwik.api.*;
import java.util.stream.*;

public class PropertyBased {

    @Property
    public void isPalindrome_shouldReturnTrueForPalindromes(@ForAll("palindromes") String s) {
        assertTrue(StringUtils.isPalindrome(s));
    }

    @Property
    public void isPalindrome_shouldReturnFalseForNonPalindromes(@ForAll("nonPalindromes") String s) {
        assertFalse(StringUtils.isPalindrome(s));
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
