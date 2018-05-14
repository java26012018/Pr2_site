package spring;

import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContextHolder {

    private static final AbstractXmlApplicationContext context;

    static {
        context = new ClassPathXmlApplicationContext("spring-context.xml");
    }
    private SpringContextHolder() {
    }

    public static AbstractXmlApplicationContext getContext() {
        return context;
    }
}
