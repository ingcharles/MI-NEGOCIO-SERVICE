package ec.gob.imark.catalogo.config;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class LiquibaseDebugger {

    @Bean
    @Primary
    public SpringLiquibase liquibase(DataSource dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog("classpath:/db/changelog/db.changelog-master.yaml");
        liquibase.setShouldRun(true); // O basado en spring.liquibase.enabled
        //liquibase.setDefaultSchema("clients");
        liquibase.setDropFirst(false);

        System.out.println("👉 Ejecutando Liquibase desde configuración personalizada");

        return liquibase;
    }
}