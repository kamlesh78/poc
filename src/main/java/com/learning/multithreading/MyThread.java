package com.learning.multithreading;

public class MyThread extends Thread{
    private SharedResource sharedResource;
    public MyThread(String name,SharedResource sharedResource) {
        super(name);
        this.sharedResource  = sharedResource;
    }

    @Override
    public void run(){
        sharedResource.execute();
    }
}
