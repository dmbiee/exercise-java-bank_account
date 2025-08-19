package dev.factoria;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountTest {

    Account account;

    @BeforeEach
    void initializeClass() {
        account = new Account(5000, 0.1f);
    }

    @Test
    void testConstructor_ShouldThrowException_WhenBalanceLessThanZero() {

        String expected = "Balance cannot be less than zero!";

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> new Account(-100, 0.05f));

        String result = ex.getMessage();

        assertThat(result, is(equalTo(expected)));
    }

    @Test
    void testConstructor_ShouldThrowException_WhenAnnualRateLessThanZero() {

        String expected = "Annual rate cannot be less than zero!";

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> new Account(100, -0.05f));

        String result = ex.getMessage();

        assertThat(result, is(equalTo(expected)));
    }

    @Test
    void testConstructor_ShouldThrowException_WhenAnnualRateGreaterThanOne() {

        String expected = "Annual rate cannot be greater than one!";

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> new Account(100, 1.5f));

        String result = ex.getMessage();

        assertThat(result, is(equalTo(expected)));
    }

    @Test
    void testDeposit_ShouldThrowException_WhenDepositAmountLessZero() {

        String expected = "Amount cannot be less than zero!";

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> account.deposit(-50));

        String result = ex.getMessage();

        assertThat(result, is(equalTo(expected)));

    }

    @Test
    void testWithdraw_ShouldThrowException_WhenWithdrawAmountLessZero() {

        String expected = "Amount cannot be less than zero!";

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> account.withdraw(-50));

        String result = ex.getMessage();

        assertThat(result, is(equalTo(expected)));
    }

    @Test
    void testWithdraw_ShouldThrowException_WhenWithdrawAmountGreaterBalance() {

        String expected = "Insufficient balance to withdraw the requested amount!";

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> account.withdraw(150000));

        String result = ex.getMessage();

        assertThat(result, is(equalTo(expected)));
    }

    @Test
    void testMonthlyStatement_ShouldThrowException_WhenMonthlyFeeGreaterBalance() {

        String expected = "Insufficient balance to cover the monthly fee!";

        account.setMonthlyFee(10000);

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> account.monthlyStatement());

        String result = ex
                .getMessage();

        assertThat(result, is(equalTo(expected)));
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
