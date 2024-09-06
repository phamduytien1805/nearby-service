package me.nearby;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"me.nearby"})
public class NearbyApplication {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}