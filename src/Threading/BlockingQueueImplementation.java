package Threading;

import java.util.concurrent.*;

/**
 * BlockingQueue -> an interface that represents a queue that is thread safe
 * Put items or take items from it ...
 * For example: one thread putting items into the queue and another thread taking items from it  at the same time !!!
 * We can do it with producer-consumer pattern !!!
 * put() putting items to the queue
 * take() taking items from the queue
 */

public class BlockingQueueImplementation {
    static class BlockingWorker implements Runnable, Callable<String> {
        private int counter;
        private BlockingQueue<Integer> blockingQueue;

        public BlockingWorker(BlockingQueue<Integer> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("Inserting: " + ++counter);
                    blockingQueue.put(counter);
                    Thread.sleep(600);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public String call() throws Exception {
            Thread.sleep(1000);
            while (blockingQueue != null) {
                Thread.sleep(1000);
                System.out.println("removed: " + blockingQueue.poll());
            }
            return null;
        }
    }

    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);
        ExecutorService service = Executors.newCachedThreadPool();
        BlockingWorker worker = new BlockingWorker(blockingQueue);
        service.submit((Callable<String>) worker);
        service.submit((Runnable) worker);
        service.shutdown();
    }
}


/**
 Sample output:
 Inserting: 1
 Inserting: 2
 Inserting: 3
 Inserting: 4
 removed: 1
 Inserting: 5
 removed: 2
 Inserting: 6
 Inserting: 7
 removed: 3
 Inserting: 8
 Inserting: 9
 removed: 4
 Inserting: 10 . . . .
 */