package com.learning.multithreading;

public class SynchronizedDeadLock {

    private final Object lock1 = new Object();
    private final Object lock2 = new Object();
    public void method1(){
        synchronized (lock1){
            System.out.println(Thread.currentThread().getName() + " acquired lock1");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (lock2){
                System.out.println(Thread.currentThread().getName() + " acquired lock2");
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public void method2(){
        synchronized (lock2){
            System.out.println(Thread.currentThread().getName() + " acquired lock2");

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (lock1){
                System.out.println(Thread.currentThread().getName() + " acquired lock1");
                System.out.println(Thread.currentThread().getName());
            }
        }
    }
}
