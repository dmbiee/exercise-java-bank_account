package dev.factoria;

public class CheckingAccount extends Account {

    private float overdraft;

    public CheckingAccount(float balance, float annualRate) {
        super(balance, annualRate);
        this.overdraft = 0;
    }

    public float getOverdraft() {
        return overdraft;
    }

    @Override
    public void withdraw(float amount) {
        if (getBalance() < amount) {
            overdraft += (amount - getBalance());
            super.withdraw(getBalance());
            return;
        }
        super.withdraw(amount);
    }

    @Override
    public void deposit(float amount) {
        boolean isOverdrafted = overdraft > 0;

        if (isOverdrafted && overdraft == amount) {
            overdraft = 0;
            return;
        }

        if (isOverdrafted && overdraft > amount) {
            overdraft -= amount;
            return;
        }

        if (isOverdrafted && overdraft < amount) {
            super.deposit(amount - overdraft);
            overdraft = 0;
            return;
        }

        super.deposit(amount);
    }

    @Override
    public String printInfo() {
        String result = "CheckingAccount { balance = %.2f, monthlyFee = %.2f, annualRate = %.2f, overdraft = %.2f }"
                .formatted(getBalance(), getMonthlyFee(), getAnnualRate(), overdraft);
        return result;
    }
}
