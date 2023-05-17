package effective_java.page12;

/**
 * @ClassName ThreadTest
 * @Description TODO
 * @Author yyhuan
 * @Date 2023/2/12 22:24
 * @Version 1.0
 */
public class ThreadTest {
    public static void main(String[] args) {
        // 线程1
        new Thread(()->{
                    try {
                        for (int i = 0; i < 10; i++) {
                            System.out.println(Thread.currentThread().getName() + " ---: " + i);
                            Thread.sleep(1000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        ).start();

        // 线程2
        new Thread(
                ()->{
                    try {
                        for (int i = 0; i < 100; i++) {
                            System.out.println(Thread.currentThread() + " ---: " + i);
                            Thread.sleep(1000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        ).start();


    }
}
