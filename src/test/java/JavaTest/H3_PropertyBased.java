package JavaTest;

import JavaCode.Palindrome;
import net.jqwik.api.*;
import net.jqwik.api.statistics.Histogram;
import net.jqwik.api.statistics.Statistics;
import net.jqwik.api.statistics.StatisticsReport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static JavaCode.Palindrome.isPalindrome;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class H3_PropertyBased {

    Palindrome palindrome;
    @BeforeEach
    void setUp(){

        palindrome = new Palindrome();
    }


    //Proprietà Palindroma: La stringa, se letta al contrario, rimane invariata.
    @Property
    @StatisticsReport(format = Histogram.class)
    //@Report(Reporting.GENERATED)
    void palindromeProperty(@ForAll("randomStrings") String s ) {
        String reversed = new StringBuilder(s).reverse().toString();
        String concatenated = s + reversed;
        assertTrue(isPalindrome(concatenated), "La stringa '" + concatenated + "' dovrebbe essere palindroma");
        Statistics.label("\nIs Palindrome " ).collect(concatenated.length());
        Statistics.label("\n"+concatenated).collect(concatenated.length());

    }



    @Property
    @StatisticsReport(format = Histogram.class)
    void isNotPalindromeProperty(@ForAll("randomStrings") String s, @ForAll("randomChars") char extra_char) {
        Assume.that(s.length() > 2);  // Assicura che la stringa abbia almeno 3 caratteri
        Assume.that(!isPalindrome(s));  // Assicura che la stringa iniziale non sia già palindroma

        String reversed = new StringBuilder(s).reverse().toString();
        String try_palindrome = s + reversed;
        if (Palindrome.isPalindrome(try_palindrome)){
            int length = s.length();
            int randomIndex;
            do {
                randomIndex = Arbitraries.integers().between(0, length - 1).sample();  // Genera un indice casuale tra 1 e length - 2
            } while (randomIndex == length / 2);  // Esclude il centro della stringa

            String modified = try_palindrome.substring(0, randomIndex) + extra_char + try_palindrome.substring(randomIndex);  // Inserisce la lettera nella posizione randomica
            if (Palindrome.isPalindrome(modified)){
                modified = modified + "zzzzz";
            }
            assertFalse(isPalindrome(modified), "La stringa '" + modified + "' non è palindroma, the char is:" + extra_char );
            Statistics.label("\nIs not Palindrome " ).collect(modified.length());
            Statistics.label("\n"+modified + "the char is:" + extra_char).collect(modified.length());

        }


    }

    //Proprietà Case-Insensivity: I palindromi non sono sensibili a maiuscole e minuscole.
    @Property
    @StatisticsReport(format = Histogram.class)
    void caseInsensitivityProperty(@ForAll("randomStrings") String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        String concatenated = s + reversed.toUpperCase();
        assertTrue(Palindrome.isPalindrome(concatenated), "La stringa '" + concatenated + "' dovrebbe essere palindroma");
        Statistics.label("\nInsensitivity Property " ).collect(concatenated.length());
        Statistics.label("\n"+concatenated).collect(concatenated.length());
    }

    //Proprietà Spazi vuoti: Nei palindromi gli spazi vuoti non sono considerati.
    @Property
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
        Statistics.label("\nEmpty Space " ).collect(modified.length());
        Statistics.label("\n"+modified).collect(modified.length());
    }

    //Proprietà Punteggiatura: Nei palindromi la punteggiatura non viene considerata.
    @Property
    @StatisticsReport(format = Histogram.class)
    void puntIsPalindromeProperty(@ForAll("randomStrings") String s , @ForAll("punctuation") char extra_char) {
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
        Statistics.label("\npunctuation Is Not Palindrome" ).collect(modified.length());
        Statistics.label("\n"+modified).collect(modified.length());
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



    //EXTRA TEST 4 100% COVERAGE
    @Test
    void emptryIsNotPalindrome () {
        assertFalse(isPalindrome("") ,"La stringa vuota non è palindroma" );
    }
    @Test
    void nullIsNotPalindrome () {
        assertFalse(isPalindrome(null), "La stringa vuota non è palindroma");
    }

}
