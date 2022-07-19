package com.example.test.atm;

import com.example.test.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class UserBackend {
    SessionFactory factory;
    Session session;

    public void connectDatabase(){
        factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(com.example.test.User.class).buildSessionFactory();
        session = factory.getCurrentSession();
        session.beginTransaction();
        System.out.println("Done!!!!!!!!!!!!!!!!!!!");
    }


    public Date date() {
        return new Date();
    }

    public String log_message(boolean correct){
        if (correct) {
            return "successful";
        }
        return "unsuccessful";
    }

    public int log_message_id(boolean correct){
        if (correct) {
            return 1;
        }
        return 0;
    }

    public int amount(int moneyAmount){
        return moneyAmount;
    }

    public String operation(String operation_type){
        return operation_type;
    }

    public void userDatabaseOp(boolean isOperation, String operation_type, int moneyAmount){
        try{
            connectDatabase();
            User user = session.get(User.class, 1);
            user.setDate(date());
            user.setOperation_type(operation(operation_type));
            user.setAmount(amount(moneyAmount));
            user.setLog_message(log_message(isOperation));
            user.setLog_message_id(log_message_id(isOperation));
            user.setOperation_type(operation(operation_type));

            session.getTransaction().commit();
        } catch (Exception e){
            System.out.println(e);
        } finally {
            factory.close();
        }
    }
}
