package dev.factoria;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountTest {

    Account account;

    @BeforeEach
    void initializeClass() {
        account = new Account(5000, 0.1f);
    }

    @Test
    void testDeposit() {

        int amount = 500;
        float excepted = 5500f;

        account.deposit(amount);

        float result = account.getBalance();

        assertThat(result, is(equalTo(excepted)));
    }

    @Test
    void testGetAnnualRate() {

        float excepted = 0.1f;
        float result = account.getAnnualRate();

        assertThat(result, is(equalTo(excepted)));
    }

    @Test
    void testGetBalance() {

        float excepted = 5000f;
        float result = account.getBalance();

        assertThat(result, is(equalTo(excepted)));

    }

    @Test
    void testGetDepositCount() {

        int excepted = 1;

        account.deposit(100);

        int result = account.getDepositCount();

        assertThat(result, is(equalTo(excepted)));
    }

    @Test
    void testGetMonthlyFee() {

        float excepted = 0f;
        float result = account.getMonthlyFee();

        assertThat(result, is(equalTo(excepted)));
    }

    @Test
    void testGetWithdrawCount() {

        int excepted = 1;

        account.withdraw(100);

        int result = account.getWithdrawCount();

        assertThat(result, is(equalTo(excepted)));
    }

    @Test
    void testMonthlyStatement() {

        float excepted = 5041.6665F;

        account.monthlyStatement();

        float result = account.getBalance();

        assertThat(result, is(equalTo(excepted)));
    }

    @Test
    void testPrintInfo() {
        String excepted = "Balance: 5000,00, Deposits: 0, Withdrawals: 0, Annual Rate: 0,10, Monthly Fee: 0,00";

        String result = account.printInfo();

        assertThat(result, is(equalTo(excepted)));
    }

    @Test
    void testWithdraw() {

        int amount = 500;
        float excepted = 4500f;

        account.withdraw(amount);

        float result = account.getBalance();

        assertThat(result, is(equalTo(excepted)));
    }
}
