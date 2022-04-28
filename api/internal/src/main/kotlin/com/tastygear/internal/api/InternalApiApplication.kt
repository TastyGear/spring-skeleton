package com.tastygear.internal.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication(scanBasePackages = ["com.tastygear"])
@EntityScan(basePackages = ["com.tastygear.*"])
@EnableJpaRepositories(basePackages = ["com.tastygear"])
class InternalApiApplication

fun main(args: Array<String>) {
    SpringApplicationBuilder(InternalApiApplication::class.java)
        .properties(
            "spring.config.location=" +
                    "classpath:application.yml," +
                    "classpath:application-${System.getProperty("spring.profiles.active")}.yml," +
                    "classpath:rds-${System.getProperty("spring.profiles.active")}.yml"
        )
        .run(*args)
}
