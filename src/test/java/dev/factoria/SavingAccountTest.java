package dev.factoria;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    Account account;

    @BeforeEach
    void initializeClass() {
        account = new SavingAccount(5000, 0.1f);
    }

    @Test
    void testDeposit_ShouldDontChangeBalanse_WhenAccountIsntActive() {

        int amount = 500;
        float excepted = 5000f;

        account.deposit(amount);

        float result = account.getBalance();

        assertThat(result, is(equalTo(excepted)));
    }

    @Test
    void testWithdraw_ShouldDontChangeBalanse_WhenAccountIsntActive() {

        int amount = 500;
        float excepted = 5000f;

        account.withdraw(amount);

        float result = account.getBalance();

        assertThat(result, is(equalTo(excepted)));
    }

    @Test
    void testMonthlyStatement() {

        account = new SavingAccount(150000, 0.2f);

        int amount = 500;
        float excepted = 148941.67F;

        account.withdraw(amount);
        account.withdraw(amount);
        account.withdraw(amount);
        account.withdraw(amount);
        account.withdraw(amount);

        account.monthlyStatement();

        float result = account.getBalance();

        assertThat(result, is(equalTo(excepted)));
    }

    @Test
    void testPrintInfo() {

        String excepted = "Account is Active: false, Balance: 5000,00, Deposits and Withdrawals: 0, Annual Rate: 0,10, Monthly Fee: 0,00";

        String result = account.printInfo();

        assertThat(result, is(equalTo(excepted)));

    }

}
