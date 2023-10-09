package org.example.demo;

public class Balance {

    @BalanceValidator
    private Integer balance;

    public Balance(Integer balance) {
        this.balance = balance;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}
