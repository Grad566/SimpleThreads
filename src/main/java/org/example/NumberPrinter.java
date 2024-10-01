package org.example;

import java.util.concurrent.Semaphore;

public class NumberPrinter {
    private static final Semaphore evenSemaphore = new Semaphore(1);
    private static final Semaphore oddSemaphore = new Semaphore(0);
    private static final int END = 100;

    public void start(){
        Thread even = new Thread(new  Even());
        Thread odd = new Thread(new Odd());

        even.start();
        odd.start();
    }

    private static class Even implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < END; i += 2) {
                try {
                    evenSemaphore.acquire();
                    System.out.println(i);
                    oddSemaphore.release();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    private static class Odd implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i < END; i += 2) {
                try {
                    oddSemaphore.acquire();
                    System.out.println(i);
                    evenSemaphore.release();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
