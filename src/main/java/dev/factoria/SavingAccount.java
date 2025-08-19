package dev.factoria;

public class SavingAccount extends Account {

    boolean isActive;

    public SavingAccount(float balance, float annualRate) {
        super(balance, annualRate);
        this.isActive = (getBalance() >= 10000);
    }

    private void updateActiveStatus() {
        this.isActive = (getBalance() >= 10000);
    }

    @Override
    public void deposit(float amount) {

        if (!isActive)
            return;

        super.deposit(amount);
    }

    @Override
    public void withdraw(float amount) {
        if (!isActive)
            return;
        super.withdraw(amount);
    }

    @Override
    public void monthlyStatement() {
        float extraFees = 0;

        if (getWithdrawCount() > 4)
            extraFees = getWithdrawCount() - 4;

        setMonthlyFee(extraFees * 1000);

        super.monthlyStatement();

        updateActiveStatus();
    }

    @Override
    public String printInfo() {
        int depositAndWithdrawalCount = getDepositCount() + getWithdrawCount();
        String result = "Account is Active: %b, Balance: %.2f, Deposits and Withdrawals: %d, Annual Rate: %.2f, Monthly Fee: %.2f"
                .formatted(isActive, getBalance(), depositAndWithdrawalCount, getAnnualRate(), getMonthlyFee());
        return result;
    }

}
