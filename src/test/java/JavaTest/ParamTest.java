package JavaTest;

import JavaCode.CreateStrings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.fail;


public class ParamTest {

    private CreateStrings createStrings;
    @BeforeEach
    void setUp(){

        createStrings = new CreateStrings();
    }

    @ParameterizedTest
    @NullAndEmptySource // Testa sia con il valore nullo che con la stringa vuota
    @ValueSource(strings = {" ", "  ", "\t", "\n"}) // Testa con spazi bianchi
    void nomeIsNullOrEmpty(String nome) {
        try {
            createStrings.creaStringa(nome, "111111", "000");
            if (nome == null) {
                fail("Expected NullPointerException, but no exception was thrown.");
            } else {
                fail("Expected StringIndexOutOfBoundsException, but no exception was thrown.");
            }
        } catch (NullPointerException e) {
            // Eccezione attesa quando il parametro nome è nullo
            if (nome != null) {
                fail("Unexpected NullPointerException.");
            }
        } catch (StringIndexOutOfBoundsException e) {
            // Eccezione attesa quando il parametro nome è una stringa vuota o contiene solo spazi bianchi
            if (nome == null) {
                fail("Unexpected StringIndexOutOfBoundsException.");
            }
        }
    }


    @ParameterizedTest
    @NullAndEmptySource // Testa sia con il valore nullo che con la stringa vuota
    @ValueSource(strings = {" ", "  ", "\t", "\n"}) // Testa con spazi bianchi
    void codiceIsNullOrEmpty(String codice) {
        try {
            createStrings.creaStringa("panna", codice, "000");
            if (codice == null) {
                fail("Expected NullPointerException, but no exception was thrown.");
            } else {
                fail("Expected StringIndexOutOfBoundsException, but no exception was thrown.");
            }
        } catch (NullPointerException e) {
            // Eccezione attesa quando il parametro codice è nullo
            if (codice != null) {
                fail("Unexpected NullPointerException.");
            }
        } catch (StringIndexOutOfBoundsException e) {
            // Eccezione attesa quando il parametro codice è una stringa vuota o contiene solo spazi bianchi
            if (codice == null) {
                fail("Unexpected StringIndexOutOfBoundsException.");
            }
        }
    }



    // Aggiungi il test parametrizzato per il tuo caso
    @ParameterizedTest
    @ValueSource(strings = {" ", "  ", "\t", "\n"}) // Testa con spazi bianchi
    void repartoIsNullOrEmpty(String reparto) {
        assertThatThrownBy(() -> {
            createStrings.creaStringa("panna", "111111", reparto);
        }).isInstanceOf(NumberFormatException.class);
    }

    @ParameterizedTest
    @MethodSource("invalidRepartoValues")
    void repartoIsLessThanThree(String reparto) {
        assertThatThrownBy(() -> {
            createStrings.creaStringa("panna", "111111", reparto);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    // Metodo utilizzato in " repartoIsLessThanThree " per generare i valori di test per il tuo caso
    static Stream<String> invalidRepartoValues() {
        return Stream.of("", "1", "12");
    }



    @ParameterizedTest
    @DisplayName("T10 - H1 - Homework#1 Parameterized Test")
    @CsvSource({
            ",," , //Test con tutti i campi nulli
            "null,," , //Test con tutti i campi nulli
            ", 111111, 000", // Test con nome nullo
            " , 111111, 000", // Test con nome vuoto
            "\t, 111111, 000", // Test con nome contenente solo tabulazioni
            "\n, 111111, 000", // Test con nome contenente solo ritorni a capo
            "John, 111111, 000", // Test con nome valido
            "Jane, , 000", // Test con codice nullo
            "Alice, 111111, ", // Test con descrizione vuota
            "Bob, 111111, 000", // Test con tutti i parametri validi
            "Pasta, 010206 , 111", // Test realistico 1
            "Riso, 213654 , 222", // Test realistico 2
            "Latte, 345998 , 330" // Test realistico 3


    })

    void testCreateStringa(String nome, String codice, String reparto) {
        try {
            createStrings.creaStringa(nome, codice, reparto);
            /*
            Tramite la chiamata a fail, forziamo il fallimento del test, passando immediatamente la chiamata
            al blocco catch.
            All'interno del blocco catch, andiamo a controllare se effettivamente l'exeption attesa sia
            valida ( test superato ) oppure no ( test fallito )
             */
            // controlla nome
            if (nome == null || nome.isBlank() || Pattern.matches(".*\\d+.*", nome)) {
                fail("Expected NullPointerException, but no exception was thrown.");
            }
            // controlla codice
            if (codice == null || codice.isBlank() || Pattern.matches(".*[a-zA-Z].*", codice)) {
                fail("Expected NullPointerException, but no exception was thrown.");
            }
            // controlla reparto
            if (reparto == null || reparto.isBlank() || Pattern.matches(".*[a-zA-Z].*", reparto)) {
                fail("Expected NumberFormatException, but no exception was thrown.");
            }
        } catch (NumberFormatException e) {
            if (reparto!= null){
                fail("Unexpected NumberFormatException.");
            }
        } catch (NullPointerException e){
            if (nome != null && codice !=null  ) {
                fail("Unexpected NullPointerException.");
            }
        }
    }

}




