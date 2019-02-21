package Threading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class Worker implements Callable<String> {
    CountDownLatch latch;
    int id;

    Worker(CountDownLatch latch, int id) {
        this.latch = latch;
        this.id = id;
    }

    @Override
    public String call() {
        System.out.println("Worker thread " + id + " starts");
        try {
            System.out.println("Worker thread " + id + " ends");
            System.out.println("Current latch count : " + latch.getCount());
            latch.countDown();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "returned future for id: " + id + " ends, Current latch count: " + latch.getCount();
    }
}

public class LatchThreading {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);

        ExecutorService service = Executors.newSingleThreadExecutor();
        List<Future> futureList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            futureList.add(service.submit(new Worker(countDownLatch, i + 1)));
        }

        try {
            countDownLatch.await();
            Thread.sleep(1000);
            System.out.println("All tasks finished");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            service.shutdown();
        }
        futureList.forEach(future -> {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
//        System.out.println("Current latch count : " + countDownLatch.getCount());
    }
}
