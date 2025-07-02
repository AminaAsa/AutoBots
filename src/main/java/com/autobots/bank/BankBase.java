package com.autobots.bank;

import java.util.*;

public abstract class BankBase implements Bank {
    private String bankName;
    private long accountNumber;
    private long routingNumber;

    public static Set<BankBase> allBankRecords = new HashSet<>();
    // public static Map<String, Set<BankBase>> bankGroupedRecords = new HashMap<>();

    public static Set<BankBase> sortedBase = new HashSet<>();

    public String getBankName() {
        return bankName;
    }

    public static void groupByBankNameAndSort() {
        sortedBase.stream()
                .sorted((b1, b2) -> b1.getBankName().compareTo(b2.getBankName()))
                .forEach(bank -> System.out.printf(
                        "BankName: %s, AccountNumber: %d, RoutingNumber: %d\n",
                        bank.getBankName(), bank.getAccountNumber(), bank.getRoutingNumber()
                ));
    }

    public BankBase(long accountNumber, long routingNumber) {
        if (Long.toString(accountNumber).length() != 12)
            throw new IllegalArgumentException("Account number must be 12 digits");
        if (Long.toString(routingNumber).length() != 9)
            throw new IllegalArgumentException("Routing number must be 9 digits");
        this.accountNumber = accountNumber;
        this.routingNumber = routingNumber;
    }

    public static void addToAllBankRecords(BankBase bank) throws Exception {
        for (BankBase b : allBankRecords) {
            if (b.getAccountNumber() == bank.getAccountNumber())
                throw new Exception("Duplicate account number");
            if (b.getRoutingNumber() == bank.getRoutingNumber())
                throw new Exception("Duplicate routing number");
        }
        allBankRecords.add(bank);

    }


    public long getAccountNumber() { return accountNumber; }
    public long getRoutingNumber() { return routingNumber; }
    public void setAccountNumber(long accountNumber) { this.accountNumber = accountNumber; }
    public void setRoutingNumber(long routingNumber) { this.routingNumber = routingNumber; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankBase bank = (BankBase) o;
        return accountNumber == bank.accountNumber && routingNumber == bank.routingNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, routingNumber);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [account=" + accountNumber + ", routing=" + routingNumber + ", balance=" + getBalance() + "]";
    }
}

