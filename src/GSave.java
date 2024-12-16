public class GSave implements BankAccountDecorator {
    private BankAccount bankAccount;

    public GSave(BankAccount bankAccount) {
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
        return "GSave";
    }

    @Override
    public double getInterestRate() {
        return 0.025;
    }

    @Override
    public double getBalance() {
        return bankAccount.getBalance();
    }

    @Override
    public String showBenefits() {
        try {
            return bankAccount.showBenefits() + " + GCash Transfer";
        } catch (Exception e) {
            return "Error retrieving benefits.";
        }
    }

    @Override
    public double computeBalanceWithInterest() {
        try {
            return getBalance() + (getBalance() * getInterestRate());
        } catch (Exception e) {
            System.out.println("Error computing GSave balance: " + e.getMessage());
            return getBalance();
        }
    }

    @Override
    public String showInfo() {
        return bankAccount.showInfo();
    }
}
