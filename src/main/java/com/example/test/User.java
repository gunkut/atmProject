package com.example.test;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "user_table")
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    @Column (name = "id")
    private int id;
    @Column (name = "user_id")
    private int user_id;
    @Column (name = "date")
    private Date date;
    @Column (name = "operation_type")
    private String operation_type;
    @Column (name = "log_message")
    private String log_message;
    @Column (name = "log_message_id")
    private int log_message_id;

    public User() {
    }

    public User(int id, int user_id, Date date, String operation_type, String log_message, int log_message_id) {
        this.id = id;
        this.user_id = user_id;
        this.date = date;
        this.operation_type = operation_type;
        this.log_message = log_message;
        this.log_message_id = log_message_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOperation_type() {
        return operation_type;
    }

    public void setOperation_type(String operation_type) {
        this.operation_type = operation_type;
    }

    public String getLog_message() {
        return log_message;
    }

    public void setLog_message(String log_message) {
        this.log_message = log_message;
    }

    public int getLog_message_id() {
        return log_message_id;
    }

    public void setLog_message_id(int log_message_id) {
        this.log_message_id = log_message_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", date=" + date +
                ", operation_type='" + operation_type + '\'' +
                ", log_message='" + log_message + '\'' +
                ", log_message_id=" + log_message_id +
                '}';
    }
}

