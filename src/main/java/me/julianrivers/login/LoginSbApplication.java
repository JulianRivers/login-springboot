package me.julianrivers.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class LoginSbApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginSbApplication.class, args);
        System.out.println("funca");
    }

}
