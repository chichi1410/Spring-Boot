package vn.hoa.spring.spring_5_15;


import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyUntil {

    @Bean
    public Calculator getCalculator(){
        return new Calculator();
    }

}
