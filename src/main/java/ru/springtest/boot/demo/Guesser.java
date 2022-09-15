package ru.springtest.boot.demo;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Guesser {
    Random r = new Random();
    int theNumber = r.nextInt(101);

}
