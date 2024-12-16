public class SavingsAccount implements BankAccount {
    private String accountNumber;
    private String accountName;
    private double balance;

    public void setAccountNumber(int accountNumber) {
        try {
            if (accountNumber <= 0) throw new IllegalArgumentException("Account number must be positive.");
            this.accountNumber = String.valueOf(accountNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void setAccountName(String accountName) {
        try {
            if (accountName == null || accountName.trim().isEmpty())
                throw new IllegalArgumentException("Account name cannot be empty.");
            this.accountName = accountName;
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void setBalance(double balance) {
        try {
            if (balance < 0) throw new IllegalArgumentException("Balance cannot be negative.");
            this.balance = balance;
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public String showAccountType() {
        return "Savings Account";
    }

    @Override
    public double getInterestRate() {
        return 0.01; // 1% interest rate
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public String showBenefits() {
        return "Standard Savings Account";
    }

    @Override
    public double computeBalanceWithInterest() {
        try {
            return this.balance + (this.balance * getInterestRate());
        } catch (Exception e) {
            System.out.println("Error computing balance: " + e.getMessage());
            return this.balance;
        }
    }

    @Override
    public String showInfo() {
        try {
            return "Account Number: " + accountNumber +
                    "\nAccount Name: " + accountName +
                    "\nBalance: " + balance;
        } catch (Exception e) {
            return "Error displaying account info.";
        }
    }
}
