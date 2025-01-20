package com.learning.multithreading;

import java.time.Instant;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReEntrantReadWriteLock {

    private int count;
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock readLock = readWriteLock.readLock();
    private final Lock writeLock = readWriteLock.writeLock();

    public void write(int i){
        writeLock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + " acquired write lock i= "+ i);
            count++;
        }finally {
            System.out.println(Thread.currentThread().getName() + " write lock finished");
            writeLock.unlock();
        }
        try{
            Thread.sleep(500);
        } catch (InterruptedException e) {

        }
    }

    public int read(int i){
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " acquired read lock i= "+i + " time :: " + Instant.now());
            return count;
        }finally {
            System.out.println(Thread.currentThread().getName() + " read lock released i= "+i);
            readLock.unlock();
        }
    }

}
