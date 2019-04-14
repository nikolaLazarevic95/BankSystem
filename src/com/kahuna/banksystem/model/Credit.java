package com.kahuna.banksystem.model;

public class Credit extends Account {

    private double creditLimit;



    public Credit(long number, double balance, double creditLimit) {
        super(number, balance);
        this.creditLimit = creditLimit;
    }


    @Override
    public void applyInterest() {
        throw new UnsupportedOperationException("Credit accounts do not have interest!");
    }

    @Override
    public void withdraw(double amount) {
        if (getBalance() - amount >= creditLimit) {
            setBalance(getBalance() - amount);
        } else {
            System.out.println("Overdrawn!");

        }
    }

}
