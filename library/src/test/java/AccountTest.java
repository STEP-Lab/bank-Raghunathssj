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

    @Test
    public void getBalance() {
        assertEquals(account.getBalance(),2000,0);
    }

    @Test(expected = MinimumBalanceException.class)
    public void mustThrowExceptionIfMinimumBalanceIsNotPresent() throws MinimumBalanceException, InvalidAccountNumberException {
        new Account(new AccountNumber("1234-1234"),200);
    }

    @Test
    public void debitAmountFromAccount() throws MinimumBalanceException {
        assertEquals(account.debit(200),1800,0);
    }

    @Test(expected =MinimumBalanceException.class)
    public void mustThrowMinimumBalanceExceptionIfMinimumBalanceIsNotPresent() throws MinimumBalanceException {
        account.debit(2100);
    }

    @Test
    public void creditAmountFromAccount() {
        assertEquals(account.credit(1000),3000,0);
    }
}
