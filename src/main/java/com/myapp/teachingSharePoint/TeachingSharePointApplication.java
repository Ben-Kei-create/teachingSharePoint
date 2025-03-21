package com.myapp.teachingSharePoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.myapp.teachingSharePoint.Repository") // リポジトリのパッケージを指定
public class TeachingSharePointApplication {
    public static void main(String[] args) {
        SpringApplication.run(TeachingSharePointApplication.class, args);
    }
}
