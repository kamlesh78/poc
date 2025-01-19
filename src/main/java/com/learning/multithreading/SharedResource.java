package com.learning.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

    private final Lock lock = new ReentrantLock();
    public void execute(){
        System.out.println(Thread.currentThread().getName() + " trying to acquire lock");
        try{

                lock.lock();

                System.out.println(Thread.currentThread().getName() + " executing share resource");

                try {
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName() + " executed shared resource");

                } catch (InterruptedException e) {

                }finally {
                    lock.unlock();
                }

        }catch (Exception ex){
            System.out.println("Exception in shared resource :: "+ ex.getMessage());

        }
    }
}
