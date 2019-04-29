package demo;

import java.util.concurrent.TimeUnit;

public class BankAccount {
    private int bal = 1000;
    String name = "";

    BankAccount(String name) {
        this.name = name;
    }

    public void withdraw(int amount) throws InterruptedException {
        synchronized (this) {
            if (bal - amount >= 0) {
                System.out.println(this.name);

                bal = bal - amount;
                System.out.println(bal);
            } else System.out.println("Insufficient funds");
        }
    }

    public void deposit(int amount) {
        synchronized (this) {
            if (amount > 0)
                bal += amount;
            System.out.println(bal);
        }
    }

    public void transfer(BankAccount b, int amount) throws InterruptedException {
        synchronized (this) {
            System.out.println("Locked: "+this.name + amount);
            TimeUnit.SECONDS.sleep(0);
            synchronized (b) {
                this.withdraw(amount);
                b.deposit(amount);
            }
        }
    }

}
