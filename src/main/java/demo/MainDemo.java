package demo;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

import java.util.concurrent.TimeUnit;

public class MainDemo {
//    public static void main(String[] args){
//        BankAccount a = new BankAccount("A");
//        BankAccount b = new BankAccount("B");
//
//        Thread t1 = new Thread(() -> {
//            try {
////                a.withdraw(500);
//                a.transfer(b,500);
//                //Thread.sleep(0);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        Thread t2 = new Thread(() -> {
//            try {
////                b.withdraw(600);
//                b.transfer(a,600);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        new Thread(t1).start();
//        new Thread(t2).start();
//
//    }

    public static void main(String[] args) throws InterruptedException {
        ActorSystem actorSystem = ActorSystem.create("akka-spring-demo");
//        ActorRef bankAcc1 = actorSystem.actorOf(Props.create(BankActor.class),"bankAcc1");
//        ActorRef bankAcc2 = actorSystem.actorOf(Props.create(BankActor.class),"bankAcc2");
//        bankAcc1.tell(new Withdraw(500),ActorRef.noSender());
//        bankAcc1.tell(new Withdraw(500),ActorRef.noSender());
////        bankAcc2.tell(new Withdraw(600),ActorRef.noSender());
//        bankAcc1.tell("exception", ActorRef.noSender());
//        bankAcc1.tell(new Withdraw(500),ActorRef.noSender());
//        bankAcc1.tell(new Withdraw(500),ActorRef.noSender());

        ActorRef consumer1 = actorSystem.actorOf(Props.create(Consumer.class), "consumer1");
//        for (int i = 0; i < 10; i++) {
//            TimeUnit.SECONDS.sleep(1);
//            System.out.println("Writing: "+i);
//            consumer1.tell(i, ActorRef.noSender());
//        }
        consumer1.tell("exception", ActorRef.noSender());
        for (int i = 0; i < 10; i++) {
            TimeUnit.MILLISECONDS.sleep(1);
            System.out.println("Writing: "+i);
            consumer1.tell(i, ActorRef.noSender());
        }
        consumer1.tell("createChild", ActorRef.noSender());
    }
}

class Client1 extends Thread {
    public void run() {
        System.out.println("thread is running...");
        BankAccount a = new BankAccount("A");
        try {
            a.withdraw(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}