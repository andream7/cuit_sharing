package com.example.sparksqltest.demos.config;

import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SparkConfig {

//    @Value("${spark.application.name}")
//    private String appName;
//
//    @Value("${spark.master}")
//    private String masterUri;

    @Bean
    public SparkSession sparkSession() {
        return SparkSession
                .builder()
                .appName("SparkApplication")
                .master("local[*]")
                .getOrCreate();
    }
}
