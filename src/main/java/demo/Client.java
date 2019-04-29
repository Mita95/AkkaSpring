package demo;

import akka.actor.AbstractActor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service(value = "xClient")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Client extends AbstractActor {

    @Autowired
    private ApplicationContext applicationContext;

//    @Autowired
//    private A a;

//    @Autowired
    private Task task;

//    public Client(){
//        System.out.println("client constructor");
//    }


    Client(){
        //applicationContext.getBean(Task.class, 2000);
        //System.out.println("client di"+task.getBalance());
    }

    @Autowired
    Client(@Qualifier("asdf")Task task){
        this.task = task; //applicationContext.getBean(Task.class, 2000);
        System.out.println("client di"+task.getBalance());
    }

//    @PostConstruct
//    public void init() {
//        this.task = applicationContext.getBean(Task.class);
//        System.out.println("client post construct");
//    }

    public static final Logger logger = Logger.getLogger(Client.class.getName());

    public Receive createReceive() {
        return receiveBuilder()
                .match(Model.class, m -> {
//                  System.out.println(m.getClientName());
//                  System.out.println(m.getAmount());
                    System.out.println(self().path().name());
                    System.out.println("receive: "+task.balance+" "+task.withdraw());
                    logger.info(m.getClientName() + " " + m.getAmount());
                }).build();
//                .match(Integer.class, x -> {
//                    a.fn1();
//                })
//                .match(String.class, x -> {
//                    a.fn2();
//                }).build();
    }
}
