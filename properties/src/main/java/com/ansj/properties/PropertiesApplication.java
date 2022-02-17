package com.ansj.properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
//@ConfigurationPropertiesScan
public class PropertiesApplication {

    public static void main(String[] args) {
//        SpringApplication.run(PropertiesApplication.class, args);
        String propertiesHome = System.getenv("PROPERTIES_HOME");
        new SpringApplicationBuilder(PropertiesApplication.class)
                .properties(
                        "spring.config.location="+
                                "file:".concat(propertiesHome)
                                        .concat("/properties/database.yml")
                ).application().run(args);
    }

}
