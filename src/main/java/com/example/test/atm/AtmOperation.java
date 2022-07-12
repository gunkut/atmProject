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
            atm.updateBalance(withdrawAmount, "-");
            viewMoney();
            System.out.println("Here is your " + withdrawAmount + "$");
        } else {
            System.out.println("Insufficient balance");
        }
}
    @Override
    public void depositAmount(int depositAmount) {
        atm.updateBalance(depositAmount, "+");
        viewMoney();
        System.out.println(depositAmount + "$ deposited successfully");
    }
}























