package experimental;

import org.junit.jupiter.api.Assertions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@SuppressWarnings("unused")
public class CheckThreadSpeedTest {
    public static final AtomicInteger counter = new AtomicInteger();
    public static final int COUNT = 500000;
    public static final Lock lock = new ReentrantLock();

    //    @Test
    public void checkSpeed() throws InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        int parallelism = forkJoinPool.getParallelism();
        System.out.println("parallelism=" + parallelism);
        ExecutorService pool = Executors.newFixedThreadPool(parallelism);

        long start = System.nanoTime();
        for (int i = 0; i < COUNT; i++) {
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
            long nanos = System.nanoTime() - start;
            System.out.println("Complete " + counter + " time: " + (nanos / 1000000) + " milliseconds");
            System.out.println("Per 1 thread " + (nanos / counter.get()) + " nanoseconds");
        }
        Assertions.assertEquals(counter.get(), COUNT);
    }

}
