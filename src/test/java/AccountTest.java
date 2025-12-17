
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.Queue;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.test.Account;

public class AccountTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void givenDepositsAndWithdrawalWhenPrintStatementThen() {

        Queue<LocalDate> dates = new ArrayDeque<>();
        dates.add(LocalDate.of(2012, 1, 10));
        dates.add(LocalDate.of(2012, 1, 13));
        dates.add(LocalDate.of(2012, 1, 14));

        Account account = new Account(dates::poll);

        account.deposit(1000);
        account.deposit(2000);
        account.withdraw(500);

        account.printStatement();

        String expected
                = """
Date || Amount || Balance
14/01/2012 || -500 || 2500
13/01/2012 || 2000 || 3000
10/01/2012 || 1000 || 1000
""";


        assertEquals(expected.replaceAll("\\s+", " ").trim(), output.toString().replaceAll("\\s+", " ").trim());
    }

}
