package ru.springtest.boot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


import java.util.InputMismatchException;
import java.util.Scanner;

@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {
        int a = 0;
        ConfigurableApplicationContext context = SpringApplication.run(TestApplication.class, args);
        Guesser guesser = context.getBean(Guesser.class);
        FindingService find = context.getBean(FindingService.class);
        MessageClass messageClass = context.getBean(MessageClass.class);
        find.submitLovers(new CookieLovers("John", "ate", 3, "cookies"));
        find.submitLovers(new CookieLovers("Jill", "ate", 6, "cakes"));
        messageClass.returnNumber();
        messageClass.greeting();
        messageClass.makeAGuess();

        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                while (true) {
                    a = scanner.nextInt();
                    if (a > guesser.theNumber) {
                        messageClass.myNumberIsLess();
                    } else if (a < guesser.theNumber) {
                        messageClass.myNumberIsBigger();
                    } else if (a == guesser.theNumber) {
                        messageClass.gratz();
                        System.out.println(a);
                        a = 9999;
                        break;
                    }
                }
                if (a == 9999) {
                    break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Можно вводить только числа. Начните игру заново");
        }

    }
}
