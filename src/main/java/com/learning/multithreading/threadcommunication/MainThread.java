package com.learning.multithreading.threadcommunication;

public class MainThread {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        Thread t1 = new Thread(()->{
            for(int i=0;i<5;i++){
                sharedResource.write(i);
            }
        },"WriteThread");

        Thread t2 = new Thread(()->{
            for(int i=0;i<5;i++){
                sharedResource.read();
            }
        },"ReadThread");

        t1.start();
        t2.start();
    }
}
