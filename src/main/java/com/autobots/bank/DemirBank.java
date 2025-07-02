package com.autobots.bank;

public class DemirBank extends BankBase {
    private double balance = 0;

    public DemirBank(long accountNumber, long routingNumber) throws Exception {
        super(accountNumber, routingNumber);
        addToAllBankRecords(this);
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        if (amount < 0 || amount > 250000)
            throw new IllegalArgumentException("Invalid amount. Cannot deposit.");
        balance += amount;
    }

    @Override
    public void withDraw(double amount) {
        if (amount < 0 || amount > 100000)
            throw new IllegalArgumentException("Invalid amount. Cannot withdraw.");
        if (amount > balance)
            throw new IllegalArgumentException("Insufficient funds");

        balance -= amount;
    }
}

