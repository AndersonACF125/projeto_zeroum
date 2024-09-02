package com.projetobeltis.projeto_zeroum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.projetobeltis.projeto_zeroum.model")
@EnableJpaRepositories(basePackages = "com.projetobeltis.projeto_zeroum.repository") // Atualize o pacote conforme necessário
public class ProjetoZeroumApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetoZeroumApplication.class, args);
    }
}