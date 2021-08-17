package other.LinkedBlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Test {

    public static void main(String[] args) {
        BlockingQueue<Integer> bq = new LinkedBlockingQueue<>(10);
        Consumer c = new Consumer(bq);
        Product p = new Product(bq);
        new Thread(c).start();
        new Thread(p).start();

    }
}
