package Threading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * This is used to synchronize one or more tasks by forcing them to wait for the completion of a set of operations being performed by other tasks
 * <p>
 * - You give an initial count to a CountDownLatch object, and any task that calls await()
 * on that object will block until the count reaches zero
 * <p>
 * - Other tasks may call countDown() on the object to reduce the count, presumably when a task finishes its job
 * - A CountDownLatch is designed to be used in a one-shot fashion; the count cannot be reset !!!
 * If you need a version that resets the count, you can use a CyclicBarrier instead
 * <p>
 * - The tasks that call countDown() are not blocked when they make that call. Only the call to await() is blocked until the count reaches zero
 * <p>
 * A typical use is to divide a problem into n independently solvable tasks and create a CountDownLatch with a value of n.
 * When each task is finished it calls countDown() on the latch. Tasks waiting for the problem to be solved call await()
 * on the latch to hold themselves back until it is completed
 */

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

public class Latch {

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
    }
}


/**
 * Sample output:
 * Worker thread 1 starts
 * Worker thread 1 ends
 * Current latch count : 5
 * Worker thread 2 starts
 * Worker thread 2 ends
 * Current latch count : 4
 * Worker thread 3 starts
 * Worker thread 3 ends
 * Current latch count : 3
 * Worker thread 4 starts
 * Worker thread 4 ends
 * Current latch count : 2
 * Worker thread 5 starts
 * Worker thread 5 ends
 * Current latch count : 1
 * All tasks finished
 * returned future for id: 1 ends, Current latch count: 4
 * returned future for id: 2 ends, Current latch count: 3
 * returned future for id: 3 ends, Current latch count: 2
 * returned future for id: 4 ends, Current latch count: 1
 * returned future for id: 5 ends, Current latch count: 0
 */