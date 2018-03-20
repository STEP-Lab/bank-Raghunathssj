import com.bank.Account;
import com.bank.InvalidAccountNumberException;
import com.bank.MinimumBalanceException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class AccountTest {

    private Account account;

    @Before
    public void setUp() throws MinimumBalanceException, InvalidAccountNumberException {
        account = new Account("1234-1234", 2000);
    }

    @Test
    public void getBalance() {
        assertEquals(account.getBalance(), 2000, 0);
    }

    @Test
    public void getAccountNumber() {
        assertThat(account.getAccountNumber(),is("1234-1234"));
    }

    @Test(expected = MinimumBalanceException.class)
    public void checkMinimumBalance() throws MinimumBalanceException, InvalidAccountNumberException {
        new Account("1234-1234",200);
    }

    @Test(expected = InvalidAccountNumberException.class)
    public void checkAccountNumber() throws InvalidAccountNumberException, MinimumBalanceException {
        new Account("1234",1000);
    }

    @Test
    public void withdraw() throws MinimumBalanceException {
        assertEquals(account.withdraw(200),1800,0);
    }

    @Test(expected =MinimumBalanceException.class)
    public void InsufficientFundsException() throws MinimumBalanceException {
        account.withdraw(2100);
    }

    @Test
    public void deposit() {
        assertEquals(account.deposit(1000),3000,0);
    }
}
