package JavaTest;

import JavaCode.Palindrome;
import net.jqwik.api.*;
import net.jqwik.api.statistics.Histogram;
import net.jqwik.api.statistics.StatisticsReport;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;
import java.util.List;

import static JavaCode.Palindrome.isPalindrome;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PropertyBased {

    Palindrome palindrome;
    @BeforeEach
    void setUp(){

        palindrome = new Palindrome();
    }


    //Proprietà Palindroma: La stringa, se letta al contrario, rimane invariata.
    @Property
    @Report(Reporting.GENERATED)
    @StatisticsReport(format = Histogram.class)
    void palindromeProperty(@ForAll("randomStrings") String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        String concatenated = s + reversed;
        assertTrue(isPalindrome(concatenated), "La stringa '" + concatenated + "' dovrebbe essere palindroma");
        //Statistics.collect(randomStrings());
    }

    @Property
    @Report(Reporting.GENERATED)
    @StatisticsReport(format = Histogram.class)
    void isNotPalindromeProperty(@ForAll("randomStrings") String s, @ForAll("randomChars") char extra_char) {
        Assume.that(s.length() > 2);  // Assicura che la stringa abbia almeno 3 caratteri
        Assume.that(!isPalindrome(s));  // Assicura che la stringa iniziale non sia già palindroma

        int length = s.length();
        int randomIndex;
        do {
            randomIndex = Arbitraries.integers().between(1, length - 2).sample();  // Genera un indice casuale tra 1 e length - 2
        } while (randomIndex == length / 2);  // Esclude il centro della stringa

        String modified = s.substring(0, randomIndex) + extra_char + s.substring(randomIndex);  // Inserisce la lettera nella posizione randomica

        assertFalse(isPalindrome(modified), "La stringa '" + modified + "' non è palindroma");
    }

    //Proprietà Case-Insensivity: I palindromi non sono sensibili a maiuscole e minuscole.
    @Property
    void caseInsensitivityProperty(@ForAll("randomStrings") String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        String concatenated = s + reversed;
        String uppercaseConcatenated = concatenated.toUpperCase();
        assertTrue(Palindrome.isPalindrome(uppercaseConcatenated), "La stringa '" + uppercaseConcatenated + "' dovrebbe essere palindroma");
    }

    //Proprietà Spazi vuoti: Nei palindromi gli spazi vuoti non sono considerati.
    @Property
    @Report(Reporting.GENERATED)
    @StatisticsReport(format = Histogram.class)
    void emptySpacePalindromeProperty(@ForAll("randomStrings") String s) {
        Assume.that(s.length() > 2);  // Assicura che la stringa abbia almeno 3 caratteri


        int length = s.length();
        int randomIndex;
        do {
            randomIndex = Arbitraries.integers().between(1, length - 2).sample();  // Genera un indice casuale tra 1 e length - 2
        } while (randomIndex == length / 2);  // Esclude il centro della stringa

        String reversed = new StringBuilder(s).reverse().toString();
        String concatenated = s + reversed;
        String modified = concatenated.substring(0, randomIndex) + " " + concatenated.substring(randomIndex);  // Inserisce la lettera nella posizione randomica

        assertTrue(isPalindrome(modified), "La stringa '" + modified + "' non è palindroma");
    }

    //Proprietà Punteggiatura: Nei palindromi la punteggiatura non viene considerata.
    @Property
    @Report(Reporting.GENERATED)
    @StatisticsReport(format = Histogram.class)
    void puntIsNotPalindromeProperty(@ForAll("randomStrings") String s , @ForAll("punctuation") char extra_char) {
        Assume.that(s.length() > 2);  // Assicura che la stringa abbia almeno 3 caratteri


        int length = s.length();
        int randomIndex;
        do {
            randomIndex = Arbitraries.integers().between(1, length - 2).sample();  // Genera un indice casuale tra 1 e length - 2
        } while (randomIndex == length / 2);  // Esclude il centro della stringa

        String reversed = new StringBuilder(s).reverse().toString();
        String concatenated = s + reversed;
        String modified = concatenated.substring(0, randomIndex) + extra_char + concatenated.substring(randomIndex);  // Inserisce la lettera nella posizione randomica

        assertTrue(isPalindrome(modified), "La stringa '" + modified + "' non è palindroma");
    }


    @Provide
    Arbitrary<String> randomStrings() {
        return Arbitraries.strings().withCharRange('a', 'z').ofMinLength(4);
    }

    @Provide
    Arbitrary<Character> randomChars() {
        return Arbitraries.chars().range('a', 'z');
    }

    @Provide
    Arbitrary<Character> punctuation() {
        List<Character> punctuationChars = Arrays.asList('!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+',
                ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_', '`', '{',
                '|', '}', '~');
        return Arbitraries.of(punctuationChars.toArray(new Character[0]));
    }
}
