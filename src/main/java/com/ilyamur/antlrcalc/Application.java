package com.ilyamur.antlrcalc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import picocli.CommandLine;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private PicocliApplication picocliApplication;

    public static void main(String[] args) {
        (new SpringApplication(Application.class)).run(args);
    }

    @Override
    public void run(String... args) {
        (new CommandLine(picocliApplication)).execute(args);
    }
}
