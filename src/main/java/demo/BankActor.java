package demo;

import akka.actor.AbstractActor;

import java.util.Optional;

public class BankActor extends AbstractActor{

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(Withdraw.class, g -> {
                    //withdraw
                })
                .match(Integer.class, g -> {
                    //withdraw
                })
                .match(String.class, g -> {
                    if(g.equalsIgnoreCase("exception")){
                        throw new Exception();
                    }
                })
                .build();
    }

    @Override
    public void preRestart(Throwable reason, Optional<Object> message) throws Exception {
        System.out.println("Restarting actor");
    }
}