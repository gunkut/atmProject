package com.example.test.atm;

public class AtmOperation implements Operation {
    AtmBackend atm = new AtmBackend();

    @Override
    public void viewMoney() {
        System.out.println("You have " + atm.getBalance() + "$");
    }

    @Override
    public void withdrawAmount(int withdrawAmount) {
        if (withdrawAmount <= atm.getBalance()){
            if (withdrawAmount % 5 != 0) {
                System.out.println("you can only get banknotes in multiples of five");
            } else if (withdrawAmount < 0){
                System.out.println("Withdraw amount cannot be lower than 0");
            } else {
                atm.reduceBalance(withdrawAmount);
                viewMoney();
            }
        } else {
            System.out.println("Insufficient balance");
        }
}
    @Override
    public void depositAmount(int depositAmount) {
        if (depositAmount % 5 != 0) {
            System.out.println("you can only Insert banknotes in multiples of five");
        } else if(depositAmount < 0) {
            System.out.println("Deposit amount cannot be lower than 0");
        } else {
            atm.addBalance(depositAmount);
            viewMoney();
            System.out.println(depositAmount + "$ deposited successfully");
        }
    }
}























