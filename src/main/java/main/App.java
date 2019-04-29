package main;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.routing.RoundRobinPool;
import demo.Model;
import demo.SpringExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.logging.Logger;

@SpringBootApplication
public class App implements CommandLineRunner {

    final static Logger log = Logger.getLogger(App.class.getName());

//    @Autowired
//    static AnnotationConfigApplicationContext applicationContext;

    @Autowired
    private ApplicationContext applicationContext;

//    @Bean
//    Task task(){
//        System.out.println("Bean created");
//        return new Task(5000);
//    }

    public static void main(final String[] args) throws Exception {
        SpringApplication.run(App.class, args);
    }

//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//        return args -> {
//
//            System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//            String[] beanNames = ctx.getBeanDefinitionNames();
//            Arrays.sort(beanNames);
//            for (String beanName : beanNames) {
//                System.out.println(beanName);
//            }
//
//        };
//    }


    @Override
    public void run(String... args) throws Exception, InterruptedException {
//        ActorSystem actorSystem = ActorSystem.create("TestSystem");
//        log.info("Actor System Started");

//        ActorRef actorRef = actorSystem.actorOf(Props.create(demo.Client.class), "AppStart");

//        actorSystem.actorOf(Props.create(demo.Client.class), "client1");
//        log.info("demo.Client Started");
//        actorSystem.actorOf(Props.create(Client2.class), "client2");
//        log.info("Client2 Started");


//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
//        applicationContext.register(DependencyConfig.class);
//        applicationContext.refresh();

        String as[] = applicationContext.getBeanDefinitionNames();

        for (String s : as) {
            System.out.println(s);
        }

        ActorSystem actorSystem = ActorSystem.create("akka-spring-demo");

        SpringExtension.SPRING_EXTENSION_PROVIDER.get(actorSystem).initialize(applicationContext);

        ActorRef actorRef = actorSystem.actorOf(new RoundRobinPool(3).props(SpringExtension.SPRING_EXTENSION_PROVIDER.get(actorSystem)
                .props("xClient")),"clients");
        log.info("demo.Client Started");

        Model m = new Model("client1", 1000);

//        actorRef.tell(1, ActorRef.noSender());
//        Thread.sleep(3000);
//        actorRef.tell("Hi", ActorRef.noSender());
        actorRef.tell(m, ActorRef.noSender());
        actorRef.tell(m, ActorRef.noSender());
        actorRef.tell(m, ActorRef.noSender());
    }

}
