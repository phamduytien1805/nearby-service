package me.nearby;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@ComponentScan({"me.nearby"})
@EnableJpaRepositories("me.nearby.persistence")
@EntityScan("me.nearby.persistence")
@EnableCaching
@Slf4j
@EnableAspectJAutoProxy
public class NearbyApplication {
    public static void main(String[] args) {

        log.info("Begin to start Spring Boot Application");
        long startTime = System.currentTimeMillis();

        SpringApplication app = new SpringApplication(NearbyApplication.class);
        Map<String, Object> mapProperties = new HashMap<String, Object>();
        mapProperties.put("spring.jackson.property-naming-strategy","SNAKE_CASE");
        app.setDefaultProperties(mapProperties);
        app.run(args);

        long endTime = System.currentTimeMillis();
        log.info("End starting Spring Boot Application, Time used: " + (endTime - startTime));
    }
}