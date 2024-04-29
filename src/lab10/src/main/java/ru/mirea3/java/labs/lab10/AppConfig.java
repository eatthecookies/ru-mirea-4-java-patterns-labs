package ru.mirea3.java.labs.lab10;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.mirea3.java.labs.lab10.programmers.Junior;
import ru.mirea3.java.labs.lab10.programmers.Middle;
import ru.mirea3.java.labs.lab10.programmers.Senior;
import ru.mirea3.java.labs.lab10.programmers.Programmer;

@Configuration
public class AppConfig {
    @Bean(name = "juniorProgrammerBean")
    public Programmer juniorProgrammer(){
        return new Junior();
    }
    @Bean(name = "middleProgrammerBean")
    public Programmer middleProgrammer(){
        return new Middle();
    }
    @Bean(name = "seniorProgrammerBean")
    public Programmer seniorProgrammer(){
        return new Senior();
    }
}
