import main.DependencyConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppContext {
    private static final ApplicationContext INSTANCE = new AnnotationConfigApplicationContext(DependencyConfig.class);

    private AppContext() {
    }

    public static ApplicationContext getInstance() {
        return INSTANCE;
    }

}
