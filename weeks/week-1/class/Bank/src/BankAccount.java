/**
 * @author Anna Scribner
 * @version April 9, 2025
 * <p>
 * Represent a bank account in the bank system
 */

public class BankAccount {

    /**
     * customer name
     */
    private String owner;
    /**
     * identification number
     */
    private final String accountId;
    /**
     * bank balance; should never be negative
     */
    private double balance;

    /**
     * Constructor
     *
     * @param owner          costumer name
     * @param accountId      Identification number
     * @param initialBalance account balance; must not be negative
     */
    public BankAccount(String owner, String accountId, double initialBalance) {
        if (accountId == null || accountId.isEmpty()) {
            throw new IllegalArgumentException("Account ID of the owner cannot be null/empty");
        }
        Utilities.verifyNonNegative("balance", initialBalance);
        deposit(initialBalance);
        setOwner(owner);
        this.accountId = accountId;
    }

    /**
     * Retrieves the customer name
     *
     * @return name
     */
    public String getOwner() {
        return owner;
    }


    /**
     * Retrieves the identification number
     *
     * @return identification
     */
    public String getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setOwner(String owner) {
        if (owner == null || owner.isEmpty()) {
            throw new IllegalArgumentException("Name of the owner cannot be null/empty");
        }
        this.owner = owner;
    }

    public double deposit(double amount) {
        Utilities.verifyNonNegative("amount", amount);
        return balance += amount;
    }

    public double withdraw(double amount) {
        Utilities.verifyNonNegative("amount", amount);
        if (amount > balance) {
            throw new IllegalArgumentException("You cannot withdraw more than the current balance");
        }
        return balance -= amount;
    }

    @Override
    public String toString() {
        return String.format("BankAccount ID: %s, " +
                "owner: %s, " +
                "balance: $%.2f", accountId, owner, balance);
    }


}
