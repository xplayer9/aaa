package com.example.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(
        basePackages = "com.example.clients"
)
public class StoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class, args);
    }
}

//[INFO] Installing /Users/justin/IdeaProjects/aaa/clients/target/clients-1.0-SNAPSHOT.jar
// to /Users/justin/.m2/repository/org/example/clients/1.0-SNAPSHOT/clients-1.0-SNAPSHOT.jar
//[INFO] Installing /Users/justin/IdeaProjects/aaa/clients/pom.xml to
// /Users/justin/.m2/repository/org/example/clients/1.0-SNAPSHOT/clients-1.0-SNAPSHOT.pom

//[ERROR] Failed to execute goal on project store:
// Could not resolve dependencies for project org.example:store:jar:1.0-SNAPSHOT:
// Failed to collect dependencies at      org.example:clients:jar:1.0-SNAPSHOT:

// Failed to read artifact descriptor for org.example:clients:jar:1.0-SNAPSHOT:
// Could not find artifact org.example:aaa:pom:1.0-SNAPSHOT -> [Help 1]
