package com.autobots.bank;

public class BankDemo {
    public static void main(String[] args) throws Exception {
        MBank aliyaBank = new MBank(123456789123L, 444444444L);
        aliyaBank.deposit(200000);

        OptimaBank ulugbekOptima = new OptimaBank(123456789122L, 555555555L);
        Bank.transferFunds(aliyaBank, ulugbekOptima, 500);

        DemirBank zinaidaDemir = new DemirBank(123675466312L, 666666666L);
        zinaidaDemir.deposit(60000);
        zinaidaDemir.withDraw(50);


        // Stream API: фильтрация и сумма
        BankBase.allBankRecords.stream()
                .filter(n -> n.getBalance() > 100)
                .forEach(System.out::println);

        double allSum = BankBase.allBankRecords.stream()
                .mapToDouble(Bank::getBalance)
                .sum();
        System.out.println("Total sum: " + allSum);

        // Кол-во клиентов по банкам и группировка
        BankBase.groupByBankNameAndSort();
    }
}

