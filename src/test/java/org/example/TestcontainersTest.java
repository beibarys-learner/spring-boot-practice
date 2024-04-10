package org.example;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@SpringBootTest

// don't use for units this annotation
public class TestcontainersTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Container
    private static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:latest")
            .withDatabaseName("code-dao-unit-test")
            .withUsername("code")
            .withPassword("password");

    @DynamicPropertySource
    private static void setProperties(DynamicPropertyRegistry registry) {
        registry.add(
                "spring.datasource.url", postgreSQLContainer::getJdbcUrl
        );
        // allows to register properties
        registry.add(
                "spring.datasource.username", postgreSQLContainer::getUsername
        );
        registry.add(
                "spring.datasource.password", postgreSQLContainer::getPassword
        );
    }

    @Test
    void canStartPostgresDB() {
        assertThat(postgreSQLContainer.isRunning()).isTrue();
        assertThat(postgreSQLContainer.isCreated()).isTrue();
    }

    @Test
    void canMigrateWithFlyway(){
        Flyway flyway = Flyway.configure().dataSource(
                postgreSQLContainer.getJdbcUrl(),
                postgreSQLContainer.getUsername(),
                postgreSQLContainer.getPassword()
        ).load();
//        flyway.migrate();
        System.out.println(applicationContext.getBeanDefinitionCount());
        for (String name : applicationContext.getBeanDefinitionNames()) {
            System.out.println(name);
        }
        System.out.println();
    }
}
