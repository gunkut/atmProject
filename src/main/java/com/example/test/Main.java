package com.example.test;

import com.example.test.atm.AtmOperation;
import com.example.test.atm.Operation;

import java.util.Scanner;


public class Main {
    public static void main(String args[]) {
        Operation operation = new AtmOperation();
        /*int cardNumber = 111;
        int cardPassword = 123;*/

        Scanner atmUser = new Scanner(System.in);
        /*while(true) {
            System.out.print("Enter your card number:");
            int userCardNumber = atmUser.nextInt();

            System.out.print("Enter your card password:");
            int userCardPassword = atmUser.nextInt();

            if(cardNumber == userCardNumber && cardPassword == userCardPassword) {
                System.out.println("Welcome to atm GG");
                break;
            } else {
                System.out.println("Invalid card number or password, please try again");
            }
        }*/
        while(true) {
            System.out.println("1 - Wallet");
            System.out.println("2 - Withdraw Money");
            System.out.println("3 - Deposit Money");
            System.out.println("4 - Exit");


            System.out.println("Select request:");
            int userSelection = atmUser.nextInt();

            switch(userSelection) {
                case 1:
                    operation.viewMoney();
                    break;
                case 2:
                    System.out.println("Enter amount:");
                    int withdrawAmount = atmUser.nextInt();
                    if (withdrawAmount != 0 && withdrawAmount % 5 == 0) {
                        operation.withdrawAmount(withdrawAmount);
                    } else {
                        System.out.println("Invalid Request, Please Try Again");
                    }
                    break;
                case 3:
                    System.out.println("Enter amount:");
                    int depositAmount = atmUser.nextInt();
                    operation.depositAmount(depositAmount);
                    break;
                case 4:
                    System.out.println("See you later!!");
                    System.exit(0);
                default:
                    System.out.println("Invalid request");
                    break;
            }
        }
    }
}
