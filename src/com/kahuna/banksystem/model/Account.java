package com.kahuna.banksystem.model;

public abstract class Account {

    long number;
    double balance;

    public Account (long number, double balance) {
        this.number = number;
        this.balance = balance;
    }

    public void deposit (double amount) {
        this.balance += amount;
    }

    public void withdraw (double amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
        }
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public long getNumber() {
        return this.number;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance(){
        return this.balance;
    }

    public abstract void applyInterest();


}
