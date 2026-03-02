package org.allTopics;

public class InsufficientBalanceException extends Throwable {
    public InsufficientBalanceException() {
        super("You don't have enough money");
    }

    public void getWithdraw(){

    }
}
