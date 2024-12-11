import org.junit.Assert;
import org.junit.Test;

public class AccountTest {
    private double epsilon = 1e-6;

    @Test
    public void accountCannotHaveNegativeWithdraw() {
        Account account = new Account(-20);
        Assert.assertEquals(false, account.withdraw(-20));
    }
  
    @Test
    public void accountCannotHaveNegativeDeposit() {
        Account account = new Account(-20);
        Assert.assertEquals(false, account.deposit(-20));
    }
  
    @Test
    public void accountDeposit() {
        Account account = new Account(-20);
        Assert.assertEquals(true, account.deposit(20));
    }
  
    @Test
    public void accountWithdraw() {
        Account account = new Account(-20);
        account.deposit(40);
        Assert.assertEquals(true, account.withdraw(20));
    }
  
    @Test
    public void accountOverdraftLimit() {
        Account account = new Account(-20);
        Assert.assertFalse(account.withdraw(50));
    }
  
    @Test
    public void accountBalanceAfterDeposit() {
        Account account = new Account(-20);
        Assert.assertTrue(account.deposit(40));
        Assert.assertEquals(40d, account.getBalance(), epsilon);
    }
  
    @Test
    public void accountBalanceAfterWithdraw() {
        Account account = new Account(-20);
        Assert.assertTrue(account.deposit(40));
        Assert.assertTrue(account.withdraw(20));
        Assert.assertEquals(20d, account.getBalance(), epsilon);
    }
}