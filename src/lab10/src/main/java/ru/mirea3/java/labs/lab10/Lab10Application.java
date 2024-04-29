package ru.mirea3.java.labs.lab10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.mirea3.java.labs.lab10.programmers.Programmer;

@SpringBootApplication
public class Lab10Application {

	public static void main(String[] args) {
		if (args.length != 1){
			return;
		}
		String beanName = args[0];
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		SpringApplication.run(Lab10Application.class, args);
		Programmer programmer = (Programmer) context.getBean(beanName);
        programmer.doCoding();
    }

}
