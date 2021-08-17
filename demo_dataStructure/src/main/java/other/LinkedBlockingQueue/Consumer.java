package other.LinkedBlockingQueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private static BlockingQueue<Integer> bq;
    Consumer(BlockingQueue<Integer> bq){
        this.bq = bq;
    }
    @Override
    public void run() {
        while (true) {
            try {
                Integer result = bq.take();
                System.err.println("\t消费者消费为：" + result);
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
