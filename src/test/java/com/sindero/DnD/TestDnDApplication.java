package com.sindero.DnD;

import org.springframework.boot.SpringApplication;

public class TestDnDApplication {

    public static void main(String[] args) {
        SpringApplication.from(DnDApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
