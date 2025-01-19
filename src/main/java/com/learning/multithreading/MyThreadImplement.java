package com.learning.multithreading;

public class MyThreadImplement implements Runnable{
    @Override
    public void run() {
        System.out.println("MyThreadImplement " + Thread.currentThread().getName());

    }
}
