package com.kahuna.banksystem.ui;

import com.kahuna.banksystem.model.Account;
import com.kahuna.banksystem.model.Credit;
import com.kahuna.banksystem.model.Current;
import com.kahuna.banksystem.model.Savings;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private ArrayList<Account> accounts = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("Banking System");
            System.out.println("1. Add Account");
            System.out.println("2. View Accounts");
            System.out.println("3. Apply Interest");
            System.out.println("4. Exit");

            int choice = sc.nextInt();
            switch (choice) {
                case 1: addAccount() ; break;
                case 2: viewAccounts(); break;
                case 3: applyInterest(); break;
                case 4:  System.exit(0); break;
                default: System.out.println("Invalid choice!"); break;

            }

        }

    }

    private void addAccount() {
        boolean validNumber = false;
        long number = 0;

        do {
            System.out.print("Account Number");
            number = sc.nextLong();
            validNumber = isNumberAvailable (number);
            if (!validNumber) {
                System.out.println("Sorry, number not available!");
            }
        } while (!validNumber);

        System.out.print("Initial Balance> ");
        double balance = sc.nextDouble();
        sc.nextLine();


        System.out.print("Account Type [S, Cu, Cr]> ");
        String acType = sc.nextLine().toLowerCase();

        switch (acType) {
            case "s": accounts.add(new Savings(number, balance)); break;
            case "cu": accounts.add(new Current(number, balance)); break;
            case "cr":
                System.out.print("Credit Limit> ");
                double limit = sc.nextDouble();
                accounts.add(new Credit(number, balance, limit));
                break;

        }
    }

    private boolean isNumberAvailable(long number) {
        for (Account a : accounts) {
            if (a.getNumber() == number) {
                return false;
            }
        }

        return true;
    }

    private void viewAccounts() {
        System.out.println("Series\t\tAccount\t\tBalance\t\tType");
        int accNo = 1;
        for (Account a : accounts) {
            String accType = "S";
            if (a instanceof Current) {
                accType = "Cu";
            } else if (a instanceof Credit) {
                accType = "Cr";
            }

            System.out.println(accNo + "\t\t\t" + a.getNumber() + "\t\t\t" + a.getBalance() + "\t\t\t" + accType);
            accNo++;
        }
        sc.nextLine();
        System.out.println("[c]ontinue, [e]dit");
        String choice = sc.nextLine();
        if (choice.equalsIgnoreCase("e")) {
            editAccount();

        }
    }

    private void editAccount() {
        System.out.print("Series Number> ");
        int num = sc.nextInt();
        while (true) {
            System.out.println("---");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Return");
            int choice = sc.nextInt();
            switch (choice) {
                case 1: withdraw(num-1); break;
                case 2: deposit(num-1); break;
                case 3: return;
                default: System.out.println("Invalid Option"); break;
            }
        }
    }

    private void withdraw(int series) {
        System.out.println("Withdrawal: ");
        System.out.println("Current Balance: " + accounts.get(series).getBalance());
        System.out.print("Amount> ");
        double amnount = sc.nextDouble();
        accounts.get(series).withdraw(amnount);
    }


    private void deposit(int series) {
        System.out.println("Deposit: ");
        System.out.println("Current Balance: " + accounts.get(series).getBalance());
        System.out.print("Amount> ");
        double amount = sc.nextDouble();
        accounts.get(series).deposit(amount);
    }

    private void applyInterest() {


    }


    public static void main(String[] args) {
        Main m  = new Main();
        m.start();
    }
}
