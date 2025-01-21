package com.learning.multithreading.Executor.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownMain {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        for(int i=0;i<10;i++){
            new Thread(()->{
                try{
                    System.out.println(Thread.currentThread().getName() + " is executing");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                 }
                finally {
                    countDownLatch.countDown();
                }
            }).start();
        }
        System.out.println("Main method");

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Main method executed");

    }
}
