package com.example.test;

import javax.persistence.*;

@Entity
@Table (name = "atm_table")
public class Atm {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;
    @Column (name = "two_hundred")
    private int two_hundred;
    @Column (name = "one_hundred")
    private int one_hundred;
    @Column (name = "fifty")
    private int fifty;
    @Column (name = "twenty")
    private int twenty;
    @Column (name = "ten")
    private int ten;
    @Column (name = "five")
    private int five;

    public Atm() {
    }

    public Atm(int two_hundred, int one_hundred, int fifty, int twenty, int ten, int five) {
        this.two_hundred = two_hundred;
        this.one_hundred = one_hundred;
        this.fifty = fifty;
        this.twenty = twenty;
        this.ten = ten;
        this.five = five;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTwo_hundred() {
        return two_hundred;
    }

    public void setTwo_hundred(int two_hundred) {
        this.two_hundred = two_hundred;
    }

    public int getOne_hundred() {
        return one_hundred;
    }

    public void setOne_hundred(int one_hundred) {
        this.one_hundred = one_hundred;
    }

    public int getFifty() {
        return fifty;
    }

    public void setFifty(int fifty) {
        this.fifty = fifty;
    }

    public int getTwenty() {
        return twenty;
    }

    public void setTwenty(int twenty) {
        this.twenty = twenty;
    }

    public int getTen() {
        return ten;
    }

    public void setTen(int ten) {
        this.ten = ten;
    }

    public int getFive() {
        return five;
    }

    public void setFive(int five) {
        this.five = five;
    }

    @Override
    public String toString() {
        return "Atm{" +
                "id=" + id +
                ", two_hundred=" + two_hundred +
                ", one_hundred=" + one_hundred +
                ", fifty=" + fifty +
                ", twenty=" + twenty +
                ", ten=" + ten +
                ", five=" + five +
                '}';
    }
}
