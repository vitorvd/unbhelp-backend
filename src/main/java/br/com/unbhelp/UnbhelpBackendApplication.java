package br.com.unbhelp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class UnbhelpBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnbhelpBackendApplication.class, args);
    }

}
