package main;

import demo.Task;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"demo"})
public class DependencyConfig {

    @Bean(name = "asdf")
    public Task task(){
        return new Task(5000);
    }

//    @Bean(value = "task2")
//    Task task2(){
//        return new Task(3000);
//    }
}