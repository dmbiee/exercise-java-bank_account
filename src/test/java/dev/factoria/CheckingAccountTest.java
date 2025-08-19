package dev.factoria;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CheckingAccountTest {

    CheckingAccount account;

    @BeforeEach
    void initializeClass() {
        account = new CheckingAccount(5000, 0.1f);
    }

    @Test
    void testDeposit() {

        int amount = 5000;

        float exceptedBalance = 10000f;
        float exceptedOverdraft = 0;

        account.deposit(amount);

        float resultBalance = account.getBalance();
        float resultOverdrafr = account.getOverdraft();

        assertThat(resultBalance, is(equalTo(exceptedBalance)));
        assertThat(resultOverdrafr, is(equalTo(exceptedOverdraft)));
    }

    @Test
    void testDeposit_WhenAmountLesstThenOverdraft() {

        int amount = 6000;
        account.withdraw(amount);

        float exceptedBalance = 0;
        float exceptedOverdraft = 500;

        amount = 500;
        account.deposit(amount);

        float resultBalance = account.getBalance();
        float resultOverdrafr = account.getOverdraft();

        assertThat(resultBalance, is(equalTo(exceptedBalance)));
        assertThat(resultOverdrafr, is(equalTo(exceptedOverdraft)));
    }

    @Test
    void testDeposit_WhenAmountEqualToOverdraft() {

        int amount = 6000;
        account.withdraw(amount);

        float exceptedBalance = 0;
        float exceptedOverdraft = 0;

        amount = 1000;
        account.deposit(amount);

        float resultBalance = account.getBalance();
        float resultOverdrafr = account.getOverdraft();

        assertThat(resultBalance, is(equalTo(exceptedBalance)));
        assertThat(resultOverdrafr, is(equalTo(exceptedOverdraft)));
    }

    @Test
    void testDeposit_WhenAmountMoreThenOverdraft() {

        int amount = 6000;
        account.withdraw(amount);

        float exceptedBalance = 500;
        float exceptedOverdraft = 0;

        amount = 1500;
        account.deposit(amount);

        float resultBalance = account.getBalance();
        float resultOverdrafr = account.getOverdraft();

        assertThat(resultBalance, is(equalTo(exceptedBalance)));
        assertThat(resultOverdrafr, is(equalTo(exceptedOverdraft)));
    }

    @Test
    void testWithdraw() {

        int amount = 4000;
        float exceptedBalance = 1000f;
        float exceptedOverdraft = 0;

        account.withdraw(amount);

        float resultBalance = account.getBalance();
        float resultOverdrafr = account.getOverdraft();

        assertThat(resultBalance, is(equalTo(exceptedBalance)));
        assertThat(resultOverdrafr, is(equalTo(exceptedOverdraft)));
    }

    @Test
    void testWithdraw_WhenExpectedOverdraft() {

        int amount = 6000;
        float exceptedBalance = 0;
        float exceptedOverdraft = 1000f;

        account.withdraw(amount);

        float resultBalance = account.getBalance();
        float resultOverdrafr = account.getOverdraft();

        assertThat(resultBalance, is(equalTo(exceptedBalance)));
        assertThat(resultOverdrafr, is(equalTo(exceptedOverdraft)));
    }

    @Test
    void testGetOverdraft() {

        int amount = 6000;
        float excepted = 1000f;

        account.withdraw(amount);

        float result = account.getOverdraft();

        assertThat(result, is(equalTo(excepted)));
    }

    @Test
    void testPrintInfo() {

        String excepted = "CheckingAccount { balance = 5000,00, monthlyFee = 0,00, annualRate = 0,10, overdraft = 0,00 }";

        String result = account.printInfo();

        assertThat(result, is(equalTo(excepted)));
    }
}
