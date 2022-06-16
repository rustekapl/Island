package com.javarush.island.khmelov;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class FJPDemo {
    public static final AtomicInteger counter = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 400000; i++) {
            Thread thread = new Thread("th" + i) {
                @Override
                public void run() {
                    counter.incrementAndGet();
                }
            };
            pool.execute(thread);
        }
        pool.shutdown();
        if (pool.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS)) {
            System.out.println("Complete "+counter);
        }
    }

}
