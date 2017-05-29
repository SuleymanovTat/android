package ru.suleymanovtat.androidapplication.model;

import java.util.Date;

public class Transactions {

    private String name;
    private int sum;
    private Date date;

    public Transactions(String name, int sum, Date date) {
        this.name = name;
        this.sum = sum;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "name='" + name + '\'' +
                ", sum=" + sum +
                ", date=" + date +
                '}';
    }
}
