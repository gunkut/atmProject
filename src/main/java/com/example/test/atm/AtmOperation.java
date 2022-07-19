package com.example.test.atm;


public class AtmOperation implements Operation {
    AtmBackend atm = new AtmBackend();
    UserBackend user = new UserBackend();

    public boolean isOperation;
    public String operation_type;
    @Override
    public void viewMoney() {
        System.out.println("You have " + atm.getBalance() + "$");
    }

    @Override
    public void withdrawAmount(int withdrawAmount) {
        operation_type = "withdraw";

        if (withdrawAmount <= atm.getBalance()){
            if (withdrawAmount % 5 != 0) {
                System.out.println("you can only get banknotes in multiples of five");
                isOperation = false;

            } else if (withdrawAmount < 0){
                System.out.println("Withdraw amount cannot be lower than 0");
                isOperation = false;

            } else {
                isOperation = true;
                atm.reduceBalance(withdrawAmount);
            }
        } else {
            System.out.println("Insufficient balance");
        }
        user.userDatabaseOp(isOperation, operation_type, withdrawAmount);
}
    @Override
    public void depositAmount(int depositAmount) {
        operation_type = "deposit";

        if (depositAmount % 5 != 0) {
            isOperation = false;
            System.out.println("you can only Insert banknotes in multiples of five");
        } else if(depositAmount < 0) {
            isOperation = false;
            System.out.println("Deposit amount cannot be lower than 0");
        } else {
            isOperation = true;
            atm.addBalance(depositAmount);
            System.out.println(depositAmount + "$ deposited successfully");
        }
        user.userDatabaseOp(isOperation, operation_type, depositAmount);
    }
}























