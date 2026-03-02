package org.allTopics;

public class BankAccount {

    private double balance;

    BankAccount(double amt){
        this.balance = amt;
    }

    public double withdraw(double amt) throws InsufficientBalanceException {
        if(amt>balance){
            throw new InsufficientBalanceException();
        }
        balance-=amt;
        return balance;
    }

    public static void main(String[] args){
        BankAccount ba1 = new BankAccount(1000);
        try{
            ba1.withdraw(2000);
        }catch (InsufficientBalanceException e1){
            // Don't know what to do.
        }
        System.out.println("Program is completed!");


    }
}
