package com.kahuna.banksystem.model;

public class Current extends Account {

    private float interestRate = 0.01f;

    public Current(long number, double balance) {
        super(number, balance);
    }

    @Override
    public void applyInterest() {
        setBalance(getBalance() + getBalance() * interestRate);
    }

}

