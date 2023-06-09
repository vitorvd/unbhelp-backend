package br.com.unbhelp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jmx.support.RegistrationPolicy;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@EnableMBeanExport(registration= RegistrationPolicy.IGNORE_EXISTING)
@EntityScan(basePackages = UnbhelpBackendApplication.PACOTE_ENTITIES)
@ComponentScan(basePackages = UnbhelpBackendApplication.BASE_COMPONENTE)
@EnableJpaRepositories(UnbhelpBackendApplication.PACOTE_REPOSITORY)
public class UnbhelpBackendApplication {

    public static final String BASE_COMPONENTE = "br.com.unbhelp";
    public static final String PACOTE_ENTITIES = BASE_COMPONENTE + ".entities";
    public static final String PACOTE_REPOSITORY = BASE_COMPONENTE + ".dao";

    public static void main(String[] args) {
        SpringApplication.run(UnbhelpBackendApplication.class, args);
    }

}
