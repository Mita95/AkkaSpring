package demo;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;

//@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Task {
    public Task() {
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Task(Integer balance) {
        this.balance = balance;
        System.out.println("task constructor");
    }

    @PostConstruct
    public void init() {
        System.out.println("task post construct");
    }

    Integer balance;

    Integer withdraw() {
        balance -= 100;
        return balance;
    }

}
