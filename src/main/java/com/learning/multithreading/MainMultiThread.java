package com.learning.multithreading;

public class MainMultiThread {

    public static void main(String[] args){

//        SharedResource sharedResource = new SharedResource();
//        MyThread t1 = new MyThread("thread1",sharedResource);
//        MyThread t2 = new MyThread("thread2",sharedResource);
//        t1.start();
//        t2.start();

//        SynchronizedDeadLock synchronizedDeadLock = new SynchronizedDeadLock();
//        Thread deadlock1 = new Thread(()-> synchronizedDeadLock.method1(),"Thread1");
//        Thread deadlock2 = new Thread(()->synchronizedDeadLock.method2(),"Thread2");
//        deadlock1.start();
//        deadlock2.start();

        ReEntrantReadWriteLock reEntrantReadWriteLock = new ReEntrantReadWriteLock();
        Thread write = new Thread(()->{
            for(int i=0;i<5;i++){
                reEntrantReadWriteLock.write(i);
            }
        },"WriteThread");

        Thread read1 = new Thread(()->{
            for(int i=0;i<5;i++){
                reEntrantReadWriteLock.read(i);
            }
        },"ReadThread1");

        Thread read2 = new Thread(()->{
            for(int i=0;i<5;i++){
                reEntrantReadWriteLock.read(i);
            }
        },"ReadThread2");

        write.start();
        read1.start();
        read2.start();
    }



}
