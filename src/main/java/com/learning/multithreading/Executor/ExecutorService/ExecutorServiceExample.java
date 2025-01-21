package com.learning.multithreading.Executor.ExecutorService;

import java.util.concurrent.*;

public class ExecutorServiceExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Runnable task1  = ()-> System.out.println("executed successfully");
        Callable<Integer> task2 = ()-> 20;
        Future<?> runnableTask = executorService.submit(task1);

       System.out.println(runnableTask.isDone());

        Future<Integer> submit = executorService.submit(task2);
        try {
            System.out.println(submit.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    }
}
