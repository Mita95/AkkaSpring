package demo;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class Consumer extends AbstractActor{
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(Withdraw.class, g -> {
                    //withdraw
                })
                .match(Integer.class, g -> {
                    TimeUnit.MILLISECONDS.sleep(2);
                    System.out.println("Consuming: "+g);
                })
                .match(String.class, g -> {
                    if(g.equalsIgnoreCase("exception")){
                        throw new Exception();
                    }
                    if(g.equalsIgnoreCase("createChild")){
                        ActorRef actorRef = getContext().actorOf(Props.create(ConsumerChild.class),"consumerChild1");
                    }
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

    @Override
    public void preRestart(Throwable reason, Optional<Object> message) throws Exception {
        super.preRestart(reason,message);
        System.out.println("Restarting actor");
    }

    @Override
    public void postRestart(Throwable reason) throws Exception {
        super.postRestart(reason);
        System.out.println("Restarted actor");
    }

    @Override
    public void postStop() throws Exception {
        super.postStop();
        System.out.println("Stopping actor");
    }
}
