package com.learning.multithreading;

public class MainMultiThread {

    public static void main(String[] args){

        SharedResource sharedResource = new SharedResource();
        MyThread t1 = new MyThread("thread1",sharedResource);
        MyThread t2 = new MyThread("thread2",sharedResource);
        t1.start();
        t2.start();
    }
}
