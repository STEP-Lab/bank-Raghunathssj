import com.bank.Account;
import com.bank.AccountNumber;
import com.bank.InvalidAccountNumberException;
import com.bank.MinimumBalanceException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountTest {

    private Account account;

    @Before
    public void setUp() throws MinimumBalanceException, InvalidAccountNumberException {
        account = new Account(new AccountNumber("1234-1234"), 2000);
    }

    @Test(expected = MinimumBalanceException.class)
    public void checkMinimumBalance() throws MinimumBalanceException, InvalidAccountNumberException {
        new Account(new AccountNumber("1234-1234"),200);
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
