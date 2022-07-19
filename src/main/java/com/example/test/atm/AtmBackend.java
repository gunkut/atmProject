package com.example.test.atm;

import com.example.test.Atm;
import com.example.test.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;


public class AtmBackend {

    public int twoHundredAmount;
    public int oneHundredAmount;
    public int fiftyAmount;
    public int twentyAmount;
    public int tenAmount;
    public int fiveAmount;
    private double balance;
    SessionFactory factory;
    Session session;

    public AtmBackend() {

    }

    public void connectDatabase(){
        factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(com.example.test.Atm.class).buildSessionFactory();
        session = factory.getCurrentSession();
        session.beginTransaction();
    }
    public double getBalance() {
        int totalMoney = 0;
        try {
            connectDatabase();
            Atm atm = session.get(Atm.class, 1);
            totalMoney = (atm.getTwo_hundred() * 200 + atm.getOne_hundred() * 100 + atm.getFifty() * 50 + atm.getTwenty() * 20 + atm.getTen() * 10 + atm.getFive() * 5);
            this.printEachMoney(atm);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            factory.close();
        }
        return totalMoney;
    }
    public void printEachMoney(Atm atm){
        System.out.println("200 dollar:" + atm.getTwo_hundred());
        System.out.println("100 dollar:" + atm.getOne_hundred());
        System.out.println("50 dollar:" + atm.getFifty());
        System.out.println("20 dollar:" + atm.getTwenty());
        System.out.println("10 dollar:" + atm.getTen());
        System.out.println("5 dollar:" + atm.getFive());
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }



    public int decreaseMoney (int money, int currency, int currencyAmount) {

        money -= currency * currencyAmount;
        return money;
    }

    public int parseMoney(int money, int currency, int amountInDatabase, String op){
        int amount = money / currency;
        if (op.equals("-"))
        {
            return checkDatabase(amount, amountInDatabase);
        }

        return amount;
    }


    public int checkDatabase(int moneyAmount, int amountInDatabase) {
        if (amountInDatabase < moneyAmount) {
            while (moneyAmount > 0) {
                moneyAmount -= 1;
                if (amountInDatabase == moneyAmount){
                    return moneyAmount;
                }
            }
        }
        return moneyAmount;
    }

    public void reduceBalance(int money){

        try {
            connectDatabase();
            Atm atm = session.get(Atm.class, 1);


            System.out.println("requested money is available");

            twoHundredAmount = parseMoney(money, 200, atm.getTwo_hundred(), "-");
            atm.setTwo_hundred(atm.getTwo_hundred() - twoHundredAmount);
            money = decreaseMoney(money, 200, twoHundredAmount);

            oneHundredAmount = parseMoney(money, 100, atm.getOne_hundred(), "-");
            atm.setOne_hundred(atm.getOne_hundred() - oneHundredAmount);
            money = decreaseMoney(money, 100, oneHundredAmount);

            fiftyAmount = parseMoney(money, 50, atm.getFifty(), "-");
            atm.setFifty(atm.getFifty() - fiftyAmount);
            money = decreaseMoney(money, 50, fiftyAmount);

            twentyAmount = parseMoney(money, 20, atm.getTwenty(), "-");
            atm.setTwenty(atm.getTwenty() - twentyAmount);
            money = decreaseMoney(money, 20, twentyAmount);

            tenAmount = parseMoney(money, 10, atm.getTen(), "-");
            atm.setTen(atm.getTen() - tenAmount);
            money = decreaseMoney(money, 10, tenAmount);

            fiveAmount = parseMoney(money, 5, atm.getFive(), "-");
            atm.setFive(atm.getFive() - fiveAmount);
            money = decreaseMoney(money, 5, fiveAmount);

            session.getTransaction().commit();
            System.out.println("Done!!");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            factory.close();
        }
    }
    public void addBalance(int money){

        try {
            connectDatabase();
            Atm atm = session.get(Atm.class, 1);

            twoHundredAmount = parseMoney(money, 200, atm.getTwo_hundred(), "+");
            money = decreaseMoney(money, 200, twoHundredAmount);
            atm.setTwo_hundred(atm.getTwo_hundred() + twoHundredAmount);

            oneHundredAmount = parseMoney(money, 100, atm.getOne_hundred(), "+");
            money = decreaseMoney(money, 100, oneHundredAmount);
            atm.setOne_hundred(atm.getOne_hundred() + oneHundredAmount);

            fiftyAmount = parseMoney(money, 50, atm.getFifty(), "+");
            money = decreaseMoney(money, 50, fiftyAmount);
            atm.setFifty(atm.getFifty() + fiftyAmount);

            twentyAmount = parseMoney(money, 20, atm.getFifty(), "+");
            money = decreaseMoney(money, 20, twentyAmount);
            atm.setTwenty(atm.getTwenty() + twentyAmount);

            tenAmount = parseMoney(money, 10, atm.getTen(), "+");
            money = decreaseMoney(money, 10, tenAmount);
            atm.setTen(atm.getTen() + tenAmount);

            fiveAmount = parseMoney(money, 5, atm.getFive(), "+");
            money = decreaseMoney(money, 5, fiveAmount);
            atm.setFive(atm.getFive() + fiveAmount);
            money = 0;

            session.getTransaction().commit();
            System.out.println("Done!!");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            factory.close();
        }
    }
}