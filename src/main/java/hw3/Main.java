package hw3;

public class Main {

    private static Boolean isPing = false;

    public static void main(String[] args) {
        new Thread(()-> {
            while (true) {
                synchronized (isPing) {
                    if (!isPing) {
                        System.out.println("ping");
                        isPing = true;
                    }
                }
            }
        }).start();
        new Thread(()-> {
            while (true) {
                synchronized (isPing) {
                    if (isPing) {
                        System.out.println("pong");
                        isPing = false;
                    }
                }
            }
        }).start();
    }
}
