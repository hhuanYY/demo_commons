package other.LinkedBlockingQueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Product implements Runnable {
    BlockingQueue<Integer> bq;
    Product(BlockingQueue<Integer> bq){
        this.bq = bq;
    }
    @Override
    public void run() {
        Random rand = new Random();
        while (true){
            try {
                Integer number = rand.nextInt(100);
                bq.put(number);
                System.err.println("生产者生产为："+number);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
