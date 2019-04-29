import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApp {
    private static ApplicationContext context;

    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("file:D:\\Beans.xml");
        context = new AnnotationConfigApplicationContext(DependencyConfig.class);
        IReader obj = context.getBean("",DBReader.class);
        obj.listen();
    }

    public static ApplicationContext getApplicationContext(){
        return context;
    }
}
