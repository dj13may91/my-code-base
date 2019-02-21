package Threading;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Latch --> multiple threads can wait for each other
 * <p>
 * A CyclicBarrier is used in situations where you want to create a group of
 * tasks to perform work in parallel + wait until they are all finished before
 * moving on to the next step -> something like join() -> something like
 * CountDownLatch
 * <p>
 * CountDownLatch: one-shot event CyclicBarrier: it can be reused over and over
 * again
 * <p>
 * + cyclicBarrier has a barrier action: a runnable, that will run automatically
 * when the count reaches 0 !!
 * <p>
 * new CyclicBarrier(N) -> N threads will wait for each other
 * <p>
 * WE CAN NOT REUSE LATCHES BUT WE CAN REUSE CyclicBarrierImplementation --> reset() !!!
 */

public class CyclicBarrierImplementation {

    static class BarrierWorker implements Runnable {
        private int id;
        private CyclicBarrier barrier;
//        private Random random;

        public BarrierWorker(int id, CyclicBarrier barrier) {
            this.id = id;
            this.barrier = barrier;
        }

        @Override
        public void run() {
            System.out.println("BlockingWorker thread " + id + " starts");
            try {
                Thread.sleep(1000);
                System.out.println("BlockingWorker thread " + id + " ends");
                Thread.sleep(1000);
                barrier.await();
                System.out.println("after await of thread " + id);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                System.out.println("Barrier broken");
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        CyclicBarrier mainBarrier = new CyclicBarrier(3, () ->
                System.out.println("All threads finished!! Now after await code will be executed")
        );

        for (int i = 0; i < 3; i++) {
            service.execute(new BarrierWorker(i + 1, mainBarrier));
            if (i > 1) {
                mainBarrier.reset();
            }
        }

        mainBarrier.reset();
        service.shutdown();
    }
}


/**
 * Sample output:
 BlockingWorker thread 3 starts
 BlockingWorker thread 1 starts
 BlockingWorker thread 2 starts
 BlockingWorker thread 2 ends
 BlockingWorker thread 3 ends
 BlockingWorker thread 1 ends
 All threads finished!! Now after await code will be executed
 after await of thread 2
 after await of thread 3
 after await of thread 1
 */