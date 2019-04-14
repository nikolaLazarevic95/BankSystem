package com.kahuna.banksystem.model;

public class Savings extends Account implements LoanAccount {

    private float interestRate = 0.02f;

    public Savings (long number, double balance) {
        super(number, balance);
    }




    @Override
    public void applyInterest() {
        setBalance(getBalance() + getBalance()*interestRate);
    }

    @Override
    public double getMaxLoanAccount() {
        return getBalance() * 0.40d;
    }
}
