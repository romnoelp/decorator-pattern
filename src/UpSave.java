public class UpSave implements BankAccountDecorator {
    private BankAccount bankAccount;

    public UpSave(BankAccount bankAccount) {
        try {
            if (bankAccount == null) throw new NullPointerException("BankAccount cannot be null.");
            this.bankAccount = bankAccount;
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public String showAccountType() {
        return "UpSave";
    }

    @Override
    public double getInterestRate() {
        return 0.04; // 4% interest rate
    }

    @Override
    public double getBalance() {
        return bankAccount.getBalance();
    }

    @Override
    public String showBenefits() {
        try {
            return bankAccount.showBenefits() + " + With Insurance";
        } catch (Exception e) {
            return "Error retrieving benefits.";
        }
    }

    @Override
    public double computeBalanceWithInterest() {
        try {
            return getBalance() + (getBalance() * getInterestRate());
        } catch (Exception e) {
            System.out.println("Error computing UpSave balance: " + e.getMessage());
            return getBalance();
        }
    }

    @Override
    public String showInfo() {
        return bankAccount.showInfo();
    }
}
