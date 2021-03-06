package com.javarush.test.level16.lesson13.bonus03;

/**
 * Created by OmniTool on 17.01.2016.
 */
/* Отдебажим все на свете
Разобраться, что делает програма.
Почитать про UncaughtExceptionHandler - это важно.
Еще раз внимательно посмотреть программу.
Разобраться - продебажить - почему наш OurUncaughtExceptionHandler не срабатывает.
Исправить ошибку, т.е. все должно работать. :)
Ожидаемый результат в произвольном порядке:
Нить 1: My exception message
Нить 2: My exception message
*/
public class SolutionAnother {
    public static Thread.UncaughtExceptionHandler handler = new OurUncaughtExceptionHandler();

    public static void main(String[] args) {
        Thread threadA = new TestedThread(handler, "Нить 1");
        Thread threadB = new TestedThread(handler, "Нить 2");
        threadA.interrupt();
        threadB.interrupt();
    }

    public static class TestedThread extends Thread {
        public TestedThread(UncaughtExceptionHandler handler, String name) {
            super(name);
            setUncaughtExceptionHandler(handler);
            start();

        }

        public void run() {
            try {

                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException("My exception message");
            }
        }
    }

    public static class OurUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println(t.getName() + ": " + e.getMessage());
        }
    }
}
