package dev.factoria;

public class Account {

    private float balance;
    private int depositCount;
    private int withdrawCount;
    private float annualRate;
    private float monthlyFee;

    public Account(float balance, float annualRate) {
        if (balance < 0)
            throw new IllegalArgumentException("Balance cannot be less than zero!");
        if (annualRate < 0)
            throw new IllegalArgumentException("Annual rate cannot be less than zero!");
        if (annualRate > 1)
            throw new IllegalArgumentException("Annual rate cannot be greater than one!");

        this.balance = balance;
        this.annualRate = annualRate;
        this.depositCount = 0;
        this.withdrawCount = 0;
        this.monthlyFee = 0;
    }

    public void deposit(float amount) {
        if (amount < 0)
            throw new IllegalArgumentException("Amount cannot be less than zero!");
        balance += amount;
        depositCount++;
    }

    public void withdraw(float amount) {
        if (amount < 0)
            throw new IllegalArgumentException("Amount cannot be less than zero!");
        if (balance < amount)
            throw new IllegalArgumentException("Insufficient balance to withdraw the requested amount!");
        balance -= amount;
        withdrawCount++;
    }

    public void monthlyStatement() {
        if (balance < monthlyFee)
            throw new IllegalArgumentException("Insufficient balance to cover the monthly fee!");

        balance -= monthlyFee;
        calculateMonthlyInterest();

    }

    public String printInfo() {
        String result = "Balance: %.2f, Deposits: %d, Withdrawals: %d, Annual Rate: %.2f, Monthly Fee: %.2f"
                .formatted(balance, depositCount, withdrawCount, annualRate, monthlyFee);
        return result;
    }

    private void calculateMonthlyInterest() {
        final int MONTH_IN_YEAR = 12;
        float monthlyInterest = (annualRate / MONTH_IN_YEAR) * balance;
        balance += monthlyInterest;
    }

    public void setMonthlyFee(float monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    public float getBalance() {
        return balance;
    }

    public int getDepositCount() {
        return depositCount;
    }

    public int getWithdrawCount() {
        return withdrawCount;
    }

    public float getAnnualRate() {
        return annualRate;
    }

    public float getMonthlyFee() {
        return monthlyFee;
    }

}
