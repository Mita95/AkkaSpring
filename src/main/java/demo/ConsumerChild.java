package demo;

import akka.actor.AbstractActor;

public class ConsumerChild extends AbstractActor {
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(Integer.class, g -> {
                })
                .build();
    }

    @Override
    public void preStart() throws Exception {
        super.preStart();
        System.out.println("Starting actor");
        System.out.println("Context: "+getContext());
        System.out.println("ActorRef: "+getSelf());
        System.out.println("Path: "+getSelf().path());
    }
}
