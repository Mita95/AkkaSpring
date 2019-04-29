import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DependencyConfig {
    @Bean
    public UserListener userListener() {
        return new UserListener();
    }

    @Bean
    public IReader dbUser(){
        return new DBReader();
    }

    @Bean(value = "cache")
    public IReader cacheUser(){
        return new CacheReader();
    }
}
