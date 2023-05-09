package JavaTest;

import JavaCode.Main;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class MainTest {

    @Test
    void main_should_print_expected_output() {
        //line.separator è il corrispettivo di un \n. è stato utilizzato perchè assertEqual non li riconosce come uguali
        String expectedOutput = "MRCABCD12001" + System.getProperty("line.separator") +
                "001#ABCD12#MarcoAAAAAAAAAABBBBBBBBBBCCCCCCCCCCDDDDDDDDDDEEEEEEEEEE" + System.getProperty("line.separator");



        //controlla cosa sia stato stampato a schermo
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        String[] args = {};
        Main.main(args);

        assertEquals(expectedOutput, outputStream.toString());
    }
}

