package JUnitExample;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    void testDeposit() {
        BankAccount account = new BankAccount();
        account.deposit(100.0);
        assertEquals(100.0, account.getBalance());
    }

    @Test
    void testWithdraw() {
        BankAccount account = new BankAccount();
        account.deposit(200.0);
        account.withdraw(50.0);
        assertEquals(150.0, account.getBalance());
    }

    @Test
    void testWithdrawInsufficientFunds() {
        BankAccount account = new BankAccount();
        account.deposit(50.0);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(100.0));
    }

    @Test
    void testDepositNegativeAmount() {
        BankAccount account = new BankAccount();
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-20.0));
    }
}
