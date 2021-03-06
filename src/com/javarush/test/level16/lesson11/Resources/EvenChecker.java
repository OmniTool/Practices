package com.javarush.test.level16.lesson11.Resources;

/**
 * Created by Neboola on 13.01.2016.
 */
import java.util.concurrent.*;

public class EvenChecker implements Runnable {
    private IntGenerator generator;
    private final int id;
    public EvenChecker(IntGenerator g, int ident) {
        generator = g;
        id = ident;
    }
    public void run() {
        while(!generator.isCanceled()) {
            int val = generator.next();
            if(val % 2 != 0) {
                System.out.println(val + " not even!");
                generator.cancel(); // Отмена всех EvenChecker
            }
        }
    }
    // Тестирование произвольного типа IntGenerator:
    public static void test(IntGenerator gp, int count) {
        System.out.println("Press Control-C to exit");
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < count; i++)
            exec.execute(new EvenChecker(gp, i));
        exec.shutdown();
    }
    // Значение по умолчанию для count:
    public static void test(IntGenerator gp) {
        test(gp, 10);
    }
}
