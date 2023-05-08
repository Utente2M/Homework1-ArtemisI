package JavaTest;
import JavaCode.CreateStrings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

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
    @CsvSource({
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

            // controlla nome
            if (nome == null || nome.trim().isEmpty()) {
                fail("Expected IllegalArgumentException, but no exception was thrown.");
            }

            // controlla codice
            if (codice == null || codice.trim().isEmpty()) {
                fail("Expected IllegalArgumentException, but no exception was thrown.");
            }

            // controlla reparto
            if (reparto == null || reparto.trim().isEmpty()) {
                fail("Expected NumberFormatException, but no exception was thrown.");
            }

        } catch (NumberFormatException e) {
            // Eccezione attesa quando il parametro reparto non può essere convertito in un numero
            if (reparto == null || !reparto.matches("\\d+")) {
                fail("Unexpected NumberFormatException.");
            }
        } catch (IllegalArgumentException e) {
            // Eccezione attesa quando il parametro nome o codice è nullo o vuoto
            if (nome != null && !nome.trim().isEmpty()) {
                fail("Unexpected IllegalArgumentException.");
            }
            if (codice != null && !codice.trim().isEmpty()) {
                fail("Unexpected IllegalArgumentException.");
            }
        }
    }

}




