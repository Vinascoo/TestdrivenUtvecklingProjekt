package se.reky.hakan;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IOHandlerTest {

   private IOHandler ioHandler;

    private IOHandler ioHandlerSetUp (String dataForScanner) {
        Scanner scanner = new Scanner(dataForScanner);

        return new IOHandler(scanner);
    }

    @DisplayName("")
    @Test
    public void testNextLine (){
        String userInput = "Testing input input";

        ioHandler = ioHandlerSetUp(userInput);

        assertEquals("Testing input input", ioHandler.nextLine());
    }

    @DisplayName("")
    @Test
    public void testHasNextInt (){
        ioHandler = ioHandlerSetUp("1111");

       assertTrue(ioHandler.hasNextInt());
    }
}
