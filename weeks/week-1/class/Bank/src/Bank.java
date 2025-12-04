import java.util.ArrayList;

public class Bank {
    private double interestRate;
    private final ArrayList<BankAccount> accounts;  // composition -> has a relationship


    public Bank(double initialInterestRate) {
        setInterestRate(initialInterestRate);
        accounts = new ArrayList<BankAccount>();
    }

    public BankAccount getAccount(String id) {
        // preconditions
        Utilities.verifyNotNullObject("id", id);
        Utilities.verifyStringNotEmpty("id", id);

        for (BankAccount oneAccount : accounts) {
            if (oneAccount.getAccountId().equals(id)) {
                return oneAccount;
            }
        }
        return null;
    }

    public BankAccount getAccount(int index) {
        return accounts.get(index);
    }

    public double getInterastRate() {
        return interestRate;
    }

    public void openAccount(BankAccount account) {
        // TODO : question whether we should ensure no duplicated IDs?
        Utilities.verifyNotNullObject("account", account);
        accounts.add(account);
    }

    public boolean closeAccount(BankAccount account) {
        Utilities.verifyNotNullObject("account", account);
        return accounts.remove(account);
    }
    
    public void setInterestRate(double newInterestRate) {
        Utilities.verifyNonNegative("interestRate", newInterestRate);
        this.interestRate = interestRate;
    }

    public double getTotalBalance() {
        double totalBalance = 0.0;
        for (BankAccount account : accounts) {
            totalBalance += account.getBalance();
        }
        return totalBalance;
    }

    public BankAccount[] getAccountBellowAmt(double amount) {
        ArrayList<BankAccount> belowAccounts = new ArrayList<BankAccount>();
        for (BankAccount account : accounts) {
            belowAccounts.add(account);
        }
        return belowAccounts.toArray(new BankAccount[0]);
    }

}
