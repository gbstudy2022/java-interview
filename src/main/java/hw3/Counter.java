package hw3;

import java.util.concurrent.locks.ReentrantLock;

public class Counter {

    private static int counter = 0;
    private static ReentrantLock locker = new ReentrantLock();

    public static void main(String[] args) {

        new Thread(()->{
            while (counter<100) {
                increment("Первый");
            }
        }).start();
        new Thread(()->{
            while (counter<100) {
                increment("Второй");
            }
        }).start();
        new Thread(()->{
            while (counter<100) {
                increment("Третий");
            }
        }).start();
    }

    private static void increment(String threadName) {
        locker.lock();
        counter++;
        System.out.println(threadName + " " + counter);
        locker.unlock();
    }
}
