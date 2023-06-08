package br.com.unbhelp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jmx.support.RegistrationPolicy;

@SpringBootApplication
@EnableMBeanExport(registration= RegistrationPolicy.IGNORE_EXISTING)
@EntityScan(basePackages = UnbhelpBackendApplication.PACOTE_ENTITIES)
@EnableJpaRepositories(UnbhelpBackendApplication.PACOTE_REPOSITORY)
//@ComponentScan(UnbhelpBackendApplication.BASE_COMPONENTE)
public class UnbhelpBackendApplication {

    public static final String BASE_COMPONENTE = "br.com.unbhelp";
    public static final String PACOTE_ENTITIES = BASE_COMPONENTE + ".entities";
    public static final String PACOTE_REPOSITORY = BASE_COMPONENTE + ".repositories";

    public static void main(String[] args) {
        SpringApplication.run(UnbhelpBackendApplication.class, args);
    }

}
