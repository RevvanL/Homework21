package ru.springtest.boot.demo;

import org.springframework.stereotype.Component;
import ru.springtest.boot.demo.annotations.LogMethod;
import ru.springtest.boot.demo.annotations.WorkTime;

import java.util.ResourceBundle;

@Component
public class MessageClass {
    ResourceBundle resource = ResourceBundle.getBundle("text");

    @LogMethod
    public int returnNumber() {
        return 28;
    }

    @WorkTime
    public void greeting() {
        System.out.println(resource.getString("greeting"));
    }

    @LogMethod
    public void makeAGuess() {
        System.out.println(resource.getString("makeAGuess"));
    }

    public void myNumberIsBigger() {
        System.out.println(resource.getString("myNumberIsBigger"));
    }

    @WorkTime
    public void myNumberIsLess() {
        System.out.println(resource.getString("myNumberIsLess"));
    }

    @WorkTime
    public void gratz() {
        System.out.print(resource.getString("gratz"));
    }
}
