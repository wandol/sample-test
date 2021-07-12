package com.example.sampletest;

import com.example.sampletest.main.Main;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class SampleTestApplication implements CommandLineRunner {

    private final Main main;

    public static void main(String[] args) {
        SpringApplication.run(SampleTestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        main.request();
    }
}
