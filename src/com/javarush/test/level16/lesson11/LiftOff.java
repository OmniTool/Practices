package com.javarush.test.level16.lesson11;

/**
 * Created by Neboola on 10.01.2016.
 */
// Реализация интерфейса Runnable.

public class LiftOff implements Runnable {
    protected int countDown = 10; // Значение по умолчанию
    private static int taskCount = 0;
    private final int id = taskCount++;
    public LiftOff() {}
    public LiftOff(int countDown) {
        this.countDown = countDown;
    }
    public String status() {
        return "#" + id + "(" +
                (countDown > 0 ? countDown : "Liftoff!") + "), ";
    }
    public void run() {
        while(countDown-- > 0) {
            System.out.print(status());
            Thread.yield();
        }


    }
}
