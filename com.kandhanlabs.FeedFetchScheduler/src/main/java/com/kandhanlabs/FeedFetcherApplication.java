package com.kandhanlabs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by gbalasubramanian on 03/06/17.
 */
@SpringBootApplication
@EnableScheduling
@ComponentScan("com.kandhanlabs")
public class FeedFetcherApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeedFetcherApplication.class);
    }
}
