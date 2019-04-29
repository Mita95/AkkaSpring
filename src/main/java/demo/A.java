package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
public class A {

    @Autowired
    private ApplicationContext applicationContext;

    private B b;

//    private  Task task;

    public void fn1() throws InterruptedException {
        B b = applicationContext.getBean(B.class);

        b.setCount(b.getCount() + 1);
        Thread.sleep(5000);

        System.out.println(b.getCount());

    }

    public void fn2() {

        B b = applicationContext.getBean(B.class);
        b.setCount(b.getCount() + 2);
    }
}
