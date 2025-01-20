package com.learning.multithreading.threadcommunication;

public class SharedResource {

    private int data;
    private boolean hasData=Boolean.FALSE;

    public synchronized void write(int data){
        while(hasData){ // while because when thread wakeup it should recheck the condition instead of jumping out of the block after wake() statement
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        hasData = Boolean.TRUE;
        this.data = data;
        System.out.println(Thread.currentThread().getName() + " write data :: " + data);
        notifyAll();
    }

    public synchronized int read(){
        while(!hasData){
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        hasData=Boolean.FALSE;
        notifyAll();
        System.out.println(Thread.currentThread().getName() + " read data :: " + data);
        return this.data;
    }


}
